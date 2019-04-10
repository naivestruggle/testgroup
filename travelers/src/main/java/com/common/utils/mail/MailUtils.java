package com.common.utils.mail;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.junit.Test;

public class MailUtils {
	/**
	 * 通过配置文件发送邮件
	 * @param c	当前类
	 * @param to	发送到
	 * @param code	激活码
	 */
	public static void sendMail(Class<?> thisClass,String to,Object[] codes,String fileName){
		//获取配置文件内容
		Properties props = new Properties();
		try {
			props.load(thisClass.getClassLoader().getResourceAsStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String host = props.getProperty("host").trim();  //获取服务器主机
		String uname = props.getProperty("uname").trim();  //获取邮箱用户名
		String pwd = props.getProperty("pwd").trim();   //获取第三方登录授权密码
		String from = props.getProperty("from").trim();   //获取发件人
		String subject = props.getProperty("subject").trim();  //获取主题
		String content = props.getProperty("content");  //获取邮件内容
		if(codes!=null && codes.length>0)
			content = MessageFormat.format(content,codes);  //替换占位符
		Mail mail = new Mail(from,to,subject,content);  //创建邮件对象
		Session session = createMailSession(host,uname,pwd);  //用自己的工具获取session
		sendMail(session,mail);  //发邮件
	}
	
	
	
	/**
	 * 获取一个javax.mail.Session的实例对象
	 * @param mailHost	服务器主机名
	 * @param username	用户名(不是邮箱地址)
	 * @param password	密码(是第三方登录授权码)
	 * @return	javax.mail.Session对象
	 */
	public static Session createMailSession(String mailHost,String username,String password){
		Properties prop = new Properties();
		prop.setProperty("mail.host", mailHost);	//设置服务器主机名
		prop.setProperty("mail.smtp.auth", "true");	//设置需要认证
		prop.put("mail.smtp.port", "465");
		//qq邮箱需要ssl加密 如果端口是456 那就需要加上下面这两句
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
		Authenticator auth = new Authenticator(){
			public PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(username,password);  //用户名和密码
			}
		};
		return Session.getInstance(prop,auth);
	}
	
	
	/**
	 * 发送邮件
	 * @param session javax.mail.Session对象
	 * @param mail	要发送的邮件对象
	 */
	public static void sendMail(Session session,Mail mail){
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(mail.getFromMailAddress()));	//设置发件人
			msg.setRecipients(RecipientType.TO, mail.getToMailAddress());  //设置收件人
			if(mail.getCcMailAddress()!= null && !mail.getCcMailAddress().isEmpty())
				msg.setRecipients(RecipientType.CC, mail.getCcMailAddress());  //设置抄送
			if(mail.getBccMailAddress() !=null && !mail.getBccMailAddress().isEmpty())
				msg.setRecipients(RecipientType.BCC, mail.getBccMailAddress());  //设置暗送
			msg.setSubject(mail.getMailSubject());	//设置主题
			
			List<AttachBean> fileBodyList = mail.getAttachBeanList();  //得到文件部件集合
			
			if(fileBodyList == null){ //如果没有文件部件
				msg.setContent(mail.getMailContent(),"text/html;charset=utf-8");	//设置正文
			}else{	//如果有文件部件
				MimeMultipart list = new MimeMultipart();  //创建多部分内容集合
				
				MimeBodyPart part1 = new MimeBodyPart(); //创建MimeBodyPart
				part1.setContent(mail.getMailContent(),"text/html;charset=utf-8"); //设置正文部件的内容
				list.addBodyPart(part1); //把正文部件添加到集合中
				
				for(AttachBean ab:fileBodyList){
					MimeBodyPart part = new MimeBodyPart();	//创建MimeBodyPart
					part.attachFile(ab.getFile());	//设置附件的内容
					part.setFileName(MimeUtility.encodeText(ab.getAttachBeanName()));  //设置显示的文件名称，并处理乱码问题
					list.addBodyPart(part);	//将部件添加到部件集合中
				}
				
				msg.setContent(list);	//把它设置给邮件作为邮件的内容
			}
			
			Transport.send(msg); //发送
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void demo(){
		sendMail(this.getClass(), "2550438618@qq.com", null, "alter_user_email.properties");
	}
}

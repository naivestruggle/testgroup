package com.common.utils.mail;

import java.util.List;
import java.util.Vector;

/**
 * 邮件
 * @author Administrator
 *
 */
public class Mail {
	private String fromMailAddress;	//发件人的邮箱地址
	private String toMailAddress;	//收件人的邮箱地址  多个用逗号隔开
	private String mailSubject;		//邮件主题
	private String mailContent;		//邮件正文
	private String ccMailAddress;   //抄送邮件地址
	private String bccMailAddress;	//暗送邮件地址
	
	private List<AttachBean> attachBeanList;		//附件对象集合
	
	public Mail(String fromMailAddress, String toMailAddress, String mailSubject, String mailContent) {
		super();
		this.fromMailAddress = fromMailAddress;
		this.toMailAddress = toMailAddress;
		this.mailSubject = mailSubject;
		this.mailContent = mailContent;
	}
	
	public String getFromMailAddress() {
		return fromMailAddress;
	}

	public String getToMailAddress() {
		return toMailAddress;
	}

	public String getMailSubject() {
		return mailSubject;
	}

	public String getMailContent() {
		return mailContent;
	}

	public List<AttachBean> getAttachBeanList() {
		return attachBeanList;
	}

	/**
	 * 添加附件部件
	 * @param attachBean 附件部件
	 */
	public void addAttachBean(AttachBean attachBean){
		if(attachBeanList == null)
			attachBeanList = new Vector<AttachBean>();
		attachBeanList.add(attachBean);
	}
	
	/**
	 * 添加抄送邮件地址
	 * @param ccMailAddress 抄送邮件地址
	 */
	public void addCcMailAddress(String ccMailAddress){
		this.ccMailAddress = ccMailAddress;
	}
	
	/**
	 * 添加暗送邮件地址
	 * @param ccMailAddress 暗送邮件地址
	 */
	public void addBccMailAddress(String bccMailAddress){
		this.bccMailAddress = bccMailAddress;
	}

	public String getCcMailAddress() {
		return ccMailAddress;
	}

	public String getBccMailAddress() {
		return bccMailAddress;
	}
}

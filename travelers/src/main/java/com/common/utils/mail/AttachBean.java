package com.common.utils.mail;

import java.io.File;

/**
 * 文件部件
 * @author Administrator
 *
 */
public class AttachBean {
	private File file;	//部件内容
	private String attachBeanName;	//部件名
	public AttachBean(File file, String attachBeanName) {
		super();
		this.file = file;
		this.attachBeanName = attachBeanName;
	}
	public File getFile() {
		return file;
	}
	public String getAttachBeanName() {
		return attachBeanName;
	}
}

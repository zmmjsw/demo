package com.test.demo.repository;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Calendar;

public class FileInfo extends HierarchyNodeInfo {

	private static final long serialVersionUID = 1177383012941808137L;

	private String mimeType;

	private String encoding;

	private transient InputStream data;

	private byte[] binaryData;

	private Calendar lastModifedTime;

	public byte[] getBinaryData() {
		return binaryData;
	}

	// 序列化附件影响性能
	@Deprecated
	public void setBinaryData(byte[] binaryData) {
		this.binaryData = binaryData;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public InputStream getData() {
		if (this.data == null && this.binaryData != null) {
			this.data = new ByteArrayInputStream(this.binaryData);
		}
		return data;
	}

	public void setData(InputStream data) {
		this.data = data;
	}

	public Calendar getLastModifedTime() {
		return lastModifedTime;
	}

	public void setLastModifedTime(Calendar lastModifedTime) {
		this.lastModifedTime = lastModifedTime;
	}
}

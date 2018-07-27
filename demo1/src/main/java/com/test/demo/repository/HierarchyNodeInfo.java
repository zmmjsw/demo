package com.test.demo.repository;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Map;

public class HierarchyNodeInfo implements Serializable {
	private static final long serialVersionUID = 3992881415228593682L;

	private String name;

	private Calendar createTime;

	private Map<String, Object> props;

	private boolean file;

	public boolean isFile() {
		return file;
	}

	public void setFile(boolean file) {
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}

	public Map<String, Object> getProps() {
		return props;
	}

	public void setProps(Map<String, Object> props) {
		this.props = props;
	}

}

package com.test.demo.repository;

public class PropertyInfo {

	public PropertyInfo(String name, int type, String value) {
		this.name = name;
		this.type = type;
		this.value = value;
	}

	private String name;

	private int type;

	private String value;

	public String getName() {
		return name;
	}

	public int getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

}

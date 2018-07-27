package com.test.demo.test;


public class ChargeStatus  {
    public static String CONFIRMED = "CHARGE_CONFIRMED";
    public static String CANCELLED = "CHARGE_CANCELLED";

    public static String REFUSED = "CHARGE_REFUSED";
    public static String WAITING_CONFIRM = "CHARGE_WAITING_CONFIRM";
    
    private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    
}

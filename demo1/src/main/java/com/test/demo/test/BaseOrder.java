package com.test.demo.test;




/**
 * Created by xmf on 2015/10/25.
 */
public class BaseOrder {
	private long id;

	private Order parent;  //一仓通

	private String deliveryTime; //一仓通
	private String routeName;

	private Boolean needCustomsClearanceByWhs;//一仓通

	private Boolean needBondedWarehouse;//一仓通

	private String planWarehouseInTime;//一仓通

	private Integer planWarehouseOutTimes; //一仓通

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Order getParent() {
		return parent;
	}

	public void setParent(Order parent) {
		this.parent = parent;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public Boolean getNeedCustomsClearanceByWhs() {
		return needCustomsClearanceByWhs;
	}

	public void setNeedCustomsClearanceByWhs(Boolean needCustomsClearanceByWhs) {
		this.needCustomsClearanceByWhs = needCustomsClearanceByWhs;
	}

	public Boolean getNeedBondedWarehouse() {
		return needBondedWarehouse;
	}

	public void setNeedBondedWarehouse(Boolean needBondedWarehouse) {
		this.needBondedWarehouse = needBondedWarehouse;
	}

	public String getPlanWarehouseInTime() {
		return planWarehouseInTime;
	}

	public void setPlanWarehouseInTime(String planWarehouseInTime) {
		this.planWarehouseInTime = planWarehouseInTime;
	}

	public Integer getPlanWarehouseOutTimes() {
		return planWarehouseOutTimes;
	}

	public void setPlanWarehouseOutTimes(Integer planWarehouseOutTimes) {
		this.planWarehouseOutTimes = planWarehouseOutTimes;
	}

	
    
}

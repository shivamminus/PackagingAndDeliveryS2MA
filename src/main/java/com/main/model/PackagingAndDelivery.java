package com.main.model;

import org.springframework.stereotype.Component;

@Component
public class PackagingAndDelivery {

	private int id;
	private int packagingCost;
	private int deliveryCost;

	public PackagingAndDelivery() {
		super();
	}

	public PackagingAndDelivery(int id, int packagingCost, int deliveryCost) {
		super();
		this.id = id;
		this.packagingCost = packagingCost;
		this.deliveryCost = deliveryCost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPackagingCost() {
		return packagingCost;
	}

	public void setPackagingCost(int packagingCost) {
		this.packagingCost = packagingCost;
	}

	public int getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(int deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	@Override
	public String toString() {
		return "PackagingAndDelivery [id=" + id + ", packagingCost=" + packagingCost + ", deliveryCost=" + deliveryCost
				+ "]";
	}

}

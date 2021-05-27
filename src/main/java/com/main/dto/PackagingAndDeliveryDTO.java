package com.main.dto;

/*Example 
{
	charge: 500.0
}*/
public class PackagingAndDeliveryDTO {

	private Double charge;

	public PackagingAndDeliveryDTO() {
	}

	public PackagingAndDeliveryDTO(double charge) {
		this.charge = charge;
	}

	public Double getCharge() {
		return charge;
	}

	public void setCharge(Double charge) {
		this.charge = charge;
	}

}

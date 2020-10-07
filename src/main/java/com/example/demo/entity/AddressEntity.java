package com.example.demo.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Type;

import com.example.demo.validation.CheckPincode;

@Entity
@Table(name = "Address")
public class AddressEntity {
	@Id
	@Type(type="string")
	@CheckPincode(message = "Pincode must contain numbers")
	private String pincode;
	
	@Type(type="string")
	@NotNull(message="Area can not be null!")
	@Pattern(regexp="[a-zA-Z]+", message = "Area Must Be String..!")
	private String area;
	
	public AddressEntity() {}
	
	
	  public AddressEntity(String pincode, String area) { super(); this.pincode =
	  pincode; this.area = area; }
	 
	
	@Override
	public String toString() {
		return "AddressEntity [pincode=" + pincode + ", area=" + area + "]";
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPincode() {
		return pincode;
	}
	public String getArea() {
		return area;
	}

}

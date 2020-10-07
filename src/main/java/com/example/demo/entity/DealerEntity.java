package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.Errors;

@Entity
@Table(name = "Dealer")
public class DealerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "int")
	private Integer id;

	@Type(type = "string")
	@NotEmpty(message="Name can not be empty!")
	@Length(min=3, message="Name should be of minimum of 3 characters!")
	private String name;

	@ManyToOne(targetEntity = AddressEntity.class, cascade = CascadeType.ALL)
	private AddressEntity addressentity;

	public DealerEntity() {

	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DealerEntity [id=" + id + ", name=" + name + ", addressentity=" + addressentity + "]";
	}

	public DealerEntity( String name,  AddressEntity addressentity ) {
		super(); //
		// this.id = id;
		this.name = name;
		this.addressentity = addressentity;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public AddressEntity getAddressentity() {
		return addressentity;
	}

	public void setAddressentity(@Valid AddressEntity addressentity, Errors errors) {
		if (errors.hasErrors()) {
			System.out.println("VALIDATION->" + errors.getFieldError().getDefaultMessage());
		}
		
		this.addressentity = addressentity;
	}

}

package com.example.Blood_Bank.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity(name="DonarList")
@Getter
@Setter
public@Data class DonarList implements Serializable{
	@Id
	private String DId;
	private String DName;
	private String DBloodGroup;
	private long DMobileNumber;
	private int AvalibityStatus;
	private String Address;
	private String DateOfLastDonate;
}

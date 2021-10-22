package com.example.Blood_Bank.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity(name="blood")
@Setter
@Getter
public class BloodBagList implements Serializable {
	@Id
	private String id;
	private String bloodgroup;
	private int status;
	private String expirydate;
	private int expirystatus;
	

}

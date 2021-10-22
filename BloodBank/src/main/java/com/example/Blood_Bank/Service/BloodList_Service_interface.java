package com.example.Blood_Bank.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Blood_Bank.Entity.BloodBagList;


public interface BloodList_Service_interface {
	BloodBagList newBloodIdList(BloodBagList bl);
	List<BloodBagList> DisplayBloodList();
	BloodBagList DisplayByBloodId(String  BloodBagId);
	void SetBloodSatatus(String  BloodBagId);
	List<BloodBagList> checkAvailabilityOfBlood(String BloodGroup);

}

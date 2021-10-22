package com.example.Blood_Bank.Service;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;

import com.example.Blood_Bank.Entity.BloodBagList;
import com.example.Blood_Bank.Entity.DonarList;

public interface Donar_Service_Interface {
	DonarList addDonar(DonarList DList);
	List<DonarList> DisplayDonarList();
	List<DonarList> DisplayDonarListByBloodGroup(String DBloodGroup );
	DonarList DisplayById(String DId);
	ResponseEntity<DonarList> recordUpadate(String DId,DonarList DL)throws AttributeNotFoundException;
	void DeleteDonarById(String DId);
	ResponseEntity<DonarList> UpdateStatusOfDonor(String DId);
	
	
	
}

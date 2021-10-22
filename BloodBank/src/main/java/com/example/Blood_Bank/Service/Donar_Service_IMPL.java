package com.example.Blood_Bank.Service;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Blood_Bank.Entity.BloodBagList;
import com.example.Blood_Bank.Entity.DonarList;
import com.example.Blood_Bank.Repository.BloodBankRepo;

@Service
public class Donar_Service_IMPL implements Donar_Service_Interface {
	
	private final BloodBankRepo repo;
	@Autowired
	 Donar_Service_IMPL(BloodBankRepo repo)
	 {
		 this.repo=repo;
	 }

	@Override
	public DonarList addDonar(DonarList DList) {
		
		return repo.save(DList);
	}

	@Override
	public List<DonarList> DisplayDonarList() {
		
		return repo.findAll();
	}

	@Override
	public List<DonarList> DisplayDonarListByBloodGroup(String DBloodGroup) {
		
		return  repo.findByTitile(DBloodGroup);
	}

	@Override
	public DonarList DisplayById(String DId) {
		
		return repo.findById(DId).get();
	}

	@Override
	public ResponseEntity<DonarList> recordUpadate(String DId, DonarList DL) throws AttributeNotFoundException {
		
		DonarList d=(DonarList) repo.findById(DId).orElseThrow(()->new AttributeNotFoundException());
		d.setDName(DL.getDName());
		d.setDMobileNumber(DL.getDMobileNumber());
		d.setAddress(DL.getAddress());
		final DonarList up=repo.save(d);
		return ResponseEntity.ok(up);
	}

	
	
	

	@Override
	public void DeleteDonarById(String DId) {
		repo.deleteById(DId);
		
	}

	@Override
	public ResponseEntity<DonarList> UpdateStatusOfDonor(String DId) {
		DonarList f=(DonarList) repo.findById(DId).orElseThrow();
		f.setAvalibityStatus(0);
		final DonarList up=repo.save(f);
		return ResponseEntity.ok(up);
	}

	
	
	
	
	
	

}

package com.example.Blood_Bank.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Blood_Bank.Entity.BloodBagList;
import com.example.Blood_Bank.Repository.BloodBankRepo_BloodList;

@Service
public class BloodList_Service_Impl implements BloodList_Service_interface{
	BloodBankRepo_BloodList Brepo;
	@Autowired
	BloodList_Service_Impl(BloodBankRepo_BloodList Brepo)
	{
		this.Brepo=Brepo;
	}
	@Override
	//adding new blood bag
	public BloodBagList newBloodIdList(BloodBagList bl) {
		
		return ((CrudRepository<BloodBagList, String>) Brepo).save(bl);
	}

	@Override
	public List<BloodBagList> DisplayBloodList() {
		
		return Brepo.findAll();
	}

	@Override
	public BloodBagList DisplayByBloodId(String BloodBagId) {
		
		return Brepo.findById(BloodBagId).get();
	}

	@Override
	public void SetBloodSatatus(String BloodBagId) {
		BloodBagList b=(BloodBagList) Brepo.findById(BloodBagId).orElseThrow();
		b.setStatus(0);
		final BloodBagList b1=Brepo.save(b);
		
	}
	@Override
	public List<BloodBagList> checkAvailabilityOfBlood(String BloodGroup) {
		return Brepo.CheckAvailabityOfBlood(BloodGroup);
	}


}

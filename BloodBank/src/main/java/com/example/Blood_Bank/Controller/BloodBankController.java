package com.example.Blood_Bank.Controller;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Blood_Bank.Entity.BloodBagList;
import com.example.Blood_Bank.Entity.DonarList;
import com.example.Blood_Bank.Service.BloodList_Service_interface;
import com.example.Blood_Bank.Service.Donar_Service_Interface;


@RestController
public class BloodBankController {
	Donar_Service_Interface in;
	BloodList_Service_interface BIn;
	@Autowired
	BloodBankController(Donar_Service_Interface in,BloodList_Service_interface BIn)
	{
		this.in=in;
		this.BIn=BIn;
	}
	@PostMapping("DonarList")
	DonarList insert(@RequestBody DonarList DL)
	{
		return in.addDonar(DL);
	}
	@GetMapping("DonarList")
	List<DonarList> DisplayRecordOfDonar()
	{
		return in.DisplayDonarList();
	}
	@GetMapping("DonarList/{DBloodGroup}")
	List<DonarList> DisplayRecordOfDonarByBloodGroup(@PathVariable String DBloodGroup)
	{
		return in.DisplayDonarListByBloodGroup(DBloodGroup);
	}
	@GetMapping("DonarList/DId/{DId}")
	DonarList getDonarById(@PathVariable String DId)
	{
		return in.DisplayById(DId);
	}
	
	
	@PutMapping("DonarList/{DId}")
	public ResponseEntity<DonarList> Update(@PathVariable String DId,@RequestBody  DonarList dl) throws AttributeNotFoundException
	{
		return in.recordUpadate(DId, dl);
		
	}
	@PatchMapping("DonarList/{DId}")
	void UpadateStatus(@PathVariable String DId)
	{
		in.UpdateStatusOfDonor(DId);
	}
	
	
	
	@DeleteMapping("DonarList/{DId}")
	public void delete(@PathVariable String DId)
	{
		in.DeleteDonarById(DId);
	}
	//---------------------------------------------Blood List Methods------------------------------------------
	@PostMapping("BloodList")
	BloodBagList insertBloodList(@RequestBody BloodBagList bl)
	{
		return BIn.newBloodIdList(bl);
		
	}
	@GetMapping("BloodList/{BloodBagId}")
	BloodBagList DisplayById(@PathVariable String BloodBagId)
	{
		return BIn.DisplayByBloodId(BloodBagId);
	}
	@GetMapping("BloodList")
	List<BloodBagList> Display()
	{
		return BIn.DisplayBloodList();
	}
	@PatchMapping("BloodList/{BloodBagId}")
	void setStatus(@PathVariable String BloodBagId)
	{
		BIn.SetBloodSatatus(BloodBagId);
	}
	@GetMapping("BloodBagList/BloodGroup/{BloodGroup}")
	List <BloodBagList> CheckAvilability(@PathVariable String BloodGroup)
	{
		return (List<BloodBagList>) BIn.checkAvailabilityOfBlood(BloodGroup);
	}
	

}

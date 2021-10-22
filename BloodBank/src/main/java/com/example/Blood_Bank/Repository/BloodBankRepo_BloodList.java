package com.example.Blood_Bank.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.Blood_Bank.Entity.BloodBagList;
import com.example.Blood_Bank.Entity.DonarList;
@Repository
public interface BloodBankRepo_BloodList extends JpaRepository<BloodBagList,String> {
	
	@Query(value="SELECT b.* FROM public.blood b WHERE b.status=1 AND b.expirystatus=0 AND  b.bloodgroup=?1",nativeQuery=true)
	List<BloodBagList> CheckAvailabityOfBlood(String bloodgroup);

}

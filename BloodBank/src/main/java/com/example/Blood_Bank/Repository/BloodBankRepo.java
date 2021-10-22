package com.example.Blood_Bank.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Blood_Bank.Entity.DonarList;
@Repository
public interface BloodBankRepo extends JpaRepository<DonarList,String> {

	@Query(value="select * from Donar_List where dblood_group=?1",nativeQuery=true)
	List<DonarList> findByTitile(String dBloodGroup);

}

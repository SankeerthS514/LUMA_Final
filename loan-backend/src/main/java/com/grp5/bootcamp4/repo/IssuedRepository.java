package com.grp5.bootcamp4.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grp5.bootcamp4.entity.Issued;

@Repository
public interface IssuedRepository extends JpaRepository<Issued, Long>{

	Issued getByloanid(Long masterId);

	Issued findByloanid(Long masterId);


	List<Issued> findAllByempid(Long empid);

	//List <Issued> findByitemcatAndItemmakeAndItemdescAndStatus(String itemcat, String itemmake, String itemdesc, String Status);
}

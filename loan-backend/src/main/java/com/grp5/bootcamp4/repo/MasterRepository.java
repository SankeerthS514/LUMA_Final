package com.grp5.bootcamp4.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grp5.bootcamp4.entity.Employee;
import com.grp5.bootcamp4.entity.Master;

@Repository
public interface MasterRepository extends JpaRepository<Master, Long>{

	//List<Master> findByEmpid(Long masterId);

	List<Master> findAllByEmpid(Long masterId);

	
//	List<Master> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	

}

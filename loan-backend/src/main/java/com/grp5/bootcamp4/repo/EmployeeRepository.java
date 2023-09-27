package com.grp5.bootcamp4.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grp5.bootcamp4.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{



	//List<> findAll();

}

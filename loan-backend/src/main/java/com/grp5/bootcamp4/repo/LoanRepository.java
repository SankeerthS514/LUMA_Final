package com.grp5.bootcamp4.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grp5.bootcamp4.entity.Loan;


@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{



	//List<Loan> findAll();

}

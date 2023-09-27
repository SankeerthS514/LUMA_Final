package com.grp5.bootcamp4.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grp5.bootcamp4.entity.Loan;
import com.grp5.bootcamp4.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{



	//List<Loan> findAll();

}

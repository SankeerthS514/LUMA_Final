package com.grp5.bootcamp4.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grp5.bootcamp4.entity.Item;
import com.grp5.bootcamp4.entity.Loan;
import com.grp5.bootcamp4.entity.Master;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

	List <Item> findByitemcatAndItemmakeAndItemdescAndStatus(String itemcat, String itemmake, String itemdesc, String Status);

	
}

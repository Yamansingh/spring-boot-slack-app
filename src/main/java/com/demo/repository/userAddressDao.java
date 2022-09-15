package com.demo.repository;

import com.demo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userAddressDao extends JpaRepository<Address,Integer> {

}

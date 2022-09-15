package com.demo.repository;

import com.demo.model.userAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userAddressDao extends JpaRepository<userAddress,Integer> {

}

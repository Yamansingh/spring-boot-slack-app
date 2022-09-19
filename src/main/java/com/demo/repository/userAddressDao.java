package com.demo.repository;

import com.demo.model.Address;
import com.demo.model.User;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface userAddressDao extends JpaRepository<Address,Integer> {
    List<Address> findByAddressId(Integer user_id);
    List<Address> findByCity(String city);
    List<Address> findByUser(User user);

}

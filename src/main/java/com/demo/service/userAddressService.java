package com.demo.service;

import com.demo.model.userAddress;

import java.util.Optional;

public interface userAddressService {
    public userAddress updateAddress(Integer addressId,String city);
    public Optional<userAddress> getAddress(Integer addressId);
}

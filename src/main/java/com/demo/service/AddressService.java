package com.demo.service;

import com.demo.model.Address;

import java.util.Optional;

public interface AddressService {
    public Address updateAddress(Integer addressId, String city);
    public Optional<Address> getAddress(Integer addressId);
}

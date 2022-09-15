package com.demo.service;

import com.demo.model.Address;
import com.demo.repository.userAddressDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private userAddressDao userAddDao;

    @Override
    public Address updateAddress(Integer addressId, String city) {
        Optional<Address> opt = userAddDao.findById(addressId);
        if(opt.isPresent())
        {
            Address existingAdd = opt.get();
            existingAdd.setCity(city);
            return  userAddDao.save(existingAdd);
        }
        return null;
    }

    @Override
    public Optional<Address> getAddress(Integer addressId) {
        Optional<Address> userAddress = userAddDao.findById(addressId);
        if(userAddress.isPresent()){
            return userAddress;
        }
        else{
            System.out.println("not_present");
        }


        return null;
    }
}

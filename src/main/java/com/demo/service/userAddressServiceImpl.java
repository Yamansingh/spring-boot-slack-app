package com.demo.service;

import com.demo.model.userAddress;
import com.demo.repository.userAddressDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class userAddressServiceImpl implements userAddressService{
    @Autowired
    private userAddressDao userAddDao;

    @Override
    public userAddress updateAddress(Integer addressId,String city) {
        Optional<userAddress> opt = userAddDao.findById(addressId);
        if(opt.isPresent())
        {
            userAddress existingAdd = opt.get();
            existingAdd.setCity(city);
            return  userAddDao.save(existingAdd);
        }
        return null;
    }

    @Override
    public Optional<userAddress> getAddress(Integer addressId) {
        Optional<userAddress> userAddress = userAddDao.findById(addressId);
        if(userAddress.isPresent()){
            return userAddress;
        }
        else{
            System.out.println("not_present");
        }


        return null;
    }
}

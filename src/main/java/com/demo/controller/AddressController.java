package com.demo.controller;

import com.demo.model.Address;
import com.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AddressController {

    @Autowired
    private AddressService userAddressService;
    //http://localhost:8089/userAdd/8?city=rampur
    @PutMapping("/userAdd/{Id}")
    public ResponseEntity<Address> updateAdd(@PathVariable("Id") Integer Id, @RequestParam("city") String city){
        Address updatecity = userAddressService.updateAddress(Id,city);
        return new ResponseEntity<Address>(updatecity, HttpStatus.ACCEPTED);

    }
    //http://localhost:8089/userAddress/32
    @GetMapping("/Address/{Id}")
    public Optional<Address> getUserAdd(@PathVariable("Id") Integer Id){
        return userAddressService.getAddress(Id);
    }


}

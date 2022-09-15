package com.demo.controller;

import com.demo.model.userAddress;
import com.demo.service.userAddressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class userAddressController {

    @Autowired
    private userAddressService userAddressService;
    //http://localhost:8089/userAdd/8?city=rampur
    @PutMapping("/userAdd/{Id}")
    public ResponseEntity<userAddress> updateAdd(@PathVariable("Id") Integer Id, @RequestParam("city") String city){
        userAddress updatecity = userAddressService.updateAddress(Id,city);
        return new ResponseEntity<userAddress>(updatecity, HttpStatus.ACCEPTED);

    }
    //http://localhost:8089/userAddress/32
    @GetMapping("/userAddress/{Id}")
    public Optional<userAddress> getUserAdd(@PathVariable("Id") Integer Id){
        return userAddressService.getAddress(Id);
    }


}

package com.demo.controller;

import com.demo.model.Address;
import com.demo.repository.userAddressDao;
import com.demo.repository.userDao;
import com.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AddressController {

    @Autowired
    private AddressService userAddressService;
    @Autowired
    private com.demo.repository.userDao userDao;
    @Autowired
    private userAddressDao adddDao;



    //http://localhost:8089/userAdd/8?city=rampur
    @PutMapping("/userAdd/{Id}")
    public ResponseEntity<Address> updateAdd(@PathVariable("Id") Integer Id, @RequestParam("city") String city){
        Address updatecity = userAddressService.updateAddress(Id,city);
        return new ResponseEntity<Address>(updatecity, HttpStatus.ACCEPTED);

    }
    //http://localhost:8089/Address/32
    @GetMapping("/Address/{address_id}")
    public Optional<Address> getUserAdd(@PathVariable("address_id") Integer address_id){
        return userAddressService.getAddress(address_id);
    }
    //http://localhost:8089/address/32
   @PostMapping("/address/{userId}")

    public ResponseEntity<Address> createAddress(@PathVariable("userId") Integer userId,@RequestBody Address addressRequest){
        Address address = userDao.findById(userId).map(user -> {
           addressRequest.setUser(user);
           return adddDao.save(addressRequest);
       }).orElseThrow();
        return new ResponseEntity<>(address,HttpStatus.CREATED);
   }
//    public ResponseEntity<Comment> createComment(@PathVariable(value = "tutorialId") Long tutorialId,
//                                                 @RequestBody Comment commentRequest) {
//        Comment comment = tutorialRepository.findById(tutorialId).map(tutorial -> {
//            commentRequest.setTutorial(tutorial);
//            return commentRepository.save(commentRequest);
//        }).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId));
//
//        return new ResponseEntity<>(comment, HttpStatus.CREATED);
//    }
     //http://localhost:8089/addresses/99
    @GetMapping("/addresses/{addressId}")
    public ResponseEntity<List<Address>> getAllAddressByUserId(@PathVariable(value = "addressId") Integer addressId) {
//        if (!adddDao.existsById(user_id)) {
//            throw new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId);
//        }

        List<Address> addreses = adddDao.findByAddressId(addressId);
        return new ResponseEntity<>(addreses, HttpStatus.OK);
    }
    //http://localhost:8089/addresses/kanpur
    @GetMapping("/addresses/{city}")
    public ResponseEntity<List<Address>> getAllAddressByCity(@PathVariable(value = "city") String  city) {
//        if (!adddDao.existsById(user_id)) {
//            throw new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId);
//        }

        List<Address> addreses = adddDao.findByCity(city);
        return new ResponseEntity<>(addreses, HttpStatus.OK);
    }


}
package com.demo.controller;

import com.demo.model.Address;
import com.demo.model.User;
import com.demo.repository.userAddressDao;
import com.demo.repository.userDao;
import com.netflix.graphql.dgs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@DgsComponent
public class UserDataFetcher {
    @Autowired
    private userDao userDao;

    @Autowired
    userAddressDao addDao;

    @DgsQuery(field = "users")
    public List<User> getUsers() {
        return userDao.findAll();

    }
    @DgsQuery(field="user")
    public Optional<User> getUsers(Integer user_Id){
        return userDao.findById(user_Id);

    }

    @DgsQuery(field = "addresses")
    public  List<Address> getAllAddresses(){
        return addDao.findAll();
    }
     @DgsQuery(field = "address")
     public Optional<Address> getAddressById(Integer user_id){
          return addDao.findById(user_id);


//        List<Address> addresses = addDao.findByAddressId(user_id);
//        if(addresses.size()>0){
//            return addresses;
//        }
  //      return null;
     }
    @DgsQuery(field = "address")
    public List<Address> getAddress(){
        List<Address> addresses= addDao.findAll();
        return addresses;
    }
    @DgsData(parentType = "Mutation", field = "saveUser")
    public User saveUser(@InputArgument("User") User UserInput)
    {
        return userDao.save(UserInput);
    }
    @DgsData(parentType = "Mutation",field = "saveAddress")
           public ResponseEntity<Address> saveAddress(@InputArgument("Address") Address AddressInput,@InputArgument("user_id") Integer user_id){


        Address address = userDao.findById(user_id).map(user -> {
            AddressInput.setUser(user);
            return addDao.save(AddressInput);
        }).orElseThrow();
        return new ResponseEntity<>(address, HttpStatus.CREATED);
            }




      @DgsData(parentType = "Mutation",field = "updateAddress")
     public Address updateAdress(@InputArgument("address_id") Integer address_id, @InputArgument("city")
      String city, @InputArgument("pin") Integer pin) {
          Optional<Address> opt = addDao.findById(address_id);
          if (opt.isPresent()) {
              Address existing_add = opt.get();
              existing_add.setPin(pin);
              existing_add.setCity(city);
              return addDao.save(existing_add);
          }

          return null;
      }


    @DgsData(parentType = "User", field = "addresses")
    public List<Address> getAdd(DgsDataFetchingEnvironment dfe) {

        User user = dfe.getSource();
       return addDao.findByUser(user);
    }


    @DgsData(parentType = "Mutation",field = "deleteAddress")

    public Optional<Address> deleteAdd(@InputArgument("addressId") Integer addressId){
        Optional<Address> add = addDao.findById(addressId);
        addDao.deleteById(addressId);
        return add;
    }


}


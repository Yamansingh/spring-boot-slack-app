package com.demo.controller;

import com.demo.model.Address;
import com.demo.model.Bank;
import com.demo.model.User;
import com.demo.repository.userAddressDao;
import com.demo.repository.userDao;
import com.netflix.graphql.dgs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
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

//       @DgsData(parentType = "UserInput",field = "addresses")
//       public List<Address> saveAdd(@InputArgument("AddressInput") AddressInput addressInput ){
//         return addDao.save(addressInput);
//       }


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


    @DgsData(parentType = "User", field = "addressList")
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


    ///////////Bank


    @DgsEntityFetcher(name = "Bank")
    public Bank bank(Map<Integer,Object> values){

       // return new Ba((Integer) values.get("userId"), (List<Bank>) values.get("banks"));
       // return new Bank((Integer) values.get("Id"),(Integer) values.get("userId"));
       // return new Bank((Integer) values.get("id"),(User)values.get("user"),(Integer) values.get("userId"));
         return new Bank((Integer) values.get("id"),(Integer) values.get("userId"));


    }
    @DgsData(parentType = "Bank",field = "UserDetails")
    public Optional<User> userDetails(DgsDataFetchingEnvironment dfe){
     Bank bank = dfe.getSource();
        System.out.println("bank.getId():"+bank.getId());
        System.out.println("bank:  "+bank);

        System.out.println("bank.getUserId():"+bank.getUserId());

          return userDao.findById(bank.getUserId());

    }



}


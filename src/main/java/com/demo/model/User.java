package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString



public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String userName;
    private Integer userAge;

    //@OneToOne(cascade =CascadeType.ALL)
    //@JoinColumn(name = "fk_add_id")
    //@OneToMany(cascade = CascadeType.ALL)
   // @JoinColumn(name ="fk_em_id" ,referencedColumnName="emp_id")
    //private List<userAddress> userAddresses;
   // private userAddress userAddress;

//    {
//        "userName":"rounak",
//            "userAge":23,
//            "userAddress":
//        {
//            "city":"belangir",
//                "pin":245304
//        }
//    }

}

package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(targetEntity = Address.class,cascade = CascadeType.ALL)
    @JoinColumn(name="user_Id",referencedColumnName = "userId")
    private List<Address> addresses ;

//    {
//        "userName":"rounak",
//            "userAge":23,
//            "Address":
//        {
//            "city":"belangir",
//                "pin":245304
//        }
//    }

}

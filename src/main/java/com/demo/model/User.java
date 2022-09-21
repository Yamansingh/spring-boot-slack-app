package com.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @Convert(converter = AttributeEncryptor.class)
    private String password;


    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private List<Address> addressList = new ArrayList<>();



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

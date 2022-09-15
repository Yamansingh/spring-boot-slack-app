package com.demo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Address {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer addressId;
    private String city;
    private Integer pin;



}

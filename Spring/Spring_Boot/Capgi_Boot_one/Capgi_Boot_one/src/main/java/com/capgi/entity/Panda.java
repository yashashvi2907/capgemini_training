package com.capgi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Panda {

     @Id
     private Integer id;
     private String name;
     private Double weight;

}

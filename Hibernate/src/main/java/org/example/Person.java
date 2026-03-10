package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "person")
public class Person {

    @Id
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Person{" + "id=" + id +
                ", name" + name +"}";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

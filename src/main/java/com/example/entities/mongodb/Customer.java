package com.example.entities.mongodb;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Customer {

    /**
     * 主键ID
     */
    @Id
    public String id;

    /**
     * 第一个名字的值
     */
    public String firstName;
    /**
     * 第二个
     */
    public String lastName;

    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}


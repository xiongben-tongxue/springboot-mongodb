package com.example.repositories.mongodb;

import com.example.entities.mongodb.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, Long> {

    /**
     * 根据名字的首字母查询
     * @param firstName
     * @return
     */
    public Customer findByFirstName(String firstName);

    /**
     * 根据名字的最后一个字母查询
     * @param lastName
     * @return
     */
    public List<Customer> findByLastName(String lastName);

}

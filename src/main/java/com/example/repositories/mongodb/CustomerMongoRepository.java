package com.example.repositories.mongodb;

import com.example.entities.mongodb.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 普通的查询示例
 */
public interface CustomerMongoRepository extends MongoRepository<Customer, String> {

    /**
     * 根据名字的首字母查询
     * @param firstName
     * @return
     */
    List<Customer> findByFirstName(String firstName);

    /**
     * 根据名字的最后一个字母查询
     * @param lastName
     * @return
     */
    List<Customer> findByLastName(String lastName);

    List<Customer> findAllById(String id);
}

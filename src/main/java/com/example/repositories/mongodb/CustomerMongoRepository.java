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
     *
     * @param firstName
     * @return
     */
    List<Customer> findByFirstName(String firstName);

    /**
     * 根据名字的最后一个字母查询
     *
     * @param lastName
     * @return
     */
    List<Customer> findByLastName(String lastName);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    List<Customer> findAllById(String id);


    /**
     * 查与这个Id相等的值
     */
    Customer findAllByIdEquals(String id);


    /**
     * 根据ids集合来查询一个List，这个list中的值，Id包括
     * @param ids
     * @return
     */
    List<Customer> findAllByIdIn(List<String> ids);
    /**
     * 数一下满足条件的有多少条记录
     * @param firstName
     * @return
     */
    Long countAllByFirstName(String firstName);

}

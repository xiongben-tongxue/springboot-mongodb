package com.example.services.mongodb;

import com.example.entities.mongodb.Customer;

import java.util.List;

/**
 * @author:wangdong
 * @description:
 */
public interface MongoService {

    /**
     * 保存客户信息
     *
     * @param firstName
     * @param lastName
     * @return
     */
    Boolean saveCustomer(String firstName, String lastName);

    /**
     * 根据第一个名字查询
     * @param firstName
     * @return
     */
    List<Customer> listCustomerByFirstName(String firstName);

    /**
     * 根据最后一个名字查询
     * @param lastName
     * @return
     */
    List<Customer> listCustomerByLastName(String lastName);

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    List<Customer> getCustomer(String id);

    /**
     * 查询所有，不需要任何条件
     * @return
     */
    List<Customer> listCustomer();

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Customer> listCustomer(Integer pageNum, Integer pageSize);
}

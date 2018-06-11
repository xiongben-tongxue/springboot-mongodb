package com.example.services.mongodb;

import com.example.entities.mongodb.Customer;

import java.util.List;

/**
 * @author:wangdong
 * @description:
 */
public interface MongoManageService {

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
}

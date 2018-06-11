package com.example.services.mongodb.impl;

import com.example.entities.mongodb.Customer;
import com.example.repositories.mongodb.CustomerRepository;
import com.example.services.mongodb.MongoManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author:wangdong
 * @description:
 */
@Service
public class MongoManageServiceImpl implements MongoManageService {

    @Autowired
    private CustomerRepository customerRepository;
    /**
     * 保存客户信息
     *
     *
     * @param firstName
     * @param lastName
     * @return
     */
    @Override
    public Boolean saveCustomer(String firstName, String lastName) {
        if (StringUtils.isEmpty(firstName) || StringUtils.isEmpty(lastName)){
            return false;
        }
        Customer customer = new Customer(firstName,lastName);
        customer.setId(1002L);

        Customer result = customerRepository.save(customer);
        if (null == result){
            return false;
        }
        return true;
    }

    /**
     * 根据第一个名字查询
     *
     * @param firstName
     * @return
     */
    @Override
    public List<Customer> listCustomerByFirstName(String firstName) {
        return null;
    }

    /**
     * 根据最后一个名字查询
     *
     * @param lastName
     * @return
     */
    @Override
    public List<Customer> listCustomerByLastName(String lastName) {
        return null;
    }
}

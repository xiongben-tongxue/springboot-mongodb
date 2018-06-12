package com.example.services.mongodb.impl;

import com.example.entities.mongodb.Customer;
import com.example.repositories.mongodb.CustomerMongoRepository;
import com.example.repositories.mongodb.CustomerPageAndSortRepository;
import com.example.services.mongodb.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author:wangdong
 * @description:
 */
@Service
public class MongoServiceImpl implements MongoService {

    @Autowired
    private CustomerMongoRepository customerMongoRepository;

    @Autowired
    private CustomerPageAndSortRepository customerPageAndSortRepository;
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
        Customer result = customerMongoRepository.save(customer);
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
        if (StringUtils.isEmpty(firstName)){
            return Collections.EMPTY_LIST;
        }
        List<Customer> customers = customerMongoRepository.findByFirstName(firstName);
        if (CollectionUtils.isEmpty(customers)){
            return Collections.EMPTY_LIST;
        }

        return customers;
    }

    /**
     * 根据最后一个名字查询
     *
     * @param lastName
     * @return
     */
    @Override
    public List<Customer> listCustomerByLastName(String lastName) {
        if (StringUtils.isEmpty(lastName)){
            return Collections.EMPTY_LIST;
        }
        List<Customer> customers = customerMongoRepository.findByLastName(lastName);
        if (CollectionUtils.isEmpty(customers)){
            return Collections.EMPTY_LIST;
        }

        return customers;
    }

    /**
     * 根据Id查询
     *
     * @param id
     * @return
     */
    @Override
    public List<Customer> getCustomer(String id) {
        if (StringUtils.isEmpty(id)){
            return Collections.EMPTY_LIST;
        }
        List<Customer> customers = customerMongoRepository.findAllById(id);
        if (CollectionUtils.isEmpty(customers)){
            return Collections.EMPTY_LIST;
        }

        return customers;
    }

    /**
     * 查询所有，不需要任何条件
     *
     * @return
     */
    @Override
    public List<Customer> listCustomer() {

        List<Customer> customers = customerMongoRepository.findAll();

        if (CollectionUtils.isEmpty(customers)){
            return Collections.EMPTY_LIST;
        }

        return customers;
    }

    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<Customer> listCustomer(Integer pageNum, Integer pageSize) {
        if (null == pageNum || null == pageSize){
            return Collections.EMPTY_LIST;
        }

        PageRequest pageRequest = new PageRequest(pageNum,pageSize);

        Page<Customer> customerPage = customerPageAndSortRepository.findAll(pageRequest);
        if (null == customerPage){
            return Collections.EMPTY_LIST;
        }
        return customerPage.getContent();
    }


}

package com.example.services.mongodb;

import com.example.entities.mongodb.Customer;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @author:wangdong
 * @description:mongoDB的删除操作
 */
public interface MongoService {

    /**
     * 保存客户信息
     *
     *
     * @param id
     * @param lastName
     * @param firstName
     * @return
     */
    Boolean saveCustomer(String id, String lastName, String firstName);

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

    /**
     * 分页查询
     * 根据指定的条件排序
     * @param pageNum
     * @param pageSize
     * @param sort
     * @return
     */
    List<Customer> listCustomer(Integer pageNum, Integer pageSize, Sort sort);

    /**
     * 删除
     * @param id
     * @return
     */
    Boolean deleteCustomer(String id);

    /**
     * 删除
     * @param customer
     * @return
     */
    Boolean deleteCustomer(Customer customer);

    /**
     * 根据ids查询
     * @param ids
     * @return
     */
    List<Customer> listCustomers(List<String> ids);
    /**
     * 批量删除
     * @param ids
     * @return
     */
    Boolean deleteCustomer(List<String> ids);

    /**
     * 有一下满足条件的有多少条
     * @param firstName
     * @return
     */
    Long countCustomerByFirstName(String firstName);
}

package com.example.controllers.api;

import com.example.entities.mongodb.Customer;
import com.example.services.mongodb.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:wangdong
 * @description:MongoDB的Controller
 */
@RestController
@RequestMapping("/api/mongodb/")
public class MongoController {

    @Autowired
    private MongoService mongoService;

    /**
     * 保存customer示例
     * @param firstName
     * @param lastName
     * @return
     */
    @RequestMapping("saveCustomer")
    public Boolean saveCustomer(String firstName, String lastName){

        Boolean result = mongoService.saveCustomer(firstName,lastName);

        return result;
    }

    /**
     * 根据名字的首字母查询
     * @param firstName
     * @return
     */
    @RequestMapping("listCustomerByFirstName")
    public List<Customer> listCustomerByFirstName(String firstName){

        List<Customer> result = mongoService.listCustomerByFirstName(firstName);

        return result;
    }

    /**
     * 根据名字的最后一个字母查询
     * @param lastName
     * @return
     */
    @RequestMapping("listCustomerByLastName")
    public List<Customer> listCustomerByLastName(String lastName){

        List<Customer> result = mongoService.listCustomerByLastName(lastName);

        return result;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping("getCustomer")
    public List<Customer> getCustomer(String id){

        List<Customer> result = mongoService.getCustomer(id);

        return result;
    }

    /**
     * 查询所有
     * 不需要任何条件
     * @return
     */
    @RequestMapping("listCustomer")
    public List<Customer> listCustomer(){

        List<Customer> result = mongoService.listCustomer();

        return result;
    }

    /**
     * 分页查询
     * 因为数据库查询是从0开始的
     * 如果这本传1的话，需要减1后查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("listCustomerByPage")
    public List<Customer> listCustomerByPage(Integer pageNum, Integer pageSize){

        List<Customer> result = mongoService.listCustomer(pageNum,pageSize);

        return result;
    }
}

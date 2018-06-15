package com.example.controllers.api;

import com.example.entities.mongodb.Customer;
import com.example.services.mongodb.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
     * 因为MongoDB的Id默认是唯一的
     * 保存customer示例
     * 同时这个接口也是更新的操作
     * 如果用的是mongoDB默认的id,在保存第二条的时候，如果传了相同的Id，那么就会把原来的一条给替换掉\
     * @param id 保存的时候不传id，更新的时候需要传id
     * @param firstName
     * @param lastName
     * @return
     */
    @RequestMapping("saveCustomer")
    public Boolean saveCustomer(String id, String firstName, String lastName) {

        Boolean result = mongoService.saveCustomer(id, lastName, firstName);

        return result;
    }

    /**
     * 根据名字的首字母查询
     *
     * @param firstName
     * @return
     */
    @RequestMapping("listCustomerByFirstName")
    public List<Customer> listCustomerByFirstName(String firstName) {

        List<Customer> result = mongoService.listCustomerByFirstName(firstName);

        return result;
    }

    /**
     * 根据名字的最后一个字母查询
     *
     * @param lastName
     * @return
     */
    @RequestMapping("listCustomerByLastName")
    public List<Customer> listCustomerByLastName(String lastName) {

        List<Customer> result = mongoService.listCustomerByLastName(lastName);

        return result;
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @RequestMapping("getCustomer")
    public List<Customer> getCustomer(String id) {

        List<Customer> result = mongoService.getCustomer(id);

        return result;
    }

    /**
     * 查询所有
     * 不需要任何条件
     *
     * @return
     */
    @RequestMapping("listCustomer")
    public List<Customer> listCustomer() {

        List<Customer> result = mongoService.listCustomer();

        return result;
    }

    /**
     * 删除Customer
     * 根据ID删除
     *
     * @return
     */
    @RequestMapping("deleteCustomerById")
    public Boolean deleteCustomerById(String id) {

        Boolean result = mongoService.deleteCustomer(id);

        return result;
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("deleteCustomerByIds")
    public Boolean deleteCustomerByIds(@RequestParam("ids[]") List<String> ids) {

        Boolean result = mongoService.deleteCustomer(ids);

        return result;
    }

    /**
     * 数一下满足条件的有多少条
     * @param firstName
     * @return
     */
    @RequestMapping("countCustomerByFirstName")
    public Long countCustomerByFirstName(String firstName){

        Long result = mongoService.countCustomerByFirstName(firstName);

        return result;
    }

    /**
     * 批量删除
     *
     * @param customers
     * @return
     */
    @RequestMapping("deleteCustomerByCustomers")
    public Boolean deleteCustomerByCustomers(@RequestBody List<Customer> customers) {

        List<String> ids = new ArrayList<>();
        ids.add("1234");
        Boolean result = mongoService.deleteCustomer(ids);

        return result;
    }

    /**
     * 分页查询
     * 因为数据库查询是从0开始的
     * 如果这本传1的话，需要减1后查询
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("listCustomerByPage")
    public List<Customer> listCustomerByPage(Integer pageNum, Integer pageSize) {

        List<Customer> result = mongoService.listCustomer(pageNum, pageSize);

        return result;
    }

    /**
     * 倒叙分页排序
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("listCustomerByTime")
    public List<Customer> listCustomerByTime(Integer pageNum, Integer pageSize) {

        //倒叙排
        Sort sort = new Sort(Sort.Direction.DESC, "ctime");

        List<Customer> result = mongoService.listCustomer(pageNum, pageSize, sort);

        return result;
    }

}

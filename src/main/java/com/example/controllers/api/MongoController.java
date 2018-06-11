package com.example.controllers.api;

import com.example.services.mongodb.MongoManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:wangdong
 * @description:MongoDB的Controller
 */
@RestController
@RequestMapping("/api/mongodb/")
public class MongoController {

    @Autowired
    private MongoManageService mongoManageService;

    @RequestMapping("saveCustomer")
    public Boolean saveCustomer(String firstName, String lastName){

        Boolean result = mongoManageService.saveCustomer(firstName,lastName);

        return result;
    }
}

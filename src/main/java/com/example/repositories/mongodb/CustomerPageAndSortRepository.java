package com.example.repositories.mongodb;

import com.example.entities.mongodb.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author:wangdong
 * @description:
 */
public interface CustomerPageAndSortRepository extends PagingAndSortingRepository<Customer,String> {

}

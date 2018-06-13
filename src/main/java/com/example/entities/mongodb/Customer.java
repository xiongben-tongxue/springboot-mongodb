package com.example.entities.mongodb;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Customer {

    /**
     * 主键ID
     */
    @Id
    private String id;

    /**
     * 第一个名字的值
     */
    private String firstName;
    /**
     * 第二个
     */
    private String lastName;

    /**
     * 创建时间
     */
    private Long ctime;

    /**
     * 更新时间
     */
    private Long utime;

    public Customer() {}

    public Customer(String firstName, String lastName,Long ctime, Long utime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ctime = ctime;
        this.utime = utime;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}


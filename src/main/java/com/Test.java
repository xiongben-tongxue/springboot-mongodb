package com;

import java.math.BigDecimal;

/**
 * @author:wangdong
 * @description:数据截取
 */
public class Test {

    public static void main(String[] args) {

        BigDecimal bigDecimal = BigDecimal.valueOf(463.21332143132);
        BigDecimal result = bigDecimal.setScale(6,BigDecimal.ROUND_HALF_UP);
        System.out.println(result);//输出：463.213321
    }
}

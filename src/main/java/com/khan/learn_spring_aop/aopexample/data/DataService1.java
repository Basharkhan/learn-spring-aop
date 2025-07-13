package com.khan.learn_spring_aop.aopexample.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {
    public int[] retrieveData() {
        return new int[] {5, 100, 40, 30, 20, 509};
    }
}

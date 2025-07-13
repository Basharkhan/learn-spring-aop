package com.khan.learn_spring_aop.aopexample.business;

import com.khan.learn_spring_aop.aopexample.data.DataService1;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {

    private final DataService1 dataService1;

    public BusinessService1(DataService1 dataService1) {
        this.dataService1 = dataService1;
    }

    public int calculateMax() {
        int[] data = dataService1.retrieveData();
        // throw new RuntimeException("Some thing went wrong");
        return Arrays.stream(data).max().orElse(0);
    }
}

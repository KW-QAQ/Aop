package com.example.demo.service;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class impl implements ApplicationRunner {
    public void aaa(){

    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("aaa");
    }
}

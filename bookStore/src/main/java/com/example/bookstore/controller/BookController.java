package com.example.bookstore.controller;

import com.example.bookstore.feign.WareFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/book")
@RestController
@Slf4j
public class BookController {

    @Resource
    WareFeign wareFeign;

    @GetMapping("/inBook")
    public void home() {

        log.info("get books from book ware house");
        wareFeign.getBook();
    }

    @GetMapping("/getBook/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public void getBookById(@PathVariable("id") String id) {
        log.info("输入的id " + id);
        if (Integer.valueOf(id) <= 0) {
            throw new RuntimeException("id " + id + "不存在");
        }
    }

    public void hystrixGet(@PathVariable("id") String id) {
        log.info("输入的id无效");
    }


    @GetMapping("/healthz")
    public String healthz() {
        String serverStatus = "The server is up and running.";

        log.info(serverStatus);

        return serverStatus;
    }

}

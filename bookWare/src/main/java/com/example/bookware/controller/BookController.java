package com.example.bookware.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/book")
@RestController
@Slf4j
public class BookController {

    @GetMapping("/inBook")
    public void inBook() {
        log.info("inBook");
    }

    @GetMapping("/outBook")
    public void outBook() {
        log.info("outBook");
    }

    @GetMapping("/healthz")
    public String healthz() {
        String serverStatus = "The bookware app is up and running.";

        log.info(serverStatus);

        return serverStatus;
    }

}

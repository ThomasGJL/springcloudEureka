package com.example.bookstore.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(value="bookWare")
public interface WareFeign {

    @GetMapping("/book/outBook")
    void getBook();

}

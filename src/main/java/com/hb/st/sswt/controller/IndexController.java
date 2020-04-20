package com.hb.st.sswt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * index
 *
 * @author Mr.huang
 * @since 2020/4/20 15:17
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/say")
    public String say() {
        return String.valueOf(System.currentTimeMillis());
    }

}

package com.hb.st.sswt.controller;

import com.hb.st.sswt.enums.ResponseEnum;
import com.hb.unic.base.common.ResponseData;
import com.hb.unic.base.util.ResponseUtils;
import com.hb.unic.logger.Logger;
import com.hb.unic.logger.LoggerFactory;
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
@RequestMapping("/controller/index")
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/say")
    public ResponseData<String> say() {
        LOGGER.info("com.hb.st.sswt.controller.IndexController.say");
        return ResponseUtils.generateResponseData(ResponseEnum.SUCCESS, String.valueOf(System.currentTimeMillis()));
    }

}

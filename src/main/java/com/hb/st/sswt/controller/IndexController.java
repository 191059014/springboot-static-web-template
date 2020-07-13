package com.hb.st.sswt.controller;

import com.hb.st.sswt.enums.ResponseEnum;
import com.hb.unic.base.common.ResponseData;
import com.hb.unic.base.util.ResponseUtils;
import com.hb.unic.logger.Logger;
import com.hb.unic.logger.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Value("${hb.name}")
    private String name;

    @Value("${unicBase.projectName}")
    private String unicBaseProjectName;

    @Value("${unicLogger.projectName}")
    private String unicLoggerProjectName;

    @GetMapping("/get_say")
    public ResponseData<String> get_say() {
        LOGGER.info("com.hb.st.sswt.controller.IndexController.get_say");
        return ResponseUtils.generateResponseData(ResponseEnum.SUCCESS, String.valueOf(System.currentTimeMillis()));
    }

    @PostMapping("/post_say")
    public ResponseData<String> post_say(@RequestBody String jsonData) {
        LOGGER.info("com.hb.st.sswt.controller.IndexController.post_say，入参：{}", jsonData);
        return ResponseUtils.generateResponseData(ResponseEnum.SUCCESS, String.valueOf(System.currentTimeMillis()));
    }

}

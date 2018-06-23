package com.xujiang.childbodyguard.controller;

import com.xujiang.childbodyguard.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author madenghui1
 * @date 20180524
 * 健康检查接口
 */
@RestController
@RequestMapping("/hello")
public class HelloController {


    @Resource
    private HelloService helloService;

    @RequestMapping("/ok")
    public String hello() {
        return helloService.hello();
    }
}

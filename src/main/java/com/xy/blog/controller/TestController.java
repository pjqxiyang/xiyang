package com.xy.blog.controller;


import com.xy.blog.exception.BlogException;
import com.xy.blog.utils.ResultUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 夕阳
 * @Date: 2021/8/16 15:40
 * @Version 1.0
 */
@RestController
public class TestController {

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public ResultUtils<?> test() {
        return new ResultUtils<>();
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public ResultUtils<?> test2() {
        throw new BlogException("操作失败");
    }

}

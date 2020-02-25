package com.yang.yhr.controller;

import com.yang.yhr.entity.Hr;
import com.yang.yhr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Hr)表控制层
 *
 * @author makejava
 * @since 2020-02-24 11:08:05
 */
@RestController
@RequestMapping("hr")
public class HrController {
    /**
     * 服务对象
     */
    @Autowired
    HrService hrService;

    @RequestMapping("query/{keywords}")
    public List<Hr> query(@PathVariable String keywords){
        return hrService.getAllHrs(keywords);
    }
}
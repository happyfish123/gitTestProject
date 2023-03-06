package com.example.demo.web;


import com.example.demo.common.Result;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Controller
@CrossOrigin
@RequestMapping("/welcome")
@Api(value = "WelcomeController", tags = {"Welcome控制器"})
public class WelcomeController {

    private final static Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @ApiOperation("测试方法")
    @GetMapping("/test")
    public ResponseEntity<String> test(@RequestParam(value = "name") String name) {
        return ResponseEntity.ok("Hello, " + name);
    }


    @RequestMapping(value="getWelcomeInfo" ,method = {RequestMethod.GET})
    @ResponseBody
    public Result getWelcomeInfo(){
        Result result = Result.success();

        Table<String, String, List<Object>> tables = HashBasedTable.create();
        tables.put("财务部", "总监", Lists.newArrayList());
        tables.put("财务部", "职员",Lists.newArrayList());
        tables.put("法务部", "助理",Lists.newArrayList());


        return result.addValue("123","13");
    }

}

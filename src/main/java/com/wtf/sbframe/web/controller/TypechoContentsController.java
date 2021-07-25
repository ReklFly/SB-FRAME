package com.wtf.sbframe.web.controller;


import com.wtf.sbframe.web.service.ITypechoContentsService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* @author WTF
*/
@RestController
@RequestMapping("/web/typecho-contents")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TypechoContentsController {

    private final ITypechoContentsService service;

    @ApiOperation(value="db1test", notes="")
    @GetMapping("/db1test")
    public List list(){
        return service.list();
    }

    @ApiOperation(value="db2test", notes="")
    @GetMapping("/db2test")
    public List list2(){
        return service.list2();
    }



}

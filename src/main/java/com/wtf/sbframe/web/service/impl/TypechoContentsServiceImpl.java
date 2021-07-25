package com.wtf.sbframe.web.service.impl;

import com.wtf.sbframe.web.entity.TypechoContents;
import com.wtf.sbframe.web.mapper.db1.TypechoContentsMapper;
import com.wtf.sbframe.web.mapper.db2.TypechoContents2Mapper;
import com.wtf.sbframe.web.service.ITypechoContentsService;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
* @author WTF
*/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TypechoContentsServiceImpl implements ITypechoContentsService {

    private final TypechoContentsMapper mapper;

    private final TypechoContents2Mapper mapper2;

    private final RestHighLevelClient restHighLevelClient;


    @Override
    public List<TypechoContents> list() {
        System.out.println(restHighLevelClient);
        return mapper.list();
    }

    @Override
    public List<TypechoContents> list2() {
        System.out.println(new RestHighLevelClient(
                RestClient.builder(
                        //集群配置法
                        new HttpHost("localhost", 9200, "http"))));
        return mapper2.list();
    }

}
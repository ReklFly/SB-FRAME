package com.wtf.sbframe;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class}) //去掉springboot 默认的数据源配置
@MapperScan("com.wtf.sbframe.web.mapper") //扫描mapper的包，或者读者可以在对应的mapper上加上@Mapper的注解

public class SbFrameApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbFrameApplication.class, args);
    }

    @Bean
    public RestHighLevelClient esClient(){
        return new RestHighLevelClient(
                RestClient.builder(
                        //集群配置法
                        new HttpHost("localhost", 9200, "http")));
    }

}

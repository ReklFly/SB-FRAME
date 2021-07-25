package com.wtf.sbframe.tools;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class CodeGenerator {
    // 数据库 URL
    private static final String URL = "jdbc:mysql://rm-bp13wbs1nx1sqnnjm5o.mysql.rds.aliyuncs.com:3306/typecho?serverTimezone=Asia/Shanghai&&characterEncoding=utf-8";
    // 数据库驱动
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    // 数据库用户名
    private static final String USERNAME = "root_wtf";
    // 数据库密码
    private static final String PASSWORD = "980903Wtf";
    // @author 值
    private static final String AUTHOR = "WTF";
    // 包的基础路径
    private static final String BASE_PACKAGE_URL = "com.wtf.template";
    // xml文件路径
    private static final String XML_PACKAGE_URL = "/src/main/resources/mapper/";
    // xml 文件模板
    private static final String XML_MAPPER_TEMPLATE_PATH = "generator/templates/mapper.xml";
    // mapper 文件模板
    private static final String MAPPER_TEMPLATE_PATH = "generator/templates/mapper.java";
    // entity 文件模板
    private static final String ENTITY_TEMPLATE_PATH = "generator/templates/entity.java";
    // service 文件模板
    private static final String SERVICE_TEMPLATE_PATH = "generator/templates/service.java";
    // serviceImpl 文件模板
    private static final String SERVICE_IMPL_TEMPLATE_PATH = "generator/templates/serviceImpl.java";
    // controller 文件模板
    private static final String CONTROLLER_TEMPLATE_PATH = "generator/templates/controller.java";

    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath + "/src/main/java");
        globalConfig.setAuthor(AUTHOR);
        globalConfig.setSwagger2(true);
        globalConfig.setOpen(false);
        globalConfig.setFileOverride(false);
        generator.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(URL);
        dataSourceConfig.setDriverName(DRIVER_NAME);
        dataSourceConfig.setUsername(USERNAME);
        dataSourceConfig.setPassword(PASSWORD);
        generator.setDataSource(dataSourceConfig);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName("web");
        packageConfig.setParent(BASE_PACKAGE_URL);
        generator.setPackageInfo(packageConfig);

        // 配置自定义代码模板 模板路径
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(XML_MAPPER_TEMPLATE_PATH);
        templateConfig.setMapper(MAPPER_TEMPLATE_PATH);
        templateConfig.setEntity(ENTITY_TEMPLATE_PATH);
        templateConfig.setService(SERVICE_TEMPLATE_PATH);
        templateConfig.setServiceImpl(SERVICE_IMPL_TEMPLATE_PATH);
        templateConfig.setController(CONTROLLER_TEMPLATE_PATH);
        generator.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude("typecho_contents");
        //strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        //strategy.setTablePrefix("t_");
        generator.setStrategy(strategy);
        generator.setTemplateEngine(new FreemarkerTemplateEngine());
        generator.execute();
    }

}



package com.rhythm.warn;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.HashMap;
import java.util.Map;

public class MybatisPlusCodeGenerator {

  private static String exportPath = "C:/Users/PC/Desktop/code";

    private static String dbUrl = "jdbc:mysql://192.168.0.248:3306/temp?useUnicode=true&characterEncoding=utf-8";

    public static void main(String[] args) {

        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(exportPath);
        gc.setFileOverride(true);
        gc.setActiveRecord(false);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setAuthor("majunjie");

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("a+rquQe5KMGKKkmFJkl0");
        dsc.setUrl(dbUrl);
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setTablePrefix(new String[] { "tb" });
        // 自定义实体父类
        strategy.setSuperEntityClass("com.wn.common.datamodel.BaseDO");
        strategy.setSuperEntityColumns(
                new String[] { "id", "created_time", "creator", "modified_time", "modifier", "is_deleted", "version" });
        strategy.setEntityLombokModel(true);// 支持lombok 简化代码
        strategy.setLogicDeleteFieldName("is_deleted");
        strategy.setVersionFieldName("version");
        strategy.setRestControllerStyle(true);
        strategy.setSuperControllerClass("com.wn.common.controller.BaseController");
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.rhythm.warn");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setXml("xml");
        mpg.setPackageInfo(pc);
        // 注入自订义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        mpg.setCfg(cfg);

        // 执行生成
        mpg.execute();
    }
}

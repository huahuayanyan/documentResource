package com.ncf.fund.test;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * description: 
 * @author xurong
 * time : 2014-1-22 上午9:51:29
 */
public class IbatisGeneratorRun {

    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<String>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(IbatisGeneratorRun.class.getClassLoader().getResourceAsStream("ibatisGeneratorConfig.xml"));

        DefaultShellCallback shellCallback = new DefaultShellCallback(true);

        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
        myBatisGenerator.generate(null);
        for (String string : warnings) {
            System.out.println(string);
        }
    }

}

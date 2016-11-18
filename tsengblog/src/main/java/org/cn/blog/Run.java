package org.cn.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by WunHwanTseng on 2016/10/27.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class Run {
    public static void main(String[] args){
        SpringApplication.run(Run.class, args);
    }
}

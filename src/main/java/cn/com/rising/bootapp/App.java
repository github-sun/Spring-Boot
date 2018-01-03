package cn.com.rising.bootapp;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

import cn.com.rising.bootapp.config.UserConfigBean;

@SpringBootApplication
@EnableConfigurationProperties({UserConfigBean.class})
public class App {
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(App.class, args);
		System.out.println("===App started");
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println("===App beanName "+beanName);
		}
	}
}

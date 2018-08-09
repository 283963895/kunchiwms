package com.kunchiwms.wms;
// 为了spring-boot全局配置导入的类。
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 为了swagger 生成doc注入的类。

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableAutoConfiguration
@SpringBootApplication
@EnableSwagger2

public class WmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WmsApplication.class, args);
	}

	@Bean
	public Docket document() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("WMS-Demo，分布式web服务如此简单。")
				.version("1.0")
				.build();
	}


	// 这个类可以让启动之后，控制台输出一行明显的提示，一般可以用于监控的钩子。
	@Bean
	CommandLineRunner sampleCommandLineRunner() {
		return (args) -> System.out.println("hello world！");
	}
}

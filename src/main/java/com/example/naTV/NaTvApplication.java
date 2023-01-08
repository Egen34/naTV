package com.example.naTV;

import com.example.naTV.microService.MicroService4Image;
import com.example.naTV.utils.RBundle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients(basePackageClasses = {MicroService4Image.class})
public class NaTvApplication {
	public static void main(String[] args) {
		SpringApplication.run(NaTvApplication.class, args);
	}

}

package com.example.demo.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.api.users.UserRestController;

@Component
@Configuration
@ApplicationPath("/spring-demo/v1/")
public class JerseyConfig extends ResourceConfig implements WebMvcConfigurer {

	/**
	 * In constructor we can define Jersey Resources & Other Components
	 */
	public JerseyConfig() {
		/* CustomTypeParamterConsumeResource auto scanned and register */
		// api
		register(UserRestController.class);


	}
}

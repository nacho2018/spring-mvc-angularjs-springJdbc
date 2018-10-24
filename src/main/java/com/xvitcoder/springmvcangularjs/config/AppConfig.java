package com.xvitcoder.springmvcangularjs.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 * Created by xvitcoder on 12/24/15.
 */
@Configuration
@Import({DatabaseConfig.class})
public class AppConfig {
	
	
}

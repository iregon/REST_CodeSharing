package com.iregon.api_codesharing.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan({"com.iregon.api_codesharing.ctrl"})
public class ServletConfig {
}

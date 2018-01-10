package org.sun.bootapp.config.ws;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.sun.bootapp.ws.UserWebServices;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

@Configuration
public class WebServicesConfig {

	@Autowired
	private Bus bus;

	@Autowired
	private UserWebServices userWebServices;

	@Bean
	public Server rsServer() {
		JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
		endpoint.setBus(bus);
		endpoint.setAddress("/");
		endpoint.setServiceBeans(Arrays.<Object>asList(userWebServices));
		endpoint.setProviders(Arrays.asList(jacksonJaxbJsonProvider()));
		return endpoint.create();
	}

	@Bean
	public JacksonJaxbJsonProvider jacksonJaxbJsonProvider() {
		return new JacksonJaxbJsonProvider();
	}

}

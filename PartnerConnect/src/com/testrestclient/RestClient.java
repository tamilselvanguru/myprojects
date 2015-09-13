package com.testrestclient;

import java.lang.reflect.Method;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.partnerconnect.model.Partner;
@Controller
public class RestClient {

	@RequestMapping(value="/partnerko" , method = RequestMethod.GET)
	public @ResponseBody void testPartner(){
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		restTemplate.exchange("http://localhost:8080/PartnerConnect/partnersList", HttpMethod.GET, entity, Partner.class);
	}}


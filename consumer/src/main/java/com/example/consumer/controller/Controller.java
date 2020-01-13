package com.example.consumer.controller;


import com.example.consumer.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Controller {

    @Autowired
    public DiscoveryClient discoveryClient;

    public HttpEntity<?>getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return new HttpEntity<>("parameters",headers);
    }

    public void getAll() throws RestClientException, IOException{
        List<ServiceInstance> instances = discoveryClient.getInstances("zuul");
        String url= instances.get(0).getUri().toString() + "/producer/employees";

        RestTemplate restTemplate= new RestTemplate();
        ResponseEntity<Employee[]> responseEntity=null;

        try {
            responseEntity= restTemplate.exchange(url, HttpMethod.GET,getHeader(),Employee[].class);
            for (int i = 0; i< Objects.requireNonNull(responseEntity.getBody()).length; i++){
                System.out.println(responseEntity.getBody()[i].toString());
            }
        }catch (Exception ex){
            System.out.println(ex.toString());
        }

    }

}

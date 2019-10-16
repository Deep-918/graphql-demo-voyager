package com.voyager.demo.customerdatacache;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

@Service
@GraphQLApi
public class CustomerService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${redisUrl}")
    String redisService;

    ObjectMapper mapper = new ObjectMapper();

    @GraphQLQuery(name = "customers")
    public List<Customer> getCustomers() throws IOException {
        System.out.println("Returning all customers from DB to Source");
        ResponseEntity<List> customersEntity =  restTemplate.getForEntity(redisService + "/getAllCustomersFromCache", List.class);

        String jsonText =  new Gson().toJson(customersEntity.getBody());
        JsonArray jsonArray = new JsonParser().parse(jsonText).getAsJsonArray();
        System.out.println(jsonArray.get(0));
        Type listType = new TypeToken<List<Customer>>() {}.getType();

        return new Gson().fromJson(jsonArray.toString(),listType);
    }

    @GraphQLQuery(name = "customer")
    public Customer getCustomerById(@GraphQLArgument(name = "customerId") Long customerId) {
        System.out.println("Retrieving Customer details for customerID: "+customerId);
           ResponseEntity<Customer> responseEntity = restTemplate.getForEntity(redisService+"/getOneCustomerFromCache/"+customerId, Customer.class);
           return  responseEntity.getBody();
    }

    @Bean
    public RestTemplate rest(){
        return new RestTemplate();
    }
}

package com.voyager.demo.customerdatacache;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    /*@Autowired
    RestTemplate restTemplate;

    @Value("${redisUrl}")
    String redisService;

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) { this.customerRepository = customerRepository; }*/

    @GetMapping(value = "/getAllCustomerFields", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllCustomerFields() throws ClassNotFoundException {
        Class clazz = Class.forName("com.voyager.demo.customerdatacache.Customer");
        List<String> fieldsList = new ArrayList<>();
        for(Field field : clazz.getDeclaredFields()){
            System.out.println(field.getName());
            fieldsList.add(field.getName());
        }

        return new ResponseEntity(fieldsList, HttpStatus.OK);
    }

    /*@PostMapping(value = "/addCustomerDataQuery")
    public Customer addCustomer(@RequestBody Customer customer){
        System.out.println("Incoming request in graphql code: "+customer.toString() + " for customerId : " + customer.getCustomer_id());
        ResponseEntity<Customer> response = restTemplate.postForEntity(redisService+"/addCustomerInCache", customer, Customer.class);

        System.out.println("Adding customer to DB : "+customer);
        return response.getBody();
    }

    @GetMapping(value = "customer/{customerId}")
    public String getCustomerById(@PathVariable String customerId){
        System.out.println("Returning customer "+customerId + " from DB to Source : "+redisService);

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(redisService+"/getOneCustomerFromCache/"+customerId, String.class);

        return responseEntity.getBody();
    }

    @GetMapping(value = "/customers")
    public ResponseEntity<Map> getAllCustomers(){
        System.out.println("Returning all customers from DB to Source");
        ResponseEntity<Map> customersList = restTemplate.getForEntity(redisService + "/getAllCustomersFromCache", Map.class);
        return customersList;
    }

    @DeleteMapping(value = "/deleteCustomerDataQuery/{customerId}")
    public String deleteCustomerById(@PathVariable String customerId){
        System.out.println("Deleting customer record : "+customerId);
        restTemplate.delete(redisService+"/deleteCustomerFromCache/"+customerId);
        return "Customer " + customerId + " deleted";
    }

    @DeleteMapping(value = "/deleteAllCustomers")
    public String deleteAllCustomers(){
        customerRepository.deleteAll();
        return "All customers deleted";
    }

    @Bean
    public RestTemplate rest(){
        return new RestTemplate();
    }*/

}

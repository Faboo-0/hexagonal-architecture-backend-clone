package com.fabooo.controller;

import com.fabooo.data.Customer.GetCustomerDto;
import com.fabooo.data.Customer.PostCustomerDto;
import com.fabooo.ports.api.CustomerServicesPort;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="/api/customer")
public class CustomerController {
    @Autowired
    private CustomerServicesPort customerServicesPort;

    @ApiOperation(value = "Returns list of customer", produces = "application/json")
    @GetMapping(value="/findAll", produces=APPLICATION_JSON_VALUE)
    public List<GetCustomerDto> findAll() {
        try {
            return customerServicesPort.findAll();
        }catch (Exception e){
            return null;
        }
    }

    @ApiOperation(value = "Returns customer by id", produces = "application/json")
    @GetMapping(value="/findById/{customerId}", produces=APPLICATION_JSON_VALUE)
    public GetCustomerDto findById(@PathVariable String customerId) {
        try {
            return customerServicesPort.findById(customerId);
        }catch(Exception e){
           return null;
        }
    }

    @ApiOperation(value = "Save customer data", produces = "application/json")
    @PostMapping("/save")
    public GetCustomerDto save(@RequestBody PostCustomerDto customerDto) {
        try{
            return customerServicesPort.save(customerDto);
        }catch (Exception e){
            return null;
        }
    }

    @ApiOperation(value = "Update customer data", produces = "application/json")
    @PutMapping("/update")
    public GetCustomerDto update(@RequestBody GetCustomerDto customerDto) {
        try{
            return customerServicesPort.update(customerDto);
        }catch (Exception e){
            return null;
        }
    }

    @ApiOperation(value = "Delete customer data", produces = "application/json")
    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<Void> deleteById(@PathVariable String customerId){
        try {
            customerServicesPort.deleteById(customerId);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return null;
        }
    }
}
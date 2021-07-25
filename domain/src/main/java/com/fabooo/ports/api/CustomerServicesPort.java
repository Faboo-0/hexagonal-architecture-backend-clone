package com.fabooo.ports.api;

import com.fabooo.data.Customer.GetCustomerDto;
import com.fabooo.data.Customer.PostCustomerDto;

import java.util.List;

public interface CustomerServicesPort {
    GetCustomerDto findById(String customerId);
    List<GetCustomerDto> findAll();
    GetCustomerDto save(PostCustomerDto customerDto);
    GetCustomerDto update(GetCustomerDto customerDto);
    void deleteById(String customerId);
}

package com.fabooo.ports.spi;

import com.fabooo.data.Customer.GetCustomerDto;
import com.fabooo.data.Customer.PostCustomerDto;

import java.util.List;

public interface CustomerPersistencePort {
    GetCustomerDto findById(String customerId);
    List<GetCustomerDto> findAll();
    GetCustomerDto save(PostCustomerDto customerDto);
    GetCustomerDto update(GetCustomerDto customerDto);
    void deleteById(String customerId);
}

package com.fabooo.adapters;

import com.fabooo.data.Customer.GetCustomerDto;
import com.fabooo.data.Customer.PostCustomerDto;
import com.fabooo.mappers.ObjectMapper;
import com.fabooo.ports.spi.CustomerPersistencePort;
import com.fabooo.entity.Customer;
import com.fabooo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerJpaAdapter extends ObjectMapper implements CustomerPersistencePort{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public GetCustomerDto findById(String customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);

        if(customer.isPresent()) {
            GetCustomerDto customerDto = this.map(customer.get(), GetCustomerDto.class);
            return customerDto;
        }

        return null;
    }

    @Override
    public List<GetCustomerDto> findAll() {
        List<Customer> customerList = customerRepository.findAll();
        return this.mapList(customerList, GetCustomerDto.class);
    }

    @Override
    public GetCustomerDto save(PostCustomerDto customerDto) {
        Customer customer = this.map(customerDto, Customer.class);
        return this.map(customerRepository.save(customer), GetCustomerDto.class);
    }

    @Override
    public GetCustomerDto update(GetCustomerDto customerDto) {
        Customer customer = this.map(customerDto, Customer.class);
        return this.map(customerRepository.save(customer), GetCustomerDto.class);
    }

    @Override
    public void deleteById(String customerId) {
        customerRepository.deleteById(customerId);
    }
}
package com.fabooo.services;

import com.fabooo.data.Customer.GetCustomerDto;
import com.fabooo.data.Customer.PostCustomerDto;
import com.fabooo.ports.api.CustomerServicesPort;
import com.fabooo.ports.spi.CustomerPersistencePort;

import java.util.List;

public class CustomerServicesImpl implements CustomerServicesPort {
    private CustomerPersistencePort customerPersistencePort;

    public CustomerServicesImpl(CustomerPersistencePort customerPersistencePort) {
        this.customerPersistencePort = customerPersistencePort;
    }

    @Override
    public GetCustomerDto findById(String customerId) {
        return customerPersistencePort.findById(customerId);
    }

    @Override
    public List<GetCustomerDto> findAll() {
        return customerPersistencePort.findAll();
    }

    @Override
    public GetCustomerDto save(PostCustomerDto customerDto) {
        return customerPersistencePort.save(customerDto);
    }

    @Override
    public GetCustomerDto update(GetCustomerDto customerDto) {
        return customerPersistencePort.update(customerDto);
    }

    @Override
    public void deleteById(String customerId) {
        customerPersistencePort.deleteById(customerId);
    }
}

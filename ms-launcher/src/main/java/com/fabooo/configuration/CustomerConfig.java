package com.fabooo.configuration;

import com.fabooo.adapters.CustomerJpaAdapter;
import com.fabooo.ports.api.CustomerServicesPort;
import com.fabooo.ports.spi.CustomerPersistencePort;
import com.fabooo.services.CustomerServicesImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {
    @Bean
    public CustomerPersistencePort customerPersistence(){
        return new CustomerJpaAdapter();
    }

    @Bean
    public CustomerServicesPort customerService(){
        return new CustomerServicesImpl(customerPersistence());
    }
}

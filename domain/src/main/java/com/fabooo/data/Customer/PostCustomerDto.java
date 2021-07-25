package com.fabooo.data.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   //@Getter, @Setter, @ToString, @EqualsAndHashCode and @RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostCustomerDto {
    private String name;
    private String lastname;
    private Integer age;
}

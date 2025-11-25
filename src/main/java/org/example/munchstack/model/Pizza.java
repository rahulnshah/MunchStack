package org.example.munchstack.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Pizza extends FastFood {
    private BigDecimal diameter;
    private String topping;
    private String drizzle;
    private String cheese;
}


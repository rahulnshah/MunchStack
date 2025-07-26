package org.example.munchstack.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Pizza extends FastFood {
   private BigDecimal diameter;
   private String topping;
   private String drizzle;
   private String cheese;
}


package org.example.munchstack.model;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.example.munchstack.enums.STATUS;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FastFood
{
   private String name;
   private int quantity;
   private BigDecimal price;
   private STATUS status;
}

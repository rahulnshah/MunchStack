package org.example.munchstack.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.munchstack.enums.STATUS;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class FastFood
{
   private String name;
   private int quantity;
   private BigDecimal price;
   @Builder.Default
   private STATUS status = STATUS.PENDING;
   @Builder.Default
   private Date createdAt = new Date();
}

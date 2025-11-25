package org.example.munchstack.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.munchstack.enums.STATUS;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class FastFood {
    private String name;
    private int quantity;
    private BigDecimal price;
    @Builder.Default
    private STATUS status = STATUS.PENDING;
    @Builder.Default
    private LocalDate createdAt = LocalDate.now();
}

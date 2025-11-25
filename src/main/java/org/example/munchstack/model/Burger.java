package org.example.munchstack.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Burger extends FastFood {
    private String bun;
    private String patty;
    private String condiment;
}

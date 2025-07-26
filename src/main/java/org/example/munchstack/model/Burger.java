package org.example.munchstack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Burger extends FastFood{
    private String bun;
    private String patty;
    private String condiment;
}

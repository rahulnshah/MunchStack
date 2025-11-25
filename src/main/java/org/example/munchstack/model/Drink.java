package org.example.munchstack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.munchstack.enums.SIZE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Drink extends FastFood {
    private SIZE size;
}

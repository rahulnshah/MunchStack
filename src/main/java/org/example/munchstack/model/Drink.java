package org.example.munchstack.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.munchstack.enums.SIZE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Drink extends FastFood {
    private SIZE size;
}

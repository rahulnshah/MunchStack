package org.example.munchstack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.munchstack.enums.SIZE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Drink extends FastFood {
    private SIZE size;
}

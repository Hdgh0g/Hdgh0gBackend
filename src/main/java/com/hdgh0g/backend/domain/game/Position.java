package com.hdgh0g.backend.domain.game;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Position {

    private static final int MAX = 100;
    private static final int MIN = 0;

    @Range(min = MIN, max = MAX)
    private double x;

    @Range(min = MIN, max = MAX)
    private double y;
}

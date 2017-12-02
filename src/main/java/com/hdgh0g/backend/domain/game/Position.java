package com.hdgh0g.backend.domain.game;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Position {

    private double x;
    private double y;
}

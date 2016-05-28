package com.deft.entities;

import com.badlogic.ashley.core.Entity;
import com.deft.components.HealthComponent;

/**
 * Created by k9sty on 2016-05-28.
 */
public class Player extends Entity {
    private String name;
    public Player(String name) {
        this.name = name;
        add(new HealthComponent());
    }
}

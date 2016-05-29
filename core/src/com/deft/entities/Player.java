package com.deft.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.deft.components.BodyComponent;
import com.deft.components.HealthComponent;
import com.deft.components.PositionComponent;

/**
 * Created by k9sty on 2016-05-28.
 */
public class Player extends Entity {
    private String name;
    public Vector2 position;

    public Player(World world, String name) {
        this.name = name;
        add(new HealthComponent());
        add(new PositionComponent());
        add(new BodyComponent(world));
        position = new Vector2(this.getComponent(PositionComponent.class).position);
    }
}

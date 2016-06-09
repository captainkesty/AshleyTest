package com.deft.entities;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.deft.adapters.Multiplexer;
import com.deft.components.AnimationComponent;
import com.deft.components.BodyComponent;
import com.deft.components.BodyID;
import com.deft.components.FootComponent;
import com.deft.components.HealthComponent;
import com.deft.components.MovementComponent;
import com.deft.components.PositionComponent;
import com.deft.components.SpriteComponent;
import com.deft.components.StateComponent;

/**
 * Created by k9sty on 2016-05-28.
 */
public class Player extends Entity {

    public Player(World world, String name, Multiplexer multiplexer) {
        add(new PositionComponent());
        add(new BodyComponent(world, ComponentMapper.getFor(PositionComponent.class).get(this).position));
        add(new BodyID(1, this));
        add(new FootComponent(this));
        add(new HealthComponent());
        add(new StateComponent());
        add(new AnimationComponent(name, this));
        add(new MovementComponent(this));
        multiplexer.addProcessor(ComponentMapper.getFor(MovementComponent.class).get(this));
    }
}

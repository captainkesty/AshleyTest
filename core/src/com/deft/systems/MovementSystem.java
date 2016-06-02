package com.deft.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.deft.components.AnimationComponent;
import com.deft.components.BodyComponent;
import com.deft.components.MovementComponent;
import com.deft.components.PositionComponent;

/**
 * Created by k9sty on 2016-05-28.
 */
public class MovementSystem extends IteratingSystem {
    BodyComponent bc;
    PositionComponent pc;
    Array<Entity> entities;

    public MovementSystem() {
        super(Family.one(BodyComponent.class, PositionComponent.class).get());
        entities = new Array<Entity>();
    }

    @Override
    public void update(float deltaTime) {
        for (Entity e : entities) {
            bc = ComponentMapper.getFor(BodyComponent.class).get(e);
            pc = ComponentMapper.getFor(PositionComponent.class).get(e);
            pc.position = bc.body.getPosition();
        }
        System.out.println(entities);
        entities.clear();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        entities.add(entity);
    }
}

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

public class MovementSystem extends IteratingSystem {
    Array<Entity> renderQ;

    public MovementSystem() {
        super(Family.all(BodyComponent.class, PositionComponent.class).get(), 1);
        renderQ = new Array<Entity>();
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        for (Entity e : renderQ) {
            BodyComponent bc = ComponentMapper.getFor(BodyComponent.class).get(e);
            PositionComponent pc = ComponentMapper.getFor(PositionComponent.class).get(e);
            pc.position = bc.body.getPosition();
        }
        renderQ.clear();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        renderQ.add(entity);
    }
}

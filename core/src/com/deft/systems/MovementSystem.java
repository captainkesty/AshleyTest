package com.deft.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.deft.components.BodyComponent;
import com.deft.components.MovementComponent;
import com.deft.components.PositionComponent;

/**
 * Created by k9sty on 2016-05-28.
 */
public class MovementSystem extends IteratingSystem {
    private ComponentMapper<BodyComponent> bc = ComponentMapper.getFor(BodyComponent.class);
    private ComponentMapper<PositionComponent> pc = ComponentMapper.getFor(PositionComponent.class);
    Array<Entity> entities;

    public MovementSystem() {
        super(Family.all(BodyComponent.class, MovementComponent.class).get());
        entities = new Array<Entity>();
    }

    public void update(float deltaTime) {
        for (Entity e : entities) {
            Vector2 position = pc.get(e).position;
            System.out.println(position);
        }
        entities.clear();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        entities.add(entity);
        pc.get(entity).position = bc.get(entity).body.getPosition();
    }
}

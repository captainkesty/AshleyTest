package com.deft.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.utils.Array;
import com.deft.components.BodyComponent;
import com.deft.components.GravityComponent;
import com.deft.components.PositionComponent;

/**
 * Created by k9sty on 2016-06-11.
 */
public class GravitySystem extends IteratingSystem {
    private ComponentMapper<PositionComponent> p;
    Array<Entity> renderQ;

    public GravitySystem() {
        super(Family.all(GravityComponent.class, PositionComponent.class).get());
        p = ComponentMapper.getFor(PositionComponent.class);
        renderQ = new Array<Entity>();

    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        for (Entity entity : renderQ) {
            BodyComponent bc = ComponentMapper.getFor(BodyComponent.class).get(entity);
            bc.body.applyLinearImpulse(0, -5, bc.body.getPosition().x, bc.body.getPosition().y, true);
        }
        renderQ.clear();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        renderQ.add(entity);
    }
}

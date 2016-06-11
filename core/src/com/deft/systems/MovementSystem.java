package com.deft.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.utils.Array;
import com.deft.components.BodyComponent;
import com.deft.components.MovementComponent;
import com.deft.components.PositionComponent;
import com.deft.entities.Player;

public class MovementSystem extends IteratingSystem {
    Array<Entity> renderQ;
    Player player;
    MovementComponent mc;

    public MovementSystem(Player player) {
        super(Family.all(BodyComponent.class, PositionComponent.class).get());
        renderQ = new Array<Entity>();
        this.player = player;
        mc = ComponentMapper.getFor(MovementComponent.class).get(player);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        mc.move();
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

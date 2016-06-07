package com.deft.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.Array;
import com.deft.components.BodyComponent;
import com.deft.components.PositionComponent;
import com.deft.entities.Player;

public class MovementSystem extends IteratingSystem {
    Array<Entity> renderQ;
    Player player;

    public MovementSystem(Player player) {
        super(Family.all(BodyComponent.class, PositionComponent.class).get(), 1);
        renderQ = new Array<Entity>();
        this.player = player;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            BodyComponent bc = ComponentMapper.getFor(BodyComponent.class).get(player);
            bc.body.setLinearVelocity(bc.body.getMass() * -100, bc.body.getLinearVelocity().y);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            BodyComponent bc = ComponentMapper.getFor(BodyComponent.class).get(player);
            bc.body.setLinearVelocity(bc.body.getMass() * 100, bc.body.getLinearVelocity().y);
        }
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

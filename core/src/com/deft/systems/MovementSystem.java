package com.deft.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import com.deft.components.BodyComponent;
import com.deft.components.MovementComponent;

/**
 * Created by k9sty on 2016-05-28.
 */
public class MovementSystem extends IteratingSystem {
    private Vector2 tmp = new Vector2();

    public MovementSystem(Family family) {
        super(Family.all(BodyComponent.class, MovementComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
    }
}

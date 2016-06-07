package com.deft.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by k9sty on 2016-05-28.
 */

public class BodyComponent implements Component {
    PolygonShape shape;
    public Body body;
    BodyDef bdef;
    FixtureDef fdef;
    float width, height;

    public BodyComponent(World world, Vector2 position) {
        width = 10;
        height = 10;
        bdef = new BodyDef();
        shape = new PolygonShape();
        bdef.position.set(position);
        bdef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bdef);
        body.setFixedRotation(true);
        body.setSleepingAllowed(false);

        shape.setAsBox(width, height);
        fdef = new FixtureDef();
        fdef.shape = shape;
        body.createFixture(fdef);
        shape.dispose();
    }
}

package com.deft.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.Gdx;
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
    Body body;
    BodyDef bdef;
    FixtureDef fdef;

    public BodyComponent(World world) {
        bdef = new BodyDef();
        shape = new PolygonShape();
        bdef.type = BodyDef.BodyType.StaticBody;
        body = world.createBody(bdef);
        body.setFixedRotation(true);
        body.setSleepingAllowed(false);

        shape.setAsBox(20f, 20f);
        fdef = new FixtureDef();
        fdef.shape = shape;
        body.createFixture(fdef);
        shape.dispose();
    }
}

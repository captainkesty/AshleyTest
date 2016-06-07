package com.deft.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

/**
 * Created by kesty on 6/7/2016.
 */
public class FootComponent implements Component {
    PolygonShape shape;
    FixtureDef fdef;
    float width, height;
    BodyComponent bc;

    public FootComponent(Entity e) {
        bc = ComponentMapper.getFor(BodyComponent.class).get(e);
        width = bc.width;
        height = bc.height;
        shape = new PolygonShape();

        shape.setAsBox(width, 0.2f, new Vector2(bc.body.getPosition().x - width * 32, bc.body.getPosition().y - (height * 32) + (height * 7) - 0.2f), 0);
        fdef = new FixtureDef();
        fdef.filter.maskBits = 1;
        fdef.filter.groupIndex = -2;
        fdef.shape = shape;
        bc.body.createFixture(fdef);
        shape.dispose();
    }
}

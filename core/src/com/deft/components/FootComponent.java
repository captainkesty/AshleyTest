package com.deft.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.RayCastCallback;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by kesty on 6/7/2016.
 */
public class FootComponent implements Component {
    PolygonShape shape;
    FixtureDef fdef;
    float width, height;
    BodyComponent bc;
    Fixture foot;
    Vector2 FOOT_POS;
    ShapeRenderer shapeDebugger = new ShapeRenderer();
    boolean onSlope;

    public FootComponent(Entity e) {
        bc = ComponentMapper.getFor(BodyComponent.class).get(e);
        width = bc.width;
        height = bc.height;
        shape = new PolygonShape();
        FOOT_POS = new Vector2(bc.body.getPosition().x - width * 32, bc.body.getPosition().y - (height * 32) + (height * 7) - 0.2f);
        shape.setAsBox(width, 0.2f, FOOT_POS, 0);
        fdef = new FixtureDef();
        fdef.filter.maskBits = 1;
        fdef.filter.groupIndex = -2;
        fdef.shape = shape;
        foot = bc.body.createFixture(fdef);
        shape.dispose();
    }

    Vector2 intersectionL = new Vector2();
    Vector2 intersectionR = new Vector2();
    Vector2 normalL = new Vector2();
    Vector2 normalR = new Vector2();
    float tempX, tempY;

    public void render(World world, Camera camera, boolean onSlope) {
        this.onSlope = onSlope;
        FOOT_POS = new Vector2(bc.body.getPosition().x, bc.body.getPosition().y - 10.2f);
        raycast(world);
        System.out.println(intersectionL.dst(FOOT_POS));
        if (normalL.y != 1 && intersectionL.dst(FOOT_POS) <= 11) {
            bc.body.setLinearVelocity(0, 5);
        } else if (normalR.y != 1 && intersectionR.dst(FOOT_POS) <= 11) {
            bc.body.setLinearVelocity(0, 5);
        } else ;
        shapeDebugger.begin(ShapeRenderer.ShapeType.Line);
        shapeDebugger.setProjectionMatrix(camera.combined);
        shapeDebugger.setColor(1, 1, 1, 1);
        shapeDebugger.line(bc.body.getPosition().x, bc.body.getPosition().y, FOOT_POS.x - width * 2, FOOT_POS.y - height);
        shapeDebugger.line(bc.body.getPosition().x, bc.body.getPosition().y, FOOT_POS.x + width * 2, FOOT_POS.y - height);
        shapeDebugger.circle(intersectionL.x, intersectionL.y, 5);
        shapeDebugger.circle(intersectionR.x, intersectionR.y, 5);
        shapeDebugger.end();
    }

    private void raycast(World world) {
        world.rayCast(new RayCastCallback() {
            @Override
            public float reportRayFixture(Fixture fixture, Vector2 point, Vector2 normal, float fraction) {
                tempX = normal.x;
                tempY = normal.y;
                normalL = new Vector2(tempX, tempY);
                if (fixture == foot) {
                    onSlope = false;
                    return -1;
                } else {
                    intersectionL = new Vector2(point.x, point.y);
                    onSlope = true;
                    return fraction;
                }
            }
        }, new Vector2(bc.body.getPosition().x, bc.body.getPosition().y), new Vector2(FOOT_POS.x - width * 2, FOOT_POS.y - height));
        world.rayCast(new RayCastCallback() {
            @Override
            public float reportRayFixture(Fixture fixture, Vector2 point, Vector2 normal, float fraction) {
                tempX = normal.x;
                tempY = normal.y;
                normalR = new Vector2(tempX, tempY);
                if (fixture == foot) {
                    onSlope = false;
                    return -1;
                } else {
                    intersectionR = new Vector2(point.x, point.y);
                    onSlope = true;
                    return fraction;
                }
            }
        }, new Vector2(bc.body.getPosition().x, bc.body.getPosition().y), new Vector2(FOOT_POS.x + width * 2, FOOT_POS.y - height));
    }
}

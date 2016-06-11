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

    Vector2 intersectionL = new Vector2(0, 0);
    Vector2 intersectionR = new Vector2(0, 0);
    Vector2 intersection = new Vector2(0, 0);

    public void render(World world, Camera camera, boolean right, boolean onSlope) {
        this.onSlope = onSlope;
        FOOT_POS = new Vector2(bc.body.getPosition().x, bc.body.getPosition().y - 10.2f);
        raycast(world, right);
        if ((int) (intersectionL.x - intersectionR.x) == -20) ;// worst hack of the century
        else {
            if (FOOT_POS.x - intersectionL.x <= 11 && FOOT_POS.x - intersectionL.x >= 0) {
                bc.body.setLinearVelocity(0, 10);
                System.out.println("on slope L");
                System.out.println(FOOT_POS.x - intersectionL.x);
            } else if (FOOT_POS.x - intersectionR.x >= -11 && FOOT_POS.x - intersectionR.x <= 0) {
                bc.body.setLinearVelocity(0, 10);
                System.out.println("on slope R");
                System.out.println(FOOT_POS.x - intersectionR.x);
            } // what the fuck?
        }

        shapeDebugger.begin(ShapeRenderer.ShapeType.Line);
        shapeDebugger.setProjectionMatrix(camera.combined);
        shapeDebugger.setColor(1, 1, 1, 1);

        //shapeDebugger.line(bc.body.getPosition().x, FOOT_POS.y, bc.body.getPosition().x + Gdx.graphics.getWidth() / 2, FOOT_POS.y);
        //shapeDebugger.line(bc.body.getPosition().x, FOOT_POS.y, bc.body.getPosition().x - Gdx.graphics.getWidth() / 2, FOOT_POS.y);
        shapeDebugger.line(bc.body.getPosition().x, bc.body.getPosition().y, FOOT_POS.x - width * 2, FOOT_POS.y - height);
        shapeDebugger.line(bc.body.getPosition().x, bc.body.getPosition().y, FOOT_POS.x + width * 2, FOOT_POS.y - height);

        shapeDebugger.circle(intersectionL.x, intersectionL.y, 5);
        shapeDebugger.circle(intersectionR.x, intersectionR.y, 5);
        shapeDebugger.end();
    }

    private void raycast(World world, boolean right) {
        /*world.rayCast(new RayCastCallback() {
            @Override
            public float reportRayFixture(Fixture fixture, Vector2 point, Vector2 normal, float fraction) {
                intersectionR = new Vector2(point.x, point.y);
                return fraction;
                //return -1: ignore this fixture and continue
                //return 0: terminate the ray cast
                //return fraction: clip the ray to this point
                //return 1: don't clip the ray and continue.
            }
        }, new Vector2(bc.body.getPosition().x, FOOT_POS.y), new Vector2(bc.body.getPosition().x + Gdx.graphics.getWidth() / 2, FOOT_POS.y));
        world.rayCast(new RayCastCallback() {
            @Override
            public float reportRayFixture(Fixture fixture, Vector2 point, Vector2 normal, float fraction) {
                intersectionL = new Vector2(point.x, point.y);
                return fraction;
                //return -1: ignore this fixture and continue
                //return 0: terminate the ray cast
                //return fraction: clip the ray to this point
                //return 1: don't clip the ray and continue.
            }
        }, new Vector2(bc.body.getPosition().x, FOOT_POS.y), new Vector2(bc.body.getPosition().x - Gdx.graphics.getWidth() / 2, FOOT_POS.y));*/
        world.rayCast(new RayCastCallback() {
            @Override
            public float reportRayFixture(Fixture fixture, Vector2 point, Vector2 normal, float fraction) {
                if (fixture == foot) {
                    onSlope = false;
                    return -1;
                } else {
                    intersectionR = new Vector2(point.x, point.y);
                    onSlope = true;
                    return fraction;
                }
                //return -1: ignore this fixture and continue
                //return 0: terminate the ray cast
                //return fraction: clip the ray to this point
                //return 1: don't clip the ray and continue.
            }
        }, new Vector2(bc.body.getPosition().x, bc.body.getPosition().y), new Vector2(FOOT_POS.x + width * 2, FOOT_POS.y - height));
        world.rayCast(new RayCastCallback() {
            @Override
            public float reportRayFixture(Fixture fixture, Vector2 point, Vector2 normal, float fraction) {
                if (fixture == foot) {
                    onSlope = false;
                    return -1;
                } else {
                    intersectionL = new Vector2(point.x, point.y);
                    onSlope = true;
                    return fraction;
                }
                //return -1: ignore this fixture and continue
                //return 0: terminate the ray cast
                //return fraction: clip the ray to this point
                //return 1: don't clip the ray and continue.
            }
        }, new Vector2(bc.body.getPosition().x, bc.body.getPosition().y), new Vector2(FOOT_POS.x - width * 2, FOOT_POS.y - height));
    }
}

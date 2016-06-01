package com.deft.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.deft.CameraRenderer;
import com.deft.components.AnimationComponent;
import com.deft.components.PositionComponent;
import com.deft.components.SpriteComponent;
import com.deft.components.StateComponent;
import com.deft.entities.Player;

/**
 * Created by k9sty on 2016-05-28.
 */
public class RenderingSystem extends IteratingSystem {
    CameraRenderer camera;
    TiledMapRenderer tiledMapRenderer;
    Box2DDebugRenderer b2dr;
    World world;
    SpriteBatch sb;
    Player player;
    Array<Entity> renderQ;

    public RenderingSystem(SpriteBatch batch, World world, Player player) {
        super(Family.all(SpriteComponent.class, PositionComponent.class, StateComponent.class).get());
        sb = batch;
        renderQ = new Array<Entity>();
        this.world = world;
        this.player = player;
        camera = new CameraRenderer();
        b2dr = new Box2DDebugRenderer();
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        world.step(1 / 60f, 6, 2);
        camera.render(player.position);
        sb.setProjectionMatrix(camera.combined);
        for (Entity entity : renderQ) {
            System.out.println("a");
            AnimationComponent a = ComponentMapper.getFor(AnimationComponent.class).get(entity);
            a.render(sb, entity);
        }
        try {
            b2dr.render(world, camera.combined);
            tiledMapRenderer.setView(camera);
            tiledMapRenderer.render();
        } catch (Exception e) {
        }
        renderQ.clear();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        renderQ.add(entity);
    }
}

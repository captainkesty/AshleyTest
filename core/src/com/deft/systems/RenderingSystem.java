package com.deft.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.deft.CameraRenderer;
import com.deft.components.TextureComponent;
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

    public RenderingSystem(SpriteBatch batch, World world, Player player) {
        super(Family.all(TextureComponent.class).get());
        sb = batch;
        this.world = world;
        this.player = player;
        camera = new CameraRenderer();
        b2dr = new Box2DDebugRenderer();
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        world.step(1 / 60f, 6, 2);
        camera.render(player.position);
        sb.setProjectionMatrix(camera.combined);
        System.out.println("rendering");
        sb.begin();
        try {
            b2dr.render(world, camera.combined);
            tiledMapRenderer.setView(camera);
            tiledMapRenderer.render();
        } catch (Exception e) {
            System.out.println("no map loaded");
        }
        sb.end();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

    }
}

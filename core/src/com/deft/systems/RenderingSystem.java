package com.deft.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.deft.components.TextureComponent;

/**
 * Created by k9sty on 2016-05-28.
 */
public class RenderingSystem extends IteratingSystem {
    OrthographicCamera camera;
    TiledMapRenderer tiledMapRenderer;

    public RenderingSystem(SpriteBatch batch) {
        super(Family.all(TextureComponent.class).get());
        createCamera();
    }

    private void createCamera() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 64 * (19 / 2), 64 * (10 / 2));
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        camera.update();
        System.out.println("rendering");
        try {
            tiledMapRenderer.setView(camera);
            tiledMapRenderer.render();
        } catch (Exception e) {
            System.out.println("no map loaded");
        }
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

    }
}

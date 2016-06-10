package com.deft.adapters;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.deft.screens.GameScreen;
import com.deft.entities.Map;
import com.deft.systems.RenderingSystem;

/**
 * Created by kesty on 6/9/2016.
 */
public class DebugInput implements InputProcessor {
    Engine engine;
    World world;

    public DebugInput(Engine engine, World world) {
        this.engine = engine;
        this.world = world;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == com.badlogic.gdx.Input.Keys.Z) {
            Map map = new Map(world, "debugroom");
            engine.addEntity(map);
            RenderingSystem.tiledMapRenderer = new OrthogonalTiledMapRenderer(map.getMap(), map.getUnitScale());
        }
        if (keycode == com.badlogic.gdx.Input.Keys.C) {
            try {
                Array<Body> arBodies = new Array<Body>();
                world.getBodies(arBodies);
                for (Body b : arBodies) {
                    if (b.getUserData() == null) {
                        world.destroyBody(b);
                    }
                }
                engine.removeEntity(GameScreen.map);
                RenderingSystem.tiledMapRenderer = new OrthogonalTiledMapRenderer(null);
            } catch (Exception e) {
            }
        }
        if (keycode == Input.Keys.V) {

        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}

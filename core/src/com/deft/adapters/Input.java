package com.deft.adapters;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.deft.components.BodyComponent;
import com.deft.entities.Player;

public class Input implements InputProcessor {
    Player player;
    BodyComponent bc;


    public Input(Player player) {
        this.player = player;
        bc = ComponentMapper.getFor(BodyComponent.class).get(player);
    }

    @Override
    public boolean keyDown(int keycode) {
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.LEFT)) {
            bc.body.setLinearVelocity(bc.body.getMass() * -100, bc.body.getLinearVelocity().y);
        } else if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.RIGHT)) {
            bc.body.setLinearVelocity(bc.body.getMass() * 100, bc.body.getLinearVelocity().y);
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        bc.body.setLinearVelocity(0, bc.body.getLinearVelocity().y);
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
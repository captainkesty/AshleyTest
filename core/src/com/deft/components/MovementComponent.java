package com.deft.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.deft.entities.Player;

/**
 * Created by k9sty on 2016-05-28.
 */
public class MovementComponent implements Component, InputProcessor {
    Player player;
    BodyComponent bc;
    StateComponent sc;

    public MovementComponent(Player player) {
        this.player = player;
        bc = ComponentMapper.getFor(BodyComponent.class).get(player);
        sc = ComponentMapper.getFor(StateComponent.class).get(player);
    }

    public void move() {
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.LEFT)) {
            sc.setIdle(false);
            sc.setRight(false);
            bc.body.setLinearVelocity(bc.body.getMass() * -100, bc.body.getLinearVelocity().y);
        } else if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.RIGHT)) {
            sc.setIdle(false);
            sc.setRight(true);
            bc.body.setLinearVelocity(bc.body.getMass() * 100, bc.body.getLinearVelocity().y);
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.X)
            bc.body.applyLinearImpulse(0, 2000, bc.body.getPosition().x, bc.body.getPosition().y, true);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == com.badlogic.gdx.Input.Keys.LEFT || keycode == com.badlogic.gdx.Input.Keys.RIGHT) {
            bc.body.setLinearVelocity(0, bc.body.getLinearVelocity().y);
            sc.setIdle(true);
        }
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

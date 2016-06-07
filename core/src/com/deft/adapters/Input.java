package com.deft.adapters;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.deft.components.BodyComponent;
import com.deft.components.StateComponent;
import com.deft.entities.Player;

public class Input implements InputProcessor {
    Player player;
    BodyComponent bc;
    StateComponent sc;


    public Input(Player player) {
        this.player = player;
        bc = ComponentMapper.getFor(BodyComponent.class).get(player);
        sc = ComponentMapper.getFor(StateComponent.class).get(player);
    }

    @Override
    public boolean keyDown(int keycode) {
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
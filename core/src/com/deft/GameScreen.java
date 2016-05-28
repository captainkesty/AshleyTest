package com.deft;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.deft.entities.Player;
import com.deft.systems.RenderingSystem;

/**
 * Created by k9sty on 2016-05-28.
 */
public class GameScreen implements Screen {
    Assets assets = new Assets();
    Music bgm;
    Engine engine = new Engine();
    SpriteBatch batch = new SpriteBatch();

    GameScreen(Game game) {
        bgm = assets.loadMusic("boop");
        bgm.play();
        engine.addEntity(new Player("Player"));
        engine.addSystem(new RenderingSystem(batch));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        engine.update(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

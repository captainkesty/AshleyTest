package com.deft.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.deft.Assets;
import com.kotcrab.vis.runtime.font.FreeTypeFontProvider;
import com.kotcrab.vis.runtime.scene.Scene;
import com.kotcrab.vis.runtime.scene.VisAssetManager;

/**
 * Created by k9sty on 2016-06-09.
 */
public class Menu extends ScreenAdapter implements InputProcessor {
    Assets assets = new Assets();
    Music bgm;
    SpriteBatch sb;
    boolean musicStarted = false;
    VisAssetManager m;
    Scene scene;
    Game game;

    public Menu(Game game) {
        this.game = game;
        bgm = assets.loadMusic("sp");
        bgm.play();
        sb = new SpriteBatch();

        // this is epic
        m = new VisAssetManager(sb);
        m.enableFreeType(new FreeTypeFontProvider());
        scene = m.loadSceneNow("scene/Menu.scene");

    }

    @Override
    public void render(float deltaTime) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // wowie
        scene.render();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void hide() {
        m.dispose();
        bgm.stop();
        bgm.dispose();
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
        game.setScreen(new GameScreen(game));
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

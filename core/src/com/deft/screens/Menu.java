package com.deft.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.deft.Assets;
import com.kotcrab.vis.runtime.font.FreeTypeFontProvider;
import com.kotcrab.vis.runtime.scene.Scene;
import com.kotcrab.vis.runtime.scene.VisAssetManager;

/**
 * Created by k9sty on 2016-06-09.
 */
public class Menu extends ScreenAdapter {
    Assets assets = new Assets();
    Music bgm;
    SpriteBatch sb;
    boolean musicStarted = false;
    VisAssetManager m;
    Scene scene;

    public Menu(Game game) {
        bgm = assets.loadMusic("menu");
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
        if (!musicStarted)
            Timer.schedule(new Timer.Task() {

                @Override
                public void run() {
                    musicStarted = true;
                }

            }, 1.5f);
        else {
            // wowie
            scene.render();
        }
    }
}

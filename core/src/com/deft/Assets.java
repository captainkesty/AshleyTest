package com.deft;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by k9sty on 2016-05-28.
 */
public class Assets extends AssetManager {
    public Assets() {
        finishLoading();
    }

    public void message(String file) {
        System.out.println("loaded " + file);
    }

    public Music loadMusic(String file) {
        load("bgm/" + file + ".mp3", Music.class);
        finishLoading();
        Music music = get("bgm/" + file + ".mp3", Music.class);
        music.setLooping(true);
        music.setVolume(0.5f);
        message(file);
        return music;
    }

    public void loadSound(String file) {
        load("sfx/" + file + ".mp3", Sound.class);
        message(file);
    }

    public BitmapFont loadFont(String file) {
        FileHandle font = Gdx.files.internal("font/" + file + ".ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(font);
        FreeTypeFontGenerator.FreeTypeFontParameter p = new FreeTypeFontGenerator.FreeTypeFontParameter();
        p.size = 12;
        BitmapFont b = generator.generateFont(p);
        generator.dispose();
        message(file);
        return b;
    }
}
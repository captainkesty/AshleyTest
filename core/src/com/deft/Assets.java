package com.deft;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by k9sty on 2016-05-28.
 */
public class Assets extends AssetManager {
    Assets() {
        finishLoading();
    }

    public Music loadMusic(String file) {
        load("bgm/" + file + ".mp3", Music.class);
        finishLoading();
        Music music = get("bgm/" + file + ".mp3", Music.class);
        music.setLooping(true);
        music.setVolume(0.5f);
        return music;
    }

    public void loadSound(String file) {
        load("sfx/" + file + ".mp3", Sound.class);
    }
}
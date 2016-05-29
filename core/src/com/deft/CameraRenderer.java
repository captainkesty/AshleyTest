package com.deft;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by k9sty on 2016-05-28.
 */
public class CameraRenderer extends OrthographicCamera {
    public CameraRenderer() {
        setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public void render(Vector2 xy) {
        position.set(xy, 0);
        update();
    }
}
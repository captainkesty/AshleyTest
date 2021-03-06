package com.deft;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by k9sty on 2016-05-28.
 */
public class CameraRenderer extends OrthographicCamera {
    public CameraRenderer() {
        setToOrtho(false, 32 * (19/2), 32 * 5);
        //setToOrtho(false, 32 * 28, 32 * 20);
    }

    public void render(Vector2 xy) {
        position.set(xy, 0);
        update();
    }
}
package com.deft.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by k9sty on 2016-05-28.
 */
public class PositionComponent implements Component {
    public float x = Gdx.graphics.getWidth() / 2;
    public float y = Gdx.graphics.getHeight() / 2;
    public Vector2 position = new Vector2(x, y);
}

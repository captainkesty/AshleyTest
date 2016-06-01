package com.deft.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by kesty on 6/1/2016.
 */
public class SpriteComponent implements Component {
    Sprite sprite = new Sprite();

    public void render(SpriteBatch sb, float x, float y) {
        sb.begin();
        sb.draw(sprite, x, y);
        sb.end();
    }
}

package com.deft.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class SpriteComponent implements Component {
    Sprite sprite = new Sprite();

    public void render(SpriteBatch sb, float x, float y) {
        sb.begin();
        sb.draw(sprite, x, y);
        sb.end();
    }
}

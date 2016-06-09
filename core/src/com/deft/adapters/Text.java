package com.deft.adapters;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;

/**
 * Created by k9sty on 2016-06-09.
 */
public class Text extends BitmapFontCache {
    public Text(BitmapFont font, String s, float x, float y) {
        super(font);
        addText(s, x, y);
    }
}

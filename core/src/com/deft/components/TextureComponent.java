package com.deft.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by k9sty on 2016-05-28.
 */
public class TextureComponent implements Component {
    public TextureRegion region = null;

    public static TextureComponent create(){
        return new TextureComponent();
    }
    public TextureComponent setRegion(TextureRegion region){
        this.region = region;
        return this;
    }
}

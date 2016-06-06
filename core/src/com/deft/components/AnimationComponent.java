package com.deft.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.deft.CameraRenderer;

/**
 * Created by kesty on 6/1/2016.
 */
public class AnimationComponent implements Component {
    TextureAtlas taIdle;
    TextureAtlas taWalk;
    Animation aniIdle, aniWalk;
    float elapsedTime = 0;

    public AnimationComponent(String host) {
        taIdle = new TextureAtlas(Gdx.files.internal(host + "/idle/idle.pack"));
        taWalk = new TextureAtlas(Gdx.files.internal(host + "/run/run.pack"));
        aniIdle = new Animation(10, taIdle.getRegions());
        aniWalk = new Animation(10, taWalk.getRegions());
        System.out.println("animinit");
    }

    public void render(SpriteBatch sb, Entity entity, CameraRenderer c) {
        Vector2 pos = new Vector2(entity.getComponent(PositionComponent.class).position);
        sb.setProjectionMatrix(c.combined);
        elapsedTime++;


        TextureRegion textureRegion;
        sb.begin();
        if (entity.getComponent(StateComponent.class).getIdle())
            textureRegion = aniIdle.getKeyFrame(elapsedTime, true);

        else
            textureRegion = aniWalk.getKeyFrame(elapsedTime, true);

        int width = textureRegion.getRegionWidth();
        int height = textureRegion.getRegionHeight();

        if (entity.getComponent(StateComponent.class).getRight())
            sb.draw(textureRegion, pos.x - width / 2, pos.y - height / 2, width, height);

        else
            sb.draw(textureRegion, pos.x + width / 2, pos.y - height / 2, -width, height);
        sb.end();
    }
}

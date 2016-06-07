package com.deft.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
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
    StateComponent sc;

    public AnimationComponent(String host, Entity player) {
        taIdle = new TextureAtlas(Gdx.files.internal(host + "/idle/idle.pack"));
        taWalk = new TextureAtlas(Gdx.files.internal(host + "/run/run.pack"));
        aniIdle = new Animation(10, taIdle.getRegions());
        aniWalk = new Animation(10, taWalk.getRegions());
        sc = ComponentMapper.getFor(StateComponent.class).get(player);
    }

    public void render(SpriteBatch sb, Entity entity, CameraRenderer c) {
        Vector2 pos = new Vector2(entity.getComponent(PositionComponent.class).position);
        float width = entity.getComponent(BodyComponent.class).width;
        float height = entity.getComponent(BodyComponent.class).height;
        sb.setProjectionMatrix(c.combined);
        elapsedTime++;


        TextureRegion textureRegion;
        sb.begin();
        if (sc.getIdle())
            textureRegion = aniIdle.getKeyFrame(elapsedTime, true);

        else
            textureRegion = aniWalk.getKeyFrame(elapsedTime, true);

        if (sc.getRight())
            sb.draw(textureRegion, pos.x - width, pos.y - height, width * 2, height * 2);

        else
            sb.draw(textureRegion, pos.x + width, pos.y - height, -width * 2, height * 2);
        sb.end();
    }
}

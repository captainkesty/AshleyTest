package com.deft;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.deft.entities.Player;
import com.deft.systems.MovementSystem;
import com.deft.systems.RenderingSystem;

/**
 * Created by k9sty on 2016-05-28.
 */
public class GameScreen implements Screen {
    Assets assets = new Assets();
    Music bgm;
    Engine engine = new Engine();
    SpriteBatch batch = new SpriteBatch();
    World world;
    Player player;

    GameScreen(Game game) {
        world = new World(new Vector2(0, -9.81f), true);
        player = new Player(world, "Player");
        bgm = assets.loadMusic("boop");
        bgm.play();
        engine.addEntity(player);
        engine.addSystem(new RenderingSystem(batch, world, player));
        engine.addSystem(new MovementSystem());
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        engine.update(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

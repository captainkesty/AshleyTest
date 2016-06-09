package com.deft.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.deft.Assets;
import com.deft.adapters.DebugInput;
import com.deft.adapters.Multiplexer;
import com.deft.entities.Map;
import com.deft.entities.Player;
import com.deft.systems.MovementSystem;
import com.deft.systems.RenderingSystem;

/**
 * Created by k9sty on 2016-05-28.
 */
public class GameScreen extends ScreenAdapter {
    Assets assets = new Assets();
    Music bgm;
    Engine engine = new Engine();
    SpriteBatch batch = new SpriteBatch();
    World world;
    Player player;
    public static Map map;
    Multiplexer multiplexer = new Multiplexer();

    public GameScreen(Game game) {
        world = new World(new Vector2(0, -200), true);
        player = new Player(world, "player", multiplexer);
        multiplexer.addProcessor(new DebugInput(engine, world));
        map = new Map(world, "debugroom");
        bgm = assets.loadMusic("boop");
        bgm.play();
        engine.addEntity(map);
        engine.addEntity(player);
        engine.addSystem(new MovementSystem(player));
        engine.addSystem(new RenderingSystem(batch, world, player, map));
        Gdx.input.setInputProcessor(multiplexer);
    }
    @Override
    public void render(float delta) {
        engine.update(delta);
    }
}

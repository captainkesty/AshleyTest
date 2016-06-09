package com.deft;

import com.badlogic.gdx.Game;
import com.deft.screens.Menu;

public class AshleyTest extends Game {
    @Override
    public void create() {
        //setScreen(new GameScreen(this));
        setScreen(new Menu(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}

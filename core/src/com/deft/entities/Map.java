package com.deft.entities;

// MAP ID: 0

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.physics.box2d.World;
import com.deft.components.BodyID;

import net.dermetfan.gdx.physics.box2d.Box2DMapObjectParser;

public class Map extends Entity {
    public Box2DMapObjectParser b2dmop;
    String MAP_NAME;

    public Map(World world, String MAP_NAME) {
        this.MAP_NAME = MAP_NAME;
        b2dmop = new Box2DMapObjectParser();
        b2dmop.load(world, new TmxMapLoader().load("maps/" + MAP_NAME + ".tmx"));
        b2dmop.getBodies();
        b2dmop.getFixtures();
        b2dmop.getJoints();
    }

    public TiledMap getMap() {
        return new TmxMapLoader().load("maps/" + this.MAP_NAME + ".tmx");
    }

    public float getUnitScale() {
        return b2dmop.getUnitScale();
    }
}

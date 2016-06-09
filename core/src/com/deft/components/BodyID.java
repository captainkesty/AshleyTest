package com.deft.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;

/**
 * Created by kesty on 6/9/2016.
 */
public class BodyID implements Component {
    BodyComponent bc;

    public BodyID(int ID, Entity e) {
        bc = ComponentMapper.getFor(BodyComponent.class).get(e);
        bc.body.setUserData(ID);
    }
}

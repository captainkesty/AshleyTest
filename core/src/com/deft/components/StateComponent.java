package com.deft.components;

import com.badlogic.ashley.core.Component;

/**
 * Created by kesty on 5/30/2016.
 */
public class StateComponent implements Component {
    private String state = "DEFAULT";
    public float time = 0.0f;
    public boolean isLooping = false;

    public void set(String newState) {
        state = newState;
        time = 0.0f;
    }

    public String get() {
        return state;
    }
}

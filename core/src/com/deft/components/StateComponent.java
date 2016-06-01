package com.deft.components;

import com.badlogic.ashley.core.Component;

/**
 * Created by kesty on 5/30/2016.
 */
public class StateComponent implements Component {
    public boolean idle;
    public boolean right;

    public void setIdle(boolean idle) {
        this.idle = idle;
    }

    public Boolean getIdle() {
        return idle;
    }

    public void setRight(boolean right){
        this.right = right;
    }
    public Boolean getRight() {
        return right;
    }
}

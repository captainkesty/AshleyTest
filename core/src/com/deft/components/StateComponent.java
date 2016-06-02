package com.deft.components;

import com.badlogic.ashley.core.Component;

public class StateComponent implements Component {
    public boolean idle = true;
    public boolean right = true;

    public void setIdle(boolean idle) {
        this.idle = idle;
    }

    public Boolean getIdle() {
        return idle;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public Boolean getRight() {
        return right;
    }
}

package com.deft.ai;

import com.badlogic.gdx.ai.fsm.State;
import com.badlogic.gdx.ai.msg.Telegram;

/**
 * Created by k9sty on 2016-06-11.
 */
public class TestAIState implements State<TestAIAgent> {
    @Override
    public void enter(TestAIAgent entity) {

    }

    @Override
    public void update(TestAIAgent entity) {

    }

    @Override
    public void exit(TestAIAgent entity) {

    }

    @Override
    public boolean onMessage(TestAIAgent entity, Telegram telegram) {
        return false;
    }
}

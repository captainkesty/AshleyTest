package com.deft.ai;

import com.badlogic.gdx.ai.msg.Telegram;
import com.badlogic.gdx.ai.msg.Telegraph;
import com.deft.components.EnemyComponent;

/**
 * Created by k9sty on 2016-06-11.
 */
public class TestAIAgent implements Telegraph {
    public TestAIAgent(EnemyComponent enemyComponent) {

    }
    @Override
    public boolean handleMessage(Telegram msg) {
        return false;
    }
}

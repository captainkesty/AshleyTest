package com.deft.components;

import com.badlogic.ashley.core.Component;
import com.deft.ai.TestAIAgent;

/**
 * Created by k9sty on 2016-06-11.
 */
public class EnemyComponent implements Component {
    TestAIAgent t;

    public EnemyComponent() {
        t = new TestAIAgent(this);
    }
}

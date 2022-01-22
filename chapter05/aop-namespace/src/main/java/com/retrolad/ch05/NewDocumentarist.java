package com.retrolad.ch05;

import com.retrolad.ch02.common.Guitar;

public class NewDocumentarist extends Documentarist{
    @Override
    public void execute() {
        guitarist.sing();
        guitarist.sing(new Guitar());
        guitarist.talk();
    }
}

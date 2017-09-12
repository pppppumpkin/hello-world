package com.qunar.fresh;

import java.io.IOException;

/**
 * Created by liyingsong on 16-5-30.
 */
public interface SubCommandHandler<Command, F, T> {
    T handleCommand(Command command, F f);
}

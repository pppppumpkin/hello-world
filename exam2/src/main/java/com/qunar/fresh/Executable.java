package com.qunar.fresh;

import java.io.IOException;
import java.util.List;

/**
 * Created by liyingsong on 16-5-27.
 */
public interface Executable<Executable, IN, OUT> {
    public OUT execute(Executable executable, IN in) throws IOException;
}

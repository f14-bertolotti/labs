package main;

import java.lang.instrument.Instrumentation;

public class Agent {
    public static void premain(String args, Instrumentation instrumentation) {
        ClassLogger classLogger = new ClassLogger();
        instrumentation.addTransformer(classLogger);
    }
}

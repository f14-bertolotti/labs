package main;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

public class ClassLogger implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader classLoader,
                            String className,
                            Class<?> clazz,
                            ProtectionDomain protectionDomain,
                            byte[] classBytes) {

        System.out.println("\033[0;32m" + className + "\033[0m");
        return classBytes;
    }
}

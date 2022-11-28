package main;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.bcel.Repository;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.MethodGen;


class Temp {
    // class Temp to be modified.
    public static void f() {
        System.out.println("World!");
    }
}

class MyClassLoader extends ClassLoader {
    // classloader to load the customized class.
    public Class loadFromBytes(byte[] dataClass, String className) {
        return defineClass(className, dataClass, 0, dataClass.length);
    }
}

public class Main {

    public static void main(String...args) throws Throwable {

        JavaClass javaClass = Repository.lookupClass("main.Temp");
        ClassGen classGen   = new ClassGen(javaClass);    
        ConstantPoolGen cpg = classGen.getConstantPool(); 
        InstructionFactory InstructionFactory = new InstructionFactory(classGen, cpg);
        classGen.setClassName("main.Temp2");

        for(Method method : classGen.getMethods()) {
            
            classGen.removeMethod(method);
            MethodGen mg = new MethodGen(method, "main.Temp2", cpg);
            InstructionList instructionList = mg.getInstructionList();
            instructionList.insert(InstructionFactory.createPrintln("Hello,"));
            mg.setMaxStack();
            classGen.addMethod(mg.getMethod());

        }

        
        // load class from byte array
        Class cls = new MyClassLoader().loadFromBytes(classGen.getJavaClass().getBytes(), "main.Temp2"); 

        // invoke Temp2::f
        java.lang.reflect.Method method = cls.getDeclaredMethod("f");
        method.setAccessible(true);
        method.invoke(null, new Object[]{});

    }
}



libs/bcel-6.6.1.jar:
	wget https://repo1.maven.org/maven2/org/apache/bcel/bcel/6.6.1/bcel-6.6.1.jar --directory-prefix libs

libs/commons-lang3-3.12.0.jar:
	wget https://repo1.maven.org/maven2/org/apache/commons/commons-lang3/3.12.0/commons-lang3-3.12.0.jar --directory-prefix libs

bin/main/Main.class: libs/bcel-6.6.1.jar libs/commons-lang3-3.12.0.jar src/java/main/Main.java 
	javac -cp libs/bcel-6.6.1.jar:libs/commons-lang3-3.12.0.jar src/java/main/Main.java -d bin

bin/main/Agent.class: src/java/main/Agent.java
	javac src/java/main/Agent.java src/java/main/ClassLogger.java -d bin

bin/main/ClassLogger.class: src/java/main/ClassLogger.java
	javac src/java/main/ClassLogger.java -d bin

bin/out.jar: MANIFEST.MF bin/main/Agent.class bin/main/ClassLogger.class bin/main/Main.class
	jar -m MANIFEST.MF -f bin/out.jar -c bin/main/Agent.class bin/main/ClassLogger.class bin/main/Main.class

compile: bin/main/Main.class bin/main/Agent.class bin/main/ClassLogger.class

run: bin/main/Main.class libs/bcel-6.6.1.jar libs/commons-lang3-3.12.0.jar
	java -cp libs/bcel-6.6.1.jar:libs/commons-lang3-3.12.0.jar:bin main.Main

run-agent: bin/out.jar libs/bcel-6.6.1.jar libs/commons-lang3-3.12.0.jar 
	java -javaagent:bin/out.jar -cp bin:libs/bcel-6.6.1.jar:libs/commons-lang3-3.12.0.jar main.Main

clean: 
	rm -rf bin/* libs/*

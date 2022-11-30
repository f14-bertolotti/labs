

libs/bcel-6.6.1.jar:
	wget https://repo1.maven.org/maven2/org/apache/bcel/bcel/6.6.1/bcel-6.6.1.jar --directory-prefix libs

libs/commons-lang3-3.12.0.jar:
	wget https://repo1.maven.org/maven2/org/apache/commons/commons-lang3/3.12.0/commons-lang3-3.12.0.jar --directory-prefix libs

bin/main/Main.class: libs/bcel-6.6.1.jar libs/commons-lang3-3.12.0.jar src/java/main/Main.java 
	javac -cp libs/bcel-6.6.1.jar:libs/commons-lang3-3.12.0.jar src/java/main/Main.java -d bin

run: bin/main/Main.class libs/bcel-6.6.1.jar libs/commons-lang3-3.12.0.jar
	java -cp libs/bcel-6.6.1.jar:libs/commons-lang3-3.12.0.jar:bin main.Main


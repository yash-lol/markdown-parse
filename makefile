#!/bin/bash

echo "Test runner: "
javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java
java -cp lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:. MarkdownParse

echo "File output: "
javac MarkdownParse.java
java MarkdownParse $1
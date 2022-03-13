#!/bin/bash

echo "File output: "
javac MarkdownParse.java
java MarkdownParse $1

echo "is $1 "
echo $1

CLASSPATH = lib/*:.

TryCommonMark.class: TryCommonMark.java
	javac -g -cp $(CLASSPATH) TryCommonMark.java
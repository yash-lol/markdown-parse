#!/bin/bash

echo "File output: "
javac MarkdownParse.java
java MarkdownParse $1

echo "is $1 "
echo $1
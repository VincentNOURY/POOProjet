#!/bin/sh
javac Code/Java/*.java -d Compile;
cd Compile;
java testsapplication.Main;

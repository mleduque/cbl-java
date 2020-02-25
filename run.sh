#!/bin/bash
mvn package
export LD_LIBRARY_PATH=-Djava.library.path="$PWD/lib/linux/x86_64/libc++:$PWD/lib/linux/x86_64/libicu:$PWD/lib/linux/x86_64/libz"
java -jar target/cbl-java-1.0-SNAPSHOT-jar-with-dependencies.jar

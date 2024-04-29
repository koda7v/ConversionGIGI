#!/bin/bash

./gradlew --refresh-dependencies
./gradlew build
./gradlew createEXE

mv -i lib/build/launch4j/CG.exe .
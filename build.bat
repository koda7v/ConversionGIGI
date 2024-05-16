@echo off
:: Script permettant la mise en place du package
echo Mise en place du package 
CALL gradlew clean build
PAUSE
cd src
javac *.java
move *.class ..\class
cd ..

cd class
jar cfe GenerateCollapsibleGuide.jar GenerateCollapsibleGuide *.class
move GenerateCollapsibleGuide.jar ..\jar
cd ..

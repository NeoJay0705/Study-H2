rem This .bat compile all .java from package org.iisi.demo into class director.

javac -verbose -cp "./lib/*" src/org/iisi/demo/*.java -d class
javac -verbose -cp "./lib/*" src/org/iisi/easysetting/*.java -d class
cd class
jar cf iisi.jar org/
move *.jar ../lib/

pause
exit
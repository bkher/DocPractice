@ECHO OFF
IF EXIST "res\" GOTO DeleteRes
:DeleteRes
rmdir "res" /s /q
IF EXIST "logs\" GOTO DeleteLogs
:DeleteLogs
rmdir "logs" /s /q
IF EXIST "test-output\" GOTO Deleteoutput
:Deleteoutput
rmdir "test-output" /s /q
IF EXIST "velocity.log" GOTO DeleteVelicity
mkdir "res\"
:DeleteVelicity
del velocity.log

mkdir "res\"

java -Dlogback.configurationFile=logback.xml -DenvParam="qa/" -Dlog4j.configuration=file:log4j.properties -cp .;CE-Automation-tests.jar;lib/*; org.testng.TestNG testng.xml

goto end

:end


# Docitt NAF automation

## Setup

- Install Java SDK (JDK, not JRE)
- Install Maven
- Add system or user variables (path can be different):
  -  JAVA_HOME: c:\Program Files (x86)\Java\jdk1.8.0_112\
  -  MAVEN_HOME: c:\bin\apache-maven-3.5.0\
  -  M2_HOME: c:\bin\apache-maven-3.5.0\
- Add to PATH:
  -  c:\bin\apache-maven-3.5.0\bin
  -  c:\Program Files (x86)\Java\jdk1.8.0_112\bin\    
- Checkout repository with tests (for example to c:\src\vnu\DOCITT_NAF_AUTOMATION\)
- Configure appropriate URLs and properties in '\qa\portal.properties'

## How to run tests

Open console, go to repository root folder (c:\src\vnu\DOCITT_NAF_AUTOMATION\), execute

``` cmd
mvn clean install -DskipTests=true -DNAF_AUTOMATION_VERSION=NAF_AUTOMATION_1.0.0
```

Then go to `target\archive-folder` (full path D:\NAF\DOCITT_NAF_AUTOMATION\target\archive-folder\)
execute `run.bat`

Report file (html) will be created in `target\archive-folder\template` . Logs will be in console output. In order to have file with logs - execute next command: `run.bat > log.txt`


For me

>mvn clean install -DskipTests=True -Docitt_AUTOMATION_VERSION=DOCITT_AUTOMATION_1.0.0
cd c:\git\chess4you_java\chess4you_java
git pull
echo "clean project and test build"
start /wait cmd.exe /c "gradlew clean"
start /wait cmd.exe /c "gradlew build"
echo "start code coverage"
start /wait cmd.exe /c "gradlew jacocoTestReport"
echo "start sonarqube"
start /wait cmd.exe /c "gradlew sonarqube -Dsonar.projectKey=Bliblob_chess4you_java -Dsonar.organization=bliblob-github -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=8e02fdf4fcad6835a4d7a5ac17e9573375c498f6 -Dsonar.coverage.jacoco.xmlReportPaths=C:\git\chess4you_java\chess4you_java\code_coverage\reports\jacocoXml\jacocoXml.xml"

cd c:\git\chess4you_java\chess4you_java
echo "run sonarqube"
gradlew sonarqube -Dsonar.projectKey=Bliblob_chess4you_java -Dsonar.organization=bliblob-github -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=8e02fdf4fcad6835a4d7a5ac17e9573375c498f6 -Dsonar.coverage.jacoco.xmlReportPaths=C:\git\chess4you_java\chess4you_java\code_coverage\reports\jacocoXml\jacocoXml.xml
FROM openjdk:8u191-jre-alpine3.8

 Run apk add curl jq

 # WorkSpace
 WORKDIR /usr/share/dockerLearning

 # Add .jar under target from host into this image
 ADD target/selenium-docker.jar          selenium-docker.jar
 ADD target/selenium-docker-tests.jar    selenium-docker-tests.jar
 ADD target/libs                         libs

 # Add suite files
 ADD book-flight-module.xml              book-flight-module.xml
 ADD search-module.xml                   search-module.xml

 # Add healthcheck.sh
 Add healthcheck.sh                      healthcheck.sh

 # BROWSER
 # HUB_HOST
 # MODULE

 #ENTRYPOINT java -cp "selenium-docker.jar:selenium-docker-tests.jar:libs/*" -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE
 ENTRYPOINT sh healthcheck.sh
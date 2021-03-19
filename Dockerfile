FROM openjdk:11
COPY target/okta-demo-app-0.0.1-SNAPSHOT.jar java-application-1.0.0.jar
ENTRYPOINT ["java","-jar","/java-application-1.0.0.jar"]

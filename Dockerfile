FROM openjdk:8u111-jdk-alpine


ADD /target/hutool-scaffold-1.0-SNAPSHOT.jar app.jar

CMD ["java","-jar","app.jar"]
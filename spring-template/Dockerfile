FROM gradle:6.8-jdk11-openj9
WORKDIR /home/gradle
COPY . .
EXPOSE 8080
RUN gradle tasks
RUN gradle bootJar
ENTRYPOINT ["java","-jar","build/libs/spring-template-0.0.1-SNAPSHOT.jar"]
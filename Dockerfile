FROM fabric8/java-alpine-openjdk11-jre
RUN mkdir -p /app/
WORKDIR /app
ADD src/main/resources/static/ .
ADD target/click_listrener_app-0.0.1-SNAPSHOT.jar /app/click_listrener_app-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container", "-jar", "/app/click_listrener_app-0.0.1-SNAPSHOT.jar"]

FROM fabric8/java-alpine-openjdk11-jre
#EXPOSE 8080
RUN mkdir -p /app/
ADD target/ /app/click_listrener_app-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container", "-jar", "/app/click_listrener_app-0.0.1-SNAPSHOT.jar"]

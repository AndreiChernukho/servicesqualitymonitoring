FROM adoptopenjdk/openjdk11:jre-11.0.8_10-alpine
VOLUME /tmp
ADD ./target/servicesQualityMonitoring-*.jar /app/app.jar

CMD [ "/opt/java/openjdk/bin/java", "-jar", "/app/app.jar" ]
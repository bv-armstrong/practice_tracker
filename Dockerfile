FROM amazoncorretto:21-alpine

COPY target/practice_tracker-0.0.1-SNAPSHOT.jar /app/practice_tracker.jar
COPY target/practice_tracker-0.0.1-SNAPSHOT-lib.jar /app/practice_tracker-lib.jar

WORKDIR /app
RUN mkdir data

ENTRYPOINT ["java", "-jar", "practice_tracker.jar"]
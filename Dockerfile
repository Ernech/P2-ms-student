FROM azul/zulu-openjdk:11.0.11
RUN apt update

#COPY target/ms-student-0.0.1-SNAPSHOT.jar ms-student-0.0.1.jar
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

ENV SERVER_PORT 6945
ENV EUREKA_URI "http://localhost:8763/eureka"
ENV ZIPKIN_URI "http://localhost:9411"

ENTRYPOINT ["java",\
 "-cp",\
 "app:app/lib/*",\
 "com.arquitecturasoftware.msstudent.MsStudentApplication"]
FROM maven:3.3-jdk-8
COPY . /
RUN mvn clean package
ARG JAR_FILE=target/*.jar
RUN mv ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
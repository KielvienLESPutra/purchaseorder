FROM maven:3.9.11-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:26-slim
RUN apt-get update && apt-get install -y curl
WORKDIR /app
COPY --from=build /app/target/*.jar purchaseorder-0.0.1-SNAPSHOT.jar
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} purchaseorder-0.0.1-SNAPSHOT.jar
ENV database_url=localhost
ENV port_purchase_order=8080
ENV database_port=5432
ENV database_name_dev=kielvien12345
# ENV database_password_dev=boostbank12345
ENV minumum_connection=1
ENV maximum_connection=5
HEALTHCHECK --interval=5m --timeout=3s --start-period=10s --retries=3 \
CMD ["curl", "-f", "http://localhost:8080/health"]
ENTRYPOINT ["java","-jar","/app/purchaseorder-0.0.1-SNAPSHOT.jar"]
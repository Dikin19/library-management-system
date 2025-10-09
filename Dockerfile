# Build Aplikasi

FROM maven:3.9.9-eclipse-temurin-24 AS builder
WORKDIR /app
# Install sertifikat agar koneksi HTTPS ke Maven Central lancar
RUN apt-get update && apt-get install -y ca-certificates && update-ca-certificates
COPY pom.xml .
COPY src ./src
# Build non-interaktif dan lewati unit test
RUN mvn -B clean package -Dmaven.test.skip=true


# Jalankan Aplikasi
FROM openjdk:24-jdk-slim
WORKDIR /app
# Copy hasil build dari tahap builder
COPY --from=builder /app/target/aplikasi.book.management-0.0.1-SNAPSHOT.jar app.jar
# Buka port default Spring Boot
EXPOSE 8080
# Jalankan aplikasi
ENTRYPOINT ["java", "-jar", "app.jar"]

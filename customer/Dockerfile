# Використовуємо офіційний образ OpenJDK як базовий
FROM openjdk:17-jdk-slim

# Встановлюємо автора
LABEL authors="vmankivskyi"

# Встановлюємо робочу директорію
WORKDIR /app

# Копіюємо jar-файл додатку в контейнер
COPY target/customer-*.jar customer.jar

# Встановлюємо активний профіль на kube
ENV SPRING_PROFILES_ACTIVE=kube

# Вказуємо команду для запуску додатку
ENTRYPOINT ["java", "-jar", "customer.jar"]
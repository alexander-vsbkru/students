# Базовый образ, содержащий java17
FROM openjdk:17-oracle

# Директория приложения внутри контейнеров
WORKDIR /app

# Копирование jar-файла приложения в контейнер
COPY students/build/libs/students-0.0.1-SNAPSHOT.jar app.jar

# Команда для запуска приложения
CMD ["java", "-jar", "app.jar"]
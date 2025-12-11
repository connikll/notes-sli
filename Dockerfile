FROM openjdk:17.0.1-jdk

WORKDIR /app

# копируем исходники
COPY src ./src
COPY data ./data

# компилируем java-файлы
RUN javac src/com/example/*.java

# том для заметок
VOLUME ["/app/data"]

# ВАЖНО: это ENTRYPOINT, а не CMD!
ENTRYPOINT ["java", "-cp", "src", "com.example.App"]
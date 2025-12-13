Notes CLI


Автор

GitHub:https://github.com/connikll/ 

Возможности приложения

Добавление заметок

Просмотр списка заметок

Подсчёт количества заметок

Хранение данных в файле data/notes.csv

Запуск как локально, так и в Docker

CI через GitHub Actions

Работа с ветками, Pull Request и релизами

Формат хранения заметок

Файл: data/notes.csv

id;текст


Пример:

1;Купить хлеб
2;Позвонить другу

▶ Запуск локально (без Docker)
Компиляция
javac src/com/example/*.java

Добавить заметку
java -cp src com.example.App --cmd=add --text="Купить хлеб"

Показать список
java -cp src com.example.App --cmd=list

Посчитать количество
java -cp src com.example.App --cmd=count

Запуск через Docker
Сборка Docker-образа

В корне проекта:

docker build -t notes-cli:dev .

▶ Запуск контейнера

Важно: команда монтирует папку data/ с хоста,
чтобы заметки сохранялись после остановки контейнера.

Добавить заметку
docker run --rm -v "%cd%/data:/app/data" notes-cli:dev --cmd=add --text="Купить хлеб"

Показать список заметок
docker run --rm -v "%cd%/data:/app/data" notes-cli:dev --cmd=list

 Посчитать количество заметок
docker run --rm -v "%cd%/data:/app/data" notes-cli:dev --cmd=count

 История версий
v1.0.0 — Initial release

Реализованы команды:

add

list

Настроен CI (GitHub Actions)

Добавлен Dockerfile

Выпущен первый релиз

v1.1.0 — Add count command

Добавлена новая команда:

count

Реализация выполнена в отдельной ветке

Создан Pull Request и выполнен merge

Выпущен релиз v1.1.0

Скриншот страницы Releases


<img width="1920" height="945" alt="chrome_aGgt2Czj2m" src="https://github.com/user-attachments/assets/f95d3a40-2c7c-40f7-9128-8e24732eaab4" />



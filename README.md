1. Стек: Java 11, Spring data, Spring Boot, PostgreSQL, maven

2. Сборка и запуск:
- Сборка проекта mvn clean install
 
- Запуск программы:
 
     Из IDE дефолтными конфигурациями (LibraryTestProjectApplication)
     
     из CMD:
     
         - cd <target root>
         - java -jar libraryTestProject-1.0.jar --spring.config.location=application.properties

3. После запуска по url http://localhost:8080/clients.html доступна страница со списком клиентов

4. Описание работы программы: 
программа хранит данные о:
книгах (жанр, название, автор, год издания, издательство);
клиентах (читателях) (персональная информация, номер читательского билета)
фактах выдачи/сдачи книг

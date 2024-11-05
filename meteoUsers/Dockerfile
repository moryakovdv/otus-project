#c DockerHub скачать JDK нужной версии
FROM openjdk:17-oracle
# Создать целевой каталог 
RUN mkdir /meteoUsers
#Скопировать приложение в контейнер
COPY ./target/meteo-users.jar /meteoUsers/meteo-users.jar
#открыть порт 9994
EXPOSE 9994
#запустить приложение при запуске контейнера
ENTRYPOINT [ "java", "-jar", "/meteoUsers/meteo-users.jar" ]
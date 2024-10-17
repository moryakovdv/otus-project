#c DockerHub скачать JDK нужной версии
FROM openjdk:17-oracle
# Создать целевой каталог 
RUN mkdir /meteoHelpers
#Скопировать приложение в контейнер
COPY ./target/meteo-helpers.jar /meteoHelpers/meteo-helpers.jar
#открыть порт 8888
EXPOSE 8888
#запустить приложение при запуске контейнера
ENTRYPOINT [ "java", "-jar", "/meteoHelpers/meteo-helpers.jar" ]
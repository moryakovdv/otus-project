#c DockerHub скачать JDK нужной версии
FROM openjdk:17-oracle
# Создать целевой каталог 
RUN mkdir /meteoHelpers
#Скопировать приложение в контейнер
COPY ./target/meteo-helpers-exec.jar /meteoHelpers/meteo-helpers.jar
#открыть порт 9998
EXPOSE 9998
#запустить приложение при запуске контейнера
ENTRYPOINT [ "java", "-jar", "/meteoHelpers/meteo-helpers.jar" ]
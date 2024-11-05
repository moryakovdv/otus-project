#c DockerHub скачать JDK нужной версии
FROM openjdk:17-oracle
# Создать целевой каталог 
RUN mkdir /meteoServices
#Скопировать приложение в контейнер
COPY ./target/meteo-services-exec.jar /meteoServices/meteo-services.jar
#открыть порт 9995
EXPOSE 9995
#запустить приложение при запуске контейнера
ENTRYPOINT [ "java", "-jar", "/meteoServices/meteo-services.jar" ]
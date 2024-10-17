#c DockerHub скачать JDK нужной версии
FROM openjdk:17-oracle
# Создать целевой каталог 
RUN mkdir /meteoServices
#Скопировать приложение в контейнер
COPY ./target/meteo-services.jar /meteoServices/meteo-services.jar
#открыть порт 8888
EXPOSE 8888
#запустить приложение при запуске контейнера
ENTRYPOINT [ "java", "-jar", "/meteoServices/meteo-services.jar" ]
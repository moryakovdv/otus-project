#c DockerHub скачать JDK нужной версии
FROM openjdk:17-oracle
# Создать целевой каталог 
RUN mkdir /meteoApi
#Скопировать приложение в контейнер
COPY ./target/meteo-api.jar /meteoApi/meteo-api.jar
#открыть порт 8888
EXPOSE 8888
#запустить приложение при запуске контейнера
ENTRYPOINT [ "java", "-jar", "/meteoApi/meteo-api.jar" ]
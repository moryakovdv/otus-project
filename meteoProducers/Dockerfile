#c DockerHub скачать JDK нужной версии
FROM openjdk:17-oracle
# Создать целевой каталог 
RUN mkdir /meteoProducers
#Скопировать приложение в контейнер
COPY ./target/meteo-producers.jar /meteoProducers/meteo-producers.jar
#открыть порт 9996
EXPOSE 9996
#запустить приложение при запуске контейнера
ENTRYPOINT [ "java", "-jar", "/meteoProducers/meteo-producers.jar" ]
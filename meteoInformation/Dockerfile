#c DockerHub скачать JDK нужной версии
FROM openjdk:17-oracle
# Создать целевой каталог 
RUN mkdir /meteoInformation
#Скопировать приложение в контейнер
COPY ./target/meteo-information.jar /meteoInformation/meteo-information.jar
#открыть порт 8888
EXPOSE 8888
#запустить приложение при запуске контейнера
ENTRYPOINT [ "java", "-jar", "/meteoInformation/meteo-information.jar" ]
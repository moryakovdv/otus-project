#c DockerHub скачать JDK нужной версии
FROM openjdk:17-oracle


#ENV OTEL_EXPORTER_OTLP_LOGS_ENDPOINT=http://grafana:4318/v1/logs
#ENV OTEL_EXPORTER_OTLP_METRICS_ENDPOINT=http://grafana:4318
#ENV OTEL_EXPORTER_OTLP_TRACES_ENDPOINT=http://grafana:4318/v1/traces



# Создать целевой каталог 
RUN mkdir /meteoApi

ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v2.4.0/opentelemetry-javaagent.jar /meteoApi/opentelemetry-javaagent.jar

#Скопировать приложение в контейнер
COPY ./target/meteo-api.jar /meteoApi/meteo-api.jar

#открыть порт 9999
EXPOSE 9999

#запустить приложение при запуске контейнера
#ENTRYPOINT [ "java", "-XX:-Inline", "-javaagent:opentelemetry-javaagent.jar", "-jar", "/meteoApi/meteo-api.jar" ]

ENTRYPOINT [ "java", "-jar", "/meteoApi/meteo-api.jar" ]
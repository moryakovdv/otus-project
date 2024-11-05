# otus-project
Otus. Java Advanced course

# Цель
Создание архитектуры микросервисных приложений для предоставления авиационной метеорологической информации.

В дальнейшем  проект может лечь в основу замены нескольких "монолитных" приложений,
существующих на сегодняшний день.

# Домены
- **Метеорологическая информация** - аэродромы, регионы полетной информации, сводки текущей погоды, ситуативная информация, минутные сводки, краткосрочные и долгосрочные прогнозы погоды по аэродрому или региону полетной информации  
  
- **Продюсеры метеоинформации** - региональные и федеральные службы, ответственные за выпуск метеорологических сводок. Могут быть расположены непосредственно на аэродроме, а также могут объединять выпуск метеоинформации с нескольких аэродромов или регионов полетной информации  
  
 - **Авиационные пользователи** - в терминологии ИКАО "stakeholders". Международные банки метеоинформации, Авиакомпании, аэродромные службы, пилоты ВС и т.д.  Получают информацию от продюсеров. Могут осуществлять подписку на регулярное получение тех или иных видов метеоинформации, а также запрашивать ее "адресно"  

# Модули

- meteoInformation - модуль работы с доменом Метеорологическая информация
- meteoProducers - модуль работы с доменом Продюсеры метеоинформации
- meteoUser - модуль работы с доменом Авиационные пользователи
- meteoServices - модуль конфигурации и управления RabbitMQ
- meteoAPI - публичное rest-API управления 


# Основные решения

1. Микросервисная архитектура на Maven и Java-modules.  
Модули представляют собой слабосвязанные проекты.

2. Общий docker-compose.yml производит разворачивание всей инфраструктуры:
 - всех модулей проекта
 - брокера RabbitMQ
 - prometeus
 - grafana
 - loki
 - Zipkin
   
3. Каждый модуль проекта имеет свой файл для сборки и разворачивания Helm Chart в Kubernetes.
   В этом случае инфраструктурные компоненты (Prometheus, Grafana, Loki, Zipkin, RabbitMQ) устанавливаются через Helm в отдельный namespace monitoring 
 
4. Для демонстрации в модуле meteoAPI использован подход API-FIRST, скелет пакетов и классов сегенерирован через OpenAPI из YAML-описания.  

5. Для управления структурой БД в модулях используется Liquibase  

6. Асинхронные вебметоды в MeteoApi на основе WebFlux

7. @Sheduled сервисы используются для выпуска в "эфир" информации, распространяемой MeteoProducers по расписанию (например, регулярные сводки METAR)

8. Брокер сообщений RabbitMQ обеспечивает подписки(модель pub-sub) MeteoUsers информации на сообщения, выпускаемые MeteoProducers.   

9. Сквозное логгирование прохождения запросов от модуля к модулю осуществляется через Zipkin

10. Для мониторинга параметров JVM, сбора статистики по результатам вызовов рест-запросов и пр. используется Prometeus

11. Grafana применяется для визуального наблюдения метрик от Prometeus и Zipkin, отображения логов от Loki
12. Для защиты веб-методов публичного API в проекте MeteoApi подключена библиотека Resilelense4j и преднастроены TimeLimiter и RateLimiter

13. Для нагрузочного тестирования применяются jmx-скрипты Jmeter

# Схема взаимодействия модулей

**meteoProducer** на основе своего расписания выпускает метеоинформацию по обслуживаемым объектам. Выпущенная сводка попадает в общее хранилище (кеш),  а также направляется в брокер сообщений. Дальше брокер направляет подписчикам по routingKey;

**meteoUser** управляет своими подписками или запросам по интересующим его объектам и типам информации. Для этого он обращется к **meteoServices** с соответсвующим запросом на subscription или адресным rest  

**meteoAPI** осуществляет общее управление созданием метео-продюсеров и метео-пользователей, ведением справочников метеоинформации, аэродромов 

# Сборка и запускк
*$ docker-compose -p otus-project up*

либо 

*$ ./startup.sh*

Пример результата запуска:
![image](https://github.com/user-attachments/assets/074646f5-324e-4829-82b2-324aba61163b)


# Слайды с результатами
1. OpenAPI + swaggerUI
![image](https://github.com/user-attachments/assets/57e6a195-0578-48d5-a66d-23c270229339)

2. Общая панель JVM-метрик в Grafana
![image](https://github.com/user-attachments/assets/68159b92-1d44-4c25-8fc6-f9a3e5aa84bf)

3. Обзор метрик тестовых вызовов рест-методов Meteo-api через веб-интерфейс Zipkin
![image](https://github.com/user-attachments/assets/3ed5b799-3fa1-4d76-a0b4-7929100128b4)

4. Просмотр метрик Prometheus в Grafana
![image](https://github.com/user-attachments/assets/38d83a40-f124-4bad-b31d-e63903efd4cd)

5. Просмотр логов от Loki в Grafana

![image](https://github.com/user-attachments/assets/cab4a82a-d122-43dd-9e74-eb425d0b043d)

6. Логи meteo-api при рзвертывании в кластере
![Screenshot from 2024-10-30 15-52-05](https://github.com/user-attachments/assets/6af90cc5-ba42-44f0-ace2-fb94c57b1c9f)

7. Создание топиков RabbitMQ из Spring-конфигурации
   ![image](https://github.com/user-attachments/assets/fefef39f-ef2e-440f-850c-6c9366b615c4)






   
   

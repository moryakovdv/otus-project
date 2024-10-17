# otus-project
Otus. Java Advanced course

# Цель
Создание микросервисного SpringBoot проекта.

В дальнейшем  проект может лечь в основу замены нескольких "монолитных" приложений,
существующих на сегодняшний день.

# Домены
- **Метеорологическая информация** - аэродромы, регионы полетной информации, сводки текущей погоды, ситуативная информация, минутные сводки, краткосрочные и долгосрочные прогнозы погоды по аэродрому или региону полетной информации  
  
- **Продюсеры метеоинформации** - региональные и федеральные службы, ответственные за выпуск метеорологических сводок. Могут быть расположены непосредственно на аэродроме, а также могут объединять выпуск метеоинформации с нескольких аэродромов или регионов полетной информации  
  
 - **Авиационные пользователи** - в терминологии ИКАО "stakeholders". Международные банки метеоинформации, Авиакомпании, аэродромные службы, пилоты ВС и т.д.  Получают информацию от продюсеров. Могут осуществлять подписку на регулярное получение тех или иных видов метеоинформации, а также запрашивать ее "адресно"  

# Модули

- meteoHelpers - модуль shared-инфрмации, кешей, служебных методов, используемых другими модулями
- meteoInformation - модуль работы с доменом Метеорологическая информация
- meteoProducers - модуль работы с доменом Продюсеры метеоинформации
- meteoUser - модуль работы с доменом Авиационные пользователи
- meteoAPI - публичное rest-API управления 

# Основные решения

Микросервисная архитектура на Maven и Java-modules.  
Для демонстрации в модуле meteoAPI использован подход API-FIRST, скелет пакетов и классов сегенерирован через OpenAPI из YAML-описания.  
Брокер сообщений RabbitMQ.   
Модель pub-sub, а также точечные rest-запросы.  


# Схема взаимодействия модулей

**meteoProducer** на основе своего расписания выпускает метеоинформацию по обслуживаемым объектам. Выпущенная сводка попадает в общее хранилище (кеш),  а также направляется в брокер сообщений. Дальше брокер направляет подписчикам по routingKey;

**meteoUser** управляет своими подписками или запросам по интересующим его объектам и типам информации. Для этого он обращется к **meteoServices** с соответсвующим запросом на subscription или адресным rest  

**meteoAPI** осуществляет общее управление созданием метео-продюсеров и метео-пользователей, ведением справочников метеоинформации, аэродромов 

# Сборка и запуск

Модули проекта незвисимы, разворачиваются через Helm-charts.
RabbitMQ заапускается в отдельном docker-контейнере

# Результаты


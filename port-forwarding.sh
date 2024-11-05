#!/bin/sh

##kill background forwards
ps aux | grep -i kubectl | grep -v grep | awk {'print $2'} | xargs kill

echo 'Previous killed. Starting new forwarding...'

kubectl port-forward --namespace monitoring svc/meteo-zipkin 9411:9411 &
kubectl port-forward --namespace monitoring svc/meteo-rabbitmq 15672:15672 5672:5672 &
kubectl port-forward --namespace monitoring svc/meteo-grafana 3000:80 &
kubectl port-forward --namespace monitoring svc/meteo-prometheus-server 9090:80 &


#kubectl port-forward --namespace monitoring meteo-api-6f897df769-znxnk 9999:9999 &
#kubectl port-forward --namespace monitoring meteo-helpers-6f897df769-znxnk 9998:9998 &
#kubectl port-forward --namespace monitoring meteo-information-6f897df769-znxnk 9997:9997 &
#kubectl port-forward --namespace monitoring meteo-producers-6f897df769-znxnk 9996:9996 &
#kubectl port-forward --namespace monitoring meteo-services-6f897df769-znxnk 9995:9995 &
#kubectl port-forward --namespace monitoring meteo-users-6f897df769-znxnk 9994:9994 &

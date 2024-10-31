#!/bin/sh

##kill background forwards
ps aux | grep -i kubectl | grep -v grep | awk {'print $2'} | xargs kill

echo 'Previous killed. Starting new forwarding...'

kubectl port-forward --namespace monitoring svc/meteo-zipkin 9411:9411 &
kubectl port-forward --namespace monitoring svc/meteo-rabbitmq 15672:15672 5672:5672 &
kubectl port-forward --namespace monitoring svc/meteo-grafana 3000:80 &
kubectl port-forward --namespace monitoring svc/meteo-prometheus-server 9090:80 &


kubectl port-forward --namespace monitoring meteo-api-6f897df769-znxnk 8080:9999 &


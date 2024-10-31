#!/bin/sh

##kill background forwards
ps aux | grep -i kubectl | grep -v grep | awk {'print $2'} | xargs kill

echo 'Previous killed. Starting new forwarding...'

kubectl port-forward --namespace monitoring svc/meteo-zipkin 9411:9411 &
kubectl port-forward --namespace monitoring pod/meteo-rabbitmq-0 15672:15672 5672:5672 &
kubectl port-forward --namespace monitoring meteo-grafana-6f9f796744-4tw4p 3000:3000 &
kubectl port-forward --namespace monitoring meteo-prometheus-server-67bb974dd8-4tjqz 9090:9090 &
kubectl port-forward --namespace monitoring meteo-api-6f897df769-znxnk 8080:9999 &


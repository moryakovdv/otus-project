#!/bin/sh
#mvn clean install

####create registry first  if not present
#docker run -d -p 5000:5000 --restart=always --name meteo-registry registry:2


#############
##allow insecure access to registry in /etc/docker/daemon.json
##{ "insecure-registries": ["localhost:5000"] }


#build app for

docker build -t meteo-api .

#set tag to application
docker tag meteo-api localhost:5000/meteo-api
#push it to docker hub
docker push localhost:5000/meteo-api

# create helm chart
helm create meteo-api

#create templates and lint
helm template meteo-api --values ./values.yaml --debug
helm lint meteo-api --values ./values.yaml --debug


###Deploy
helm upgrade --install --namespace monitoring  meteo-api --values ./values.yaml ./meteo-api --debug

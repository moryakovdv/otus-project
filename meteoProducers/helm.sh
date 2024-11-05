#!/bin/sh
#mvn clean install

####create registry first  if not present
#docker run -d -p 5000:5000 --restart=always --name meteo-registry registry:2


#############
##allow insecure access to registry in /etc/docker/daemon.json
##{ "insecure-registries": ["localhost:5000"] }


#build app for

docker build -t meteo-producers .

#set tag to application
docker tag meteo-producers localhost:5000/meteo-producers
#push it to docker hub
docker push localhost:5000/meteo-producers

# create helm chart
helm create meteo-producers

#create templates and lint
helm template meteo-producers --values ./values.yaml --debug
helm lint meteo-producers --values ./values.yaml --debug


###Deploy
helm upgrade --install --namespace monitoring  meteo-producers --values ./values.yaml ./meteo-producers --debug

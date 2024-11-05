#!/bin/sh
#mvn clean install

####create registry first  if not present
#docker run -d -p 5000:5000 --restart=always --name meteo-registry registry:2


#############
##allow insecure access to registry in /etc/docker/daemon.json
##{ "insecure-registries": ["localhost:5000"] }


#build app for

docker build -t meteo-users .

#set tag to application
docker tag meteo-users localhost:5000/meteo-users
#push it to docker hub
docker push localhost:5000/meteo-users

# create helm chart
helm create meteo-users

#create templates and lint
helm template meteo-users --values ./values.yaml --debug
helm lint meteo-users --values ./values.yaml --debug


###Deploy
helm upgrade --install --namespace monitoring  meteo-users --values ./values.yaml ./meteo-users --debug

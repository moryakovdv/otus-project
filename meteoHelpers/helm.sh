#!/bin/sh
#mvn clean install

####create registry first  if not present
#docker run -d -p 5000:5000 --restart=always --name meteo-registry registry:2


#############
##allow insecure access to registry in /etc/docker/daemon.json
##{ "insecure-registries": ["localhost:5000"] }


#build app for

docker build -t meteo-helpers .

#set tag to application
docker tag meteo-helpers localhost:5000/meteo-helpers
#push it to docker hub
docker push localhost:5000/meteo-helpers

# create helm chart
helm create meteo-helpers

#create templates and lint
helm template meteo-helpers --values ./values.yaml --debug
helm lint meteo-helpers --values ./values.yaml --debug


###Deploy
helm upgrade --install --namespace monitoring  meteo-helpers --values ./values.yaml ./meteo-helpers --debug

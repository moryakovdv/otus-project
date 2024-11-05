#!/bin/sh
#mvn clean install

####create registry first  if not present
#docker run -d -p 5000:5000 --restart=always --name meteo-registry registry:2


#############
##allow insecure access to registry in /etc/docker/daemon.json
##{ "insecure-registries": ["localhost:5000"] }


#build app for

docker build -t meteo-information .

#set tag to application
docker tag meteo-information localhost:5000/meteo-information
#push it to docker hub
docker push localhost:5000/meteo-information

# create helm chart
helm create meteo-information

#create templates and lint
helm template meteo-information --values ./values.yaml --debug
helm lint meteo-inormation --values ./values.yaml --debug


###Deploy
helm upgrade --install --namespace monitoring  meteo-information --values ./values.yaml ./meteo-information --debug

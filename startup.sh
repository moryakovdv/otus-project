#!/bin/sh

#mvn clean install

#build multiply containers with docker-compose
#daemon mode not used to display console output

docker-compose build --no-cache &&
docker-compose -p otus-project up --force-recreate -V

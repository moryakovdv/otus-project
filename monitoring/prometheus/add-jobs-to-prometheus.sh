#!/bin/sh
helm upgrade --install meteo-prometheus --set-file extraScrapeConfigs=./meteo-jobs.yml  --namespace monitoring prometheus-community/prometheus
#
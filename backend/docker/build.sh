#!/bin/bash

if [ ! -e libs ]; then
  sudo mkdir libs
fi

cd ..
mvn package
sudo cp target/fortune-calc-backend-jar-with-dependencies.jar docker/libs
cd docker
sudo docker build .

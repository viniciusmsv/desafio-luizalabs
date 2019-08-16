#!/bin/bash

PATH=/tmp/mongodb/

/bin/mkdir $PATH

/bin/cp ./dataset_products.csv $PATH

/usr/bin/docker exec -it mongodb_mongo_1 mongoimport -d luizalabs -c products --type CSV --file /data/db/dataset_products.csv --headerline --authenticationDatabase admin -u root  -p root -h localhost:27017

/bin/rm $PATH/dataset_products.csv
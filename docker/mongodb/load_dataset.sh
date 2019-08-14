#!/bin/bash
cp dataset_products.csv /mnt/WDC-1TB/Desenv/Banco/mongodb/
docker exec -it mongodb_mongo_1 mongoimport -d luizalabs -c products --type CSV --file /data/db/dataset_products.csv --headerline --authenticationDatabase admin -u root  -p root -h localhost:27017
rm /mnt/WDC-1TB/Desenv/Banco/mongodb/dataset_products.csv
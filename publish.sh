#!/bin/sh

PRO=/root/neeet
FILE=/root/netease-homework-tanc.war

cd $PRO

# shutdown docker-compose
docker-compose down

# remove old code
rm -rf tomcat/*

# cp new code
mv $FILE tomcat

# restart docker compose
docker-compose up -d

echo 'publish mission done'


#!/bin/sh

PRO=/root/neeet
TMP=/root/upload
UPLOAD_DIR=/root/neeet/tomcat/netease-homework-tanc/upload
FILE=/root/netease-homework-tanc.war

cd ${PRO}

# shutdown docker-compose
docker-compose down

# css  favicon.ico  fonts  img  js  META-INF  upload  WEB-INF
# /root/neeet/tomcat/netease-homework-tanc
rm /root/neeet/tomcat/netease-homework-tanc/favicon.ico
rm -rf /root/neeet/tomcat/netease-homework-tanc/css
rm -rf /root/neeet/tomcat/netease-homework-tanc/fonts
rm -rf /root/neeet/tomcat/netease-homework-tanc/img
rm -rf /root/neeet/tomcat/netease-homework-tanc/js
rm -rf /root/neeet/tomcat/netease-homework-tanc/META-INF
rm -rf /root/neeet/tomcat/netease-homework-tanc/WEB-INF

unzip -oq ${FILE} -d /root/neeet/tomcat/netease-homework-tanc

# restart docker compose
docker-compose up -d

echo 'publish mission done'

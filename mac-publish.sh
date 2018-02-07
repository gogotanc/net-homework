#!/bin/sh

ProjectRoot=/Users/tanc/project/neeet
File=$ProjectRoot/target/netease-homework-tanc.war
Host=hj

mvn clean package -Pdocker -Dmaven.test.skip=true

ret=$?

if [ $ret != 0 ]
then
  echo 'package : some thing wrong.'
  exit $ret
fi

echo 'package : mission completed'

scp $File $Host:~/

ret=$?

if [ $ret != 0 ]
then
  echo 'transfor.sh : some thing wrong.'
  exit $ret
fi

echo 'transfor.sh : mission completed'

scp ./publish.sh $Host:~/

ssh $Host '/bin/sh ~/publish.sh'

ret=$?

if [ $ret != 0 ]
then
  echo 'remote.sh : some thing wrong.'
  exit $ret
fi

echo 'All mission done.'


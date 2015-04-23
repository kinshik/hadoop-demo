#!/bin/bash

export IN_PATH=/user/bigdata/test.txt
# export IN_PATH=/user/bigdata/deepFriendList_deep_2.json
export OUT_PATH=/user/bigdata/output/1

export LIBJARS=./hadoop-demo_lib/base64coder-2010-12-19.jar

clear

# hadoop jar hadoop-demo.jar -libjars ${LIBJARS} ${IN_PATH} ${OUT_PATH}
su hdfs -c 'hadoop jar hadoop-demo.jar -D textinputformat.record.delimiter=] -libjars ${LIBJARS} ${IN_PATH} ${OUT_PATH}'

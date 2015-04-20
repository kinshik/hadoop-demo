#!/bin/bash

export IN_PATH=/user/bigdata/test.txt
export OUT_PATH=/user/bigdata/output_

# export LIBJARS=/usr/local/bigdata/hadoop-demo_lib/base64coder-2010-12-19.jar
export LIBJARS=./hadoop-demo_lib/base64coder-2010-12-19.jar

clear

hadoop jar hadoop-demo.jar -libjars ${LIBJARS} ${IN_PATH} ${OUT_PATH}

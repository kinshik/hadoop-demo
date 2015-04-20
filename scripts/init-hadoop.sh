#!/bin/bash

hadoop fs -mkdir /user/bigdata
hadoop fs -copyFromLocal /usr/local/bigdata/test.txt /user/bigdata/test.txt

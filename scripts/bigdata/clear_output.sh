#!/bin/bash

su hdfs -c 'hadoop fs -rm -r /user/bigdata/output/*'
su hdfs -c 'hadoop fs -ls -R /user/bigdata'

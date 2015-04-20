#!/bin/bash

chown -R hdfs:hdfs /usr/local/bigdata
chmod 777 /usr/local/bigdata/*.sh
su hdfs ./init-hadoop.sh

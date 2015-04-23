rem *** PIVOTAL ***
set host=root@52.8.36.116
set sourcePath=./bigdata
set targetPath=/usr/local/bigdata
set apiPath=C:/Program Files (x86)/PuTTY
set keyFile=./ssh/aws.ppk
set hdfsPath=/user/bigdata

set plink="%apiPath%/plink.exe" -i %keyFile% %host%

%plink% mkdir %targetPath%
"%apiPath%/pscp.exe" -r -i %keyFile% %sourcePath%/ %host%:%targetPath%
%plink% chown -R hdfs:hdfs %targetPath%
%plink% chmod 777 %targetPath%/*.sh
%plink% su hdfs -c 'hadoop fs -mkdir %hdfsPath%'
%plink% su hdfs -c 'hadoop fs -mkdir %hdfsPath%/output'
%plink% su hdfs -c 'hadoop fs -copyFromLocal %targetPath%/test.txt %hdfsPath%/test.txt'

pause

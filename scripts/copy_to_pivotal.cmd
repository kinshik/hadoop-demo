echo off
rem http://safezone.cc/threads/peremennye-v-cmd-komanda-set-i-arifmetika.22660/
rem http://ab57.ru/cmdlist/call.html
rem http://scriptcoding.ru/2013/08/20/funkcii-komandno-stroki/
goto BODY

:PSCP
%pscp% %spath%%1 %tpath%
exit /b

:BODY

rem **************************************************************************
rem *                           Настройка путей                              *
rem **************************************************************************

set host=root@52.8.36.116
set pscp="C:\Program Files (x86)\PuTTY\pscp.exe" -i C:\TEMP\aws.ppk
set spath=C:/TEMP/jar-out/
set tpath=%host%:/usr/local/bigdata/

rem **************************************************************************
rem *                         Копирование файлов                             *
rem **************************************************************************

rem call :PSCP downloads/deepFriendList_deep_2.json
rem call :PSCP hadoop-demo_lib/base64coder-2010-12-19.jar
call :PSCP hadoop-demo.jar

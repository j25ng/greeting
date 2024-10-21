#!/bin/bash

# Start the application
nohup java -jar build/libs/greeting-0.0.1-SNAPSHOT.jar > server.log 2>&1 &

sleep 10
echo "> 실행 완료. 백그라운드에서 애플리케이션이 실행 중입니다."

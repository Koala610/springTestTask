cd backEnd
call gradlew build
cd build/libs
set /p DB_NAME="Database name: "
set /p PG_USER="Username: "
set /p PG_PASSWORD="Password: "
set /p SERVER_PORT="Server port: "
java -jar eschool-0.0.1.jar
exit 0
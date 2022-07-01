cd frontEnd
call npm install
cd dist/eschool
if not exist index.html call ng build
cd ..
cd ..
set /p ANGULAR_PORT="Enter server port: "
echo Starting server...
node server.js
set DB_ADDRESS=localhost:5432
set DB_NAME=tenisu
set DB_USERNAME=postgres
set DB_PASSWORD=passer
set SERVER_PORT=8080
mvn clean package && java -jar target/ROOT.jar
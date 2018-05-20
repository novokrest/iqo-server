# IQ Option Application

Simple server for counting unique users who visited it.

## Implementation
Server was implemented with Spring Boot Framework.
The first time the server is started, a local SQLite database is created to store the server's state between runs.

## How To
### Configure
To specify server port, change `server.port` property in `src/main/resources/application.yml` file.
The port `8080` is used by default.

### Run
To run server, issue the following command:
```
sbt run
```

## Usage
To visit server by `<user-id>` user, call the `/user` POST-method with JSON-body `{ "user_id": "<user-id>" }`.
Example:
```
curl -X POST -H 'Content-Type: application/json' -d '{ "user_id": "user1" }' http://localhost:8080/user
```

To get the number of unique users, call the `/stat` GET-method.
Example:  
```
curl http://localhost:8080/stat
```

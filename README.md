# Spring Boot Boilerplate
SpringBoot App with PostgreSQL run with Docker

# Steps to run

```
git clone https://github.com/Denis-26/SpringBootBoilerplate.git
```

**If there is no docker on your machine**
```
sudo apt-get install docker
sudo apt-get install docker-compose
sudo service docker start
```

**If docker is on your machine**
```
sudo docker-compose up
```

Then try

    POST http://localhost.ru:8080/rest/api/sign_up?username=Denis&password=1234
    
    POST http://localhost.ru:8080/rest/api/sign_in?username=Denis&password=1234

    POST http://localhost.ru:8080/rest/api/data/create?dataName=TestDataName
    
    GET http://localhost.ru:8080/rest/api/datas
    
    GET http://localhost.ru:8080/rest/api/data?id=0

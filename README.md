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

_http://<host_name>:8080/getTests_

Your hav to see 

```[
      {
        "id": 1,
        "title": "Test1",
        "value":"OK"
      },
      {
        "id": 2,
        "title": "Test2",
        "value": "OK"
       }
    ]
```

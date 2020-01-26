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

    localhost:8080/users/login?username=Test&password=1234
    
    localhost:8080/api/users/current?username=Test&password=1234
    
    localhost:8080/api/users/testInfo?username=Test&password=1234

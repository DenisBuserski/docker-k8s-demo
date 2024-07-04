# Docker & K8 

## Commands
Check all RUNNING Docker containers:
```
docker ps
```
Check all Docker containers:
```
docker ps -a
```
Check Docker images:
```
docker images
```
<br>

Build the Docker image:
```
docker build -t [IMAGE_NAME]:[VERSION] .

docker build -t hello-docker:1.0 .
```


Run the Docker image:
```
docker run [IMAGE_NAME]:[VERSION]

docker run hello-docker:1.0
```





Before deleting an image delete the container that uses is:
```
docker container rm [CONTAINER_ID]
```
Delete the image:
```
docker rmi [IMAGE_ID]
```



```
docker-compose down
```

```
docker-compose up
```



- [Intro to Docker [with Java Examples]](https://www.youtube.com/watch?v=FzwIs2jMESM)
- [Docker in IntelliJ IDEA](https://www.youtube.com/watch?v=FzwIs2jMESM)
- [100+ Docker Concepts you Need to Know](https://www.youtube.com/watch?v=rIrNIzy6U_g)
- [Docker in 100 Seconds](https://www.youtube.com/watch?v=Gjnup-PuquQ)
- [Learn Docker in 7 Easy Steps - Full Beginner's Tutorial](https://www.youtube.com/watch?v=gAkwW2tuIqE)
- [How to dockerize your Spring Boot API | Docker Tutorial](https://www.youtube.com/watch?v=3SNKdr3f9Io)
- [you need to learn Docker RIGHT NOW!! // Docker Containers 101](https://www.youtube.com/watch?v=eGz9DS-aIeY)
- [Why Use Docker: Real-life Use Cases](https://www.youtube.com/watch?v=rcYswUg0J5k)
- [Multi Container Docker Applications | A real-world example](https://www.youtube.com/watch?v=bX_tFv0YCqg)
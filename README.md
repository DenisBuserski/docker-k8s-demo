# docker-k8-demo

### Commands

Check Docker containers:
```
docker ps -a
```

Check Docker images:
```
docker images
```

Build the Docker image:
```
docker build -t [IMAGE_NAME]:[VERSION] .
```

```
docker build -t hello-docker:1.0 .
```

Run the Docker image:
```
docker run [IMAGE_NAME]:[VERSION]
```

```
docker run hello-docker:1.0
```




Before deleting an image delete the Containter that uses is:
```
docker container rm [CONTAINER ID]
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

# Docker & K8 

## Commands
Build the Docker image:
```
docker build -t [IMAGE_NAME]:[VERSION] .

docker build -t hello-docker:1.0 .
```
<br>

Check Docker images:
```
docker images
```
<br>

Run the Docker image:
```
docker run --name [CONTAINER_NAME] [IMAGE_NAME]:[VERSION]

docker run --name MyDockerApp hello-docker:1.0
```
<br>

Check all RUNNING Docker containers:
```
docker ps
```
Check all Docker containers:
```
docker ps -a
```
<br>

Stop the Docker container:
```
docker stop [CONTAINER_ID]
```
<br>

Start Docker container:
```
docker start [CONTAINER_ID]
```
<br>

Before deleting an image delete the container that uses it:
```
docker container rm [CONTAINER_ID]
```
Delete the image:
```
docker rmi [IMAGE_ID]
docker image rm [IMAGE_ID]
```
<br>


| `docker run`                                     | `docker start`                       |
|--------------------------------------------------|--------------------------------------|
| Creates and starts a new container from an image | Starts an existing stopped container |
 
<br>




```
docker system prune -a
```
```
docker-compose down
```

```
docker-compose up
```
<br>

## Videos

### Docker
- [Intro to Docker [with Java Examples]](https://www.youtube.com/watch?v=FzwIs2jMESM)
- [Docker in IntelliJ IDEA](https://www.youtube.com/watch?v=FzwIs2jMESM)
- [100+ Docker Concepts you Need to Know](https://www.youtube.com/watch?v=rIrNIzy6U_g)
- [Docker in 100 Seconds](https://www.youtube.com/watch?v=Gjnup-PuquQ)
- [Learn Docker in 7 Easy Steps - Full Beginner's Tutorial](https://www.youtube.com/watch?v=gAkwW2tuIqE)
- [How to dockerize your Spring Boot API | Docker Tutorial](https://www.youtube.com/watch?v=3SNKdr3f9Io)
- [you need to learn Docker RIGHT NOW!! // Docker Containers 101](https://www.youtube.com/watch?v=eGz9DS-aIeY)
- [Why Use Docker: Real-life Use Cases](https://www.youtube.com/watch?v=rcYswUg0J5k)
- [Multi Container Docker Applications | A real-world example](https://www.youtube.com/watch?v=bX_tFv0YCqg)
- [Docker Crash Course Tutorial](https://www.youtube.com/playlist?list=PL4cUxeGkcC9hxjeEtdHFNYMtCpjNBm3h7)
<br>

### K8
- [What is Kubernetes?](https://www.youtube.com/watch?v=IMOZCDhH7do&list=PLN_xGGp_EzELV3J2Bp-kNkmI2Vor338NI&index=9)
<br>

### Udemy course
- [Docker & Kubernetes: The Practical Guide [2024 Edition]](https://www.udemy.com/course/docker-kubernetes-the-practical-guide/?couponCode=LETSLEARNNOWPP)
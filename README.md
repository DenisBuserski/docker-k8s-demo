# Docker & K8s 

![docker-and-k8s-logo](docker-and-k8s.jpeg)

<details>
<summary><h2>Docker</h2></summary>

</details>

<details>
<summary><h2>K8s</h2></summary>

</details>

## Commands
Build the Docker image:
```
docker build -t [IMAGE_NAME]:[VERSION] .

docker build -t hello-docker:1.0 .
```
`-t` - Tag <br>
`.` - <br>
<br>

| `docker run`                                                | `docker start`                       | `docker stop`                |
|-------------------------------------------------------------|--------------------------------------|------------------------------|
| Creates and starts a new container from an image            | Starts an existing stopped container | Stop the Docker container    |
| `docker run --name [CONTAINER_NAME] [IMAGE_NAME]:[VERSION]` | `docker start [CONTAINER_ID]`        | `docker stop [CONTAINER_ID]` |
| `--name` -                                                  |                                      |                              |
| `docker run --name MyDockerApp hello-docker:1.0`            |                                      |                              |
| ``                                                          |                                      |                              |
|                                                             |                                      |                              |

| Check all RUNNING Docker containers  | Check all Docker containers  | Check Docker images |
|--------------------------------------|------------------------------|---------------------|
| `docker ps`                          | `docker ps -a`               | `docker images`     |

| Delete container                     | Delete image                                               |
|--------------------------------------|------------------------------------------------------------|
|                                      | Before deleting an image delete the container that uses it |
| `docker container rm [CONTAINER_ID]` | `docker image rm [IMAGE_ID]`                               |
|                                      | `docker rmi [IMAGE_ID]`                                    |

<br>

Volumes are folders on the host machine, which are mounted into containers / Bind mounts

TO DO: Re-build image when change code
```
docker attach container
```
attached detaached container
exposing ports `-p`
add rm when run the container
docker exec
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

### Udemy course
- [Docker & Kubernetes: The Practical Guide [2024 Edition]](https://www.udemy.com/course/docker-kubernetes-the-practical-guide/?couponCode=LETSLEARNNOWPP)
<br>

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
- [Docker Tutorial for Beginners | Full Course [2021]](https://www.youtube.com/watch?v=p28piYY_wv8&t=3763s)
<br>

### K8s
- [What is Kubernetes?](https://www.youtube.com/watch?v=IMOZCDhH7do&list=PLN_xGGp_EzELV3J2Bp-kNkmI2Vor338NI&index=9)
- [Kubernetes Explained in 100 Seconds](https://www.youtube.com/watch?v=PziYflu8cB8)
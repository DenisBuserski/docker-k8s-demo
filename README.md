# Docker & K8s 

![docker-and-k8s-logo](docker-and-k8s.jpeg)

<details>
<summary><h2>Docker</h2></summary>

Build the Docker image from a Dockerfile:
```
docker build -t [IMAGE_NAME]:[VERSION] .

docker build -t hello-docker:1.0 .
```
`-t` - Flag used to tag the image with a name and optionally a version or tag. Name - `hello-docker`, tag - `1.0` <br>
`.` - Specifies the build context. The build context is the set of files located in the specified directory, which Docker will
use for the build process. The `.` refers to the current directory, meaning Docker will look for a Dockerfile in the current
directory and use the files in the current directory as the context for building the image. <br>

| `docker run`                                                                                                                        | `docker start`                                    | `docker stop`                |
|-------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------|------------------------------|
| Creates and starts a new container from an image                                                                                    | Starts an existing stopped container              | Stop the Docker container    |
| `docker run --name [CONTAINER_NAME] [IMAGE_NAME]:[VERSION]`                                                                         | `docker start [CONTAINER_ID]`                     | `docker stop [CONTAINER_ID]` |
| `--name` - Assign a custom name to the container being created                                                                      |                                                   |                              |
| `docker run --name MyDockerApp hello-docker:1.0`                                                                                    |                                                   |                              |
| `docker run -d --rm --name MyDockerApp hello-docker:1.0`                                                                            |                                                   |                              |
| `-d` - Detached mode. This allows you to continue using the terminal for other commands while the container runs in the background. | Starts the container in detached mode by default. |                              |
| `docker attach [CONTAINER_NAME]` - Connect your terminal to a running Docker container's standard input, output, and error streams. |                                                   |                              |
| `-rm` - Automatically remove the container when it exits.                                                                           |                                                   |                              |

| Check all RUNNING Docker containers  | Check all Docker containers  | Check Docker images |
|--------------------------------------|------------------------------|---------------------|
| `docker ps`                          | `docker ps -a`               | `docker images`     |

| Delete container                     | Delete image                                               | Remove all unused images and containers |
|--------------------------------------|------------------------------------------------------------|-----------------------------------------|
|                                      | Before deleting an image delete the container that uses it |                                         |
| `docker container rm [CONTAINER_ID]` | `docker image rm [IMAGE_ID]`                               | `docker system prune -a`                |
|                                      | `docker rmi [IMAGE_ID]`                                    |                                         |



</details>


<details>
<summary><h2>K8s</h2></summary>

</details>











<br>

Volumes are folders on the host machine, which are mounted into containers / Bind mounts

TO DO: Re-build image when change code


exposing ports `-p`

docker exec

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
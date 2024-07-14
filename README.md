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

| `docker run`                                                                                                                                                                                                            | `docker start`                                    | `docker stop`                |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------|------------------------------|
| Creates and starts a new container from an image                                                                                                                                                                        | Starts an existing stopped container              | Stop the Docker container    |
| `docker run --name [CONTAINER_NAME] [IMAGE_NAME]:[VERSION]`                                                                                                                                                             | `docker start [CONTAINER_ID]`                     | `docker stop [CONTAINER_ID]` |
| `--name` - Assign a custom name to the container being created                                                                                                                                                          |                                                   |                              |
| `docker run --name MyDockerApp hello-docker:1.0`                                                                                                                                                                        |                                                   |                              |
| `docker run -d --rm --name MyDockerApp hello-docker:1.0`                                                                                                                                                                |                                                   |                              |
| `-d` - Detached mode. This allows you to continue using the terminal for other commands while the container runs in the background.                                                                                     | Starts the container in detached mode by default. |                              |
| `docker attach [CONTAINER_NAME]` - Connect your terminal to a running Docker container's standard input, output, and error streams.                                                                                     |                                                   |                              |
| `-rm` - Automatically remove the container when it exits.                                                                                                                                                               |                                                   |                              |
| `docker run -d -p 8080:80 --name MyDockerApp hello-docker:1.0`                                                                                                                                                          |                                                   |                              |
| `-p 8080:80` - Publish a container's port(s) to the host. Allows you to make services running inside the container accessible from the host machine or network. Maps port 8080 on the host to port 80 in the container. |                                                   |                              |

| Check all RUNNING Docker containers  | Check all Docker containers  | Check Docker images |
|--------------------------------------|------------------------------|---------------------|
| `docker ps`                          | `docker ps -a`               | `docker images`     |

| Description                             | Command                              |                         | Addition                                                   |
|-----------------------------------------|--------------------------------------|-------------------------|------------------------------------------------------------|
| Delete container                        | `docker container rm [CONTAINER_ID]` |                         |                                                            |
| Delete image                            | `docker image rm [IMAGE_ID]`         | `docker rmi [IMAGE_ID]` | Before deleting an image delete the container that uses it |
| Remove all unused images and containers | `docker system prune -a`             |                         |                                                            |
| Remove volume                           | `docker volume rm`                   | `docker volume prune`   |                                                            |         

Docker has 2 options for containers to store files on the host machine, so that the files are persisted even after the 
container stops: 

| Volumes                                                            | Bind mounts                                                                                                                                                                                                              |
|--------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Completely handled by Docker                                       | When you use a bind mount in Docker, you are linking a directory on the host filesystem to a directory in the container                                                                                                  |
| One container writes to the storage while another reads from it    | If you modify, create, or delete files in the directory on the host, these changes will be immediately visible inside the container in the corresponding directory                                                       |
| Anonymous volume                                                   | If you modify, create, or delete files from within the container in the mounted directory, these changes will be reflected on the host filesystem                                                                        |
| Named volume                                                       | Allows for real-time collaboration between the host and the container, which is particularly useful for development environments where code changes need to be tested immediately without rebuilding the container image |
|                                                                    |                                                                                                                                                                                                                          |
|                                                                    |                                                                                                                                                                                                                          |
|                                                                    |                                                                                                                                                                                                                          |
|                                                                    |                                                                                                                                                                                                                          |



TODO: 
Add volumes to demo-docker-with-spring
Add port(-p) to demo-docker-with-spring 
Try `docker exec my_container echo "Hello, World!"`

```
docker-compose up
```

```
docker-compose down
```

</details>


<details>
<summary><h2>K8s</h2></summary>

</details>

<br>

Volumes are folders on the host machine, which are mounted into containers / Bind mounts
Host volume
docker run -v host_dir:container_dir
Anonymous volume
docker run -v container_dir
Named volumes
docker run -v name:container_dir



<br>

## Learning materials

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
- [Docker Volumes explained in 6 minutes](https://www.youtube.com/watch?v=p2PH_YPCsis)
- [Docker Volumes Explained](https://www.youtube.com/watch?v=n4LRpnqsXIo)
- [How to create and use a Docker volume](https://www.youtube.com/watch?v=_MlSdlP6nwc)
- [Docker Volumes Explained (PostgreSQL example)](https://www.youtube.com/watch?v=G-5c25DYnfI)
- [Docker Volumes Demo || Docker Tutorial 13](https://www.youtube.com/watch?v=SBUCYJgg4Mk)
- [Docker Crash Course #10 - Volumes](https://www.youtube.com/watch?v=Wh4BcFFr6Fc)
- [What is Docker Volume | How to create Volumes | What is Bind Mount | Docker Storage](https://www.youtube.com/watch?v=VOK06Q4QqvE)
<br>

### K8s
- [What is Kubernetes?](https://www.youtube.com/watch?v=IMOZCDhH7do&list=PLN_xGGp_EzELV3J2Bp-kNkmI2Vor338NI&index=9)
- [Kubernetes Explained in 100 Seconds](https://www.youtube.com/watch?v=PziYflu8cB8)
- [Kubernetes Explained in 6 Minutes | k8s Architecture](https://www.youtube.com/watch?v=TlHvYWVUZyc&list=WL&index=51)
- [Docker vs Kubernetes vs Docker Swarm | Comparison in 5 mins](https://www.youtube.com/watch?v=9_s3h_GVzZc)
- [What is Kubernetes | Kubernetes explained in 15 mins](https://www.youtube.com/watch?v=VnvRFRk_51k)
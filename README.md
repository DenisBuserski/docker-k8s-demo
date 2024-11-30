# Docker & K8s 

![docker-and-k8s-logo](docker-and-k8s.jpeg)

<details>
<summary><h2>Docker</h2></summary>

Build the Docker image from a Dockerfile
```
docker build -t [IMAGE_NAME]:[VERSION] .

docker build -t hello-docker:1.0 .
```
`-t` - Flag used to tag the image with a name and optionally a version or tag. Name - `hello-docker`, tag - `1.0` <br>
`.` - Specifies the build context. The build context is the set of files located in the specified directory, which Docker 
will use for the build process. The `.` refers to the current directory, meaning Docker will look for a Dockerfile in the 
current directory and use the files in the current directory as the context for building the image. <br>

| `docker run`                                                                                                                                                                                                            | `docker start`                                    | `docker stop`                |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------|------------------------------|
| Creates and starts a new container from an image                                                                                                                                                                        | Starts an existing stopped container              | Stop the Docker container    |
| `docker run --name [CONTAINER_NAME] [IMAGE_NAME]:[VERSION]`                                                                                                                                                             | `docker start [CONTAINER_ID]`                     | `docker stop [CONTAINER_ID]` |
| `docker run --name MyDockerApp hello-docker:1.0`                                                                                                                                                                        |                                                   |                              |
| `docker run -d --rm --name MyDockerApp hello-docker:1.0`                                                                                                                                                                |                                                   |                              |
| `docker run -d -p 8080:80 --name MyDockerApp hello-docker:1.0`                                                                                                                                                          |                                                   |                              |
| `--name` - Assign a custom name to the container being created                                                                                                                                                          |                                                   |                              |
| `-d` - Detached mode. This allows you to continue using the terminal for other commands while the container runs in the background.                                                                                     | Starts the container in detached mode by default. |                              |
| `docker attach [CONTAINER_NAME]` - Connect your terminal to a running Docker container's standard input, output, and error streams.                                                                                     |                                                   |                              |
| `-rm` - Automatically remove the container when it exits.                                                                                                                                                               |                                                   |                              |
| `-p 8080:80` - Publish a container's port(s) to the host. Allows you to make services running inside the container accessible from the host machine or network. Maps port 8080 on the host to port 80 in the container. |                                                   |                              |

| Check all RUNNING Docker containers | Check all Docker containers  | Check Docker images  | Follow the logs of a container in realtime use |
|-------------------------------------|------------------------------|----------------------|------------------------------------------------|
| `docker ps`                         | `docker ps -a`               | `docker images`      | `docker logs -f [CONTAINER_NAME]`              |

| Description                                     | Command                                    |                                      | Addition                                                   |
|-------------------------------------------------|--------------------------------------------|--------------------------------------|------------------------------------------------------------| 
| Delete container                                | `docker container rm [CONTAINER_ID]`       |                                      |                                                            |
| Delete image                                    | `docker image rm [IMAGE_ID]`               | `docker rmi [IMAGE_ID]`              | Before deleting an image delete the container that uses it |
| Remove all unused images and containers         | `docker system prune -a`                   |                                      |                                                            |
| Remove volume                                   | `docker volume rm`                         | `docker volume prune`                |                                                            |                                                                                                                                                                                                                                                           

<br>

`_TO_DO_`
Docker has 2 options for containers to store files on the host machine, so that the files are persisted even after the 
container stops: 

| Volumes                                                                                         | Bind mounts(Host volume)                                                                                                                                                                                                   |
|-------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Completely handled by Docker.                                                                   | When you use a bind mount in Docker, you are linking a directory on the host filesystem to a directory in the container.                                                                                                   |
|                                                                                                 | If you modify, create, or delete files in the directory on the host, these changes will be immediately visible inside the container in the corresponding directory.                                                        |
|                                                                                                 | If you modify, create, or delete files from within the container in the mounted directory, these changes will be reflected on the host filesystem.                                                                         |
| One container writes to the storage while another reads from it.                                | Allows for real-time collaboration between the host and the container, which is particularly useful for development environments where code changes need to be tested immediately without rebuilding the container image.  |
| Named volume - Have specific name assigned to it.                                               | `docker run -v host_dir:container_dir`                                                                                                                                                                                     |
| `docker run -v name:container_dir`                                                              |                                                                                                                                                                                                                            |
| Anonymous volume - Not given a specific name. Docker assigns them an unique ID automatically.   |                                                                                                                                                                                                                            |
| `docker run -v container_dir`                                                                   |                                                                                                                                                                                                                            |
|                                                                                                 |                                                                                                                                                                                                                            |

<br>

Start multiple containers `docker-compose.yml`:
```
docker-compose up
```

Stop the containers:
```
docker-compose down
```

</details>


<details>
<summary><h2>K8s</h2></summary>

![kubernetes-architecture](kubernetes-architecture.png)

Features:
- High availability - No downtime
- Scalability - High performance
- Disaster recovery - Backup and restore

`Kubernetes cluster`
- Cluster - Set of nodes
Consists of a `Control plane` and 1 or more `Worker nodes`. Every cluster needs at least one `Worker node` in 
order to run `Pods`. The `Worker nodes` host the `Pods` that are the components of the application workload. <br>

`Control plane` components make global decisions about the cluster(Example - scheduling), as well as detecting and responding to 
cluster events(Example - Starting up a new `Pod` when a `Deployment's replicas`(Copies of `Pods`, ensuring availability, scalability, 
and fault tolerance by maintaining identical instances) field is unsatisfied).
- `kube-apiserver` - Exposes an HTTP API that lets end users, different parts of your cluster, and external components communicate with one another.
- `etcd` - Consistent and highly-available key value store used as Kubernetes' backing store for all cluster data.
- `kube-scheduler` - Watches for newly created `Pods` with no assigned `Node`, and selects a `Node` for them to run on.
- `kube-controller-manager` - Component that runs controller processes. 
- `cloud-contrller-manager` - Integrates with underlying cloud provider.

`Node` is a worker machine in K8s. The `Node` components run on every node, maintaining running `Pods` and providing the K8s runtime environment. can be either a physical or virtual machine
- `kubelet` - Makes sure that containers are running in a `Pod`.
- `kube-proxy`
  - Implements part of the `K8s Service`(Way to expose an application running on a set of `Pods` as a network service) concept.
  - Maintains network rules on `Nodes`. These network rules allow network communication to your `Pods` from network sessions inside or outside of your cluster.
  - 
- `Container runtime` - Software responsible for running containers.

As pods come and go, services help the other pods "find out and keep track of which IP address to connect to."
Cluster

`Pod`
- Smallest unit in K8s.
- Holds 1 or more containers.
- Usually 1 application per pod.
- Each `Pod` gets its own IP address(New IP address on re-creation of the `Pod`).
- Can die very easily.
- `Service` 
  - Abstract way to expose an application running on a set of pods as a network service. 
  - Has a permanent IP address that can be attached to each `Pod`.
  - Will send the request to the `Pod`, which is less busy
- `Ingress` - Manages external access to the services in a cluster. Before the `Service` is reached it goes through the `Ingress`
- The lifecycle of a `Pod` and `Service` are not connected.
  - Represents a set of runnign containtres in your cluster 
 
`Configmap` - External configuration of the application(Example - DB_URL)
`Secret` - Identical to `Configmap`, but is used to store secret data(Example - DB_USER / DB_PASSWORD)

  - Runs on a `Worker node`. The `Worker node` runs the containers in the application. The `node` is a machine(virtual instance)л
  - Inside the `Worker node` there is Proxy/Config which control the network access
  - can have multiple Worker nodes

Worker node are controlled by the Master node

`Deployments` - describe the desired state of your application, like which images to use and the number of Pod replicas / Blueprint for app pods
`Serivices` - 

`Namespace` - Namespaces help split a Kubernetes cluster into sub-clusters, making it possible to divide resources between different projects or teams.
`Lables & Selectors` -  powerful tools that allow you to organize and select subsets of objects, like Pods, based on key-value pairs for more precise resource management.

Kubernetes cluster
- `Master node`
  - `API server`
  - `Controller manager` - Keeps track of what is happening in the cluster
  - `Scheduler`
  - `etcd`
- `Worker nodes` - Has a `Kublet` process running on it. Has containers on it. On worker nodes the applciations are running
`Node` - Virtual or physical machine
Virtual Network

`Volumes` - attaches a physical hard drive can be local or cloud

K8s doesn't manage data persistence 
DBs cant be replicated via Deployment, because it has a state
`StatefulSet` - for statefull apps or dbs
DBs are ofter hosted outside the K8s cluster






Control plane
`Minikube` - Master and Worker run on 1 node
`Kubectl` - CLI for K8s cluster
`Helm`

Kube-Proxy
`ArgoCd`
`Vault`

</details>


<details>
<summary><h2>Learning materials</h2></summary>

### Udemy course
- [Docker & Kubernetes: The Practical Guide [2024 Edition]](https://www.udemy.com/course/docker-kubernetes-the-practical-guide/?couponCode=LETSLEARNNOWPP)

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
- [Docker Compose will BLOW your MIND!! (a tutorial)](https://www.youtube.com/watch?v=DM65_JyGxCo)
- [Docker Compose & Docker Volumes | Docker](https://www.youtube.com/watch?v=41o4RJxfCZM)
- [Docker Crash Course #11 - Docker Compose](https://www.youtube.com/watch?v=TSySwrQcevM)
- [Docker Compose Tutorial](https://www.youtube.com/watch?v=HG6yIjZapSA)
- [When would you want to use docker and docker-compose on your projects?](https://www.youtube.com/watch?v=m3To85qMOuA&list=WL&index=94)

### K8s
- [What is Kubernetes?](https://www.youtube.com/watch?v=IMOZCDhH7do&list=PLN_xGGp_EzELV3J2Bp-kNkmI2Vor338NI&index=9)
- [Kubernetes Explained in 100 Seconds](https://www.youtube.com/watch?v=PziYflu8cB8)
- [Kubernetes Explained in 6 Minutes | k8s Architecture](https://www.youtube.com/watch?v=TlHvYWVUZyc&list=WL&index=51)
- [Docker vs Kubernetes vs Docker Swarm | Comparison in 5 mins](https://www.youtube.com/watch?v=9_s3h_GVzZc)
- [What is Kubernetes | Kubernetes explained in 15 mins](https://www.youtube.com/watch?v=VnvRFRk_51k)
- [Kubernetes Tutorial For Beginners - Learn Kubernetes](https://www.youtube.com/watch?v=yznvWW_L7AA&list=WL&index=104)
- [Kubernetes Tutorial - Kubernetes Architecture Explained](https://www.youtube.com/watch?v=1vnA13v8PcA&list=WL&index=83)
- [Първи стъпки с Kubernetes - Димитър Захариев](https://www.youtube.com/watch?v=-zu7qioThP4)
- [you need to learn Kubernetes RIGHT NOW!!](https://www.youtube.com/watch?v=7bA0gTroJjw&list=WL)
- [Intro to Kubernetes | Container Tools For Beginners | Orchestration Tools | Great Learning](https://www.youtube.com/watch?v=WUU85wXv4mA&list=WL&index=75&t=673s)
- [Kubernetes Crash Course for Absolute Beginners [NEW]](https://www.youtube.com/watch?v=s_o8dwzRlu4&list=WL&index=63&t=290s)
- [Deploying Java Applications with Docker and Kubernetes | DevOps Project](https://www.youtube.com/watch?v=0GgBi8yNQT4&list=WL&index=67&t=433s)
- [Kubernetes Roadmap - Complete Step-by-Step Learning Path](https://www.youtube.com/watch?v=S8eX0MxfnB4&list=WL&index=83)

- [What is Kubernetes?](https://www.redhat.com/en/topics/containers/what-is-kubernetes)
- [What is Kubernetes?](https://cloud.google.com/learn/what-is-kubernetes)
- [How to explain Kubernetes in plain English](https://enterprisersproject.com/article/2017/10/how-explain-kubernetes-plain-english)
- [What Is Kubernetes? What You Need To Know As A Developer](https://medium.com/@rphilogene/what-is-kubernetes-what-you-need-to-know-as-a-developer-674af25e3947)
- [Overview](https://kubernetes.io/docs/concepts/overview/)
- [Kubernetes Components](https://kubernetes.io/docs/concepts/overview/components/)
- [Objects In Kubernetes](https://kubernetes.io/docs/concepts/overview/working-with-objects/)
- [The Kubernetes API](https://kubernetes.io/docs/concepts/overview/kubernetes-api/)
- [Cluster Architecture](https://kubernetes.io/docs/concepts/architecture/)
  
</details>





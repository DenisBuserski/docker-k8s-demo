# Docker & K8s 

![docker-and-k8s-logo](docker-and-k8s.jpeg)

<details>
<summary><h2>Docker</h2></summary>


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

</details>


<details>
<summary><h2>K8s</h2></summary>



### Kubernetes architecture
![kubernetes-architecture](kubernetes-architecture.png)



</details>


<details>
<summary><h2>Learning materials</h2></summary>


### Docker

#### Videos
- [Learn Docker in 7 Easy Steps - Full Beginner's Tutorial](https://www.youtube.com/watch?v=gAkwW2tuIqE)
- [How to dockerize your Spring Boot API | Docker Tutorial](https://www.youtube.com/watch?v=3SNKdr3f9Io)
- [you need to learn Docker RIGHT NOW!! // Docker Containers 101](https://www.youtube.com/watch?v=eGz9DS-aIeY)
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
- [Docker Crash Course for Absolute Beginners [NEW]](https://www.youtube.com/watch?v=pg19Z8LL06w&list=WL&index=63&t=3s)

- [Използване на Docker за локална разработка на уеб приложения](https://www.youtube.com/watch?v=JHsNBNGNNCk&list=WL&index=53&t=2256s)

### K8s
#### Videos

- [Kubernetes Explained in 6 Minutes | k8s Architecture](https://www.youtube.com/watch?v=TlHvYWVUZyc&list=WL&index=51)
- [Docker vs Kubernetes vs Docker Swarm | Comparison in 5 mins](https://www.youtube.com/watch?v=9_s3h_GVzZc)

- [Kubernetes Tutorial For Beginners - Learn Kubernetes](https://www.youtube.com/watch?v=yznvWW_L7AA&list=WL&index=104)
- [Kubernetes Tutorial - Kubernetes Architecture Explained](https://www.youtube.com/watch?v=1vnA13v8PcA&list=WL&index=83)
- [Първи стъпки с Kubernetes - Димитър Захариев](https://www.youtube.com/watch?v=-zu7qioThP4)
- [Intro to Kubernetes | Container Tools For Beginners | Orchestration Tools | Great Learning](https://www.youtube.com/watch?v=WUU85wXv4mA&list=WL&index=75&t=673s)
- [Kubernetes Crash Course for Absolute Beginners [NEW]](https://www.youtube.com/watch?v=s_o8dwzRlu4&list=WL&index=63&t=290s)
- [Deploying Java Applications with Docker and Kubernetes | DevOps Project](https://www.youtube.com/watch?v=0GgBi8yNQT4&list=WL&index=67&t=433s)
- [Kubernetes Roadmap - Complete Step-by-Step Learning Path](https://www.youtube.com/watch?v=S8eX0MxfnB4&list=WL&index=83)
- [Do NOT Learn Kubernetes Without Knowing These Concepts...](https://www.youtube.com/watch?v=wXuSqFJVNQA&list=WL&index=18&t=1s)
- [Kubernetes Tutorial for Beginners [FULL COURSE in 4 Hours]](https://www.youtube.com/watch?v=X48VuDVv0do&list=WL&index=12&t=1s)
- [ArgoCD Tutorial for Beginners | GitOps CD for Kubernetes](https://www.youtube.com/watch?v=MeU5_k9ssrs&list=WL&index=1)
- [HashiCorp Vault Explained in 180 seconds](https://www.youtube.com/watch?v=nG8fCdWkLzc)
- [Hashicorp vault 101](https://www.youtube.com/watch?v=8UBJbhzbHp4)
- [What is Helm in Kubernetes? Helm and Helm Charts explained | Kubernetes Tutorial 23](https://www.youtube.com/watch?v=-ykwb1d0DXU)
- [Helm and Helm Charts Explained - Helm Tutorial for Beginners](https://www.youtube.com/watch?v=w51lDVuRWuk)
- [What is Helm?](https://www.youtube.com/watch?v=fy8SHvNZGeE)
- [How to Create Helm Charts - The Ultimate Guide](https://www.youtube.com/watch?v=jUYNS90nq8U&t=47s)

#### Read

- [What is Kubernetes?](https://cloud.google.com/learn/what-is-kubernetes)
- [How to explain Kubernetes in plain English](https://enterprisersproject.com/article/2017/10/how-explain-kubernetes-plain-english)
- [What Is Kubernetes? What You Need To Know As A Developer](https://medium.com/@rphilogene/what-is-kubernetes-what-you-need-to-know-as-a-developer-674af25e3947)
- [Overview](https://kubernetes.io/docs/concepts/overview/)
- [Kubernetes Components](https://kubernetes.io/docs/concepts/overview/components/)
- [Objects In Kubernetes](https://kubernetes.io/docs/concepts/overview/working-with-objects/)
- [The Kubernetes API](https://kubernetes.io/docs/concepts/overview/kubernetes-api/)
- [Cluster Architecture](https://kubernetes.io/docs/concepts/architecture/)
- https://www.geeksforgeeks.org/kubernetes-tutorial/
- https://www.geeksforgeeks.org/introduction-to-kubernetes-k8s/
 
 
</details>





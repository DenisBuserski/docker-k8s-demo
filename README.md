# Docker & K8s 

![docker-and-k8s-logo](docker-and-k8s.jpeg)

<details>
<summary><h2>Docker</h2></summary>





                                                                                                                                                                                                                                                          

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



</details>


<details>
<summary><h2>K8s</h2></summary>

`K8s` - Tool that helps us to run and manage applications in containers. 

### Features:
- High availability - No downtime
- Scalability - High performance
- Self-Healing Capabilities – It provides rescheduling, replacing, and restarting the containers that are dead

### Kubernetes architecture
![kubernetes-architecture](kubernetes-architecture.png)



`K8s cluster` <br>
`Cluster` 
- Set of nodes
- Consists of a `Master node` and 1 or more `Worker nodes`. <br>
<br>
- `Node` is a worker machine in K8s. 
  - Its components run on every node, maintaining running pods and providing the K8s runtime environment.
  - Can be either a physical or virtual machine.
  - Has multiple pods on it.
  - `kubelet` - Ensures that the containers defined in a Pod are running and healthy.
    - Communicates with the Master node
    - If it notices any issues with the pods running on the Worker nodes then it tries to restart the pod on the same node. If
      the issue is with the Worker node itself then the K8s master node detects the node failure and decides to re-create the pods on the other healthy node.
  - `kube-proxy` - Implements the networking aspects of the `Service` concept.
    - `Service`
      - Abstract way to expose an application running on a set of pods as a network service.
      - Provides a virtual IP(known as the ClusterIP), which enables communication with any pod in the set without worrying about individual pod IP changes. 
      - As pods are created and destroyed, services provide a stable endpoint, allowing other pods to discover and connect to the appropriate IP addresses, even as individual pods come and go.
      - Uses a simple round-robin load balancing approach to distribute traffic across the pods.
      - `Ingress` - Manages external access to the services in a K8s cluster(HTTP/HTTPS traffic). When external traffic comes 
        to the cluster, it first passes through the Ingress, which routes it to the appropriate Service based on defined rules.
    - Maintains network rules on nodes, which allow internal and external communication to the pods.
  - `Container runtime`- Software responsible for running containers.
    
- `Worker node`
  - Every cluster needs at least 1 worker node in order to run pods.
  - Does the actual work, runs the containers that make up the application, managed by the `kubelet`.
  - Controlled by the Master node.
  - Hosts the pods that are the components of the application workload.
  - `Pod`
    - Smallest unit in K8s.
    - Holds 1 or more containers, deployed together on the same host.
    - Represents a set of running containers in the cluster.
    - Usually 1 application per pod.
    - Each pod gets its own unique IP address, which changes if the pod is recreated.
    - Can die very easily.
    - The lifecycle of a `Pod` and a `Service` are independent of each other.
    
- `Master node`
  - Entry point of all administrative tasks.
  - Need less resources than the `Worker nodes`.
  - Hosts the K8s `Control plane` components, which make global decisions about the cluster state, as well as detecting and responding to cluster events.
    - `kube-apiserver`
      - Exposes an HTTP API that serves as the primary communication hub for end users, cluster components, and external systems.
      - If you want to deploy a new application in a K8s cluster you interact with the API server using UI(K8s Dashboard) or CLI(`kubectl`).
      - Cluster gateway.
      - Acts as a gatekeeper for authentication.
      - Good for security, because there is only 1 entry point into the cluster.
    - `kube-scheduler`
      - Responsible for distributing the workload and tracking the utilization of the working load of each Worked node.
      - Watches for newly created Pods that have no assigned Node, and selects an appropriate Node for them to run on based on resource availability and other scheduling constraints.
      - Only decides on which Node a new Pod should be scheduled, the actual the process of running the Pod is handled by the `kublet`.
    - `kube-controller-manager` 
      - Collecting and sending information to the API server.
      - Detects and manages changes in the cluster's desired state.
      - If a pod dies or becomes unhealthy, the Controller manager is responsible for ensuring that the desired state is 
        restored. It does this by creating a new pod to replace the missing pod, and the `kube-scheduler` will then schedule the new pod onto an appropriate node.
    - `etcd`
      - Stores all cluster state data.
      - The cluster brain.
      - Key value store database.
      - How does the `kube-scheduler` know what resources are available?
      - How does the `kube-contrller-manager` know that the cluster state change?
      - Does not store Application data.
    - `cloud-contrller-manager` - Interacts with the underlying cloud provider's API to manage cloud-specific resources, such as load balancers, storage, and networking.

K8s objects
- `Deployment`
  - Describe the desired state of your application(Example - Which images to use, Number of pod replicas).
  - Blueprint for app pods.
  - Controls multiple pods.
  - Manages a `ReplicaSet`(Ensures the desired number of pod replicas are running in the cluster at all times).
- `Services`
- `Volumes` - attaches a physical hard drive can be local or cloud
K8s doesn't manage data persistence
  DBs cant be replicated via Deployment, because it has a state
  `StatefulSet` - for statefull apps or dbs
  DBs are ofter hosted outside the K8s cluster

`Minikube` - 1 node K8s cluster. `Master node` and `Worker node` run on 1 node. Useful for local test. <br>
`Configmap` - Used to store non-sensitive, external configuration data for an application (Example - DB_URL). <br>
`Secret` - Similar to `Configmap`, but is used to store sensitive data such as passwords, API keys, or tokens(Example - DB_USER / DB_PASSWORD). <br>

`Helm`
- Package manager for K8s. 
- `Helm chart` - bundle of `.yaml` files, can be pushed to Helm repository.










imperative vs declarative



The configuration file has 3 parts:
- Metadata - `metadata:`
  - Contains identifying information about the resource, such as its name, `Namespace`, and `Labels`.
  - `Namespace` - Help isolate workloads, making it easier to apply resource quotas, access controls, and policies specific to each namespace
    - `kube-system`
    - `kube-public`
    - `kube-node-lease`
    - `default`
  - `Labels` 
- Specification - `spec:`
  - Describes the desired state of the resource.
  - Attributes are specific to the kind.
- Status
  - Automatically generated and updated by K8s. 
  - K8s continuously compares the Desired state(From the `spec`) with the Actual state(Stored in `etcd`) and takes actions to reconcile any differences.

`deployment.yaml`
```yaml
apiVersion: apps/v1  #For each component there is a different apiVersion
kind: Deployment
metadata:
  name: java-deployment
  namespace: my-namespace
  labels:
    app: java
spec:
  replicas: 1
  selector:
    matchLabels:
      app: java
  template:
    metadata:
      labels:
        app: java
    spec:
      containers:
      - name: java
        image: java
        ports:
        - containerPort: 8080
        env:
        - name: JAVA_ROOT_USERNAME
          valueFrom:
            secretKeyRef:
              name: java-secret
              key: java-root-username
        - name: JAVA_ROOT_PASSWORD
          valueFrom:
            secretKeyRef:
              name: java-secret
              key: java-root-password

```

`ArgoCd`
- Continuous delivery tool.
- Provides a visual dashboard for managing K8s applications.
- Constantly checks for changes in the Git repository and automatically syncs those changes to the K8s cluster.


</details>


<details>
<summary><h2>Learning materials</h2></summary>

### Udemy course
- [Docker & Kubernetes: The Practical Guide [2024 Edition]](https://www.udemy.com/course/docker-kubernetes-the-practical-guide/)

### Docker
#### Read
https://medium.com/thesecmaster/understand-the-difference-between-docker-engine-and-docker-desktop-with-thesecmaster-0c2fecec926f#3eff

#### Videos
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
- [Docker Crash Course for Absolute Beginners [NEW]](https://www.youtube.com/watch?v=pg19Z8LL06w&list=WL&index=63&t=3s)
- [18 Weird and Wonderful ways I use Docker](https://www.youtube.com/watch?v=RUqGlWr5LBA&list=WL&index=92)
- [Използване на Docker за локална разработка на уеб приложения](https://www.youtube.com/watch?v=JHsNBNGNNCk&list=WL&index=53&t=2256s)
- [Коя е НАЙ-РЕВОЛЮЦИОННАТА технология в ИТ?](https://www.youtube.com/watch?v=yuRXnPkD_YY)

### K8s
#### Videos
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
- [What is Kubernetes?](https://www.redhat.com/en/topics/containers/what-is-kubernetes)
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





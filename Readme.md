# Openshift demo project
This project uses Spring-boot Framework.

## _Minimum requirement_
- VirtualBox
- Minishift, oc (cli tool)
- nodejs for http web server
- JDK 8
- Maven 

## Installation

1) Virtual box
    Download Virtual box and install it
2) Minishift
    Download minishift
    Download oc
3) add minishift and oc to path envirionment variable
4) open command line shell run following command.
>It will download minishift image about 1GB and starts minishift.
```shell script
 minishift start --vm-driver virtualbox
```
5) set vm driver for future run
```shell script
 minishift config set vm-driver virtualbox
```
6) install npm web server
```shell script
npm install --global http-server
```
7) git clone this repo
```
git clone https://github.com/rbhupesh/s2i.git
```
8) change to s2i directory
```
cd s2i
```
9) start http-server 
>It serves two purpose
>Easy way to pull docker file inside minishift
>Inject springboot Jar file at run time 
```
http-server
```
10) login to minishift using oc use system user
```
oc login -u system:admin
```
11) login to minishift shell 
```
minishift ssh
```
12) download dockerfile and build it  
```
curl http://[minishift ip]:8080/manifest/Dockerfile -o Dockerfile
docker build -t openjdk/s2i:14.0.1 .
```
>docker build will download base JDK image and tags it to openjdk/s2i:14.0.1 
> run below command it should list our s2i image.
> both command can be combined using pipe
>
> curl  http://[minishift ip]:8080/manifest/Dockerfile | docker build -f -  -t openjdk/s2i:14.0.1 .
> 
> Refer : https://docs.docker.com/engine/reference/commandline/build/
```
docker images
```
>now exit from minikube shell
13) run maven command to create executable jar file
```
mvn clean compile test package
```
14) run following command in manifest directory
```
oc create -f ms1.yml
oc create -f route.yml
```
15) open another shell run following command to check minishift logs
```
minishift logs -f
```
16) open anothe shell comand run following commands to check status of services, replica set and pods
```
oc get svc
oc get rs
oc get pods
```
> ##Testing
>Open minikube console
>check status of pods replicaset services and route
>click on route url for my run route is
>http://ms1-v1-service-myproject.192.168.99.101.nip.io/api/v2/greeting/Bhupesh
>route can also be created using simple command like
>oc expose svc/ms1-v1-service

17) Cleanup
```
oc delete -f ms1.yml
oc delete -f route.yml
```
---
## useful commands
### Minishift
| Command     | 
| ----------- |
| Minishift start --vm-driver virtualbox | 
| minishift openshift registry   | 
| minishift log -f   | 
| minishift stop   |
| minishift delete  |


| OC| 
|-|
| oc login -u system:admin   | 
| oc whoami   | 
| oc logs -f buildconfig/{config name}   | 

| |
|-|
| oc create -f rs.yml | 
| oc create -f svc.yml | 
| oc create -f route.yml |
| oc apply -f rs.yml |

| | 
|-|
| oc get deployment   | 
| oc get rs   | 
| oc get svc   | 
| oc get imagestream  | 
| oc get imagestreamtag.image.openshift.io  | 
| oc get buildconfig  | 

| |
|-|
| oc delete deployment  demo | 
| oc delete rs  demo | 
| oc delete svc  demo | 
| oc delete imagestream demo | 
| oc delete imagestreamtag.image.openshift.io demo | 
| oc delete buildconfig demo | 


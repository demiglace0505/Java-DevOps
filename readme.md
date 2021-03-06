- [Certificate of Completion](#certificate-of-completion)
  - [AWS](#aws)
      - [EC2](#ec2)
      - [Linux Directories](#linux-directories)
      - [vi editor](#vi-editor)
      - [Installing Software](#installing-software)
  - [Git](#git)
  - [Maven](#maven)
      - [Lifecycle Phases](#lifecycle-phases)
      - [Coordinates](#coordinates)
      - [Maven Repositories](#maven-repositories)
      - [Creating a Maven Project](#creating-a-maven-project)
  - [Project](#project)
      - [Coupon Service](#coupon-service)
      - [Product Service](#product-service)
      - [Integrating Microservices](#integrating-microservices)
  - [Manual Deployment to AWS using S3](#manual-deployment-to-aws-using-s3)
      - [Automating launch](#automating-launch)
      - [Creating AMI and Scaling Manually](#creating-ami-and-scaling-manually)
  - [Elastic Load Balancer](#elastic-load-balancer)
  - [Auto Scaling Group](#auto-scaling-group)
  - [CloudWatch and SNS](#cloudwatch-and-sns)
      - [SNS](#sns)
      - [Cloudwatch Alarm](#cloudwatch-alarm)
  - [Deploy to Elastic Beanstalk using RDS](#deploy-to-elastic-beanstalk-using-rds)
      - [Deploying the Coupon Service](#deploying-the-coupon-service)
      - [Deploying the Product Service](#deploying-the-product-service)
  - [Docker](#docker)
      - [Docker Components](#docker-components)
      - [Docker in Action](#docker-in-action)
      - [Docker Layers and Overlay Storage](#docker-layers-and-overlay-storage)
      - [Launching a MySQL Container](#launching-a-mysql-container)
      - [Volumes and Bind Mounts](#volumes-and-bind-mounts)
      - [Docker Networking](#docker-networking)
      - [Dockerfile](#dockerfile)
  - [Dockerize Micro Services](#dockerize-micro-services)
      - [Build Images](#build-images)
      - [Launch the Containers](#launch-the-containers)
      - [Docker Hub](#docker-hub)
  - [Docker Compose](#docker-compose)
      - [Networks](#networks)
      - [Volumes](#volumes)
      - [Composing the MySQL Service](#composing-the-mysql-service)
      - [Composing MicroServices](#composing-microservices)
  - [Kubernetes](#kubernetes)
      - [Kubernetes Architecture](#kubernetes-architecture)
      - [Kubernetes Installation Types](#kubernetes-installation-types)
      - [Kubectl Configuration](#kubectl-configuration)
      - [Pod](#pod)
      - [Pod Life Cycle](#pod-life-cycle)
      - [Labels and Selectors](#labels-and-selectors)
      - [Namespaces](#namespaces)
      - [Deployment](#deployment)
      - [Service](#service)
      - [Rolling Updates](#rolling-updates)
      - [Volumes](#volumes-1)
      - [ConfigMaps](#configmaps)
      - [Secrets](#secrets)
      - [Persistent Volumes](#persistent-volumes)
  - [Deploying Microservices to Kubernetes](#deploying-microservices-to-kubernetes)
  - [Eclipse Jkube](#eclipse-jkube)
  - [Docker Swarm](#docker-swarm)
      - [Architecture](#architecture)
      - [Setting up Swarm](#setting-up-swarm)
      - [Creating Service](#creating-service)
      - [Multiple Replicas and Scaling](#multiple-replicas-and-scaling)
      - [Drain Worker Node](#drain-worker-node)
      - [Docker Stack Deploy](#docker-stack-deploy)
      - [Remove Worker Nodes from Swarm](#remove-worker-nodes-from-swarm)
      - [Switch Managers](#switch-managers)
      - [Replicas in Docker Swarm](#replicas-in-docker-swarm)
  - [AWS Lambda](#aws-lambda)
  - [Ansible](#ansible)
      - [Master and Agent](#master-and-agent)
      - [Playbook](#playbook)
      - [Tags](#tags)
  - [Jenkins](#jenkins)
      - [Jobs](#jobs)
      - [Build Triggers](#build-triggers)
      - [Deployment](#deployment-1)
      - [Webhooks](#webhooks)
      - [Master and Slave](#master-and-slave)
  - [Jenkins Pipelines](#jenkins-pipelines)
      - [Creating a Java Project pipeline](#creating-a-java-project-pipeline)
      - [Java Web Project Pipeline](#java-web-project-pipeline)

# Certificate of Completion

![Certificate of Completion](UC-a69b4513-4a46-4fca-a5e8-0a2c8970a6eb.jpg)

## AWS

#### EC2

EC2 uses AMI Amazon Machine Images which have the required OS and software. When we create an EC2 instance, a public DNS will be assigned to it. An isntance IP address will change when it is rebooted. If we need to create a static IP address, we need to create an Elastic IP (not free).

In order to connect to the remote instance, we can use SSH on port 22. It uses public key cryptography wherein the private key is stored by the user. We can connect to the remote instance using the following command.

```
ssh -i "awskeys.pem" ec2-user@ec2-18-140-52-67.ap-southeast-1.compute.amazonaws.com
```

#### Linux Directories

- `/` represents the root directory
- `/bin` is where all the command line utilities are stored
- `/boot` includes all the linux startup files including the linux kernel
- `/etc` contains all the configuration files for the system to run
- `/dev` contains all the hardware and software devices
- `/home` is the home directory for every user
- `/lib` contains libraries for the kernel and various command line utilities
- `/mnt` points to removable media
- `/opt` is where all the applications binaries are stored
- `/proc` holds all the currently running kernel related processes
- `/root` is the home directory of the root user
- `/sbin` is for the system administration commands
- `/tmp` a temporary directory
- `/usr` is where all the small programs such command line utilities
- `/var` variable data such as log files, printer spools

#### vi editor

The vi editor comes with 3 different modes: **Command** where we can give a command to the editor **Insert** for adding data and **Execute** wherein we can do search, add line numbrs etc. We can enter Insert mode using `i`. The `escape` key returns us to the command mode. The `o` key creates a new line. `a` appends data to the cursor location. `s` removes the current character. `dd` removes the entire line. To enter execute mode, we use `:`. `wq` stands for write quit which saves and quit. `/` will search for data.

#### Installing Software

We can install software using the yum command. The `yum repolist` command lists the repositories. `yum list installed` shows the currently installed software. `yum grouplist` shows grouped software. To install software, we can use `yum install httpd`. We can launch this web server using `service httpd start`.

## Git

Git allows developers to work in parallel without overriding each other's changes. A **Centralized VCS** has all files maintained in one central location. This has a disadvantage of needing to be online at all times. The **Distributed VCS** allows a developer to clone a remote repository to his local machine and allows them to work offline. Git is free, open source, fast, lightweight and offers SHA1 security. It also offers branching.

Each commit we do has a unique commitId, and a pointer called head will point to the latest commit.

**git commands**

- `git log` shows a history of all commits made
- `git diff hash1 hash2` shows the differences between two commits.
- `git checkout index.html` is a way to revert unstaged changes
- `git reset HEAD index.html` unstages a changes for a file afterwards we can do `git checkout index.html`
- `git checkout -b branchname` creates a new branch
- `git merge frombranch` will merge the changes from the frombranch to the current branch
- `git branch -d branchname` will delete a branch
- `git fetch` checks for changes from a remote repository, but will not pull the files
- `git reset` is used to set the HEAD to a particular commit. If we need to push the new head to the remote, we need to use the `-f` flag
- `git revert` creates a new commit by undoing the unwanted commit. This does not delete commits unlike git reset.

**Resolving Merge Conflicts**

In this example, we created a new branch called _bugfix_ wherein we need to fix a bug from the _dev_ branch. However, someone else is working on the same line in the dev branch. When the second developer commits his changes, and the first developer attempts to merge, they will come across a merge conflict. We can decide on which line to keep.

```html
<<<<<<< HEAD
<h2>cat cat cat cat cat cat</h2>
=======
<h2>dogedogedoge</h2>
>>>>>>> bugfix
```

## Maven

Maven is a project management tool. Building a proejct is composed of compiling, running tests, packaging into jar, bundling into war, and desploying to servers. Maven uses convention over configuration. `mvn insall` will compile the source code under `src/main/java` and run the tests under `src/test/java` and then package into a JAR/WAR.

Maven is also used for dependencies and bundling them. Maven also uses repositories where it puts all artifacts and plugins for on the fly downloading. Maven is lightweight and uses a plugin model through which plugins can be reused across projects.

We can create a Java project from the commandline.

```
mvn archetype:generate -DgroupId=com.demiglace -DartifactId=hellomaven -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

The maven archetype describes the **generate** goal wherein we pass various parameters such as groupId, artifactId, archetypeArtifactId. A maven plugin is a collection of one or more goals, wherein a goal is a specific task that can be run independently or as a part of a bigger build.

When we execute a maven command to build a project, it looks for the **pom.xml**. It describes the project packaging, information, and the third party libraries as dependencies.

To build, we can use the command `mvn install` which will compile, run tests and package the project. The compiled project will be under the `target` directory.

#### Lifecycle Phases

When we run the mvn install command, we asked maven to execute a lifecycle phase. Maven has many lifecycle phases such as process-resources, compile, test, package and many more. Each phase is associated with one or more goals. We can also execute a particular phase for example `mvn surefire:test`.

#### Coordinates

When we build our project, the plugins such as jar and war will look at coordinates in the pom.xml like groupId, artifactId, version, packaging for the information about the project. These coordinates are represented internally by maven by groupId:artifactId:packaging:version and will decide where our project will be located in the maven repository and what the name of the final output will be.

#### Maven Repositories

When we run `mvn install`, maven downloads jars and plugin from the Maven central repository. Maven also creates a local repository on our machine so that plugins and jars are pulled from that instead of the central repository every time we do a mvn install.

#### Creating a Maven Project

Using the following command, we created a standalone java project using maven. The archetype is generate, with groupId as com.demiglace and project name as java-project.

```
mvn archetype:generate -DgroupId=com.demiglace -DartifactId=java-project -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

We also create a web project

```
mvn archetype:generate -DgroupId=com.demiglace -DartifactId=java-web-project -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
```

We can also create the project on our linux instance. We first need to install the Java jdk and maven and then we run the commands above.

```
yum install java-1.8.0-openjdk
yum install maven
```

## Project

We will be creating the Product and Coupon microservice that exposes a REST api which will allow the client to create a Product and in the process, the ProductService will use the CouponService to apply a voucher. The Coupon information is maintained by the CouponService and the ProductService will be responsible for creating a Product in the database.

We start with creating the database tables for product and coupon

```sql
use mydb;

create table product(
id int AUTO_INCREMENT PRIMARY KEY,
name varchar(20),
description varchar(100),
price decimal(8,3)
);

create table coupon(
id int AUTO_INCREMENT PRIMARY KEY,
code varchar(20) UNIQUE,
discount decimal(8,3),
exp_date varchar(100)
);
```

#### Coupon Service

For the Coupon Service, the necessary dependencies are Spring Web for developing the RESTful services, Spring Data JPA for doing ORM against the database and MySQL Driver for connecting to the mysql database.

We then create the model class and repository interface. The repository extends the JpaRepository interface from Spring. In the **findByCode()** method, Spring Data JPA will automatically use the passed code and create a select query where the code is equal to the passed code.

```java
@Entity
public class Coupon {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String code;
	private BigDecimal discount;
	private String expDate;
}

public interface CouponRepo extends JpaRepository<Coupon, Long> {
	Coupon findByCode(String code);
}
```

Afterwards we create the REST Controller and expose out the RESTful api. We inject the CouponRepo to our rest controller.

```java
@RestController
@RequestMapping("/couponapi")
public class CouponRestController {
	@Autowired
	CouponRepo repo;

	@RequestMapping(value="/coupons", method = RequestMethod.POST)
	public Coupon create(@RequestBody Coupon coupon) {
		return repo.save(coupon);
	}

	@RequestMapping(value="/coupons/{code}", method=RequestMethod.GET)
	public Coupon getCoupon(@PathVariable("code") String code) {
		return repo.findByCode(code);
	}
}
```

Finally we configure the datasource in application.properties

```
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=1234

server.port=9091
```

We can test by sending a POST request to `http://localhost:9091/couponapi/coupons` and a GET request to `http://localhost:9091/couponapi/coupons/SUPERSALE`

```json
{
  "code": "SUPERSALE",
  "discount": 10,
  "expDate": "12/12/2022"
}
```

#### Product Service

For the Product Service, we use the same dependencies: Spring Data JPA, MySQL Driver, Spring Web. We also proceed with creating the Product model class and repository interface. The couponCode field is marked with **@Transient** annotation since we do not want to include it to our database.

```java
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private BigDecimal price;

  @Transient
	private String couponCode;
}

public interface ProductRepo extends JpaRepository<Product, Long> {

}
```

We create the rest controller for the products afterwards and configure its datasource. For now, this controller doesn't apply the discount from the CouponService yet.

```java
@RestController
@RequestMapping("/productapi")
public class ProductRestController {
	@Autowired
	ProductRepo repo;

	@RequestMapping(value="/products", method = RequestMethod.POST)
	public Product create(@RequestBody Product product) {
		return repo.save(product);
	}
}
```

```
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=1234

server.port=9090
```

We can test the Product Service by sending a POST request to `http://localhost:9090/productapi/products`

```json
{
  "name": "Legion 5",
  "description": "Gaminig Laptop",
  "price": 1000
}
```

#### Integrating Microservices

To integrate the ProductService, we invoke the rest api exposed out to the CouponService. We will be using **RestTemplate** to get the couponCode and use it inside the ProductRestController create() method. We also take this time to create a Coupon DTO object in our productservice.

```java
@RestController
@RequestMapping("/productapi")
public class ProductRestController {
	@Autowired
	ProductRepo repo;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${couponservice.url}")
	private String couponServiceURL;

	@RequestMapping(value="/products", method = RequestMethod.POST)
	public Product create(@RequestBody Product product) {
		Coupon coupon = restTemplate.getForObject(couponServiceURL + product.getCouponCode(), Coupon.class);
		// discount logic
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));

		return repo.save(product);
	}
}

public class Coupon {
	private Long id;
	private String code;
	private BigDecimal discount;
	private String expDate;
}
```

We also inject a RestTemplate bean in our ProductServiceApplication so that we will have a RestTemplate bean at runtime

```java
@SpringBootApplication
public class ProductserviceApplication {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductserviceApplication.class, args);
	}
}
```

To test the integration between the two services, we can send a post request to the product endpoint and include a _couponCode_ in the body. This time, the price will be discounted by 10.

```json
{
  "name": "Nitro 5",
  "description": "Gaminig Laptop",
  "price": 800,
  "couponCode": "SUPERSALE"
}
```

## Manual Deployment to AWS using S3

S3 is an Object based storage unlike EC2 which uses elastic block storage or elastic file storage. To manually deploy the SpringBoot application to AWS, we first need to launch an EC2 instance. We install mariadb-server on this instance for working with SQL.

```
yum install -y mariadb-server
systemctl enable mariadb
systemctl start mariadb
mysql_secure_installation
mysql -uroot -p
```

We then proceed on creating the database and tables manually

```sql
create database mydb;

use mydb;

create table product(
id int AUTO_INCREMENT PRIMARY KEY,
name varchar(20),
description varchar(100),
price decimal(8,3)
);

create table coupon(
id int AUTO_INCREMENT PRIMARY KEY,
code varchar(20) UNIQUE,
discount decimal(8,3),
exp_date varchar(100)
);
```

Afterwards, we install java

```
yum install java-1.8.0-openjdk
```

We then run mvn clean and mvn install on couponservice then upload the resulting jar file into the s3 bucket. We can download it to the EC2 instance using wget.

```
wget -O couponservice-0.0.1-SNAPSHOT.jar '<presigned URL>'
```

Afterwards, we can run the jar from within the EC2 instance

```
java -jar couponservice-0.0.1-SNAPSHOT.jar
```

We'll need to open port 9091 of the ec2 instance by editing the instance's security group. Then afterwards, we can access the service via postman through its public DNS `http://ec2-54-179-226-23.ap-southeast-1.compute.amazonaws.com:9091/couponapi/coupons`. We can send a POST request to /couponapi/coupons just like before.

#### Automating launch

The command from the previous section `systemctl start mariadb` causes mariadb to startup automatically when the instance is booted up. To start up Spring boot automatically, we can modify `/etc/rc.local`. We first need to make sure that hte jar file is available at the ec2-user directory.

```
cat /etc/rc.local
vi /etc/rc.local
chmod + x /etc/rc.d/rc.local
```

We append the following at the end of the file using vim

```
java -jar /home/ec-2user/couponservice-0.0.1-SNAPSHOT.jar
```

#### Creating AMI and Scaling Manually

To create a custom AMI, we just need to go to actions->Image and Template->Create Image. We will then be able to spin up instances using this image. It is important to note that we should use the same security group in order to expose out port 9091.

We installed Stress which will stress our instance so that we can have a means to trigger scaling.

```
amazon-linux-extras install epel -y
yum install stress -y
```

## Elastic Load Balancer

The Elastic Load Balancer distributes loads to multiple instances. The three ways of load balancers are Application, Classic and Network. Application and Network load balancers both work with the VPC whereas the Classic load balancer works with an EC2. Both Application and Classic will work at layer 7 (application layer) and deals with routing HTTP/HTTPS traffic. Network load balancer works with the network layer at the TCP/UDP level.

In this project, we use the Classic load balancer. We specify port 80 of the load balancer HTTP protocol to redirect to the EC2 instance's port 9091. In the Health Check configuration, we set the ping protocol as HTTP port 9091 and ping path is `/couponapi/coupons/SUPERSALE`. In realtime applications, we can have a ping service that can always be pinged once the application is running.

To test the load balancer, we simply take the DNS name and access it using the web browser. In this case: `http://couponserviceloadbalancer-1160041653.ap-southeast-1.elb.amazonaws.com/couponapi/coupons/SUPERSALE`

## Auto Scaling Group

Auto Scaling will scale up or down our EC2 instances as required. We start with creating the launch configuration. For this, we use the couponservice custom AMI that we created earlier. It is important to remember that the security group used by the ASG should have the SSH port open.

After creating the launch configuration, we can create an ASG using the action button. We set Desired Capacity as 2, which means the ideal capacity for the application. The minimum capacity is set to 1 which means 1 instance will be used when there is not enough load. Maximum capacity is set to 4. The scaling policy is set to Target Tracking Policy with average cpu utilization on a target value of 50. This means if the cpu utilization exceeds 50, an instance will be created.

To test, we can make use of **stress** from the previous chapters. The ASG is configured for 300 seconds before spinning up new instances.

```
stress --cpu 1
```

## CloudWatch and SNS

CloudWatch can be used automate Collecting, Monitoring and Analyzing of logs/data. It integrates with the other services such as EBS EC2 RDS SNS etc.

#### SNS

Simple Notification Service allows us to capture events and send notifications. The two elements of SNS are Topic and Subscription. **Topic** is a virtual channel which will receive messages and whichever subscribers are subscribed to that Topic, they will get that message and react to that message. A Cloud Watch Alarm can be a sender of a message to create a topic. Our microservice applications can also send messages to create a topic as well.

For this demo, we create a Topic and Subscriber. When creating a subscription, we use the ARN Amazon Resource Number which a unique number for our topic. We set Email as the protocol to send us an email.

#### Cloudwatch Alarm

We can create a cloudwatch alarm from within the service that we are using. In this case, we can create from the status checks tab of our EC2 instance. After creating the alarm, we can use the `stress --cpu 1` command again on the EC2 instance that we attached the alarm to.

## Deploy to Elastic Beanstalk using RDS

Elastic Beanstalk allows us to easily deploy applications and run them seamlessly. It does so by orchestrating different AWS services such as EC2, autoscaling, s3, SNS, load balancing, etc. EBS makes it easy to deploy applications written in any programming language. In this project, we will be using RDS to deploy on EBS. RDS will also host our MySQL database.

RDS allows us to use any relational database such as MySQL, Postgres, MariaDB, etc. RDS provides us with options for replication, auto backup, auto recovery and caching.

We created a database instance under RDS using the standard create option. We select the MySQL engine and make sure that connectivity is set to public to be able to connect to it using MySQL workbench locally. We also need to make sure that the security group allows inbound rules for port 3306.

#### Deploying the Coupon Service

To deploy the coupon service to EBS, we need to define the database endpoint in our application.properties. We also changed the server port to 5000 since by default EBS exposes port 5000.

```
spring.datasource.url=jdbc:mysql://productcouponservice2.cfwvppbgxide.ap-southeast-1.rds.amazonaws.com:3306/mydb

server.port=5000
```

After doing a mvn clean and install, we can go to EBS and click on Create Application button. The platform will be Java, and we will use the default Corretto 11. We then proceed on manually uploading the JAR file from our local machine.

We can then access our app. We don't need to specify the port number anymore since EBS takes care of internally running at port 5000. We can now send requests to `http://couponservice-env.eba-vq3e6j4q.ap-southeast-1.elasticbeanstalk.com/couponapi/coupons` via postman.

#### Deploying the Product Service

For the Product Service, we do the same by updating the application.properties. It is important to note that even if the two services have the same port 5000, they will be running on different EC2 instances internally.

```
spring.datasource.url=jdbc:mysql://productcouponservice2.cfwvppbgxide.ap-southeast-1.rds.amazonaws.com:3306/mydb

server.port=5000
couponService.url=http://couponservice-env.eba-vq3e6j4q.ap-southeast-1.elasticbeanstalk.com/couponapi/coupons/
```

We can then access via postman `http://productservice-env.eba-widbma8s.ap-southeast-1.elasticbeanstalk.com/productapi/products`

## Docker

Docker follows the OCI Open Container Initiative standard. Docker simplfies the deployment process by giving us images which contains all the infrastructure required for the application to work along with the application itself. These images will then be used to launch containers. Docker enables us to package once then deploy anywhere on any operating system that has Docker.

#### Docker Components

The **Registry** is where all the docker images are stored. The **Docker Host** is the machine where we install the docker engine. The **Docker Client** uses the ability to run commands such as docker pull against the docker engine.

#### Docker in Action

To install docker, we need to use `yum install docker` and then `service docker start` to start the daemon.

The command `docker run hello-world` will pull the hello-world image from dockerhub. With this command, the docker client contacts the docker daemon which we started earlier. The docker daemon will then pull the hello-world image from dockerhub and then create a new container from that image. The docker daemon then streams the output from the executable to our terminal.

We can run a container using the `docker run -i -d -t -p 80:80 --name=mycontainer nginx`. Of particular notice is the -p 80:80, which means to expose port 80 of the container on port 80 of the host machine (host:container). This means that port 80 of the container is accessible in port 80 of the host machine, in this case, our EC2 instance. After running the nginx container, we can try visiting our EC2 instance ipv4 DNS to see the nginx welcome page.

Docker commit allows us to save the current state of a container into an image. `docker commit <container-id> imageName`. However, it is much better to use a dockerfile to create images. In this example, we pulled the ubuntu image and executed it using

```
docker exec -it <id> bash
```

We then installed apache2

```
apt-get update
apt-get install apache2
```

And then finally we commit it

```
docker commit 798660049c49 mywebserver
```

When we do a `docker images`, we will find the new _mywebserver_ image.

#### Docker Layers and Overlay Storage

When we try doing `docker pull ubuntu` we will notice that the pull is separated into layers. The final image is the combination of these layers. We can see the layers by running `docker history ubuntu`

```
2b4cba85892a   9 days ago   /bin/sh -c #(nop)  CMD ["bash"]                 0B
<missing>      9 days ago   /bin/sh -c #(nop) ADD file:8a50ad78a668527e9???   72.8MB
```

The CMD and ADD are called as dockerfile commands. If we do `docker info`, we can find the property **Docker Root Dir** which points to the location where docker stores files. The _overlay2_ directory is the storage driver of docker. Inside this, it contains all the layers of the ubuntu image we pulled. Docker uses the Union File System to integrate the various layer to come up with the complete image.

#### Launching a MySQL Container

```
docker run -dit -p 6666:3306 --name=demiglace-mysql --env="MYSQL_ROOT_PASSWORD=t est1234" --env="MYSQL_DATABASE=emp" mysql
```

We will map port 3306 of the container to the host's 6666. We also pass in the password as an environment variable. The MYSQL*DATABASE environment variable will automatically create the \_emp* database upon startup

We can then enter the command line using `docker exec -it demiglace-mysql bash` and then access mysql using `mysql -uroot -p`

#### Volumes and Bind Mounts

When we store some data inside the container's writable layer and then stop the container, we will still have that data. But when we delete the container and relaunch a container form the same image, the data will no longer be there. Bind Mounts and Volumes helps us persist the data on the host machine instead of storing data directly on the container. **Bind Mount** will use any folder on the host machine to store the data. **Volume** on the other hand is a docker object and is managed by docker inside the folder /var/lib/docker/volumes.

Volumes are recommended way for persisting storage. To create a volume, we use `docker volume create name`. To mount the volume, we can do so while running a container `docker run -dit --mount source=myvol,destination=/tmp nginx`. The destination property is the folder on the container that will be mapped to the source volume. The volumes are stored under `/var/lib/docker/volumes/

To use bind mounts, we can run `docker run -dit -v /root/mydata:/tmp ubuntu`. The /tmp directory from the container will be bound to /root/mydata

#### Docker Networking

By default docker comes with bridge, host, none networks. We can assign our own subnets when we create our own network. `docker network create demonw --subnet=172.19.0.0/16`. We can now assign this network to a new container `docker run --name webserver --net demonw --ip 172.19.0.2 -h web.demiglace.com -p 82:80 -ti ubuntu /bin/bash`.

We can disconnect a container from a network using `docker network disconnect demonw webserver`. And to connect: `docker network connect demonw webserver`

#### Dockerfile

We can use Dockerfiles to create our own images. The Dockerfile contains commands to assemble an image.

- **FROM** is used for specifying a base image
- **COPY** can be used to copy files to a particular folder in the image
- **ENV** is used to set environment variables
- **RUN** will run a particular command during the image build process
- **CMD** will be executed after the image is built
- **EXPOSE** will expose out a particular port on the docker image

In this project, we use Centos as the base OS, and we install httpd on top of it. We add a index.html file and expose out port 80.

```Dockerfile
FROM centos
RUN yum install -y httpd
ADD index.html /var/www/html
CMD apachectl -D FOREGROUND
EXPOSE 80
MAINTAINER demiglace
ENV myenv myval
```

We can then build the image using the following command `docker build -t my-webserver .`. The docker daemon will then execute the instructions one at a time.

## Dockerize Micro Services

We first containerize the database server using mysql. We do so by running a docker container for mysql. We expose the port 3306 port of the docker host to our local host through port 6666.

```
docker run -d -p 6666:3306 --name=docker-mysql --env="MYSQL_ROOT_PASSWORD=test1234" --env="MYSQL_DATABASE=mydb" mysql
docker exec -it docker-mysql bash
```

This brings us to the bash shell of the container. From there we enter mysql and then create the tables.

```
# mysql -uroot -p
test1234
mysql> show databases;
```

We can set up the tables using a separate command line. This will run the tables.sql file on the same directory as the command line. We can also do this by using MySQL workbench and connecting to port 6666.

```
docker exec -i docker-mysql mysql -uroot -ptest1234 mydb<tables.sql
```

```sql
use mydb;

create table product(
id int AUTO_INCREMENT PRIMARY KEY,
name varchar(20),
description varchar(100),
price decimal(8,3)
);

create table coupon(
id int AUTO_INCREMENT PRIMARY KEY,
code varchar(20) UNIQUE,
discount decimal(8,3),
exp_date varchar(100)
);
```

To dockerize the coupon and product service, we make use of a Dockerfile. Using **FROM** we use java:8 as the base, and then afterwards the **ADD** is where we copy the Springboot jar file into the container (using the same name). Finally, we specify the launch parameters to the **ENTRYPOINT**.

```dockerfile
FROM java:8
ADD target/couponservice-0.0.1-SNAPSHOT.jar couponservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java","-jar","couponservice-0.0.1-SNAPSHOT.jar" ]
```

#### Build Images

Before building the images, we first need to update our application.properties to point out to the new data source url. In this case, the coupon service container will be named as coupon-app.

```
// coupon service
spring.datasource.url=jdbc:mysql://docker-mysql:3306/mydb
spring.datasource.username=root
spring.datasource.password=test1234

server.port=9091

// product service
spring.datasource.url=jdbc:mysql://docker-mysql:3306/mydb
spring.datasource.username=root
spring.datasource.password=test1234

server.port=9090
couponService.url=http://coupon-app:9091/couponapi/coupons/
```

We will be using the command line for generating a jar, since the services would fail the tests from the above chagnes.

```
mvn clean package -DskipTests
```

And to finally build the images,

```
docker build -f Dockerfile -t coupon_app .
docker build -f Dockerfile -t product_app .
```

#### Launch the Containers

We can use the command line to launch the microservice containers. We need to use the `--link` flag to link the microservice with the mysqk container created earlier. We will expose port 9091 of the container to the local machine's port 10555. For the product service, we need to link both mysql and coupon service.

```
docker run -t --name=coupon-app --link docker-mysql:mysql -p 10555:9091 coupon_app
docker run -t --link docker-mysql:mysql --link coupon-app:coupon_app -p
10666:9090 product_app
```

The urls for testing will be

```
http://localhost:10555/couponapi
http://localhost:10666/productapi
```

#### Docker Hub

To push to docker hub, we run the following command

```
docker login

docker tag product_app demiglace0505/productservice
docker tag coupon_app demiglace0505/couponservice

docker push demiglace0505/couponservice
docker push demiglace0505/productservice
```

## Docker Compose

Docker Compose is a tool using which we can run one or more containers required for our microservice applications. With Docker Compose there is no need to write scripts to start our containers. Using a single YAML configuration file, each containers will be defined as services and we can launch all components using the `docker-compose up` command.

The **version** can be used to introduce or deperecate elements. **services** is used to define the group of services. Under that we can define a container. In the following example, the image will be based on httpd and we will give it a container name of mywebserver. Port 80 will be exposed out on port 8080.

```yaml
version: "3.3"
services:
  web:
    image: httpd
    container_name: mywebserver
    ports:
      - "8080:80"
```

The above configuration is comparable to `docker run -dit --name mywebserver -p 8080:80 httpd`. To verify that the above configuration is valid, we can run `docker-compose config` at the directory of the docker-compose.yaml file. `docker-compose up -d` can be used to launch the container in a detached state.

#### Networks

When we run docker-compose up, it creates a default network and attaches it to our containers. The default network has the naming convention of `directoryName_default`. We can also define and provide our own networks that will be created. The root level _networks_ is used to define all the networks, and the _networks_ element under a service is for using the network. Once we use `docker-compose up`, it will create and use the network `dockercomposedemo_webnetwork`.

```yaml
version: "3.3"
services:
  web:
    image: httpd
    container_name: mywebserver
    networks:
      - webnetwork
    ports:
      - "8080:80"
networks:
  webnetwork:
    driver: bridge
  dbnetwork:
    driver: bridge
```

#### Volumes

We can mount volume by specifiying the **volumes** element. The volume myvol in this case will be mounted to the `/data` directory.

```yaml
version: "3.3"
services:
  web:
    image: httpd
    container_name: mywebserver
    ports:
      - "8080:80"
    volumes:
      - myvol:/data
volumes:
  myvol:
```

#### Composing the MySQL Service

In the following docker-compose configuration, we launch a container called docker-mysql using the mysql image. We specify the environment variables for the database name and root password. Along this, we defomethe root host, which means tells the mysql server inside the container which machines can access the mysql server inside the container. The `%` is a wildcard. We automate creation of the tables using the **volumes** element. We mount the `./sql` folder inside couponservice into `/docker-entrypoint-initdb.d`. This will make the container search for sql files inside the sql folder and execute them. We then expose out port 3306 into 6666.

```yaml
version: "3"
services:
  docker-mysql:
    container_name: docker-mysql
    image: mysql
    restart: always
    environment:
      MYSQL_DATABASE: mydb
      MYSQL_ROOT_PASSWORD: test
      MYSQL_ROOT_HOST: "%"
    volumes:
      - ./sql:/docker-entrypoint-initdb.d
    ports:
      - "6666:3306"
    healthcheck:
      test: '/usr/bin/mysql --user=root --password=test1234 --execute "SHOW DATABASES"'
      interval: 4s
      timeout: 20s
      retries: 5
```

#### Composing MicroServices

The WAIT_HOSTS element in the environment will keep checking if mysql is running on port 3306. We also need to provide the container dependencies.

```yaml
version: "3"
services:
  product-app:
    container_name: product-app
    image: demiglace0505/productservice
    restart: on-failure
    ports:
      - 10666:9090
    environment:
      WAIT_HOSTS: mysql:3306
    depends_on:
      - docker-mysql
      - coupon-app

  coupon-app:
    container_name: coupon-app
    image: demiglace0505/couponservice
    restart: on-failure
    ports:
      - 10555:9091
    environment:
      WAIT_HOSTS: mysql:3306
    depends_on:
      - docker-mysql

  docker-mysql:
    container_name: docker-mysql
    image: mysql
    restart: always
    environment:
      MYSQL_DATABASE: mydb
      MYSQL_ROOT_PASSWORD: test1234
      MYSQL_ROOT_HOST: "%"
    volumes:
      - ./sql:/docker-entrypoint-initdb.d
    ports:
      - 6666:3306
    healthcheck:
      test: '/usr/bin/mysql --user=root --password=test1234 --execute "SHOW DATABASES"'
      interval: 4s
      timeout: 20s
      retries: 5
```

We then run `docker-compose up` to compose the containers.

## Kubernetes

Microservice applications that are containerized needs to be fault-tolerant and should be able to scale on-demand. With Container Orchestration, all our containers are grouped into a cluster wherein the deployment and management is automated. Kubernetes makes CICD easy while taking care of the lifecycle of the containers.

Kubernetes uses an object model to represent different persistence entities. We create these objects using a spec yaml. The **Pod** is a logical group of similar contianers. Pods however are not self-healing or fault tolerant on their own. For that, we need **ReplicaSets** which will make sure that the desired number of pods is always running. Instead of managing pods and replicas separately, we can create **Deployments**. The **Namespace** will help us host applications from across the organization by creating virtual clusters. It is similar to packages in Java.

#### Kubernetes Architecture

All the machines inside a kubernetes cluster are referred to as nodes. The master node is the one that manages the entire cluster. The worker nodes are responsible for launching pods, creating containers, etc. We interact with the master node through a RESTful API which we interact with using **kubectl**. The **Scheduler** is responsible for scheduling the pods on the worker nodes. It is responsible for launching the pods inside worker nodes as required by the application. The **Control Manager** runs in the background and is responsible for making sure that the cluster is in the desired state. The **Api Server** maintains the current state of the cluster in a distributed storage service called etcd, which is a name-value storage which stores object information such as pods, etc. When we have multiple master nodes, the etcd will be stored in all master nodes. In the worker node, a **kubelet** have apis which the Api Server calls for communication with the master node. We never interact directly with the kubelet, but only through the Api Server. The **Proxy** is the load balancer and network proxy. There is a proxy for each and every worker node

#### Kubernetes Installation Types

In a **Single Node Installation**, all the master components and worker components live in a single node/machine. It is good for development and quick testing, but not for prod. Minikube and Docker Desktop gives us a single node cluster. In a **Single Master and Multi Worker**, we have one master running on its own node and multiple workers which has its own node. In **Multi Master and Multi Worker**, we have a highly available cluster with multiple masters. The etcd will only be on a single master in this type. We can also replicate the etcd into multiple masters as well. This is called **Multi etcd**

#### Kubectl Configuration

The kubectl command can be used to connect to a kubernetes cluster and work with the resources in that cluster. All the connection information is stored in a configuration file which we can view using `kubectl config view`. The important pieces in a config file are clusters, users, and context.

#### Pod

The pod is the smallest and most important object in kubernetes. A pod is an abstraction that logically groups a set of related containers. The pods will have the resources that will be needed by the containers to work such as networking, security, configuration, volumes etc. Although a pod is defined as a group of containers, it is a good practice to use only one container per pod.

There are two ways to create a pod: using kubectl and through a YAML file. However, in real time we will be creating pods using Deployments to make it easier to create multiple number of pods/replicas and maintain cluster state. Pods are exposed to other pods through Services.

We can create an nginx pod using the following kubectl command.

```
minikube start
kubectl run firstpod --image=nginx

kubectl describe pod firstpod
```

The above pod has the following events. The default scheduler assigns firstpod to our minikube node. Afterwards the kubelet on the minikube worker node pulls the image from docker hob then create and start the container.

```
  Type    Reason     Age   From               Message
  ----    ------     ----  ----               -------
  Normal  Scheduled  63s   default-scheduler  Successfully assigned default/firstpod to minikube
  Normal  Pulling    63s   kubelet            Pulling image "nginx"
  Normal  Pulled     36s   kubelet            Successfully pulled image "nginx" in 27.1696947s
  Normal  Created    36s   kubelet            Created container firstpod
  Normal  Started    36s   kubelet            Started container firstpod
```

To enter the pod's bash shell, we can use the command `kubectl exec -it firstpod -- /bin/bash`. We can view more details about the pod using `kubectl get pod firstpod -o yaml`

The recommended approach for creating a pod is through a YAML file. The very first line of any kubernetes configuration file is **kind** wherein we define the type of resource. Under **metadata**, we provide data about the resource. **spec** is the body of the resource, wherein we define how the resource should be created.

```yaml
kind: Pod
apiVersion: v1
metadata:
  name: firstpod
spec:
  containers:
    - name: db
      image: redis
    - name: web
      image: httpd
```

To create a pod using the yaml file, we can use `kubectl create -f firstpod.yaml`. Once we run the command, we can check using `kubectl describe pods` the status of this pod

```
  Type    Reason     Age   From               Message
  ----    ------     ----  ----               -------
  Normal  Scheduled  36s   default-scheduler  Successfully assigned default/firstpod to minikube
  Normal  Pulling    36s   kubelet            Pulling image "redis"
  Normal  Pulled     23s   kubelet            Successfully pulled image "redis" in 12.258865s
  Normal  Created    23s   kubelet            Created container db
  Normal  Started    23s   kubelet            Started container db
  Normal  Pulling    23s   kubelet            Pulling image "httpd"
  Normal  Pulled     9s    kubelet            Successfully pulled image "httpd" in 14.5372012s
  Normal  Created    8s    kubelet            Created container web
  Normal  Started    8s    kubelet            Started container web
```

To go inside a particular container in the pod, we use `kubectl exec -it firstpod --container db -- /bin/bash`

#### Pod Life Cycle

The first phase of the pod is **Pending**. This is where the pod is just created, the api server on the master node will validate that the pod configuration is ok and will create an entry in the etcd. The **Running** phase is where all the pods containers have been created and is scheduled on one of the worker nodes. **Succeeded** is where all the containers have successfully executed without any errors. **Failed** means that some containers in a pod have exited. **Unknown** is when the pod status cannot be obtained by the master node's api server.

#### Labels and Selectors

Labels are key-value pairs that we can assign to any resource in a kubernetes cluster to logically group and query resources. We can easily filter through pods using selectors. Labels are defined in the **metadata** section of our yaml file.

```yaml
metadata:
  name: firstpod
  labels:
    app: fp
    release: stable
    team: doge
```

We filter through the labels using `kubectl get all --selector='app=fp'`. In this case, only those with the label app: fp will be returned.

Annotations on the other hand are key-value pairs but not used to query for resources. They are just arbitrary data provided and can be used by other tools as required. Annotations are also defined under **metadata**

```yaml
annotations:
  logsDir: "/etc/logs"
```

#### Namespaces

Namespace is a logical division of a kubernetes cluster for each team or application that is deployed. Each namespace will be allocated a resource quota such as cpu, storage or even limits on the number of kubernetes of objects that can be created. This way, applications are isolated from each other. By default, pods created go into the **default** namespace. To create our own namespace, we use the command `kubectl create ns firstns`. Afterwards, we can specify in which namespace we can create a pod `kubectl create -f firstpod.yaml --namespace firstns`. To check that the pod got created in the correct namespace: we run `kubectl get pods --namespace firstns`

#### Deployment

A Deployment helps us manage pods and we can have multiple replicas of a pod through a deployment. Through deployments, we can tell how many pods we want and kubernetes will automatically create those replicas to maintian the desired state. We can create a deployment through the kubernetes dashboard or by a YAML file. On the other hand, there are three ways to accessing clusters: web dashboard, CLI, and REST api. Using minikube, we can launch the dashboard using the `minikube dashboard` command.

We proceed with creating our own deployment yaml. We assign the deployment with labels for `app: httpd`. Under spec, we specify our replicationset. We make sure to use **selectors** that match with the pod spec. The **template** section is where we specify our pod details. The **spec** section of the template is for our containers. In here, we expose out port 80 of the container. We then create the deployment using `kubectl create -f webserver.yml`

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: mywebserver
  labels:
    app: httpd
spec:
  replicas: 2
  selector:
    matchLabels:
      app: httpd
  template:
    metadata:
      labels:
        app: httpd
    spec:
      containers:
        - name: myhttpd
          image: httpd
          ports:
            - containerPort: 80
```

#### Service

For the pods to communicate with each other, we need to use the **Service** object. It logically groups a set of pods that need to access each other so that they can communicate with each other.

The **ClusterIP** service type decouples the pods and generates a virtual IP address and all communicate will happen through that virtual IP address. ClusterIP also acts as a load balancer. However, only pods within the same cluster can communicate with each other. **NodePort** service on the other hand, creates a ClusterIP internally but also exposes a port from 30000-32767 so that client applications outside the cluster will be abel to communicate with nodes in the cluster. **LoadBalancer** service type is where we expose the service using cloud providers. The NodePort and ClusterIP will be automatically created internally.

In the following yaml configuration, we use a service type NodePort since we will be exposing out the pods outside the cluster. For the **selector**, we need to use whatever label we used on the pod, in this case, _httpd_. In the **ports** section, the port is labeled as 80 which means that the port 80 of the pod will be exposed and we can access the service from that port. The targetport is the port wherein we redirect traffic. We create the service using `kubectl create -f webserver-svc.yml`

```yaml
apiVersion: v1
kind: Service
metadata:
  name: webserver-service
spec:
  type: NodePort
  selector:
    app: httpd
  ports:
    - nodePort: 30123
      port: 80
      targetPort: 80
```

Running kubectl get services, we can see the following. The service internally is mapped to port 80 and 30123 is used for outside the cluster. To access port 30123 and the cluster ip, we can use `minikube service swebserver-service`

```
NAME                TYPE        CLUSTER-IP     EXTERNAL-IP   PORT(S)        AGE
webserver-service   NodePort    10.101.0.102   <none>        80:30123/TCP   27s
```

#### Rolling Updates

Deployments also allow us to update applications in a cluster with zero downtime seamlessly. The first update strategy is **Recreate**. This is where kubernetes destroys the pods and then recreates them. This doesn't provide zero downtime, but may be useful in cases where our microservices cannot have multiple versions running at the same time. **Rolling Update** is where there is zero downtime. New pods will be created, but older pods will not be taken down. Once the cluster is in the desired state, it will start destroying the older pods.

Using maxSurge, we define how many pods can immediately be created as soon as an update is pushed. maxUnavailable defines how many old pods can be killed.

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: mywebserver
  labels:
    app: httpd
spec:
  replicas: 10
  strategy:
    type: RollingUpdate
    rollingUpdate:
      maxSurge: 3
      maxUnavailable: 4
  selector:
    matchLabels:
      app: httpd
  template:
    metadata:
      labels:
        app: httpd
    spec:
      containers:
        - name: myhttpd
          image: httpd
          ports:
            - containerPort: 80
```

We first create the deployment with `kubectl -create -f webserver.yml`. Then afterwards, we modified the yml file to use httpd version 2 to trigger an update. We then run `kubectl replace -f webserver.yml` to replace the cluster with the new changes.

```yml
containers:
  - name: myhttpd
    image: httpd:2
    ports:
      - containerPort: 80
```

Kubernetes internally maintains the versions of every deployment we make. Using the command `kubectl rollout history deployment`, we can see two versions of deployments. We can also see the changes made in a certain revision using `kubectl rollout history deployment mywebserver --revision=2`

```
deployment.apps/mywebserver
REVISION  CHANGE-CAUSE
1         <none>
2         <none>
```

To undo a deployment, we can use `kubectl rollout undo deployment mywebserver --to-revision=1`

#### Volumes

Volumes in kubernetes are usually directly connected to the pod. Each container gets some space from the pod and is mounted to a folder in the container. The other containers in the pod can also exchange data with any container on the pod. Containers can also exchange data with the pod's volume.

To mount a volume, we first define the volume in a pod level, and mount it in a container level.

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: mywebserver
  labels:
    app: httpd
spec:
  replicas: 10
  strategy:
    type: RollingUpdate
    rollingUpdate:
      maxSurge: 3
      maxUnavailable: 4
  selector:
    matchLabels:
      app: httpd
  template:
    metadata:
      labels:
        app: httpd
    spec:
      containers:
        - name: myhttpd
          image: httpd:2
          ports:
            - containerPort: 80
          volumeMounts:
            - mountPath: /data
              name: demovol
      volumes:
        - name: demovol
          hostPath:
            path: /data
            type: Directory
```

#### ConfigMaps

ConfigMaps lets us store configuration for other objects to use. It doesn't have a spec, but has _data_ instead.

```yml
apiVersion: v1
kind: ConfigMap
metadata:
  name: demo-configmap
data:
  initdb.sql: select * from product;
    create table coupon();
  keys: 12312312312
    sdadasdasdasd
```

To use this in our deployment, we need to define the configmap under volumes and volumeMounts.

```yml
spec:
  containers:
    - name: myhttpd
      image: httpd:2
      ports:
        - containerPort: 80
      volumeMounts:
        - mountPath: /data
          name: demovol
        - mountPath: /etc/config
          name: demo-configmap-vol
  volumes:
    - name: demovol
      hostPath:
        path: /data
        type: Directory
    - name: demo-configmap-vol
      configMap:
        name: demo-configmap
```

We should be able to see initdb.sql and keys file under the directory /etc/config of our pod.

```
kubectl exec -it mywebserver-95cb4dd94-598pq -- bash
cd /etc/config
ls
```

#### Secrets

Secrets are similar to ConfigMaps, with the difference that Secrets store sensitive information. Kubernetes stores these information in tmpf. The secret will only be available on a node when a pod requests for it. Once the pod is done using the secret, kubernetes will delete the secret from the node. In here, we specify the secret type as **Opaque** which stands for arbitrary data. Values are commonly encoded in b64.

```yml
apiVersion: v1
kind: Secret
metadata:
  name: demo-secret
type: Opaque
data:
  userName: ZG9nZQ==
  password: ZG9nZTEyMw==
```

To use in our webserver deployment, we specify it in volumes and volumeMounts

```yml
spec:
  containers:
    - name: myhttpd
      image: httpd:2
      ports:
        - containerPort: 80
      volumeMounts:
        - mountPath: /data
          name: demovol
        - mountPath: /etc/mysecrets
          name: my-secret
  volumes:
    - name: demovol
      hostPath:
        path: /data
        type: Directory
    - name: my-secret
      secret:
        secretName: demo-secret
```

#### Persistent Volumes

PersistentVolume is a volume that lives as long as the cluster lives, it is a storage that is allocated in the cluster. PersistentVolume is used if we want a storage for our pods and containers that lives beyond the lifecycle of the pod. The pod can request for space through the PersistentVolumeClaim. We start with creating the **PersistentVolume** wherein we define the size we need. In the **spec**, we provide a 128M capacity, accessModes wherein we provide read write access only for a single node.

```yaml
apiVersion: v1
kind: PersistentVolume
metadata:
  name: demo-persistent-volume
spec:
  capacity:
    storage: 128M
  accessModes:
    - ReadWriteOnce
  hostPath:
    path: /data/demo-persistent-volume
```

We then request space that pods needs through a **PersistentVolumeClaim**. Within the spec, we specify the amount of storage requested

```yaml
apiVersion: v1
kind: PersistentVolumeClaim
metadata:
  name: demo-pvc
spec:
  resources:
    requests:
      storage: 64M
  accessModes:
    - ReadWriteOnce
```

Afterwards, we mount the PVC to our container.

```yaml
spec:
  containers:
    - name: myhttpd
      image: httpd:2
      ports:
        - containerPort: 80
      volumeMounts:
        - mountPath: /data
          name: demovol
        - mountPath: /data/clustervol
          name: demo-pvc
  volumes:
    - name: demovol
      hostPath:
        path: /data
        type: Directory
    - name: demo-pvc
      persistentVolumeClaim:
        claimName: demo-pvc
```

Using `kubectl get pv` and `kubectl get pvc` we can verify that the volume has allocated

```
NAME                                       CAPACITY   ACCESS MODES   RECLAIM POLICY   STATUS      CLAIM              STORAGECLASS   REASON   AGE
demo-persistent-volume                     128M       RWO            Retain           Available                                              8m43s
pvc-4cc59a37-8ca1-4854-b9d0-f580719ee0e7   64M        RWO            Delete           Bound       default/demo-pvc   standard                4m41s

NAME       STATUS   VOLUME                                     CAPACITY   ACCESS MODES   STORAGECLASS   AGE
demo-pvc   Bound    pvc-4cc59a37-8ca1-4854-b9d0-f580719ee0e7   64M        RWO            standard       5m32s

```

Even if we run `kubectl delete all --all`, the persistent volume will still stay and will only get deleted if the cluster itself is deleted.

## Deploying Microservices to Kubernetes

We start with deployment of the mysql DB. We will be defining a container that uses the MySQL image. We will be mounting the volume so that an initial database can be created for us. Instead of directly mounting a volume, we will be using configmaps. Afterwards, we will create the mysql service wherein we define the internal port, target port, and nodePort. Afterwards, we proceed with the product and coupon service deployment. We also create a Service of type nodePort to expose the services as well.

The applications on the cluster would communicate with each other, it is important that our kubernetes service names matches those from our application.properties. In this case, we will be using the following configurations. Hence, the names of the services would be product-app, coupon-app, docker-mysql.

```properties
# coupon service
spring.datasource.url=jdbc:mysql://docker-mysql:3306/mydb
spring.datasource.username=root
spring.datasource.password=test1234

server.port=9091


# product service
spring.datasource.url=jdbc:mysql://docker-mysql:3306/mydb
spring.datasource.username=root
spring.datasource.password=test1234

server.port=9090
couponService.url=http://coupon-app:9091/couponapi/coupons/

```

We start with creating the Deployment of the database. The **%** value for _MYSQL_ROOT_HOST_ means that this can be accessed from any IP address.

```yml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: docker-mysql
  labels:
    app: docker-mysql
spec:
  # REPLICAS SECTION
  replicas: 1
  selector:
    matchLabels:
      app: docker-mysql
  # POD TEMPLATE
  template:
    metadata:
      labels:
        app: docker-mysql
    # POD SPECS
    spec:
      containers:
        - name: docker-mysql
          image: mysql
          env:
            - name: MYSQL_DATABASE
              value: mydb
            - name: MYSQL_ROOT_PASSWORD
              value: test1234
            - name: MYSQL_ROOT_HOST
              value: "%"
```

We will also create a configmap to initialize our database schema. With this, a file with the name `initdb.sql` will be created with the content as the value of the key.

```yml
apiVersion: v1
kind: ConfigMap
metadata:
  name: mysql-initdb-config
data:
  initdb.sql: use mydb;

    create table product(
    id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(20),
    description varchar(100),
    price decimal(8,3)
    );

    create table coupon(
    id int AUTO_INCREMENT PRIMARY KEY,
    code varchar(20) UNIQUE,
    discount decimal(8,3),
    exp_date varchar(100)
    );
```

Afterwards, we need to mount the configmap as a volume in our db-mysql deployment. We define it and the volumeMounts under the spec section. We want the configmap to be mounted under `/docker-entrypoint-initdb.d`. This way the SQL files under that folder will be executed.

```yml
# POD SPECS
spec:
  volumes:
    - name: mysql-initdb-vol
      configMap:
        name: mysql-initdb-config
  containers:
    - name: docker-mysql
      image: mysql
      env:
        - name: MYSQL_DATABASE
          value: mydb
        - name: MYSQL_ROOT_PASSWORD
          value: test1234
        - name: MYSQL_ROOT_HOST
          value: "%"
      volumeMounts:
        - name: mysql-initdb-vol
          mountPath: /docker-entrypoint-initdb.d
```

Finally, we create the DB service to expose out the mysql server outside the cluster. This will enable us to access the service using our local mysql workbench. The **selector** means that whichever pods matches the label _docker-mysql_ will be picked up by this service. We use NodePort since we want this to be exposed outside the cluster as well. Port 3306 will be used internally in the cluster and will be bound to the targetPort 3306 of the container. In other words, traffic to the **port** will be redirected to the **targetPort**. **nodePort** is where we want to receive external traffic.

```yml
apiVersion: v1
kind: Service
metadata:
  name: docker-mysql
  labels:
    app: docker-mysql
spec:
  selector:
    app: docker-mysql
  type: NodePort
  ports:
    - port: 3306
      targetPort: 3306
      nodePort: 30287
```

To deploy the db deployment, configmap and service at one go, we can use the following command

```
kubectl create -f docker-mysql-configmap.yml,docker-mysql-deployment.yml,docker-mysql-service.yml

kubectl get service
NAME           TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)          AGE
docker-mysql   NodePort    10.100.72.193   <none>        3306:30287/TCP   34s

kubectl get pods
NAME                            READY   STATUS              RESTARTS   AGE
docker-mysql-548449c8c9-5hr7b   0/1     ContainerCreating   0          28s

kubectl get service
NAME           TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)          AGE
docker-mysql   NodePort    10.100.72.193   <none>        3306:30287/TCP   21s

kubectl get configmaps
NAME                  DATA   AGE
mysql-initdb-config   1      24s

minikube ip
192.168.49.2
```

We can access the database from SQL workbench using ip address 192.168.49.2 and port number 30287.

Next is creating the Coupon and Product yamls. The coupon service will be exposed in port 9091

```yml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: coupon-app
  labels:
    app: coupon-app
spec:
  replicas: 1
  selector:
    matchLabels:
      app: coupon-app
  # POD BODY
  template:
    metadata:
      name: coupon-app
      labels:
        app: coupon-app
    # POD SPECS
    spec:
      containers:
        - name: coupon-app
          image: demiglace0505/couponservice
```

```yml
apiVersion: v1
kind: Service
metadata:
  name: coupon-app
  labels:
    app: coupon-app
spec:
  type: NodePort
  selector:
    app: coupon-app
  ports:
    - port: 9091
      targetPort: 9091
      nodePort: 30288
```

```yml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: product-app
  labels:
    app: product-app
spec:
  replicas: 1
  selector:
    matchLabels:
      app: product-app
  # POD BODY
  template:
    metadata:
      name: product-app
      labels:
        app: product-app
    # POD SPECS
    spec:
      containers:
        - name: coupon-app
          image: demiglace0505/productservice
```

```yml
apiVersion: v1
kind: Service
metadata:
  name: product-app
  labels:
    app: product-app
spec:
  type: NodePort
  selector:
    app: product-app
  ports:
    - port: 9090
      targetPort: 9090
      nodePort: 30289
```

To deploy the microservices, we can run `kubectl create -f coupon-service-deployment.yml,coupon-service-svc.yml,product-service-deployment.yml,product-service-svc.yml`. And to access, we can do it via postman by referring to the ports that we configured.

```
kubectl get services
NAME           TYPE        CLUSTER-IP       EXTERNAL-IP   PORT(S)          AGE
coupon-app     NodePort    10.109.118.96    <none>        9091:30288/TCP   8m22s
docker-mysql   NodePort    10.110.151.102   <none>        3306:30287/TCP   45m
kubernetes     ClusterIP   10.96.0.1        <none>        443/TCP          46m
product-app    NodePort    10.96.128.147    <none>        9090:30289/TCP   7m53s

minikube ip
inikube ip
192.168.49.2
```

In this case, we can access the coupon service at `http://192.168.49.2:30288/couponapi/coupons`

## Eclipse Jkube

We can deploy our Spring Boot or Java application to a kubernetes cluster without writing code using the Jkube plugin. There are various helpful maven commands that can be used as well. `mvn k8s:build` will create a docker image on the fly. `mvn k8s:resource` will generate the kubernetes yaml files that are required to deploy our application, its pods and create the services unto the kubernetes cluster. `mvn k8s:apply` will apply the generated yaml files. `mvn k8s:log` will tail the logs into our terminal. `mvn k8s:debug` allows us to debug from within the IDE.

We start by creating a SpringBoot RESTful endpoint project. This project uses Spring Web as a dependency.

```java
@RestController
public class JKubeController {

	@GetMapping("/hello")
	public String hello() {
		return "JKube is cool";
	}
}
```

In the pom.xml, we add the JKube plugin.

```xml
<plugin>
	<groupId>org.eclipse.jkube</groupId>
	<artifactId>kubernetes-maven-plugin</artifactId>
	<version>1.0.0-rc-1</version>
</plugin>
```

We then build the docker image using `mvn k8s:build`. To deploy to kubernetes, we first need to start minikube using `minikube start`. We then connect to minikube's docker daemon using `eval $(minikube -p minikube docker -env)`. When we execute commands for JKube, it will automatically use the daemon from minikube (unix only). The command `mvn k8s:resource` will generate the kubernetes resources for our spring boot project. The files will be under `/target/classes/META-INF/jkube/kubernetes`. To deploy, we can use `mvn k8s:apply` which will apply the generated resources to the minikube kubernetes cluster.

We can easily change the service type from clusterIP to NodePort. We can do this by adding the following to the properties section in our pom.xml

```xml
	<properties>
		<jkube.enricher.jkube-service.type>NodePort</jkube.enricher.jkube-service.type>
	</properties>
```

We can undeploy our cluster using `mvn k8s:undeploy`. We can debug applications that are running in our kubernetes cluster through the ide using `mvn k8s:debug` which will start the application in debug mode. It enables port forwarding to port 5005. IN Eclipse, we can launch a remote debugger by going to the debugger, debug configurations -> remote java application -> create new with port 5005.

## Docker Swarm

Docker Swarm is an orchestration tool that comes with Docker. It takes our containers as services and deploys them as a cluster (swarm). It offers autoscaling, fault tolerance, rolling updates, auto discovery, load balancing. Compared to Kubernetes, Docker Swarm is different in how it works, setup, architecture components.

We can create a docker swarm using the command `docker swarm init`. This makes the current node as the manager of the docker swarm cluster. Afterwards, it will generate TLS certificates and tokens wherein other worker and manager nodes can join the swarm. The **Manager Nodes** are responsible for getting the containers deployed to the cluster. There can only be one manager that leads the swarm at a time, and if it goes down, another manager will take its place. **Worker Nodes** are responsible launching the containers and doing the work. Docker Swarm uses the raft database to store its cluster state whereas Kubernetes uses etcd.

Docker Swarm abstracts services and tasks. **Service** is a combination of a docker image, number of replicas. A service results into one or more tasks which will create the container on various worker nodes for us. Services are the central structure of a Docker Swarm whereas in Kubernetes services are for exposing pods. A **Task** is a running container and a part of a service.

#### Architecture

The Manager Node consists of the following architectural components. The **API** is an architectural component that receives all of our docker service commands. It will use the **Orchestrator** which will create the service and maintain that the cluster is in the desired state. The **Allocator** assigns IP addresses to the tasks created by the Orchestrator. Once IP addresses are assigned, the **Dispatcher** will take them and allocate the tasks to the appropriate nodes in the cluster. **Schedulae** makes sure that the tasks are being executed correctly on the worker nodes.

For the Worker Node, we have the **Worker** which checks the dispatcher for any work to be done. The **Executor** will be responsible for executing the work on the worker. The end result would be a container.

The Manager Node uses the RAFT data store to store the complete state of the cluster.

#### Setting up Swarm

The first step is to create 5 EC2 instances wherein there will be two manager and three worker nodes. For each instance, we install docker with `yum install docker -y`. To setup swarm, we first startup docker on a manger node using `service docker start` and then `docker swarm init`. This makes the current instance a manager node with a unique node id in the cluster.

```
Swarm initialized: current node (i77mtl78vigixmdnosxj2ieri) is now a manager.

To add a worker to this swarm, run the following command:

    docker swarm join --token SWMTKN-1-2pn0ri0g8j249bnrvb1s2zi04yphzr82b2flvz5fotpusn7wd0-2lspsj16icwa30lk2elb1del4 172.31.16.165:2377

To add a manager to this swarm, run 'docker swarm join-token manager' and follow the instructions.
```

We then need to enable All ICMP IPV4 traffic from anywhere and port 2377 from anywhere of the manager node in our manager1 security group. We can then run the above command to our worker instances. The command `docker node ls` will list out the nodes in the cluster.

```
ID                            HOSTNAME                                           STATUS    AVAILABILITY   MANAGER STATUS   ENGINE VERSION
i77mtl78vigixmdnosxj2ieri *   ip-172-31-16-165.ap-southeast-1.compute.internal   Ready     Active         Leader           20.10.7
2ar2it73ifvi2ytsgdpouqi99     ip-172-31-19-254.ap-southeast-1.compute.internal   Ready     Active                          20.10.7
jye5cj7vp416b4nfah2awyorv     ip-172-31-26-110.ap-southeast-1.compute.internal   Ready     Active                          20.10.7
u4h074o709h7xj2lhx8l8quv0     ip-172-31-27-251.ap-southeast-1.compute.internal   Ready     Active                          20.10.7
```

To add a manager to the swarm, we simply need to run `docker swarm join-token manager`. We can then run the returned command on another instance.

```
To add a manager to this swarm, run the following command:

    docker swarm join --token SWMTKN-1-2pn0ri0g8j249bnrvb1s2zi04yphzr82b2flvz5fotpusn7wd0-1cd84z5uktxwrneeir8qc393p 172.31.16.165:2377
```

#### Creating Service

To create a service, we can use the following command

```
docker service create --name my-server nginx
```

We can verify that the service got created

```
docker service ls
ID             NAME        MODE         REPLICAS   IMAGE          PORTS
dzohsuytcdwa   my-server   replicated   1/1        nginx:latest
```

And also we can list out the processes running from that service wherein we can find on which node it is running. We can see that it is currently being run on the ip address of one of our worker nodes.

```
docker service ps dzohsuytcdwa
ID             NAME          IMAGE          NODE                                               DESIRED STATE   CURRENT STATE            ERROR     PORTS
l3gc22f4dgxz   my-server.1   nginx:latest   ip-172-31-27-251.ap-southeast-1.compute.internal   Running         Running 36 seconds ago
```

If we run `docker ps` and `docker images` on the instance with ip address 172-31-27-251, we will see that the container is running.

```
docker ps
CONTAINER ID   IMAGE          COMMAND                  CREATED         STATUS         PORTS     NAMES
20ba7ccdedd2   nginx:latest   "/docker-entrypoint.???"   4 minutes ago   Up 4 minutes   80/tcp    my-server.1.l3gc22f4dgxz1wib1707zxet4

docker images
REPOSITORY   TAG       IMAGE ID       CREATED      SIZE
nginx        <none>    f2f70adc5d89   2 days ago   142MB
```

To delete the service, we can run the following command in our manager node leader `docker service rm my-server`

#### Multiple Replicas and Scaling

We can specify the number of replicas we want `docker service create --name my-server -p 80:80 --replicas=3 nginx`. We then verify that they have converged

```
docker service ls
ID             NAME        MODE         REPLICAS   IMAGE          PORTS
zok9buak0r84   my-server   replicated   3/3        nginx:latest   *:80->80/tcp

docker service ps zok9buak0r84
ID             NAME          IMAGE          NODE                                               DESIRED STATE   CURRENT STATE            ERROR     PORTS
y2kjvdommwev   my-server.1   nginx:latest   ip-172-31-26-110.ap-southeast-1.compute.internal   Running         Running 29 seconds ago
w6xli3g9uw17   my-server.2   nginx:latest   ip-172-31-16-165.ap-southeast-1.compute.internal   Running         Running 28 seconds ago
b8szecbrk7df   my-server.3   nginx:latest   ip-172-31-27-251.ap-southeast-1.compute.internal   Running         Running 29 seconds ago
```

Using `docker service scale my-server=5` we can scale to 5 instances.

```
docker service ps zok9buak0r84
ID             NAME          IMAGE          NODE                                               DESIRED STATE   CURRENT STATE            ERROR     PORTS
y2kjvdommwev   my-server.1   nginx:latest   ip-172-31-26-110.ap-southeast-1.compute.internal   Running         Running 2 minutes ago
w6xli3g9uw17   my-server.2   nginx:latest   ip-172-31-16-165.ap-southeast-1.compute.internal   Running         Running 2 minutes ago
b8szecbrk7df   my-server.3   nginx:latest   ip-172-31-27-251.ap-southeast-1.compute.internal   Running         Running 2 minutes ago
5frhj2uix38d   my-server.4   nginx:latest   ip-172-31-21-138.ap-southeast-1.compute.internal   Running         Running 16 seconds ago
uaj6skrmriv9   my-server.5   nginx:latest   ip-172-31-19-254.ap-southeast-1.compute.internal   Running         Running 17 seconds ago
```

We can update the image throughout our replicas using `docker service update --image=nginx:1.16 my-server` and `docker service rollback my-server` to rollback changes.

#### Drain Worker Node

We can bring a node down to do some maintenance work using `docker node update --availability drain`. Whatever replica that is running on that node will be handed off to another node automatically by docker swarm. To return to active status, we can use `--availability active` flag.

```
[root@ip-172-31-16-165 ~]# docker node ls
ID                            HOSTNAME                                           STATUS    AVAILABILITY   MANAGER STATUS   ENGINE VERSION
i77mtl78vigixmdnosxj2ieri *   ip-172-31-16-165.ap-southeast-1.compute.internal   Ready     Active         Leader           20.10.7
2ar2it73ifvi2ytsgdpouqi99     ip-172-31-19-254.ap-southeast-1.compute.internal   Ready     Active                          20.10.7
ijtgksac05hdwvduousq883a8     ip-172-31-21-138.ap-southeast-1.compute.internal   Ready     Active         Reachable        20.10.7
jye5cj7vp416b4nfah2awyorv     ip-172-31-26-110.ap-southeast-1.compute.internal   Ready     Active                          20.10.7
u4h074o709h7xj2lhx8l8quv0     ip-172-31-27-251.ap-southeast-1.compute.internal   Ready     Active                          20.10.7

[root@ip-172-31-16-165 ~]# docker node update --availability drain ip-172-31-19-254.ap-southeast-1.compute.internal
ip-172-31-19-254.ap-southeast-1.compute.internal

[root@ip-172-31-16-165 ~]# docker node ls
ID                            HOSTNAME                                           STATUS    AVAILABILITY   MANAGER STATUS   ENGINE VERSION
i77mtl78vigixmdnosxj2ieri *   ip-172-31-16-165.ap-southeast-1.compute.internal   Ready     Active         Leader           20.10.7
2ar2it73ifvi2ytsgdpouqi99     ip-172-31-19-254.ap-southeast-1.compute.internal   Ready     Drain                           20.10.7
ijtgksac05hdwvduousq883a8     ip-172-31-21-138.ap-southeast-1.compute.internal   Ready     Active         Reachable        20.10.7
jye5cj7vp416b4nfah2awyorv     ip-172-31-26-110.ap-southeast-1.compute.internal   Ready     Active                          20.10.7
u4h074o709h7xj2lhx8l8quv0     ip-172-31-27-251.ap-southeast-1.compute.internal   Ready     Active                          20.10.7
```

#### Docker Stack Deploy

We can also use a docker-compose.yml configuration file to launch containers and replicas in our docker swarm. The same docker-compose file can be used to deploy multiple services as a stack. The biggest difference from a normal docker-compose is we don't need to define a container name when we define our services. We can specify the number of replicas using the _deploy_ property.

Docker Stack Deploy can be used to deploy multiple services in one go. We create the following docker-compose.yml in our manager instance using vi. We then deploy the stack using `docker stack deploy --compose-file docker-compose.yml my-stack` which will create two services for us.

```yml
version: "3.3"
services:
  web:
    image: httpd
    ports:
      - "8080:80"
  db:
    image: redis
```

We can verify that the services got created for us

```
[root@ip-172-31-16-165 ~]# docker service ls
ID             NAME           MODE         REPLICAS   IMAGE          PORTS
zok9buak0r84   my-server      replicated   2/2        nginx:latest   *:80->80/tcp
4qgk7qqwvpmu   my-stack_db    replicated   1/1        redis:latest
4frihug2ku4a   my-stack_web   replicated   1/1        httpd:latest   *:8080->80/tcp
```

#### Remove Worker Nodes from Swarm

To delete a node, we use `docker swarm leave` on the worker node. This will shutdown the node and its work will be automatically transferred to another node.

#### Switch Managers

The recommended way to switch managers using the following. This command guarantees that the other manager will take over.

```
[root@ip-172-31-16-165 ~]# docker node ls
ID                            HOSTNAME                                           STATUS    AVAILABILITY   MANAGER STATUS   ENGINE VERSION
i77mtl78vigixmdnosxj2ieri *   ip-172-31-16-165.ap-southeast-1.compute.internal   Ready     Active         Leader           20.10.7
2ar2it73ifvi2ytsgdpouqi99     ip-172-31-19-254.ap-southeast-1.compute.internal   Down      Active                          20.10.7
ijtgksac05hdwvduousq883a8     ip-172-31-21-138.ap-southeast-1.compute.internal   Ready     Active         Reachable        20.10.7
jye5cj7vp416b4nfah2awyorv     ip-172-31-26-110.ap-southeast-1.compute.internal   Ready     Active                          20.10.7
u4h074o709h7xj2lhx8l8quv0     ip-172-31-27-251.ap-southeast-1.compute.internal   Ready     Active                          20.10.7

[root@ip-172-31-16-165 ~]# docker node demote ip-172-31-16-165.ap-southeast-1.compute.internal
Manager ip-172-31-16-165.ap-southeast-1.compute.internal demoted in the swarm.
```

#### Replicas in Docker Swarm

To have replicas in Docker Swarm, we can use the **deploy** property in docker-compose

```yml
version: "3.3"
services:
  web:
    image: httpd
    deploy:
      replicas: 3
    ports:
      - "8080:80"
  db:
    image: redis
    deploy:
      replicas: 2
```

## AWS Lambda

AWS Lambda is a serverless compute service which allows us to write code that runs is response to events taht happens in other resources. When the event source triggers our lambda functions, the code we write will be run and our lambda function will be able to interact with other AWS components.
These components should have the permissions to invoke lambda functions through IAM Resource policies while the lambda function itself will have an IAM Role to access resources.

For this demo, we use node.js runtime. Typically, a lambda function is triggered by an event from other components.

```javascript
exports.handler = async (event) => {
  // TODO implement
  const response = {
    statusCode: 200,
    body: JSON.stringify("Hello from Lambda!"),
  };
  return response;
};
```

Using the test tab, we can create a test event which will pass the json input to the lambda function. It will end up in the event object that the lambda is receiving. The response will be

```json
{
  "statusCode": 200,
  "body": "\"Hello from Lambda!\""
}
```

## Ansible

Ansible is a provisioning/configuration management tool. Using it, we can push whatever services are required to make our microservices function across multiple nodes. Ansible is agentless which means we don't need to install software on the host machines. We just need to setup Ansible on the master machine and we can execute adhoc commands using SSH to be executed on the host machine. Using playbooks, we can install software in a single shot in exactly the same way in multiple machines.

The **master node** is where we will be installing Ansible. The **managed nodes** are where we want to install software. **Inventory** is a configuration file where the information of all the managed nodes such as ip address etc. The inventory is maintained in the master node. **Modules** are provided by Ansible and are used to perform certain tasks such as copying files, installing software on the host machine.

#### Master and Agent

To create the Ansible master and agent nodes, we can use two Ubuntu EC2 instances. For the master, we need to install ansible and for the agent, we only need python. We can install ansible on the master using the commands. To install python, we use `sudo apt install python3`

```
$ sudo apt update
$ sudo apt install software-properties-common
$ sudo add-apt-repository --yes --update ppa:ansible/ansible
$ sudo apt install ansible
```

We also make sure to add an inbound rule in our security group to allow all icmp ipv4 traffic from any ip address. After adding the inbound rule, we can try pinging each instance. The next step is to setup SSH between the two instances. In the master, we can generate a key pair using `ssh-keygen`. This will generate the id_rsa private key and id_rsa public key which we need to copy to the agent. On the agent machine, we navigate to ~/.ssh and then add the contents of the id_rsa.pub file from the master.

```
ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCjzlBwb2TSlIbzF6Fg8LV9pMkqYBCXGSFdmC0hcGNqZibSMdeARf2tbm6TewL0nP6ZAmA/7QxOgGcU4An4NTAmyMdlnuklbZVkSMQuZBpoWrp10ER36GkOxqvS6rW5wdxWAmO4YolDDuWLK2RBWzFZwEg3GRejc/oDcPOR0FsDeMVyFaIPfswjNOnD/q40xbxaDwMd7BUCzptCQHObOTLRhRCAfysxx1S5VOguJjSkgRvdU2k+uOylk5oRRVHOJ+8Lg5cHkZKzlypAHP1XdLi0NmYkPWsb8Xc7T/EfO/5wIyLL9BX4jeWThiyun9Ae7y4Go0oph4KgCqXOJfSnzG3H awskeys

ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQDWsdCtdGcingTadJ6V0hLuYMNLYl8cFb0+bBR+n092Z2kUB1fF7m6S3nnV9cqaKhkKhF4CTw8dfu3MWjCkOJH26fDeweCs6X6kpVW7xyBWJ60MHIgDDUl+piJ/ITcXeSl4p3373aj0rn+47hDe4eVsAW+mUNgToYYUk7c8x9+6n9N/LV8UNtcqMGRt02YJWenF77sywoSshLRPLki0RdXKtFrBixe5Y7jCNvIuyY/4RJlxPPIke72y//R/+80uwxzyE5ImaAWnuOARwPzrYrAkf0tvQgp36gVhC9+x07KgVVmE4wn/TgaKbcNSKadXu6S+oJjO3BYnCeoTnprIJ07z4/0CCVRmNDJZo9J9yK0qt7s08R209FDj4HBMpUjX3JwjK9R8E9q+1fKuITRqTod0VATi74oIFtmeEng7PkliMYlK9YlKLRolztLxjQHUFfWpOjA8JzMVNSpEeha2oJ5ccdyIosMiGUoh7ecClMtezlMocL/Hmc7nqpjxDL357+8= root@ip-172-31-22-95
```

Now, the agent has the public key while the master has the private key. These keys will be used for the ssh communication. We can try doing an ssh from the master to the agent using `ssh root@172.31.16.232`. This proves that ssh works between the two instances.

In the master node, we navigate to `/etc/ansible` and from there, add the agent's ip address to the **hosts** file. Afterwards we can run `ansible 172.31.16.232 -m ping` to ping the agent. Any ansible syntax has the following format.

```
ansible <group> -m <module>
```

We can also configure a hostname mapping instead of the ip address. On the master, we edit the `/etc/hosts` file and add the private ip address of the agent. Instead of using the ip address in the /etc/ansible/hosts file, we can use agent1 instead.

```
127.0.0.1 localhost
172.31.16.232 agent1
```

To create a file on the remote machine, we can use the file module `ansible agent1 -m file -a 'path=/root/test.txt state=touch mode=0770 owner=root'`

To install apache remotely, we can use the following commands on the ansible master. At this point, we need to open up port 80 on the agent node.

```
ansible agent1 -m command -a "apt update"
ansible agent1 -m command -a "apt upgrade"
ansible agent1 -m command -a "apt install apache2"
```

After apache has been installed, we need to start up apache. We can do so with `ansible agent1 -m service -a "name=apache2 state=started"`

#### Playbook

The following playbook copies a file to the agent and will add content to that file dynamically. In this playbook, we can define variables. In this case, we assign "Hello Ansible" to the _msg_ variable. The **tasks** field is where we will define tasks to be executed. The **copy** module has the _dest_ attribute which is where we want to create a file abc.txt and the _content_ attribute will be what we defined in the msg variable. we can run it using `ansible-playbook filecopy.yml`

```yml
- hosts: agent1
  vars:
    msg: "Hello Ansible"
  tasks:
    - name: Test
      copy:
        dest: /root/abc.txt
        content: "{{msg}}"
```

The following playbook creates a bunch of directories on the agent using loops. Here we use the **file** module to create directories. The _item_ attribute will be obtained dynamically with the _with_items_ syntax wherein we pass the directory names. When we run the playbook, it will loop throug these items and its value will be used in {{item}}.

```yml
- hosts: agent1
  tasks:
    - name: create directories if they do not exist
      file:
        path: "{{item}}"
        state: directory
      with_items:
        - dir1
        - dir2
```

The playbook below can be used to install git and mysql to the agent node. For this, we use the **apt** module since we are using an Ubuntu machine.

```yml
- hosts: agent1
  tasks:
    - name: install packages
      apt:
        name:
          - git
          - mysql-server
        update_cache: yes
```

#### Tags

We can use the previous playbook and extend it to start mysql.

```yml
- hosts: agent1
  tasks:
    - name: install packages
      apt:
        name:
          - git
          - mysql-server
        update_cache: yes
    - name: Start mysql
      service: name=mysql state=started
```

If we need to skip the installation task, we can use Ansible tasks. We can tag the tasks. Now to run a particular task, we can do `ansible-playbook installpackages.yml --tags "start"`. This way, only the tags that are specified will be run. `--skip-tags` can be used to skip particular tasks.

```yml
- hosts: agent1
  tasks:
    - name: install packages
      apt:
        name:
          - git
          - mysql-server
        update_cache: yes
      tags:
        - install
    - name: Start mysql
      service: name=mysql state=started
      tags:
        - start
```

If we want to list out all the tasks in a playbook, we can do `ansible-playbook installpackages.yml --list-tasks`. There are also special tags: `always` and `never`. By default, the Gathering Facts tag is marked with always. If we tag a task with always, it will always get executed and we have to skip it manually if needed.

## Jenkins

Jenkins is a CICD framework that can be used throughout the delivery pipeline

1. Code and Commit - GitHub SVN
2. Build and Configuration - Maven Gradle Docker Ant
3. Testing - Junit Sonar Selenium Cucumber
4. Release - XL Release uDeploy UrbanCode
5. Deploy - AWS Web Logic OpenStack

To install Jenkins and build Maven projects, we can use an AWS EC2 instance wherein we install maven and java. From there, we create a maven standalone java-project and java-web-project.

```
yum install java-1.8.0-openjdk
yum install maven

mvn archetype:generate -DgroupId=com.bharath -DartifactId=java-project -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

mvn archetype:generate -DgroupId=com.bharath -DartifactId=java-web-project -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
```

To install jenkins, we can use the following commands:

```
wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins-ci.org/redhat/jenkins.repo
rpm --import https://pkg.jenkins.io/redhat/jenkins.io.key
yum install jenkins
```

Afterwards we open port 8080 of the ec2 instance and we can start jenkins using `service jenkins start`. At this point, we can visit port 8080 of the ec2 instance via the web browser and we will be able to access the Jenkins dashboard. The dashboard will prompt us with an administrator password. To get the password, we can use `cat /var/lib/jenkins/secrets/initialAdminPassword`. We can go and install the suggested plugins from the dashboard. When we start working with jenkins, it will store all of its working information under `/var/lib/jenkins`. We need to delete this directory whenever we uninstall jenkins.

Under Manage Jenkins -> Global Tool Configuration, we can configure the paths to Java, Maven and Swarm. The path for git will be `/usr/bin/git`. To determine the home directory of maven and Java, we can use `mvn -version`

```
Maven home: /usr/share/maven
Java version: 1.8.0_312, vendor: Red Hat, Inc.
Java home: /usr/lib/jvm/java-1.8.0-openjdk-1.8.0.312.b07-1.amzn2.0.2.x86_64
```

Before creating jobs, we need to first configure the root user permissions. We can assign the root user and permissions using the following command

```
vi /etc/sysconfig/jenkins

JENKINS_USER="root"
```

Afterwards we change ownership of some jenkins folders. We do a restart after changing ownership with `service jenkins restart`.

```
chown -R root:root /var/lib/jenkins !!! causes jenkins to break
chown -R root:root /var/cache/jenkins
chown -R root:root /var/log/jenkins
```

#### Jobs

To create a jekins job, we start by creating a shell script. We need to make sure to give 777 permissions to the script.

```
vi hello.sh

echo "Hello Jenkins!"

chmod 777 hello.sh
```

Afterwards, under the jenkins dashboard, we can go to New Item and select **freestyle project**. Under **Build** we select Execute shell and give the command `/root/hello.sh`. Once we click build, jenkins will run the job.

To build a maven project from within a jenkins job, we can create a new freestyle project and under the build step, **Invoke top level Maven targets** and for the goal, we use `clean install`. Under the advanced section, we specify the location of the POM.xml to point to the pom.xml in our ec2 machine `/root/java-project/pom.xml`.

We can pull from a remote Git repository using a jenkins job as well. We first install the Maven Integration plugin which will allow us to choose **Maven Project** under new item. Under the Source Code Management tab, we need to specify the git repository url. In the Build tab, we specify the goals as `clean package`

#### Build Triggers

To automated building, we can use Build Triggers. Under our job's Configure, we can go to the Build Triggers tab. Build whenever a SNAPSHOT dependency is built means that whenever other maven projects are built that is a dependency of this project, this project will be built as well. This is important for continuous integration. **Build Periodically** is like a CRON job wherein we can schedule a job by providing times. **Poll SCM** is where a repository will be constantly pulled.

#### Deployment

To deploy a WAR file to a apache tomcat instance from within jenkins, we start by installing Tomcat on a new EC2 instance. We will be creating a new Deployment User on the Tomcat console, and in jenkins, we need to install the Deployment plugin.

We create a new ec2 instance for this. From within here, we install tomcat. After installing, we can start tomcat using `service tomcat start`. Afterwards, we can visit the ec2 ip's port 8080 to be able to access the tomcat dashboard.

```
yum install java-1.8.0-openjdk
yum install tomcat
yum install tomcat-webapps tomcat-admin-webapps
```

Afterwards, we need to configure the tomcat users so we can access the tomcat Manager App and also for our jenkins Deployment. The following will give us a new user with username and password _deployer_.

```xml
vi /usr/share/tomcat/conf/tomcat-users.xml

<role rolename="admin"/>
<role rolename="admin-gui"/>
<role rolename="admin-script"/>
<role rolename="manager"/>
<role rolename="manager-gui"/>
<role rolename="manager-script"/>
<role rolename="manager-jmx"/>
<role rolename="manager-status"/>
<user username="deployer" password="deployer" roles="manager-script" />
<user name="admin" password="admin" roles="admin,manager,admin-gui,admin-script,manager-gui,manager-script,manager-jmx,manager-status" />
```

In jenkins, we need to install the plugin **deploy to container**. We can now create a jenkins job that will pull from our github repo and then push it to the tomcat instance. For this, we use freestyle project and specify under source code management the url of our git repo. Under Build, we invoke top level Maven target with goal `clean package` to create a war file.

Under Post build actions, we select **Deploy war/ear to a container** which is available thanks to the plugin we installed. We specify `**/java-web-project.war` as the WAR/EAR file and context path will be `javawebapp`. Container will be tomcat 7.x. Here, we use the credentials with username and password _deployer_. Tomcat URL will be the amazon instance's port 8080.

These will allow jenkins to build and deploy to tomcat. At this point, we can see /javawebapp under our tomcat manager. If we click the link to /javawebapp in tomcat manager, we will be greeted by Hello World.

#### Webhooks

For CICD, we can use webhooks to tell jenkins that an update has happened in our repository. This is so when we do a push to the github repo, github will notify our jenkins job to trigger a build. The payload URL will be the jenkins url. In this case, the port 80 of our ec2 instance plus github-webhook/. `http://ec2-52-221-180-103.ap-southeast-1.compute.amazonaws.com:8080/github-webhook/`. The _Secret_ can be used to sign the webhook message for security. In our jenkins project, we need to enable **Github hook trigger for GitScm polling** which means that a build will be trigger through a github webhook.

#### Master and Slave

So far, we have installed jenkins only on a single ec2 instance which we use to run our jobs. In the cases where we have a high load or we need to run a job on a particular environment, we can use the master/slave architecture. We can create multiple slaves with one master machine where jenkins is installed. The master will push the job to the slave machines. We can do this by creating an ec2 slave instance, configuring SSH and then configuring a node on the master instance.

Using `ssh-keygen` on the master instance, we can generate a private and public key. We can get our keys using `cat ~/.ssh/id_rsa.pub`. The private key will be used by jenkins when configuring the slave, and the public key will go to the authorization keys file of the slave. We then proceed on creating the slave ec2 instance. In the slave instance, we copy the public key and paste it into authorized_keys. Afterwards we install java with `yum install java-1.8.0-openjdk`

Afterwards, we create a node using the master jenkins dashboard. We can do so under Manage Jenkins -> Manage Nodes and Clouds. The remote root directory shall be `/home/ec2-user`. **Launch method** will be Launch agents via SSH. The **Host** will be the pubkuc ip address of the slave ec2 instance. **Credentials** will be SSH username with private key where username will be ec2-user. Here we paste the private key we obtained earlier. **Verification Strategy** will be manually trusted key verification strategy.

To see our node slave in action, we created two jobs wherein we pass the shell command `sleep 30s`. This will take time and is intended to make the master pass on the job to the node.

## Jenkins Pipelines

A pipeline allows us to create a repeatable, reliable, automated system for getting our product to the customer quickly. It is a combination of multiple staged such as commit, build, test, stage, qa, deploy. We usually create a Jenkinsfile under our project.

We can create a pipeline under new item -> pipeline. Here we can write out our own pipeline script. The following is an example of a multistage pipeline. We can access jenkins environment variables from within our jobs easily. Jenkins by default exposes out environment variables that it uses. We can find this in `http://ec2-52-221-180-103.ap-southeast-1.compute.amazonaws.com:8080/env-vars.html/`. We can also pass parameters to our pipeline by ticking **Thisproject is parameterized**. These parameters can be passed in at runtime. We can also ask for user input using `input`. When the pipeline reaches the Approval stage, it would pause and prompt us if we want to proceed or build.

```
pipeline{
    agent any
    stages{
        stage("checkout"){
            steps{
                echo "Checkout started"
                echo "Running ${env.BUILD_NUMBER} on ${env.JENKINS_URL}"
            }
        }
        stage("Build"){
            steps{
                echo "Building project"
            }
        }
        stage("test"){
            steps{
                echo "Testing project"
                echo "${skiptests}"
            }
        }
        stage("Approval") {
            steps{
                input "Have all the tests passed?"
            }
        }
        stage("Deploy"){
            steps{
                echo "Deploying"
            }
        }
    }
}
```

#### Creating a Java Project pipeline

We create a new pipeline in jenkins and under build triggers we enable github hook trigger for GITScm polling. Under Pipeline, we use PipelineScript from SCM. We create the following Jenkinsfile in our git repo:

```
pipeline{
    agent any
    stages{
        stage("Build") {
            steps{
                sh 'mvn -DskipTests clean package'
            }
        }
        stage("Test") {
            steps{
                sh 'mvn test'
            }
        }
    }
}
```

Its a good idea to run the build pipeline at least once manually before testing it with the webhook.

#### Java Web Project Pipeline

In this section we built a jenkins pipeline for a java maven web application. The pipeline does everything including deploying to tomcat. Instead of manually typing out the pipeline, we used the snippet generator and used the sample step for **Deploy war/ear to container**. In here we specify WAR/EAR files as `**/java-web-project.war` and Context path `javawebapp`. Container will be tomcat 7.x wherein we pass the public ip of the ec2 instance.

```
pipeline{
    agent any
    stages {
        stage("Build"){
            steps {
                sh "mvn clean package"
            }
        }
        stage("Deploy") {
            steps {
                deploy adapters: [tomcat7(credentialsId: '82d45004-9d0d-45f5-a576-8f3f82c2216b', path: '', url: 'http://ec2-13-250-44-20.ap-southeast-1.compute.amazonaws.com:8080/')], contextPath: 'javawebapp', war: '**/java-web-project.war'
            }
        }
    }
}
```

Afterwards ,we proceed on creating the webhook from github with payload `http://ec2-52-221-180-103.ap-southeast-1.compute.amazonaws.com:8080/github-webhook`

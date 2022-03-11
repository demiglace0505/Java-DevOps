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

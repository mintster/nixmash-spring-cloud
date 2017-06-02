NixMash Cloud
==========================

A Spring Cloud application with NixMash Blog Tutorials at [http://nixmash.com](http://nixmash.com). **NixMash Cloud** will eventually be a Microservice Version of NixMash Blog [located here.](https://github.com/mintster/nixmash-blog) **NixMash Cloud** uses the same SQL Schema as **NixMash Blog.**

## Modules

NixMash Cloud consists of the following Modules:

- **Spring Cloud Config Server**
- **CORE** Module with shared Domain objects and log
- **POSTS** Posts Service Module
- **EUREKA** Eureka Discovery Service Module
- **MVC** Web Client Application
- *Zipkin and other Cloud modules in development*
 
 ## NixMash Post List by Branch
 
 ### nixmashcloud-v0.1.0 - Initial Layout and Structure (in progress)
 
 - [NixMash Post: Consuming REST HAL-formatted JSON with Spring RestTemplate](http://nixmash.com/post/consuming-rest-hal-formatted-json-with-spring-resttemplate)
 - [NixMash Post: Customizing REST Output with Spring Projections](http://nixmash.com/post/customizing-rest-output-with-spring-projections)
 
 ## Installation
 
 Open the application root `build.gradle` file in your IDE. Use the IDE to build the project or the included Gradle `buildAll.sh` bash script in `/install/sh/buildAll.sh.`
 
 NixMash Cloud is configured for **MySQL** and **H2.** Spring Profiles are "mysql" and "h2" respectively. A setup script is provided in `/install/sql/mysqlsetup.sql` for MySQL, but currently includes no data. Data is included when using H2 for testing purposes. MySQL Configuration is located in `/core/src/main/resources/db/mysql.properties` or configurable as runtime arguments.
 
 Spring Cloud uses a Git Configuration directory to house the various Cloud `.properties` files. The Configuration Directory used for NixMash Cloud is found in the GitHub repository [nixmash-cloud-config.](https://github.com/mintster/nixmash-cloud-config) Change the location of the directory in your Config Server `application.properties` and module `bootstrap.properties` files.
 
 ## To Run
 
 To run NixMash Cloud in your IDE launch the following in order: 
 
1. **Config Server** 
2. **Eureka Service**
3. **Posts Service**
4. **MVC Client Web Application**
 
- Posts List: http://localhost:8000/posts *(will initially be empty in mysql)*
- Edge REST retrieval of same: http://localhost:8001/post-service/posts
 
 *MORE AS IT COMES ONLINE....*
 
 To run in Gradle:
 
 ```bash
 $ gradle config:clean config:bootRun
 $ gradle eureka:clean eureka:bootRun
 $ gradle posts:clean posts:bootRun
 $ gradle mvc:clean mvc:bootRun
 ```
 
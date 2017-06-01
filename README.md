NixMash Cloud
==========================

A Spring Cloud application with NixMash Blog Tutorials at [http://nixmash.com](http://nixmash.com). **NixMash Cloud** will eventually be a Microservice Version of NixMash Blog [located here.](https://github.com/mintster/nixmash-blog) **NixMash Cloud** uses the same SQL Schema as **NixMash Blog.**

## Modules

NixMash Cloud consists of the following Modules:

- **Spring Cloud Config Server**
- **CORE** Module with shared Domain objects and log
- **POSTS** Posts Service Module
- *Eureka, Zipkin, other Cloud and Client modules in development*
 
 ## NixMash Post List by Branch
 
 ### nixmashcloud-v0.1.0 - Initial Layout and Structure (in progress)
 
 - *coming...*
 
 ## Installation
 
 Open the application root `build.gradle` file in your IDE. Use the IDE to build the project or the included Gradle `buildAll.sh` bash script in `/install/sh/buildAll.sh.`
 
 NixMash Cloud is configured for **MySQL** and **H2.** Spring Profiles are "mysql" and "h2" respectively. A setup script is provided in `/install/sql/mysqlsetup.sql` for MySQL, but currently includes no data. Data is included when using H2 for testing purposes. MySQL Configuration is located in `/core/src/main/resources/db/mysql.properties` or configurable as runtime arguments.
 
 Spring Cloud uses a Git Configuration directory to house the various Cloud `.properties` files. The Configuration Directory used for NixMash Cloud is found in my [nixmash-cloud-config repository.](https://github.com/mintster/nixmash-cloud-config) Change the location of the directory in your Config Server `application.properties` or Module `bootstrap.properties` files.
 
 ## To Run
 
 To run NixMash Cloud in your IDE first launch **Config Server** then **Posts Service.**
 
 - Posts List: http://localhost:8000/posts *(will initially be empty in mysql)*
 
 *MORE AS IT COMES ONLINE....*
 
 To run in Gradle:
 
 ```bash
 $ gradle config:clean clean:bootRun
 $ gradle posts:clean posts:bootRun
 ```
 
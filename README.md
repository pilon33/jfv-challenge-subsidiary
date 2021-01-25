## Lightweight RESTful  API with Spring Boot,Spring Security PostgreSQL, JPA, Docker,Lombok, Swagger mockito, Units 4,Healthcheck.

[Jose Francisco valdez]



## How it works:
**0. Runs as Spring boot app**
* Clone the repository:
```bash
https://github.com/pilon33/challenge-subsidiary.git
```
* Update maven project:
```Runs As 
Spring Boot App
```
* Authorization:
```bash
username: `admin` and password: `admin` 

```
**1. Docker. First you need to install docker**
* Download Docker [Here](https://docs.docker.com/docker-for-windows/install/). Hint: Enable Hyper-V feature on windows and restart;
* Then open powershell and check:
```bash
docker info
```
or, and you see versions docker & docker compose
```bash
docker -v
```
```bash
docker-compose -v
```
**2. Spring boot app**
* Clone the repository:
```bash
https://github.com/pilon33/challenge-subsidiary.git
```
* Build the maven project:
```bash
mvn clean install
```
* Now run:
```bash
docker-compose up
```

Appendix A.

All commands should be run from project root (where docker-compose.yml locates)

**Guide for using endpoint the app:**
to test and would specify basic authorization a username: `admin` and password: `admin` 

* GET request to `/api/sucursales/` returns a list of "subsidiarys";
* GET request to `/api/sucursales/1` returns the "subsiadiary" with ID 1;
* POST request to `/api/sucursales/` with a "subsiadiary" object as JSON creates a new "subsiadiary";
* GET request to `/api/sucursalCercana/32.9697/-96.80322` origen latitude and longuitud returns the "subsiadiary by closest Distance" with Distance(KM) ;

or use Swagger API [http://localhost:8182/swagger-ui.html](http://localhost:8182/swagger-ui.html)

and generation API docks [http://localhost:8182/v2/api-docs.yaml](http://localhost:8182/v2/api-docs.yaml)

* Do not forget, if you see db, open the Windows Services Manager on your Windows 10 computer and stop postgres

**3. Docker control commands**
* Check all the images you have:
```bash
docker images
```
* If you have to want see running containers:
```bash
docker ps
```
**4. End stop app**
*  Stop containers:
```bash
docker-compose down
```
* Remove old stopped containers of docker-compose
```bash
docker-compose rm -f
```





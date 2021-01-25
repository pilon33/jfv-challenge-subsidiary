# Start with a base image containing Java runtime
FROM java:8

# Make port 8080 available to the world outside this container
EXPOSE 8182

ADD target/jfv-challenge-subsidiary.jar jfv-challenge-subsidiary.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","jfv-challenge-subsidiary.jar"]
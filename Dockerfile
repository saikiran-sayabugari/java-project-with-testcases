# Use an official OpenJDK runtime as a parent image
FROM openjdk:8-jdk-alpine

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Compile the Java code
RUN javac src/main/java/com/kiran/**/*.java

# Run google-java-format
RUN wget https://github.com/google/google-java-format/releases/download/v1.11.0/google-java-format-1.11.0-all-deps.jar -O google-java-format.jar
RUN java -jar google-java-format.jar --replace src/**/*.java

# Build the fat JAR
RUN mvn package

# Expose the Spark server port
EXPOSE 8080

# Run the Spark web server when the container launches
CMD ["java", "-jar", "target/java-project-1.0-SNAPSHOT.jar"]


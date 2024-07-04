# Use OpenJDK 18 image as base image
FROM openjdk:18

# Create a new app directory for my application files
RUN mkdir /app

# Copy the app files from the host machine to image filesystem
COPY target/classes/ /app

# Set the directory for executing future commands
WORKDIR /app

# Run the Main class
CMD ["java", "com.demo.Main"]
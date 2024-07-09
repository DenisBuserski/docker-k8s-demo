# FROM - This instruction sets the base image for the Docker image you are building.
# Use OpenJDK 18 image as base image
FROM openjdk:18

# RUN - Executes commands in the Docker image's build process.
# Create a new app directory("/app") for my application files, inside the image's filesystem to store the application files.
RUN mkdir /app

# COPY - Copies files and directories from the host machine to the image's filesystem.
# Copy the app files from the host machine to image filesystem. The "target/classes/" specifies the source directory on
# the host machine that contains the compiled Java classes. The "/app" specifies the destination directory inside the
# image where the files will be copied.
COPY target/classes/ /app

# WORKDIR - Sets the working directory for any subsequent 'RUN', 'CMD', 'ENTRYPOINT', 'COPY', and 'ADD' instructions.
# Specifies the directory "/app" as the working directory. This means any command that is run after this instruction
# will be executed in the "/app" directory.
WORKDIR /app

# CMD - This instruction specifies the default command to run when the container starts.
CMD ["java", "com.demo.Main"]



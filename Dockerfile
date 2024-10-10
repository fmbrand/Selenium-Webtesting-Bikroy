# Use an OpenJDK runtime as base image
FROM ubuntu:22.04

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project files to the container
COPY . .

# Install Maven
RUN apt-get update && apt-get upgrade -y

# Build the Maven project
RUN chmod +x ./install_dependecies.sh

# Expose the port for Allure report (if needed)
RUN ./install_dependecies.sh

# Run the Allure report generation command
CMD [ "mvn","clean", "test" ]

# (Optional) You can specify the command to run your tests here instead of the CMD above.
# CMD mvn test

# (Optional) If you have a custom script to run the tests and generate the report, you can specify it here.
# CMD ./run_tests.sh

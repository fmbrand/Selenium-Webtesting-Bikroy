#!/bin/bash

# Update package index and install dependencies

apt install openjdk-17-jdk openjdk-17-jre
# Install Java
apt-get install -y default-jdk

# Install Maven
apt-get install -y maven

# install Crome 
apt install chromium-browser chromium-chromedriver

# Install Allure
wget https://github.com/allure-framework/allure2/releases/download/2.27.0/allure_2.27.0-1_all.deb
chmod +x allure_2.27.0-1_all.deb 
dpkg -i allure_2.27.0-1_all.deb

chmod +x ./src/test/resources/chromedriver_linux

# Verify installations
java -version
mvn -version
allure --version

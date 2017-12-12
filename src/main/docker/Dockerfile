ARG CODE_VERSION=latest
ARG USER_HOME_DIR="/root"
ARG project

FROM ubuntu:${CODE_VERSION}
ENV container docker

# Add git client
RUN apt-get -qq update && apt-get install --no-install-recommends -qqy \
    curl \
    ca-certificates \
    maven \
    git \
    software-properties-common

# Install Java 8
RUN \
  echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
  add-apt-repository -y ppa:webupd8team/java && \
  apt-get update && \
  apt-get install -y oracle-java8-installer && \
  rm -rf /var/lib/apt/lists/* && \
  rm -rf /var/cache/oracle-jdk8-installer


# Define working directory.
WORKDIR /data

# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle
# Get a project
RUN mkdir /app
RUN mkdir /app/SpBootApp
RUN git clone https://gundartsev:blackK1TTY@github.com/gundartsev/SpBootApp1.git /app/SpBootApp
WORKDIR /app/SpBootApp
RUN mvn install
CMD ["java", "-jar", "target/SpBootApp-1.0-SNAPSHOT.jar"]
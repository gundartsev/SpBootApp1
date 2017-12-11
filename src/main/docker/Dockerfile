ARG CODE_VERSION=latest
ARG project
FROM ubuntu:${CODE_VERSION}
ENV container docker

# Add git client
RUN apt-get -qq update && apt-get install --no-install-recommends -qqy \
    curl \
    ca-certificates \
git

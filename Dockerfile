FROM jenkinsci/blueocean
USER root
ENV GRADLE_VERSION 5.3-bin
RUN echo -e 'https://mirrors.aliyun.com/alpine/v3.6/main/\nhttps://mirrors.aliyun.com/alpine/v3.6/community/' > /etc/apk/repositories && \
    apk update && \
    apk upgrade && \
    apk add --no-cache maven && \
    apk add --no-cache apache-ant && \
    apk add bash vim curl wget jq docker git tar unzip bash-completion ca-certificates && \
    curl https://downloads.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip > gradle.zip && \
    unzip gradle.zip && \
    mv gradle.zip /opt && \
    cd /opt &&  unzip gradle.zip && rm gradle.zip
ENV PATH "$PATH:/opt/gradle-${GRADLE_VERSION}/bin/"

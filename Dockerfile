FROM hub.c.163.com/public/centos:7.2-tools
MAINTAINER GGG
# 安装jdk1.8.0
WORKDIR /usr/local
RUN yum -y install java-1.8.0-openjdk
# 安装wget下载zookeeper
RUN yum -y install wget  \
    && wget https://archive.apache.org/dist/zookeeper/zookeeper-3.4.12/zookeeper-3.4.12.tar.gz \
    && tar -zxvf zookeeper-3.4.12.tar.gz \
    && cd zookeeper-3.4.12/conf/ && cp zoo_sample.cfg zoo.cfg && cd ..\
    && cd bin/ && ./zkServer.sh start
EXPOSE 2181 3888 2888
ENTRYPOINT /usr/sbin/sshd -D

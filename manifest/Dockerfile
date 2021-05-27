# Dockerfile

FROM openjdk:14

MAINTAINER  Bhupesh Rathod <rbhupesh78@gmail.com>


ENV JAVA_VER 14
RUN ls -alt /usr/lib
#RUN ls -alt /usr/lib/jvm
RUN java -version
RUN cd / && mkdir target && chmod 777 target && cd target && mkdir config
RUN ls -alt /
RUN ls -alt
RUN ls -alt /sbin/
RUN pwd

CMD ["/sbin/my_init"]
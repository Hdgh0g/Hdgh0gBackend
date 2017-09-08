FROM openjdk:jre-alpine

WORKDIR /bin/
ADD backend.jar ./

EXPOSE 9000

CMD java -jar backend.jar
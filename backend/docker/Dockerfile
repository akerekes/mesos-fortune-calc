FROM develar/java

ADD https://s3-us-west-2.amazonaws.com/akerekes-dcos-jar-repo/fortune-calc-backend-jar-with-dependencies.jar /fortune-calc-backend-jar-with-dependencies.jar

ENV FORTUNE_BACKEND_PORT=9090
EXPOSE $FORTUNE_BACKEND_PORT

CMD ["-jar", "/fortune-calc-backend-jar-with-dependencies.jar"]

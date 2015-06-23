FROM develar/java

ADD libs/fortune-calc-backend-jar-with-dependencies.jar /fortune-calc-backend-jar-with-dependencies.jar

ENV FORTUNE_BACKEND_PORT=9090
EXPOSE $FORTUNE_BACKEND_PORT

CMD ["-jar", "/fortune-calc-backend-jar-with-dependencies.jar"]

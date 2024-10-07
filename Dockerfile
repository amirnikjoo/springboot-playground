FROM hwregistry.kian.digital/infra/eclipse-temurin:11-jre-focal
WORKDIR /app
COPY target/payment-0.1.jar payment-0.1.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "payment-0.1.jar"]
#docker build -t payment-0.1.jar .
#docker run -p 8888:8888 payment-0.1.jar
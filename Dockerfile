FROM openjdk:8
COPY build/libs/*.jar /apps/pokemon/pokemon.jar
WORKDIR /apps/pokemon
ENTRYPOINT ["java","-jar","pokemon.jar"]
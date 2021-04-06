FROM openjdk
COPY target/countryinfo.jar .
CMD java -jar countryinfo.jar
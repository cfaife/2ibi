# Countries Info API

## Context
 This is a Java based REST API that holds information of countries.
 
## Technologies used:
    JDK 8
    Springboot 2.4.2 -> as java framework
    H2 Database -> used in memory
    FlywayDB -> for migration
    GIT -> for Version control
    Maven -> for dependency management
    Docker -> for containerization 

## Deployment instructions 
###  Via Docker
There is a docker image available in the docker registry, in  the command line
type:
   
    $ docker container run -d --rm  --name countryinfo -p 8081:8080  cfaife/countryinfo

For the first time this will pull the image from docker hub,  it might take a while.

###  Build and Deploy locally

#### Follow the bellow instructions:

1. Clone the  project from https://github.com/cfaife/2ibi-countryinfo.git.
   
   `$ git clone https://github.com/cfaife/2ibi-countryinfo.git`
   
2. install maven and bulild project
   
   `$ mvn clean install`

3. Create a local docker image
   
   `$ docker  image build -t countryinfo .`
   
4. Run the container from local docker image
        
   `$ docker container run -d --rm  --name countryinfo -p 8081:8080 countryinfo`
        

##  Resource usage instructions

###    Base URI:  `/countries`
#### 1. Creating a country information    

    VERB: `POST`
    URI: `/countries`

This is the example of the request:

    $ curl --location --request POST 'http://localhost:8081/countries' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "name":"Mozambique",
        "capital":"Maputo",
        "region":"South of Africa",
        "subRegion":"Africa Austral",
        "area":"801590" 
        }'
The system does not allow duplicated names, otherwise 409 error is raised.

#### 2. Getting all countries information

An unsorted list of countries is returned.     

    VERB: `GET` 
    URI: `/countries`

e.g:
    
    $ curl --location --request GET 'http://localhost:8081/countries

#### 3. Getting all countries information ordering by the given field
For this you can specify the `order key` in the request param,
 the possible values are:
`name, capital, region, subregion` and `area`. So when the value is passed
in the request the API will order according the given field.

    VERB: `GET`
    URI: `/countries/order/<field to sort by>`

e.g.: ordering by name:

    $ curl --location --request GET 'http://localhost:8081/countries/order/name'

#### 4. Alter an existent country

    VERB: `PUT`
    URI: `/countries`

An example of the `put` request:

    $ curl --location --request PUT 'http://localhost:8081/countries' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "id":"1",
        "name":"Mozambique",
        "capital":"Maputo",
        "region":"South of Africa",
        "subRegion":"Africa Austral",
        "area":"801590"
    }'

Assuming that the data-raw exists in the database.

#### 5. Delete an existent country

    VERB: `DELETE`
    URI: `/countries/<country object identifier>`

Request param is the numeric `id` of the country 

e.g.: 

    $ curl --location --request DELETE 'http://localhost:8081/countries/1

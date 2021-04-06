# Countries Info API

## Context
 This is a Java based REST API that holds information of countries.
 
## Technologies used
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
   
    $docker run cfaife/countryinfo

###  Build and Deploy locally

####Follow the bellow instructions

    1. clone the  project from
        $ git clone 
    2. install maven and run in project directory
        $ mvn clean install
    3. Create a local docker image
        $  docker  image build -t countryinfo .
    4. Run the container
        $  docker container run -d --rm  --name countryinfo -p 8081:8080 countryinfo
        

##  Resource usage instructions

###    Base URI:  `/countries`
#### 1. Creating a country information    

    VERB: `POST`

This is the example of the request:

    $curl --location --request POST 'http://localhost:8081/countries' \
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

e.g:
    
    $ curl --location --request GET 'http://localhost:8081/countries

#### 3. Getting all countries information ordering by the given field
For this you can specify the `order key` in the request param,
 the possible values are:
`name, capital, region, subregion` and `area`. So when the value is passed
in the request the API will order according the given field.

    VERB: `GET` 

e.g.: ordering by name:

    curl --location --request GET 'http://localhost:8081/countries/order/name'

#### 4. Alter an existent country

    VERB: `PUT`

An example of the `put` request:

    curl --location --request PUT 'http://localhost:8081/countries' \
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

Request param is the numeric `id` of the country 

e.g.: 

    curl --location --request DELETE 'http://localhost:8081/countries/1

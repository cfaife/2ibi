# Countries Info REST API

## Context
 This is a Java based API that holds countries information.
 
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

###  Nativelly

##  Resource usage instructions

###    Base URI:  `/countries`
#### Creating a country information    
    POST:  

    {
        "name":"Mozambique",
        "capital":"Maputo",
        "region":"East of Africa",
        "subRegion":"Africa Austral",
        "area":"801590"
    
    }


#### Getting all countries information

     GET: 

# RobotApocalypse


Hello there my name is Nkwe Justice Mapoulo java developer from South Africa.

The following is the manual on how to run the project:



1. Clone the project
2. Run the Eureka Server (Port 8761)
3. Run the ConfigServer  (Port 8881)
4. Run the Gateway  (Port 9090)
5. Run the Survior Service
6. Run the RobotCPUInfo
7. Run the Location Service


Eureka Server is an application that holds the information about all client-service applications. 
Every Micro service will register into the Eureka server and Eureka server knows all the client applications running on each port and IP address.


Spring Cloud Config Server provides an HTTP resource-based API for external configuration (name-value pairs or equivalent YAML content). 
The server is embeddable in a Spring Boot application, by using the @EnableConfigServer annotation. I used it to centralize the common configurations. This is the link to 
the github file where my configurations are https://github.com/mapoulo/RobotApocalypseConfig


The API Gateway Service is a Spring Boot application that routes client requests to other services. Every request made from the client will come to the gateway first 
and that's where we usually do the authentication and other security related measures.


Survior Service:

      http://localhost:9090/api/survivor/save   is used to save a survivor using the post method e.g 	
  {
		"id": 7,
		"identificationNumber": 7777,
		"name": "Lyle",
		"gender": "Male",
		"age": 20,
		"infected": false
	}
  
  
  
  http://localhost:9090/api/survivor/saveResource  is used to save resource 
  
    {
			"haveWater": true,
		"haveFood": true,
		"haveMedication": true,
		"haveAmmunition": true,
		"id": 0,
		"identificationNumber": 88888
	
		}
    
    
    http://localhost:9090/api/survivor/update  is used to update a resource
    
    
    {
			"haveWater": true,
		"haveFood": true,
		"haveMedication": true,
		"haveAmmunition": true,
		"id": 0,
		"identificationNumber": 88888
	
		}
    
    http://localhost:9090/api/survivor/  is used to get all survivors
    
    http://localhost:9090/api/survivor/identificationNumber  is used to get a survior by Id
    
    http://localhost:9090/api/survivor/getPercentageOfInfectedPeople  Is used to get a percentage of in infected survivors
    
    http://localhost:9090/api/survivor/getPercentageOfNonInfectedPeople  used to get percentage of uninfected survivors
    
    http://localhost:9090/api/survivor/getNonInfectedSurviovor  used to get non infeted survivors
     
    http://localhost:9090/api/survivor/geInfectedSurviovor  used to get infected survivors
    
    
    RobotCPUInfo Service:
            
            
            http://localhost:9090/api/robot/ is used to get  all the robots
            
            http://localhost:9090/api/robot/land Is used to get only those that are on land
            
            http://localhost:9090/api/robot/flying Is used to get only those that are flying


Location Service:

http://localhost:9090/api/location/save  is used to save the location of the survivor. The identification number is the id of the survivor
 
 {
		"id": 1,
		"longitude": 12.44,
		"latitude": 42.9,
		"identificationNumber": 88888
	}
  
  
  http://localhost:9090/api/location/  Is used to get all locations
  
  http://localhost:9090/api/identificationNumber  Is used to get the location of a specific survivor
  
 http://localhost:9090/api/update Is used to update the location of the survivor
   

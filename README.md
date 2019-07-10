# Very Simple Java/Angular Application for Flight Scheduling Simulation act to study SpringBoot backend and frontend with Angular

The project is not a real usecase software but is to be understood as a very simple use study code.

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

# Back-end:
- Java8, 
- Spring Boot 
- JPA, 
- H2,
- Rest services 
- Lombok, 
- Spring Web. 
- Maven
# Front End
- Angular5
- Typescrip
- Material Design
- angular cli
- node-js (only for developmnet reason)

# Description
Designed and developed a simplified java simulation engine to emulate flight information system.
The simulation engine should:
-	Generates flights scheduling for the current day 
-	Evolves simulation using current time.
-	Flight will be identified by flight number and should include at least information regarding:
    -  Company
    - Source airport
    -	Destination Airport
    -	Flight status {scheduled, operating, cancelled}
    -	Scheduled time: is the time planned for arrival/departure
    -	Estimated time: is the time estimated for the flight arrival/departure it change in case of delay 
    -	Actual time: the effective arrival/departure time assigned when the flight arrives/depart
-	Flights information should be exposed over REST service 
-	A flight will be considered delayed when at least one of the following conditions is meet
o	actual time > scheduled time +15 minutes for already departed/arrived flights
o	 estimated time > scheduled time +15 minutes for not yet departed/arrived flights
From the web ui the user must be able to:
-	Add a company e.g. Alitalia, Ryanair ...
-	Set the number of departure/arrival flights planned for a given company
-	Modify simulation result by setting:
    -	The probability of flight to be delayed for a given company
    -	The probability of flight to be cancelled for a given company


# Cars-Service

Used :  Spring Boot REST API, Mongo DB

Features -
01: Using addCar one lists the cars.

02: When listing a particular car using addCar first check is done using the provided engineNo whether the car is already listed or not, 
if it is already listed it says “Car is already listed”. And if it’s not then check is done whether the Car model is listed or not, 
if it’s listed then the particular car is listed and the InStock count for that particular model will be increased by 1 in the inventory table and if it’s not, 
the car is listed and a new row is created for the model with InStock set to 1.

03: Using getCarsInfo one can get all the cars information form the cars table.

04: Using getCarByEngienNo one can get the car associated with that engineNo and if it’s not present it throws an CarNotFoundException.

05: Using getCarByMaker one can get the listed car(s) with that maker.

06: Using getCarByModel one can get the listed car(s) with that model.

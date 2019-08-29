# SB Components Motor-Shield Java API

Disclaimer : Not the offical API for this shield, the original is on python and in the link :  [Original API](https://github.com/sbcshop/MotorShield)
If you want the original manual go here : [Manual
](https://github.com/sbcshop/MotorShield/blob/master/Maker_Sphere_Manual.pdf)

![](https://cdn.shopify.com/s/files/1/1217/2104/products/motor_shield_a_720_660_1800x1800.png?v=1528533987)


## How it works 
 ```java
Motor m1 = Motors.MOTOR_1; // Get the motor Can be MOTOR_2 , MOTOR_3 or MOTOR_4  
  
m1.forward(100); //Tell the motor to go forward at the speed of 100% (Anything higher will be the same)  
m1.stop(); //Tell the motor to stop, it will set his speed to 0
m1.reverse(100); // Tell the motor to go in reverse at the speed of 100%  
  
m1.unBound(); //Unbound the motor, it will released all the pin and can be recreate to work
```
Here you have the basics of the API, you can create more complexe one : 
```java
Motor m1 = Motors.MOTOR_1;  
Motor m2 = Motors.MOTOR_2;  
Motor m3 = Motors.MOTOR_3;  
Motor m4 = Motors.MOTOR_4;  
//Create all motors  
  
LinkedMotors all = new LinkedMotors(m1, m2, m3, m4); // Create a list with all the motors  
  
all.forward(100); // Tell all motors to move forward at a speed of 100%  
all.stop(); //Tell all motors to stop, it will set their speed to 0  
all.reverse(100); // Tell all motors to go on reverse at a speed of 100%
```
or 
```java
Motor m1 = Motors.MOTOR_1;  
Motor m2 = Motors.MOTOR_2;  
Motor m3 = Motors.MOTOR_3;  
Motor m4 = Motors.MOTOR_4;  
//Create all motors  
  
InvertedMotors motorsList = new InvertedMotors();  
motorsList.addReverse(m2);  
motorsList.addReverse(m3);  
motorsList.addGoodWay(m1);  
motorsList.addGoodWay(m4);  
// Create a list with all the motors  
  
motorsList.forward(100); // Tell all motors m1 and m4 to go forward and tell m2 and m3 to go on reverse  
motorsList.stop(); //Tell all motors to stop, it will set their speed to 0  
motorsList.reverse(100); // Tell all motors m1 and m4 to go on reverse and tell m2 and m3 to go forward
```
The last exemple can be usefull if you have a 4 motor setup and all the motors cannot be on the same direction

## Installation : 
Gradle : 
```
repositories {  
  repositories {  
	jcenter()
    }
}

dependencies {     
  compile 'fr.pa1007:motorapi:1.0'
}
```
Maven : 
```maven
<repositories>  
	<repository>  
		<id>bintray-pa1007-Raspberry-Pi-Robots-API</id>  
		<url>https://dl.bintray.com/pa1007/Raspberry-Pi-Robots-API</url>  
	</repository>  
</repositories>  

    
<dependency>
  <groupId>fr.pa1007</groupId>
  <artifactId>motorapi</artifactId>
  <version>1.0</version>
</dependency>
```

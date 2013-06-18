Navigation Via Smartphone Vibration
========================================

This repository contains the two Android apps that I built for the OU course TM470 The computing 
and IT project. Both apps are heavily commented. This was due to me having to prove that I had an 
understanding of the code I was creating.
Download a PDF of the final report here: <https://dl.dropboxusercontent.com/u/17315310/TM470-EMA-Martin%20Thorne.pdf>

Description of project:
-------------------------------
The building of the two apps was done to test if it is possible to navigate a user only using a phones
vibration function. The phone would be in the users pocket and navigation would be achieved via 
vibration patterns. The advantages of this would be:

* Safety: When looking at the screen the user is paying less attention to the world around them. They 
could walk into others or possibly onto the road. 
* Risk of Theft: A modern up to date smartphone can cost over five hundred pounds. This makes 
them highly desirable to thieves. Someone using their phone for navigation would be considered an 
easy target as the phone is out, plus the user is not concentrating on the world around them. 

The first app: Vibration Pattern Test
---------------------------------------
This app was built to test out various vibration patterns. The vibration pattern would be built with 
the following elements:
* Vibration time in milliseconds
* Gap time in milliseconds
* Number of vibrations in a pattern
* Gap between vibrations in milliseconds

[![ScreenShot](https://dl.dropboxusercontent.com/u/17315310/app%201.jpg)](https://dl.dropboxusercontent.com/u/17315310/app%201.jpg)

The second app: Navigation Vibration App
------------------------------------------
This app displayed a map, the users position, and markers that showed the proximity alerts. As a 
user entered a proximity alert the phone would start vibrating in a particular pattern. A message would 
also come up that indicated direction, plus how close to a turn the user is (the test was mainly added 
to show evidence of the app working to the project marker). When the user exited the proximity alert the 
vibration pattern would stop.  After testing various vibration patterns with the first app I used the 
following patterns in this app:

Right Turn:
* Vibration and gap length: 250 milliseconds
* Number of vibrations in a pattern: 2
* Gap between vibration patterns:
* Turn next: 500 milliseconds
* Turn imminent: 1000 milliseconds
* Turn coming up: 2000 milliseconds

Left Turn:
* Vibration and gap length: 250 milliseconds
* Number of vibrations in a pattern: 4
* Gap between vibration patterns:
* Turn next: 500 milliseconds
* Turn imminent: 1000 milliseconds
* Turn coming up: 2000 milliseconds

[![ScreenShot](https://dl.dropboxusercontent.com/u/17315310/app%202.1.jpg)](https://dl.dropboxusercontent.com/u/17315310/app%202.1.jpg)
[![ScreenShot](https://dl.dropboxusercontent.com/u/17315310/app%202.2.jpg)](https://dl.dropboxusercontent.com/u/17315310/app%202.2.jpg)
----------------------------------------------------------------------------
If you attempt to run this app please keep in mind the following:
* Read the NOTE below.
* The app uses Google maps API and so needs a key to display a map properly. I have removed my key (it no 
longer works for me). If you wish to put in your own key please note that the new V2 API key will not work, 
it needs to be V1 only. You may still run the app without a keybut only grid lines will show.
* The map will display your current position. This will probably mean that you will not see the markers for the 
proximity alerts. Zooming out you should see red marks around Bristol. Zoom in again to see the layout of 
the markers.
* The markers/proximity alerts position is defined in code. If you wish to change these then you will have to 
rewrite some of the code in the NavigationMain.java class.
* The app only works when the screen is on.
* Vibrations may still continue, plus the phones GPS may still be on, after the app is closed. After finishing 
with app restart your phone.

__NOTE__: Both of these apps were built only for the OU project. They are in no way meant to be final products.  
They were only meant to be used by me and volunteers used to test the Navigation Vibration App with my phone. 
If you choose to try out either app you do so at your own risk.

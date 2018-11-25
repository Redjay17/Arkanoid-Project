# Arkanoid-Project
Ignore the java files scattered in the main directory. I can't figure out how to delete them.
Only look at the folders.


Folder a1_MVC: the controller will be the main method. Window class is the actual view, not View class.
Do not run the main method in Window, or else you will only get a window.
GamePlay is just where I'm getting the physics from, since it's from the old implementation of the game. 

Controller feeds information to view from model by passing an array of Rect objects to it. Those Rect objects are drawn. 

Folder working_but_without_MVC: it is what it says. It's a mostly working version of the game but without the MVC pattern.


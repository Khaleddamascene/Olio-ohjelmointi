Assignment: A virtual pet
Your task is to create an application where the user walks a virtual pet. The pet is represented by an icon that moves around the canvas. Whenever the user moves the mouse over the canvas, the pet starts moving towards the mouse cursor. Once the pet has reached the mouse cursor, it stops moving. The pet also stops moving if the user moves the mouse cursor outside the canvas.

You get points for this assignment based on the following criteria (PLEASE NOTE! You need to inform in your answer what of the following items (1–5) you have done, otherwise you will not get points for the assignment):

A cute pet image is displayed on the canvas (1 point). You can use any small image you like.
The pet moves towards the mouse cursor when the mouse is moved over the canvas (+ 1 point)
The pet stops moving when it reaches the mouse cursor (+ 1 point)
The pet stops moving when the mouse cursor is moved outside the canvas (+ 1 point)
The program follows the MVC pattern (+ 2 points). The model consists of the Pet class that stores the pet's location. The controller class contains the method for updating the pet's location. The view class contains the canvas and draws the pet on the canvas.
Hints:

Use the Image class for loading the pet image.
Can you calculate the movements of the pet in such a way that the pet moves directly towards the mouse cursor? This involves some interesting trigonometry.
Find a way to limit the speed of the pet so that it does not move too fast.

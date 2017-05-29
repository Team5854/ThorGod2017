# RoboCodeTemplate
This is a template for all future robot comp-season programming.

Usage:
- Encoders need to be wired to talan 1 (front left) and 3 (front right).
- Wiring Layout for easy coding:
	- 1 (front left)
	- 2 (read left)
	- 3 (front right)
	- 4 (rear right)
	- 5 (front left 2)
	- 6 (read left 2)
	- 7 (front right 2)
	- 8 (rear right 2)
- Each function (Auto, Teleop...) has their own class.
- RobotState object in global variables holds the robot's state (teleop, Auto).
- GlobalVariables class holds variables that should be accesed from all classes.


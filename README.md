# vacuum-cleaner
This is a Java program that implements a simulator for a vacuum cleaner.
This was a homework assignment for CSE 486 - Introduction to Artificial Intelligence.

### The specifications of the vacuum cleaner are:
* The performance measure awards one point for each square that is clean at the end of each time step. Thus, the maximum possible performance is 8000.
* The agent correctly perceives its location.
* The agent’s perception of a square’s dirtiness (at any time step) is noisy. That is, P% of the time, the agent’s view of a square’s dirtiness is correct. That is a clean square is thought to be dirty and a dirty square is thought to be clean.
* The suck action works S% of the time. That is, a dirty square can remain dirty, even after suction has been applied.
* At the beginning of each time step, each square has a 20% chance of getting dirt on it. An agent could be able to perceive the dirt and suck in the same time step.
* An agent is able to suck or move in one time step, but not both.

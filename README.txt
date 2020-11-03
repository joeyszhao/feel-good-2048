=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 120 Game Project README
PennKey: joeyzhao
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

===================
=: Core Concepts :=
===================

- List the four core concepts, the features they implement, and why each feature
  is an appropriate use of the concept. Incorporate the feedback you got after
  submitting your proposal.

  1. 2-D array: I modeled the board using a 2-D array and it is an appropriate use of the 
  	 concept because 2048 is a board game on a 4 by 4 board so the most convenient way would 
  	 be to model the 4 by 4 board using a 2-D array. 

  2. JUnit testing: I used JUnit testing to test the functionality of my methods in my board
     class which is essentially where I code my game logic for 2048. I also created methods 
     such as addSpecificTile and addSpecificRanTile for testing purposes so I could add a 
     specific tile where I would like and then test the win and lose methods that check if
     they are properly changing the game state as well as to check if score is adding right.

  3. File I/O: I used file I/O to implement my save and resume game buttons. The save button 
     essentially saves the state of the current game by writing the values of all the tiles 
     into a file and the resume button essentially restores the board to the state that was 
     saved by reading from the file. This essentially acts as an undo button as it allows
     the player to play from the last saved state without compromising the score. Initially 
     I was planning on using file I/O to create a score board that recorded the scores in 
     sorted order and display the top three high scores but I changed my mind.

  4. Collections: I used collections to produce a certain message corresponding to a certain score 
 	 reached. More specifically, I used a map model this function, but using the target scores as 
 	 the keys such that if the current score is equal to one of the target scores in the map
 	 a message such as "Beep! Level 1!" will display on the bottom of the screen. In addition, if 
 	 a certain score such as 5260 or 830 is reached, a special message will appear on the screen.
 	 I used a map to store these target scores because I thought it made the most sense and was 
 	 the best way to keep track of the level target scores and special message target scores.


=========================
=: Your Implementation :=
=========================

- Provide an overview of each of the classes in your code, and what their
  function is in the overall game.
	
	Board: my board class essentially stores the game logic of my game with essential methods
	such as slide up, slide down, slide right, and slide left and within these methods the 
	corresponding merges. In addition my board class keeps count of the score when tiles merge.
	It also keeps count of the game state by checking for when the game is won or lost. 
	
	Tile: my tile class creates a tile object that essentially stores an integer and reads the 
	image file of the tile image corresponding to the value the tile stores.
	
	GameBoard: my gameboard class does some of the gui in that it paints the actual board and 
	the tiles as well as the score. It also performs the corresponding keyboard actions when 
	it is clicked and redraws the board with the reset method. The class also has save and 
	resume methods which calls the appropriate methods in the board class to save the current
	state of the game into a file and restore it when the resume button is clicked.
	
	Game2048: my game2048 class does the remaining gui which includes creating the window
	for the game and the instructions as well as the buttons that with a mouseclick will 
	react according such as if the save button is pressed the save method in gameboard will be 
	called and the current state of the board will be written into a file.
	
	BoardTest: my boardtest class tests methods that implement my game logic present in my board 
	class. Some I used print statements to visualize that certain functionalities work such as 
	slide up and slide down. Others I used assertequal to check that the scores are counted right
	and for these I used helper functions in my board class to insert tiles where I want instead of
	have them randomly generate like in the game.

- Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?

	Yes, I would say that getting started was the hardest part, since 2048 is a board game,
	I was really stuck on what code I could make use of from the provided starter code as well
	as where exactly to start. There seemed to be so to have to be implemented and it was 
	really overwhelming to find a starting point. Once I coded my game logic, I got really stuck
	on how exactly to connected the gui to the game logic, like how to get the board to represent
	the 2-D tile array that I have in my board class and how to have the tile images to move
	the way I coded my game logic in the 2-D tile array. 

- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?
	
	I would say that my design has a fairly good separation of functionality since my classes 
	acted as layers which in a way helped encapsulate the private state. More specifically,
	only my board class called methods from my tile class, only my gameboard class called methods
	from my board class, and only my game2048 class called methods from my gameboard class. In 
	addition, I made all the fields and helper methods within my individual classes private
	in order to encapsulate the state so that one would not be able to directly change the internal
	state. 


========================
=: External Resources :=
========================

- Cite any external resources (libraries, images, tutorials, etc.) that you may
  have used while implementing your game.
  
  I used images of the empty board and of the numbered and empty tiles found through google.

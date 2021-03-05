How to Run the program:
Use command for full functionality: 
Compile :   javac -cp .:json-20200518.jar crytoGraph.java
RUN:	
Interactive mode: java -Xss4m -cp .:json-20200518.jar cryptoGraph -i
Report Mode: java -cp .:json-20200518.jar cryptoGraph -r assetdata.json tradedata.json

Note: For use of json files, program should be run with -cp .:json-20200518.jar command.
Note 2: For use of serialisation of the data, program should be runt with -Xss4m command.



Class descriptions:
cryptoGraph: contains main method. Run this for the program.
fileIO: Handles serialisation/deserialisation of the data.
ParseJson: handles reading data from json files.
UserInterface: Handles user input and exceptions
DSAGraph: Contains graph ADT and its methods
DSAGraphVertex: Contains vertices of the graph, stores asset information.
DSAGraphEdge: Contains edges of the graph, stores trade path information.
DSALinkedList: Contains double ended doubly linked list ADT.
DSAQueue: Contains linked list with queue behaviour methods.
DSAStack: Contains linked list with stack behaviour methods.
UnitTestX: Contains related test for every class in their name.

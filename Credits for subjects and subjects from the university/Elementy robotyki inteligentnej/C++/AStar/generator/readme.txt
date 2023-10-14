**************************************************************
* The A star algorithm - path finding in the grid square map *
*                                                            *
*             author: Piotr Barbarski                        *
*                                                            *
*    description in Polish is in the opis.txt file          *
*                                                            *
**************************************************************

Description:

The program has been written in the Java language. It marks optimum path from start to end point in the grid square map, using A star algorithm. Used heuristics is Euclidean metric. The only allowed movement directions are: up, down, left, right. Fields are visited in the same order. Possible conflicts are arbitrated by selection last visited field. The user can generate map of barriers from within the program, using the external generator. Barriers, start and end points can also be established using a mouse. In addition, this program offers possibility to change default costs for each of movement directions.


*Instruction*

To run the program, please click on Astar.jar

Settings panel description:

> Actions panel - button panel calling specified actions

- Generate grid.txt file - generates grid.txt file using included map_generator.exe program (the map_generator.exe must be placed inside the same directory as Astar.jar) and load generated map of barriers

- Edit grid.txt file - opens to edit grid.txt file (if the file exists) in default editor e.g. notepad

- Load grid.txt file - load map of barriers from grid.txt file (if the file exists)

- Clear map - clears map and sets default start and end points

- Find path - finds path from start to end, in addition, map of search results is written to result_grid.txt file, where found path is marked by the number 3

> Edit mode panel - panel of editing mode selection for the visible map

- None - no mode is active

- Set barriers - mode of adding/removing barriers

- Set start field - mode of defining start field 

- Set end field - mode of defining end field 

> Panel Movement costs - panel of defining costs for the particular movement directions

- UP - defining cost for upward movement

- DOWN - defining cost for downward movement

- LEFT - defining cost for movement in the left

- RIGHT -defining cost for movement in the right
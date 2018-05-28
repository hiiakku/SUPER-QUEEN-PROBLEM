# SUPER-QUEEN-PROBLEM
Secure The Palace using Super Queens
There is a King paranoid about safety of his grand palace divided in a number of rooms . 
The king place guards whose armor afford them a very peculiar field of vision- combined move of a chess knight and queen.

# Project Structure
It is build with JAVA and Algorithm concepts. 
Contains a solution building algorithm which makes use of concepts of multithreading in JAVA.

# Problem Statement
Once upon a time there was a King who was really paranoid about the safety of his grand palace. The map of the palace can be described by a matrix with N rows and M columns. Each cell of the matrix encodes either a wall, or free space, where trophies, jewellery and precious fur can be stored.
During the last replanning of the palace, it was divided into a number of rooms, each of which has a rectangular shape on the palace map and is separated from other rooms via walls. There is also a big outer wall surrounding the whole palace which is not indicated on the map.
The King is, however, still not satisfied with the safety of his palace. In order to make it even more safe, he plans to place guards at some of the free spaces in the palace.
The palace guards' armour affords them a very peculiar field of vision. A guard can see only what happens at the cells that are reachable from his position via either one move of a chess knight, or one move of a chess queen. Moreover, a guard can't see what happens in other rooms. Even if a particular cell is reachable from a guard's position, but is placed in another room, the guard can't see it.
The guards are instructed to attack anyone they see immediately; so if two guards see each other, they will collapse. That's why it is forbidden to place two guards in such a way that one can see the other.
The King wants to place as much guards as possible to protect his assets. Please found this maximal number and find any correct placement of guards in the palace so that no guard sees another one.


# How to Use
1.Edit twodmatrix.java file.
  In main method make object with the dimensions you need.
  
2.Input the matrix with '.' and '#' as the possible value of each cell.
  '.' denotes vacant
  '#' denotes brick
*Some sample test cases are provided in cases.txt file 

3.Now try to place maximum guards in each room so that no guard can see other guards placed in the same room.

4.You can edit your placings by clicking and deselecting the placed guard.

5.For solution click on any brick.


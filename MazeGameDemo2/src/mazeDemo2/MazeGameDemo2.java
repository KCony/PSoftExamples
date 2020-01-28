package mazeDemo2;

import java.util.HashSet;

enum Direction {NORTH, SOUTH, EAST, WEST};

class Maze {
	private HashSet<Room> rooms;

	Maze() {
		rooms = new HashSet<Room>();
		System.out.println("Maze()");
	}

	void addRoom(Room room) {
		rooms.add(room);
	}
}

class Room {
	private final int roomId;

	Room(int roomId) {
		System.out.println("Room(" + roomId + ")");
		this.roomId = roomId;
	}

	void setSide(Direction d, Wall w) {
		System.out.println("Side");
	}

	void setSide(Direction d, Door door) {
		System.out.println("Side");
	}
}


class Door {
	private final Room room1;
	private final Room room2;

	Door(Room room1, Room room2) {
		System.out.println("Door");
		this.room1 = room1;
		this.room2 = room2;
	}
}

class Wall {
	Wall() {
		System.out.println("Wall");
	}
}

/**
 * Direction.
 */
	class MazeGame {
		// Create the maze.
	
		public Maze makeMaze() {return new Maze();}
		public Room makeRoom(int n) {return new Room(n);}
		public Wall makeWall() {return new Wall();}
		public Door makeDoor(Room r1, Room r2)
			{return new Door(r1, r2);}	
	
		public Maze createMaze() {
		    Maze maze = this.makeMaze();
		    Room r1 = this.makeRoom(1);
		    Room r2 = this.makeRoom(2);
		    Door door = this.makeDoor(r1, r2);
		    		
			maze.addRoom(r1);
			maze.addRoom(r2);
			r1.setSide(Direction.NORTH, new Wall());
			r1.setSide(Direction.EAST, door);
			r1.setSide(Direction.SOUTH, new Wall());
			r1.setSide(Direction.WEST, new Wall());
			r2.setSide(Direction.NORTH, new Wall());
			r2.setSide(Direction.EAST, new Wall());
			r2.setSide(Direction.SOUTH, new Wall());
			r2.setSide(Direction.WEST, door);
			return maze;
		}
	}

public class MazeGameDemo2 {

	public static void main(String[] args) {
		MazeGame mg = new MazeGame();
		mg.createMaze();
	}

}

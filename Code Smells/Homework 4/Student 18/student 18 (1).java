import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * Author: Zabdiel Hernandez
 * 
 * 
 * 
**/



public class Board {
	private char[][] board;
	private int Size;
	
	public Board() {
		this.Size = 15;
		this.board = new char[Size][Size];
		for(int i = 0; i < Size; i++) {
			for(int j = 0; j < Size; j++) {
				this.board[i][j] = '.';
			}
		}
	}
	public boolean hasValues() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] != '.') {
					return true;
				}
			}
		}
		return false;
	}
	public Board(int a) {
		this.Size = a;
		this.board = new char[Size][Size];
		for(int i = 0; i < Size; i++) {
			for(int j = 0; j < Size; j++) {
				this.board[i][j] = '.';
			}
		}
	}
	
	public void clear() {
		for(int i = 0; i < Size; i++) {
			for(int j = 0; j < Size; j++) {
				this.board[i][j] = '.';
			}
		}
	}
	
	public boolean isFull() {
		for(int i = 0; i < Size; i++) {
			for(int j = 0; j < Size; j++) {
				if(this.board[i][j] == '.') {
					return false;
				}
			}
		}
		return true;
	}
	
	public char[][] getBoard() {
		return this.board;
	}
	
	public void placeStone(int x, int y, Player p) {
		board[x][y] = p.getSymbol();
	}
	
	public void resetMoveBoard(int x, int y, char c) {
		board[x][y] = c;
	}
	
	public boolean isEmpty(int x, int y) {
		if(this.board[x][y] == '.') {
			return true;
		}
		return false;
	}
	
	public boolean isOccupied(int x, int y) {
		if(isEmpty(x,y)) {
			return false;
		}
		return true;
	}
	
	public Object playerAt(int x, int y) {
		if(this.isEmpty(x, y)) {
			return null;
		}
		return this.board[x][y];
	}
	
	public boolean isWonBy(Player p) {
		for(int i = 0; i < Size; i++) {
			for(int j = 0; j < Size; j++) {
				if(this.Won(p, i, j)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void printBoard() {
		System.out.print("Y  ");
		for (int i = 0; i < this.board.length; i++) {
			System.out.print(" "+i);
			if(i < 10) {
				System.out.print(" ");
				
			}
		}
		System.out.println("<");
		
		System.out.println("X");
		for (int i = 0; i < this.board[0].length; i++) {
			String temp = "";
			if (i < 10) {
				temp += " ";
			}
			for (int k = 0; k < this.board[i].length;k++) {
				
				temp+=" ";
				
				temp += this.board[i][k]+ " ";
			}
			System.out.println(i+" "+temp);
		}
	}
	
	public char getCharAtXY(int x, int y) {
		return board[x][y];
	}

	public boolean Won(Player p, int x, int y) {
		char c = p.getSymbol();
		if(verticalWin(c,x,y)) {
			return true;
		}
		if(horizontalWin(c,x,y)) {
			return true;
		}
		if(leftToRightSlashWin(c,x,y)) {
			return true;
		}
		if(rightToLeftSlashWin(c,x,y)) {
			return true;
		}
		return false;
	}
	
	private boolean verticalWin(char c, int x, int y) {
		int tempX = x-1;
		
		while (tempX >= 0 && this.board[tempX][y] == c) {
			tempX -=1;
		}
		tempX+=1;
		int count = 0;
		while(tempX < this.Size && this.board[tempX][y] == c) {
			count+=1;
			tempX++;
			if (count >= 5) {
				return true;
			}
		}
		return false;
	}
	
	private boolean horizontalWin(char c, int x, int y) {
		int tempY = y-1;
		
		while (tempY >= 0 && this.board[x][tempY] == c) {
			tempY -=1;
		}
		tempY+=1;
		int count = 0;
		while(tempY < this.Size && this.board[x][tempY] == c) {
			count+=1;
			tempY++;
			if (count >= 5) {
				return true;
			}
		}
		return false;
	}
	
	private boolean leftToRightSlashWin(char c, int x, int y) {
		int tempX = x-1;
		int tempY = y-1;
		while (tempY >= 0 && tempX >= 0 && this.board[tempX][tempY] == c) {
			tempY -=1;
			tempX -=1;
		}
		tempX++;
		tempY++;
		int count = 0;
		while(tempX < this.Size && tempY < this.Size && this.board[tempX][tempY] == c) {
			count+=1;
			tempX++;
			tempY++;
			if(count >=5) {
				return true;
			}
		}
		return false;
	}
	
	private boolean rightToLeftSlashWin(char c, int x, int y) {
		int tempX = x-1;
		int tempY = y+1;
		while (tempY < this.Size && tempX >= 0 && this.board[tempX][tempY] == c) {
			tempY +=1;
			tempX -=1;
		}
		tempX++;
		tempY--;
		int count = 0;
		while(tempX < this.Size && tempY >= 0 && tempX>=0 &&tempY<this.Size && this.board[tempX][tempY] == c) {
			count+=1;
			tempX++;
			tempY--;
			if(count >=5) {
				return true;
			}
		}
		return false;
	}
	
	public int size() {
		// TODO Auto-generated method stub
		return this.Size;
	}
	
	public List<Place> winningRow(){
		List<Place> lst= new ArrayList<Place>();
		for(int i = 0; i < this.Size; i++) {
			for(int j = 0; j < this.Size; i++) {
				if(this.board[i][j] != '.') {
					if(Won(new Player(this.board[i][j]), i, j)) {
						return rowReturner(i,j,this.board[i][j]);
					}
				}
			}
		}
		return lst;
	}
	
	private List<Place> rowReturner(int x, int y, char c) {
		List<Place> lst = new ArrayList<Place>();
		if(verticalWin(c, x, y)) {
			while (x<this.Size && y < this.Size && this.board[x][y] == 'c') {
				lst.add(Place(x,y));
				x +=1;
			}
			return lst;
		}
		if(horizontalWin(c,x,y)) {
			while(y < this.Size && this.board[x][y] == c) {
				lst.add(Place(x,y));
				y+=1;
			}
			return lst;
		}
		if(leftToRightSlashWin(c,x,y)) {
			while(x < this.Size && y < this.Size && this.board[x][y] == c) {
				lst.add(Place(x,y));
				x+=1;
				y+=1;
			}
			return lst;
		}
		if(rightToLeftSlashWin(c,x,y)) {
			while (y < this.Size && x >= 0 && this.board[x][y] == c) {
				y +=1;
				x -=1;
			}
			x+=1;
			y-=1;
			while(x < this.Size && y >= 0 && x>=0 && y<this.Size && this.board[x][y] == c) {
				lst.add(Place(x,y));
				x++;
				y--;
			}
			return lst;
		}
		return null;
	}

	private Place Place(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

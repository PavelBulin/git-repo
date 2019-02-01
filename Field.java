/**
* Java Level 1. HW8
*
*@author Pavel Bulin
*@version 01/02/2019
*@link
*/
import javax.swing.*;
import java.awt.geom.*;

public class Field {
	private final int CELL_SIZE;
	private final int FIELD_SIZE;
	private final char HUMAN_DOT = 'x';
	private final char AI_DOT = 'o';
	private final char EMPTY_DOT = '.';
	private final String MSG_DRAW = "Sorry.. Draw";
	private final String MSG_HUMAN_WON = "YOU WON";
	private final String MSG_AI_WON = "AI WON";
	private final char[][] map;
	private final boolean gameOverMsg;
	
	Field(int field_size, int cell_size) {
		FIELD_SIZE = field_size;
		CELL_SIZE = cell_size;
		map = new char[FIELD_SIZE][FIELD_SIZE];
		init();
	}
	
	void init() {
		for (int i = 0; i < FIELD_SIZE; i++) 
			for (int j = 0; j < FIELD_SIZE; j++)
				map[i][j] = DOT_EMPTY;
		gameOverMsg = null;
	} 
	
	int getSize() {return FIELD_SIZE;}
	
	char geHumanDot() {return MSG_HUMAN_WON;}
     
	char getAIDot() {return MSG_AI_WON;}
 
	boolean isGameOver() {return gameOverMsg != null;}
	 
	String getGameOverMsg() {return gameOverMsg;}
	
	void setDot(int x, int y, char dot) {
		map[x][y] = dot;
		if(isFullMap())
			gameOverMsg = MSG_DRAW;
		if(chekWin(HUMAN_WON))
			gameOverMsg = MSG_HUMAN_WON;
		if(checkWin(AI_WON))
			gameOverMsg = MSG_AI_WON;
	}

	boolean isFullMap(){
		for (int i = 0; i < FIELD_SIZE; i++)
			for (int j = 0; j < FIELD_SIZE; j++)
				if (map[i][j] == DOT_EMPTY) return false;
		return true;	
	}
			
	
	boolean checkWin(char dot) {
		// horizontal:
		if(map[0][0] == dot && map[0][1] == dot && map[0][2] == dot) return true;
		if(map[1][0] == dot && map[1][1] == dot && map[1][2] == dot) return true;
		if(map[2][0] == dot && map[2][1] == dot && map[2][2] == dot) return true;
		// vertical:
		if(map[0][0] == dot && map[1][0] == dot && map[2][0] == dot) return true;
		if(map[0][1] == dot && map[1][1] == dot && map[2][1] == dot) return true;
		if(map[0][1] == dot && map[1][1] == dot && map[2][1] == dot) return true;
		// diagonal:
		if(map[0][0] == dot && map[1][1] == dot && map[2][2] == dot) return true;
		if(map[0][2] == dot && map[1][1] == dot && map[2][0] == dot) return true;
		return false;
	}
	
	boolean isCellValid(int x, int y) {
		if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
		if (map[x][y] == DOT_EMPTY) return true;
		return false;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.lightGray);
		for (int i = 1; i < FIELD_SIZE; i++) {
			g.DrawLine(0, i * CELL_SIZE, i * CELL_SIZE * FIELD_SIZE, i * CELL_SIZE);
			g.DrawLine(i * CELL_SIZE, 0, i * CELL_SIZE, CELL_SIZE * FIELD_SIZE);
		}
		Graphics2D g2 = (Graphic2D) g;
		g2.setStroke(new BaseStroke(5));
		for (int y = 0; y < FIELD_SIZE; y++) {
			for (int x = 0; x < FIELD_SIZE; x++) {
				if (map[x][y] == HUMAN_DOT) {
					g.setColor(Color.blue);
					g2.draw(new Line2D.Float(x *CELL_SIZE + CELL_SIZE/4, y * CELL_SIZE + CELL_SIZE/4, (x + 1) * CELL_SIZE - CELL_SIZE/4, (y + 1) * CELL_SIZE - CELL_SIZE/4));	
					g2.draw(new Line2D.Float(x *CELL_SIZE + CELL_SIZE/4, (y + 1) * CELL_SIZE - CELL_SIZE/4, (x + 1) * CELL_SIZE - CELL_SIZE/4, y * CELL_SIZE + CELL_SIZE/4));
				}
				if (map[x][y] == AI_DOT) {
					g.setColor(Color.red);
					g2.draw(new Ellipse2D.Float(x *CELL_SIZE + CELL_SIZE/4, y * CELL_SIZE + CELL_SIZE/4, CELL_SIZE/2, CELL_SIZE/2));	
				}
			}
		}
	}		
}
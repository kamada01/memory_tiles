import java.awt.Color;
import java.util.Random;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class main_game extends JPanel {
	
	//dimension of the grid
	private int size;
	
	//number of tiles
	private int no_tiles;
	
	//grid dimension UI
	private int dimension;
	
	//foreground color;
	private static final Color FOREGROUND_COLOR = new Color(1, 0, 0);
	
	//random object to generate pattern
	private static final Random RANDOM = new Random();
	
	//Array of tiles
	private int[] tiles;
	
	//size of tile UI
	private int sz_tile;
	
	//grid UI size
	private int margin;
	
	//true if game's over, false otherwise
	private boolean gameOver;
	
	//size of grid
	private int sz_grid;
	
	//tracks number of matched pairs
	private int pairs;
	
	//tracks number of moves
	private int moves;
	
	public main_game(int size, int dimension, int margin) {
		this.size = size;
		this.dimension = dimension;
		this.margin = margin;
		
		//initialize tiles
		no_tiles = size * size;
		tiles = new int[size * size];
				
		//calculate grid and tile sizes
		sz_grid = (dimension - 2 * margin);
		sz_tile = sz_grid / size;
				
		setPreferredSize(new Dimension(dimension, dimension + margin));
		setBackground(Color.WHITE);
		setForeground(FOREGROUND_COLOR);
		setFont(new Font("SansSerif", Font.BOLD, 60));
		
		gameOver = true;
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		
		newGame();
	}
	
	private void newGame() {
		do {
			reset();
		} while (pairs != 8);
		gameOver = false;
	}
	
	private void reset(){
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = (i + 1) % tiles.length;
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("MEMORY TILES");
		frame.setResizable(false);
		frame.add(new main_game(4, 550, 30));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
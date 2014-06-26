package npuzzle;

import java.util.Stack;
import search.Node;

public class TilesPrinting implements search.Printing {
	public void printSolution(Node solution) {
		if (solution == null)
			System.out.println("No solution found!");
		else {
			Stack<Node> stack = new Stack<Node>();
			Node node = solution;
			while (node != null) {
				stack.push(node);
				node = node.parent;
			}
			int stepNo = 0;
			while (!stack.isEmpty()) {
				node = stack.pop();
				System.out.print(stepNo++);
				if (node.parent == null)
					System.out.println(": start");
				else {
					System.out.print(": ");
					print((Movement) node.action);
					System.out.println();
				}
				System.out.println();
				print((Tiles) node.state);
				System.out.println();
			}
		}
	}
	public void print(Movement movement) {
		System.out.print(movement.name());
	}
	public void print(Tiles tiles) {
		int width = tiles.getWidth();
		int cellLength = String.valueOf(width * width).length();
		System.out.print('-');
		for (int column = 0; column < width; column++)
			printChar('-', cellLength + 3);
		System.out.println();
		for (int row = 0; row < width; row++) {
			System.out.print('|');
			for (int column = 0; column < width; column++) {
				System.out.print(' ');
				if (row == tiles.getEmptyTileRow() && column == tiles.getEmptyTileColumn())
					printChar(' ', cellLength);
				else {
					String cell = String.valueOf(tiles.getTile(row, column));
					printChar(' ', cellLength - cell.length());
					System.out.print(cell);
				}
				System.out.print(" |");
			}
			System.out.println();
			System.out.print('-');
			for (int column = 0; column < width; column++)
				printChar('-', cellLength + 3);
			System.out.println();
		}
	}
	protected static void printChar(char c, int number) {
		for (int index = 0; index < number; index++)
			System.out.print(c);
	}
}

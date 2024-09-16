package gui;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import domain.Piece;
import domain.Square;
import domain.Board;

public class GameBoardUtil {
    
	public static Dimension calculateDimension(int i) {
		i = i - 4;
		int shortSide = i / 4;
		int longSide = (i - (shortSide * 2)) / 2;
		return new Dimension(longSide, shortSide);
	}
	
	public static List<Piece> getEastCells(Board board) {
		Dimension d = calculateDimension(board.getSquareNumber());
		int longSide = d.width;
		int shortSide = d.height;
		List<Piece> cells = new ArrayList<Piece>();
		for(int i = board.getCellNumber() - shortSide; i <= board.getSquareNumber() - 1; i++) {
			cells.add(board.getSquare(i));
		}
		return cells;
	}
	
	public static List getNorthCells(Board board) {
		Dimension d = calculateDimension(board.getSquareNumber());
		int longSide = d.width;
		int shortSide = d.height;
		List cells = new ArrayList();
		for(int i = longSide + 2 + shortSide; i <= longSide + 2 + shortSide + longSide + 1; i++) {
			cells.add(board.getSquare(i));
		}
		return cells;
	}
	
	public static List getSouthCells(Board board) {
		Dimension d = calculateDimension(board.getSquareNumber());
		int longSide = d.width;
		int shortSide = d.height;
		List cells = new ArrayList();
		for(int i = longSide + 1; i >= 0; i--) {
			cells.add(board.getSquare(i));
		}
		return cells;
	}
	
	public static List getWestCells(Board board) {
		Dimension d = calculateDimension(board.getSquareNumber());
		int longSide = d.width;
		int shortSide = d.height;
		List cells = new ArrayList();
		for(int i = longSide + 1 + shortSide; i > longSide + 1; i--) {
			cells.add(board.getSquare(i));
		}
		return cells;
	}
}

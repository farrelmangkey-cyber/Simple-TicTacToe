public class GameBoard {
    private char[] cells;

    public GameBoard() {
        cells = new char[9];
        reset();
    }

    public void reset() {
        for (int i = 0; i < cells.length; i++) {
            cells[i] = ' ';
        }
    }

    public char getCell(int index) {
        return cells[index];
    }

    public void setCell(int index, char symbol) {
        cells[index] = symbol;
    }

    public boolean isEmpty(int index) {
        return cells[index] == ' ';
    }

    public char[] getCells() {
        return cells;
    }
}
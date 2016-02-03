package hanoi;

/**
 * A {@link ArrayBasedHanoiBoard} is a simple implementation of
 * {@link HanoiBoard}
 * 
 * @author jcollard
 * 
 */
public class ArrayBasedHanoiBoard implements HanoiBoard {
	/**
	 * Creates a {@link ArrayBasedHanoiBoard} with three empty {@link HanoiPeg}s
	 * and {@code n} rings on peg 0.
	 */
	StackBasedHanoiPeg[] board;
	public ArrayBasedHanoiBoard(int n) {
		
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		
		board = new StackBasedHanoiPeg[3];
		board[0] = new StackBasedHanoiPeg();
		board[1] = new StackBasedHanoiPeg();
		board[2] = new StackBasedHanoiPeg();
		for (int i = n; i > 0; i--) {
			board[0].addRing(new HanoiRing(i));
		}
	}

	@Override
	public void doMove(HanoiMove move) throws IllegalHanoiMoveException {
		if (!isLegalMove(move)) {
			throw new IllegalHanoiMoveException("Could not perform illegal move.");
		}
		HanoiRing temp = board[move.getFromPeg()].remove();
		board[move.getToPeg()].addRing(temp);
	}

	@Override
	public boolean isSolved() {
		System.out.println(!board[0].hasRings() + " " + !board[0].hasRings());
		return !board[0].hasRings() && !board[1].hasRings();
	}

	@Override
	public boolean isLegalMove(HanoiMove move) {
		if (move == null) {
			throw new NullPointerException();
		}
		if (!board[move.getFromPeg()].hasRings()) {
			return false;
		}
		if (!board[move.getToPeg()].hasRings()) {
			return true;
		}
		if (move.getToPeg() == move.getFromPeg()) {
			return false;
		}
		if (board[move.getFromPeg()].getTopRing().getSize() > board[move.getToPeg()].getTopRing().getSize()) {
			return false;
		}
		
		return true;
	}
}

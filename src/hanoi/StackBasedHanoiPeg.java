package hanoi;

import structures.LinkedStack;
import hanoi.IllegalHanoiMoveException;

/**
 * A {@link StackBasedHanoiPeg} is an implementation of {@link HanoiPeg}.
 * 
 * @author jcollard
 */
public class StackBasedHanoiPeg implements HanoiPeg {
	
	LinkedStack<HanoiRing> stack;

	/**
	 * Creates a new {@link StackBasedHanoiPeg} that has no rings.
	 */
	public StackBasedHanoiPeg() {
		stack = new LinkedStack<HanoiRing>();
		
	}

	@Override
	public void addRing(HanoiRing ring) throws IllegalHanoiMoveException {
		if (!this.hasRings()) {
			stack.push(ring);
			return;
		} else if (ring.getSize() >= stack.peek().getSize()) {
			throw new IllegalHanoiMoveException("Cannot move a larger ring onto a smaller one!");
		}
		stack.push(ring);
	}

	@Override
	public HanoiRing remove() throws IllegalHanoiMoveException {
		if (!hasRings()) {
			throw new IllegalHanoiMoveException("Cannot remove a ring from an empty peg!");
		}
		return stack.pop();
	}

	@Override
	public HanoiRing getTopRing() throws IllegalHanoiMoveException {
		if (!hasRings()) {
			throw new IllegalHanoiMoveException("Cannot get the top ring from an empty peg!");
		}
		return stack.peek();
	}

	@Override
	public boolean hasRings() {
		return !stack.isEmpty();
	}
}

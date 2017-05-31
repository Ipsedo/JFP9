import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Direction {
	UP(-1, 0), DOWN(1, 0), RIGHT(0, 1), LEFT(0, -1);

	private static final List<Direction> VALUES = Collections
			.unmodifiableList(Arrays.asList(values()));
	private final int dI, dJ;

	private Direction(int di, int dj) {
		this.dI = di;
		this.dJ = dj;
	}

	public int dI() {
		return dI;
	}

	public int dJ() {
		return dJ;
	}

	public static Direction random() {
		return VALUES.get(new Random().nextInt(VALUES.size()));
	}

	public static Direction[] getAllDirection() {
		return new Direction[] { UP, DOWN, RIGHT, LEFT };
	}
}

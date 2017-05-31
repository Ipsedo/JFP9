import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Direction {
	UP(0, -1), DOWN(0, 1), RIGHT(1, 0), LEFT(-1, 0);

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

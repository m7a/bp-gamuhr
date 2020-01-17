package ma.gamuhr;

import javax.swing.JComponent;
import java.awt.*;

class ZSegment7 extends JComponent {

	private static final int HEIGHT = 5 * 18;
	private static final Color DARKRED = new Color(100, 0, 0);
	static final Color LIGHTRED = new Color(255, 0, 0);

	private final int[][] polysx = { { 1, 2, 8, 9, 8, 2 }, // Segment 0
			{ 9, 10, 10, 9, 8, 8 }, // Segment 1
			{ 9, 10, 10, 9, 8, 8 }, // Segment 2
			{ 1, 2, 8, 9, 8, 2 }, // Segment 3
			{ 1, 2, 2, 1, 0, 0 }, // Segment 4
			{ 1, 2, 2, 1, 0, 0 }, // Segment 5
			{ 1, 2, 8, 9, 8, 2 }, // Segment 6
	};

	private final int[][] polysy = { { 1, 0, 0, 1, 2, 2 }, // Segment 0
			{ 1, 2, 8, 9, 8, 2 }, // Segment 1
			{ 9, 10, 16, 17, 16, 10 }, // Segment 2
			{ 17, 16, 16, 17, 18, 18 }, // Segment 3
			{ 9, 10, 16, 17, 16, 10 }, // Segment 4
			{ 1, 2, 8, 9, 8, 2 }, // Segment 5
			{ 9, 8, 8, 9, 10, 10 }, // Segment 6
	};

	private final int[][] digits = { { 1, 1, 1, 1, 1, 1, 0 }, // Ziffer 0
			{ 0, 1, 1, 0, 0, 0, 0 }, // Ziffer 1
			{ 1, 1, 0, 1, 1, 0, 1 }, // Ziffer 2
			{ 1, 1, 1, 1, 0, 0, 1 }, // Ziffer 3
			{ 0, 1, 1, 0, 0, 1, 1 }, // Ziffer 4
			{ 1, 0, 1, 1, 0, 1, 1 }, // Ziffer 5
			{ 1, 0, 1, 1, 1, 1, 1 }, // Ziffer 6
			{ 1, 1, 1, 0, 0, 0, 0 }, // Ziffer 7
			{ 1, 1, 1, 1, 1, 1, 1 }, // Ziffer 8
			{ 1, 1, 1, 1, 0, 1, 1 } // Ziffer 9
	};

	private int digit;

	public ZSegment7() {
		super();
		this.digit = 0;
	}

	public Dimension getPreferredSize() {
		return new Dimension(5 * 10, HEIGHT);
	}

	public Dimension getMinimumSize() {
		return new Dimension(1 * 10, 1 * 18);
	}

	public void paint(final Graphics g) {
		// dx und dy berechnen
		final int dx = getSize().width / 10;
		final int dy = getSize().height / 18;
		// Hintergrund
		g.setColor(DARKRED);
		g.fillRect(0, 0, getSize().width, getSize().height);
		// Segmente
		g.setColor(LIGHTRED);
		for (int i = 0; i < 7; ++i) {
			// alle Segmente
			if(digits[digit][i] == 1) {
				final Polygon poly = new Polygon();
				for (int j = 0; j < 6; ++j) {
					// alle Eckpunkte
					poly.addPoint(dx * polysx[i][j],
							dy * polysy[i][j]);
				}
				g.fillPolygon(poly);
			}
		}
		// Trennlinien
		g.setColor(DARKRED);
		g.drawLine(0, 0, dx * 10, dy * 10);
		g.drawLine(0, 8 * dy, 10 * dx, 18 * dy);
		g.drawLine(0, 10 * dy, 10 * dx, 0);
		g.drawLine(0, 18 * dy, 10 * dx, 8 * dy);
	}

	public void setValue(final int value) {
		digit = value;
		repaint();
	}

}

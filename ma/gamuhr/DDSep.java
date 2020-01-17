package ma.gamuhr;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

class DDSep extends JComponent {

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(30, 90);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(ZSegment7.LIGHTRED);
		((Graphics2D)g).fill(new Ellipse2D.Float(10, 13, 10, 10));
		((Graphics2D)g).fill(new Ellipse2D.Float(10, 67, 10, 10));
	}

}

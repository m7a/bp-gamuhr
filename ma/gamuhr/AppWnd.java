package ma.gamuhr;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;

class AppWnd extends JFrame {

	private static final Color BG = new Color(40, 0, 0);

	/** left to right: hour minute second */
	private final ZSegment7[] hms;

	private final JButton pause;

	private boolean paused = false;

	AppWnd() {
		super("GAM UHR");

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		JPanel segments = new JPanel(new FlowLayout(FlowLayout.CENTER));
		segments.setBackground(BG);
		ZSegment7[] preHMS = new ZSegment7[6];
		for(int i = 0; i < preHMS.length; ++i) {
			preHMS[i] = new ZSegment7();
			segments.add(preHMS[i]);
			if(i == 1 || i == 3)
				segments.add(new DDSep());
		}
		hms = preHMS;

		pause = new JButton("Pause");
		pause.setBackground(BG);
		pause.setForeground(Color.WHITE);
		pause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				paused = !paused;
				pause.setText(paused? "Unpause": "Pause");
			}
		});

		JPanel arseg = new JPanel(new FlowLayout(
						FlowLayout.CENTER, 40, 40));
		arseg.setBackground(BG);
		arseg.add(segments);

		cp.add(BorderLayout.CENTER, arseg);
		cp.add(BorderLayout.SOUTH, pause);

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	boolean isPaused() {
		return paused;
	}

	/** @param deltaT seconds */
	void updateClock(final long deltaT) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				long deltaTR = deltaT;
				for(int i = hms.length - 1; i >= 0; i -= 2) {
					int relevant = (int)(deltaTR % 60);
					hms[i - 1].setValue(relevant / 10);
					hms[i    ].setValue(relevant % 10);
					deltaTR /= 60;
				}
			}
		});
	}

}

package ma.gamuhr;

public class Main {

	public static void main(String[] args) {
		AppWnd wnd = new AppWnd();
		ClockTicker ticker = new ClockTicker(wnd);
		wnd.setVisible(true);
		ticker.start();
	}

}

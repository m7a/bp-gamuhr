package ma.gamuhr;

class ClockTicker extends Thread {

	private final AppWnd wnd;

	ClockTicker(AppWnd wnd) {
		super();
		this.wnd = wnd;
	}

	@Override
	public void run() {
		long deltaRecorded = 0;
		try {
			long tn = System.currentTimeMillis();
			while(!isInterrupted()) {
				sleep(250);
				long tb = tn;
				tn = System.currentTimeMillis();
				if(!wnd.isPaused()) {
					deltaRecorded += (tn - tb);
					wnd.updateClock((long)Math.round(
						deltaRecorded / 1000.0d));
				}
			}
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
	}

}

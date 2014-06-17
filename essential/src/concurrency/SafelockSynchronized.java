package concurrency;

import java.util.Random;

public class SafelockSynchronized {
	Runnable r = new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	};
	static class Friend {
		private final String name;
		
		public Friend(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}

		public void bow(Friend bower) {
			synchronized (bower) {
					System.out.format("%s: %s has"
							+ " bowed to me!%n", 
							this.name, bower.getName());
					bower.bowBack(this);
			}
		}

		public void bowBack(Friend bower) {
			System.out.format("%s: %s has" +
					" bowed back to me!%n",
					this.name, bower.getName());
		}
	}

	static class BowLoop implements Runnable {
		private Friend bower;
		private Friend bowee;

		public BowLoop(Friend bower, Friend bowee) {
			this.bower = bower;
			this.bowee = bowee;
		}

		public void run() {
			Random random = new Random();
			for (;;) {
				try {
					Thread.sleep(random.nextInt(10000));
				} catch (InterruptedException e) {}
				bowee.bow(bower);
			}
		}
	}


	public static void main(String[] args) {
		final Friend alphonse =
				new Friend("Alphonse");
		final Friend gaston =
				new Friend("Gaston");
		new Thread(new BowLoop(alphonse, gaston)).start();
		new Thread(new BowLoop(gaston, alphonse)).start();
	}
}

import java.io.IOException;


public class SynchrnizedThreads extends Thread {

		private String firstName; // Store for first name
		private String secondName; // Store for second name
		private long aWhile; // Delay in milliseconds
		
		static int count = 0;
		Object obj = new Object();
		public SynchrnizedThreads(String fname, String sname, long delay) {
			this.secondName = sname; // Store the second name
			this.firstName = fname; // Store the first name

			aWhile = delay; // Store the delay
			setDaemon(true); // Thread is daemon
		}

		public static void main(String[] args) throws IOException {
			// Create three threads
			
			SynchrnizedThreads first = new SynchrnizedThreads("Aryan ", "Jahaz ", 2000L);

			SynchrnizedThreads second = new SynchrnizedThreads("Tahir ", "Pilot ", 2000L);
			SynchrnizedThreads third = new SynchrnizedThreads("Shah ", "PhP-Master ", 2000L);
			System.out.println("Press Enter when you have had enough...\n");
			
			System.out.println(first.getPriority()+","+second.getPriority()+","+third.getPriority());


			first.start(); // Start the first thread
			second.start(); // Start the second thread
			third.start(); // Start the third thread
			

			try {
				System.out.println("Press Enter when you have had enough...\n");
				System.in.read(); // Wait until Enter key pressed
				System.out.println("Enter pressed...\n");
			} catch (IOException e) { // Handle IO exception
				System.out.println(e); // Output the exception
			}
			
			System.out.println("Count: "+count);
			System.out.println("Ending main()");

			
		}
		
		public void PrintCount() {
			System.out.println("Count: "+count);
		}

		// Method where thread execution will start
		public void run() {
			
	synchronized (obj) {
		count++;
	}
		
			try {
				while (true) { // Loop indefinitely...
					System.out.print(firstName+ ", "+ secondName + "\n"); // Output first name

					
					//System.out.print(secondName + "\n"); // Output second name
					sleep(aWhile); // Wait aWhile msec.
				
					
				}
			} catch (Exception e) { // Handle thread interruption
				System.out.println(firstName + secondName + e); // Output the
																// exception
			}
		
		}


	}


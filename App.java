import java.util.*;
import java.util.ArrayList;
public class App {
	int[] totalinputreader = {0,1,2,3,4,5};
	ArrayList<String> totalinput = new ArrayList<String>();
	int inputcount = 0;
	int readercount = 0;
	String readInput(Scanner sc) {
		System.out.println("Input Code Ready to be entered.");
		boolean found = false;
		int in = -1;
		if (sc.hasNext()) {
			sc.skip("[^0-9]*");		// skip non-digits
			totalinput.add(sc.next());
			for(int i = 0; i < totalinput.size(); i++) {   
			    System.out.print(totalinput.get(i));
			}  
			inputcount = totalinput.get(0).length();
			System.out.println(" is the entered code.");
			System.out.println("Input code is "+inputcount+" digits long.");
		}
		
		while(found == false) {
			for(int i=0; i<5; i++) {
				totalinputreader[i] = totalinputreader[i+1];
			}
			
				if(totalinput.get(readercount).length() < 2) {
					totalinputreader[5] = Integer.parseInt(totalinput.get(readercount));
					readercount = readercount + 1;
					int intreader = totalinputreader[0] * 100000 + totalinputreader[1] * 10000 + totalinputreader[2] * 1000 + totalinputreader[3] * 100 + totalinputreader[4] * 10 + totalinputreader[5];
					System.out.println("Reader reads "+intreader+".");
					if(intreader == 830271) {
						found = true;
						in = 1;
						System.out.println("Unlock Code received.");
						totalinput.removeAll(totalinput);
						readercount = 0;
					}else if(intreader == 830274) {
						found = true;
						in = 2;
						System.out.println("Lock Code received.");
						totalinput.removeAll(totalinput);
						readercount = 0;
					}else if(readercount >= inputcount) {
						found = true;
						in = 0;
						System.out.println("Invalid Code received.");
						totalinput.removeAll(totalinput);
						readercount = 0;
					}
					
				}else {
					boolean found2 = false;
					int count = 0;
					String number = totalinput.get(readercount);
					char[] digits = number.toCharArray();
					while(found2==false) {
						totalinputreader[5] = Character.getNumericValue(digits[count]);
						count++;
						readercount = readercount + 1;
						int intreader = totalinputreader[0] * 100000 + totalinputreader[1] * 10000 + totalinputreader[2] * 1000 + totalinputreader[3] * 100 + totalinputreader[4] * 10 + totalinputreader[5];
						System.out.println("Reader reads "+intreader+".");
						if(intreader == 830271) {
							found2 = true;
							found = true;
							in = 1;
							System.out.println("Unlock Code received.");
							totalinput.removeAll(totalinput);
							readercount = 0;
						}else if(intreader == 830274) {
							found2 = true;
							found = true;
							in = 2;
							System.out.println("Lock Code received.");
							totalinput.removeAll(totalinput);
							readercount = 0;
						}else if(readercount >= inputcount) {
							found2 = true;
							found = true;
							in = 0;
							System.out.println("Invalid Code received.");
							totalinput.removeAll(totalinput);
							readercount = 0;
						}else {
							System.out.println("Reading Next Digit");
							System.out.println(readercount);
							for(int i=0; i<5; i++) {
								totalinputreader[i] = totalinputreader[i+1];							
							}
						}
					}
				}
		}
		return String.valueOf(in);
	}
	
	private void securityDevice() {
		String out = "";
		int in;
		Scanner sc = new Scanner(System.in);
		FSM fsm = new FSM();
		while (true) {
			in = Integer.parseInt(readInput(sc));
			fsm.input(in);
			if (out.equals("Lock")) {
				out = fsm.output();
				if (out.equals("Lock")) {
					System.out.println(out);
					System.out.println("No change in state.");
				}else {
					System.out.println(out);
				}
			}else if (out.equals("Unlock")) {
				out = fsm.output();
				if (out.equals("Unlock")) {
					System.out.println(out);
					System.out.println("No change in state.");
				}else {
					System.out.println(out);
				}
			}else {
				out = fsm.output();
				if (out.equals("Lock") || out.equals("Unlock")) {
					System.out.println(out);
				}else {
					System.out.println("No change in state.");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		App app = new App();
    	app.securityDevice();
	}
}

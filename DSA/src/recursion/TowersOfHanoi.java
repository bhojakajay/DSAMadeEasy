package recursion;

public class TowersOfHanoi {
	public void towersOfHanoi(int disks, String from, String to, String aux) {
		if(disks==1) {
			System.out.println("Move disk from "+ from + " to " + to);
			return;
		}
		towersOfHanoi(disks-1,from,aux,to);
		System.out.println("Move disk from "+ from + " to " + to);
		towersOfHanoi(disks-1,aux,to,from);
	}
	
	public static void main(String[] args) {
		new TowersOfHanoi().towersOfHanoi(2, "A", "C", "B");
	}
}
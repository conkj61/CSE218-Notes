package partitioning;
//  4/2/2019
public class PartitionDemo {

	public static void main(String[] args) {
		ArrayPar arr = new ArrayPar(10);
		arr.insert(5);
		arr.insert(1);
		arr.insert(3);
		arr.insert(9);
		arr.insert(4);
		arr.insert(6);
		arr.insert(2);
		
		arr.display();
		int partitionIndex = arr.partitionIt(0, arr.size() - 1, 3);
		System.out.println(partitionIndex);
	}

}

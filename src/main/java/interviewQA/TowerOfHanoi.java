package interviewQA;

public class TowerOfHanoi {
    //Recursive Method for Solving the Tower of hanoi.
    private static void TOH(char source, char auxiliary, char destination, int numOfDisk){
        if (numOfDisk > 0){
            TOH(source, destination, auxiliary, numOfDisk-1);
            System.out.println("Move 1 disk from "+source+" to "+destination+" using "+auxiliary+".");
            TOH(auxiliary, source, destination, numOfDisk-1);
        }
    }
    public static void main(String[] args) {
        TOH('A','B','C', 3);
    }
}


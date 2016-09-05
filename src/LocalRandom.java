import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LocalRandom
{
    static List  indexList = new ArrayList();
	private static int[] arr;
	private static ArrayList<Integer> part;
	private static ArrayList<Integer> buffer;
	private static int[] arrFive;
	private static List<Integer> part1;
    public static int[] getArr() {
		return arr;
	}


	public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);
        list.add(90);
        list.add(100);
        list.add(19);
        list.add(21);
        list.add(33);
        list.add(25);
        list.add(20);
        list.add(26);
        list.add(27);
        list.add(28);
        list.add(29);
        list.add(30);

        LocalRandom obj = new LocalRandom();
        
        System.out.println("ten: = " + Arrays.toString(tenAndPlay(list, obj, 10)));
        System.out.println("Five: = " + partFive(list, obj, 5));
        
        
        for(int i = 0; i < indexList.size (); i++) {
 //           System.out.println (list.get (i));
        }
    }


	public static List<Integer> partFive(List<Integer> list, LocalRandom obj, int listSize) {
		arrFive = new int[listSize];
		for(int i = 0; i < listSize; i++){
  //          System.out.print(obj.getRandomList(list) + ", ");
            arrFive[i] = obj.getRandomList(list);
        }
		part1 =  new ArrayList<Integer>(Arrays.asList(TestReadFile3.toObject(arrFive)));

//		System.out.println("part1: ----------------------> " +  part1);
		return part1;
	}


	public static int[] tenAndPlay(List<Integer> list, LocalRandom obj, int listSize) {
		arr = new int[listSize];
		for(int i = 0; i < listSize; i++){
  //          System.out.print(obj.getRandomList(list) + ", ");
            arr[i] = obj.getRandomList(list);
        }
		part =  new ArrayList<Integer>(Arrays.asList(TestReadFile3.toObject(arr)));
		System.out.println();
		System.out.println("First Choice of 10 numbers: ---------> " +  part);
		return arr;
	}
	


    public int getRandomList(List<Integer> list) {
        int index = ThreadLocalRandom.current().nextInt(list.size());
        
        while (indexList.contains (index)) {
            index = ThreadLocalRandom.current().nextInt(list.size());
        }
        indexList.add (index);
        
        return list.get(index);
    }


	public static ArrayList<Integer> getPart() {
		return part;
	}


	public static List<Integer> getPart1() {
		return part1;
	}
    
    
    
    
}

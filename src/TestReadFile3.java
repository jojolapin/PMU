import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TestReadFile3 {
	static List<List<Integer>> morningResultList = new ArrayList<List<Integer>>();
	static List<Integer> treeResult = new ArrayList<Integer>();
	static int C5Max = 34;
	private static List<Integer> numbersMax = new ArrayList<Integer>(); //numbers to take the list difference from on Cash5 max num
	private  ArrayList<Integer> part;
	private final static int r = 5; //like in C(n, r)

	public static void main(String args[]) {

		populate();

		String fileName = "C:/Users/jojolapin/Documents/PMU/Cash5_9-5-2016.txt";
		List<String> list = new ArrayList<String>();

		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

			// br returns as stream and convert it into a List
			list = br.lines().collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

		String delims1 = "[ ;/:,]+";
		list.forEach(oneLine -> {
			String[] dayTokens = oneLine.split(delims1);
			List<Integer> morningResult = new ArrayList<Integer>();

			// Morning Results
			// System.out.println("WinningDate " + WinningDate[0]);
			morningResult.add(Integer.parseInt(dayTokens[4]));
			morningResult.add(Integer.parseInt(dayTokens[5]));
			morningResult.add(Integer.parseInt(dayTokens[6]));
			morningResult.add(Integer.parseInt(dayTokens[7]));
			morningResult.add(Integer.parseInt(dayTokens[8]));
			morningResultList.add(morningResult);

		});

		for (int i = 0; i < 3; i++) {
			treeResult.addAll(morningResultList.get(i)); // the 3 sets play
		}

		System.out.println("                                        SUMMARY FOR THE MORNING GAME");
		System.out.println("                                        ============================");
		System.out.println();
		System.out.println("Last 3 Sets played: -----------------> " + treeResult);
		List<Integer> sourceList = oppositChoice(treeResult, numbersMax);
		System.out.println("numbers to be used to play: ---------> " + sourceList);
		
		//Combination list of all number to be used (34-15=19)
//		Permutation.printCombination(convertIntegers(sourceList), sourceList.size(), 5); //combinaison pour le reste des non-choisi
		
		//First Choice of 10 numbers Combination List ...part
		LocalRandom obj = new LocalRandom();
		
		Permutation.printCombination(LocalRandom.tenAndPlay(sourceList, obj, 10), LocalRandom.getArr().length, r );
		System.out.println("numbers to be used to play: ---------> " + sourceList);
		System.out.println("First Choice of 10 numbers: ---------> " +  LocalRandom.getPart());
		ArrayList<Integer> parti = LocalRandom.getPart();
		
		 System.out.println("Part list 5: ------------------------> " + LocalRandom.partFive(parti, obj, 5));
		 List<Integer> contrePart = oppositChoice(parti, sourceList );
		
		 
		 //Second Choice of 10 numbers Combination List ...(contrePart list)
		 System.out.println("Second Choice of 10 numbers: --------> " + contrePart);
		 //contrePart Combination list
//		 Permutation.printCombination(convertIntegers(contrePart), contrePart.size(), r );
		 
		 System.out.println("Part() list : ---> " + parti);
		 
//		 	 System.out.println("Part list 5: ---> " + LocalRandom.partFive(parti, obj, 5));
		 System.out.println("contrePart list 5: ---> " + LocalRandom.partFive(contrePart, obj, 5));
		 
		 
		 
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static List<Integer> oppositChoice(List<Integer> smalerList, List<Integer> largerList) {
		Collection<Integer> myList = smalerList;
		List<Integer> sourceList = largerList;
		List<Integer> destinationList = new ArrayList<Integer>(myList);
		sourceList.removeAll(myList);
		myList.removeAll(destinationList);
		return sourceList;
	}

	static void populate() {
		for (int i = 0; i < C5Max; i++) {
			numbersMax.add(i + 1);
		}
		// System.out.println(numbers);
	}
	
	public static int[] convertIntegers(List<Integer> integers) //converts Integer to int
	{
	    int[] ret = new int[integers.size()];
	    Iterator<Integer> iterator = integers.iterator();
	    for (int i = 0; i < ret.length; i++)
	    {
	        ret[i] = iterator.next().intValue();
	    }
	    return ret;
	}
	
	public static Integer[] toObject(int[] intArray) {

		Integer[] result = new Integer[intArray.length];
		for (int i = 0; i < intArray.length; i++) {
			result[i] = Integer.valueOf(intArray[i]);
		}
		return result;
	}
}

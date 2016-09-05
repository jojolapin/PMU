import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestReadFile {
	static List<String> morningResultList = new ArrayList<String>();
	static List<String> nightResultList = new ArrayList<String>();
	static List<?> morningNightResultList = new ArrayList<String>();
	private static int doNotPlayCount;
	private static int noMatchCount;

	public static void main(String args[]) {
		List<List<String>> morningResultList = new ArrayList<List<String>>();
		List<List<String>> nightResultList = new ArrayList<List<String>>();
		List<List<String>> morningNightResultList = new ArrayList<List<String>>();
		List<Integer> timeBeforeWinning = new ArrayList<>();

		String fileName = "C:/Users/jojolapin/Documents/PMU/Cash5_8-31-2016.txt";
		List<String> list = new ArrayList<>();

		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

			// br returns as stream and convert it into a List
			list = br.lines().collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

//		list.forEach(System.out::println);
		System.out.println();
		System.out.println();
//		System.out.println("The Reverse List is :");
		// reverse the list
		Collections.reverse(list);
		// list.forEach (System.out::println);

		// System.out.println(list.get(0));// to be looped for each element of
		// the
		// list

		String delims1 = "[ ;/:,]+";
		list.forEach(oneLine -> {
			System.out.println();
//			System.out.println("OneLine = " + oneLine);
			String[] dayTokens = oneLine.split(delims1);
			List<String> morningResult = new ArrayList<String>();
			List<String> nightResult = new ArrayList<String>();
			
			// Morning Results
//			System.out.println("WinningDate " + WinningDate[0]);
			System.out.println("Morning Time");
			/*
			 * System.out.println("tokens3 = " + dayTokens[4]);
			 * System.out.println("tokens3 = " + dayTokens[5]);
			 * System.out.println("tokens3 = " + dayTokens[6]);
			 * System.out.println("tokens3 = " + dayTokens[7]);
			 * System.out.println("tokens3 = " + dayTokens[8]);
			 */
			morningResult.add(dayTokens[4]);
			morningResult.add(dayTokens[5]);
			morningResult.add(dayTokens[6]);
			morningResult.add(dayTokens[7]);
			morningResult.add(dayTokens[8]);
			morningResultList.add(morningResult);
			
			morningNightResultList.add(morningResult);

			// Night Results
			System.out.println();
			String[] nightTokens = dayTokens;
			System.out.println("Night Time");
			/*
			 * System.out.println("tokens3 = " + nightTokens[10]);
			 * System.out.println("tokens3 = " + nightTokens[11]);ror
			 * System.out.println("tokens3 = " + nightTokens[12]);
			 * System.out.println("tokens3 = " + nightTokens[13]);
			 * System.out.println("tokens3 = " + nightTokens[14]);
			 */
			nightResult.add(dayTokens[10]);
			nightResult.add(dayTokens[11]);
			nightResult.add(dayTokens[12]);
			nightResult.add(dayTokens[13]);
			nightResult.add(dayTokens[14]);
			nightResultList.add(nightResult);
			morningNightResultList.add(nightResult);
		});

		System.out.println();
		System.out.println("Morning List");
//		morningResultList.forEach(System.out::println);
		System.out.println();
		System.out.println("Night List");
//		nightResultList.forEach(System.out::println);
		System.out.println();
//		System.out.println("Morning and Night List");
//		morningNightResultList.forEach(System.out::println);

//		System.out.println(morningResultList.get(0).get(0).equals(morningResultList.get(3).get(0)));

		List<String> treeResult = new ArrayList<String>();
		List<String> currentPlay = new ArrayList<String>();
		
		out2: for (int i = 0; i < morningResultList.size(); i++) {
			treeResult.clear();
			currentPlay.clear();
			
			treeResult.addAll(morningResultList.get(i));	//the 3 sets play
			treeResult.addAll(morningResultList.get(i + 1));
			treeResult.addAll(morningResultList.get(i + 2));
			
			if (i < morningResultList.size() - 3) {
				currentPlay.addAll(morningResultList.get(i + 3)); // result to compare with the 3 sets
			}

			
			System.out.println("Curent Play:  " + currentPlay);
			System.out.println("Last 3 Plays: " + treeResult);
			
			out: for (int j = 0; j < treeResult.size(); j++) { // 15 looping for
																// the whole 3
																// sets of 5
																// numbers

				for (int k = 0; k < 5; k++) {
					if (i < morningResultList.size() - 3) {
						
//						System.out.println("treeResult.get(j) = " + treeResult.get(j));
//						System.out.println("morningResultList.get(i+3).get(k) = " + morningResultList.get(i + 3).get(k));
						
						
						if (treeResult.get(j).equals(morningResultList.get(i + 3).get(k))) {
							doNotPlayCount++;
							noMatchCount = 0;
							break out;
						} else {
							noMatchCount++;
						}
					} else {
						System.out.println("MorningPlays since begining = " + i);
						currentPlay.clear();
						break out2;
					}

				}

			}
			if (noMatchCount == 75) {
				System.out.println("lost "+ doNotPlayCount + " times before winning this time" );
				
				System.out.println("No numbers from the 3 last plays is present in the current play");
				System.out.println("Possible Wins!...You can Play");
				timeBeforeWinning.add(doNotPlayCount);
				System.out.println();
				
				doNotPlayCount = 0;
				noMatchCount = 0;
			} else {
				System.out.println("No Wins!...Do Not Play");
//				System.out.println("doNotPlayCount = " + doNotPlayCount);
				System.out.println();
			}

		}
		timeBeforeWinning.forEach(System.out::println);
		for(int i = 0; i < 71; i++) {
//		System.out.println( "frequency of " + i + " = " + Collections.frequency(timeBeforeWinning, i));
		}
		
		for(int i = 0; i < 71; i++) {
//			System.out.println(Collections.frequency(timeBeforeWinning, i));
		} 
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestReadFile2
{
    
    static List<String> list = fileReader ("C:/Users/jojolapin/Documents/PMU/Cash5_8-31-2016.txt");
    
    
    public static void main (String args[]) {
         
        int arr[] = {1,2,3,6};
        int r = 3;
        int n = arr.length;
        Permutation.printCombination(arr, n, r);
        
 //       ArrayList numbers2 = new ArrayList();
   //     (Collection)numbers2.removeAll (Permutation.numbers);
     
      //  Permutation.populate();
       
        Collection<Integer> myList = new ArrayList(Arrays.asList(1,2, 3, 4, 5, 6, 7,8,9,10,11,12,13,14,15));
        List<Integer> sourceList = Permutation.numbers;
        List<Integer> destinationList = new ArrayList<Integer>(myList);

        System.out.println("Last 3 Sets: " + myList );
        System.out.println(" cash5Max    " + Permutation.populate() );
        sourceList.removeAll( myList );
        myList.removeAll( destinationList );
        System.out.println("numbers to be sused to play: " +  sourceList );
       // System.out.println("list: " + myList );
        
         
        
        
/*        list.forEach (System.out::println);

        // reverse the list
        Collections.reverse (list);
        System.out.println ();
        System.out.println ();
        System.out.println ("The Reverse List is :");
        list.forEach (System.out::println);
        System.out.println (list.get (0));*/
        
        
    }

    
    
    
    
    
    
    
    
    
    
    private static List<String> fileReader (String filePath) {
        String fileName = filePath;
        List<String> list = new ArrayList<> ();

        try (BufferedReader br = Files.newBufferedReader (Paths.get (fileName))) {

            // br returns as stream and convert it into a List
            list = br.lines ().collect (Collectors.toList ());

        }
        catch (IOException e) {
            e.printStackTrace ();
        }
        return list;
    }

}

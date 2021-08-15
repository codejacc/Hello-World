/* This class will be given a list of words (such as might be tokenized
 * from a paragraph of text), and will provide a method that takes two
 * words and returns the shortest distance (in words) between those two
 * words in the provided text.
 * Example:
 *   SentenceDistanceFinder finder = new SentenceDistanceFinder(Arrays.asList("the", "quick", "brown", "fox", "quick"));
 *   assert(finder.distance("fox", "the") == 3);
 *   assert(finder.distance("quick", "fox") == 1);
 *
 * "quick" appears twice in the input. There are two possible distance values for "quick" and "fox":
 *     (3 - 1) = 2 and (4 - 3) = 1.
 * Since we have to return the shortest distance between the two words we return 1.
 */
public class SentenceDistanceFinder {
  
    Map<String, LinkedList<Integer>> stringToIndexes;
    public SentenceDistanceFinder(List<String> words) {
       this.stringToIndexes = new HashMap<>();
      
       int index = 1;
       for(String word: words) {
           index++;
           stringToIndexes.putIfAbsent(word, new LinkedList<>());
         
           stringToIndexes.get(word).addLast(index);
           
       }
    }
  
  
  
    // "the", "quick", "brown", "fox", "quick"
     // finder.distance("quick", "fox")

  
  
  // Quick : 5
  // fox : 4
    public int distance(String wordOne, String wordTwo) {
         if(!stringToIndexes.contains(wordOne)  || !stringToIndexes.contains(wordTwo)) {
            throw new RuntimeException("String not found in input map");
         }
       
         LinkedList<Integer> listOne = stringToIndexes.get(wordOne);
         LinkedList<Integer> listTwo = stringToIndexes.get(wordTwo);
      
        // We need to find the minimum distance
        int minDistance = Integer.MAX_VALUE;
        Integer maxSoFarFromListOne = null;
        Integer maxSoFarFromListTwo = null;
      
        while(!listOne.isEmpty || !listTwo.isEmpty()) {
             Integer elementOne = listOne.isEmpty() ? null : listOne.getFirst();
             Integer elementTwo = listTwo.isEmpty ?  null : listTwo.getFirst();
             
             // 2 
             // 4

// maxQuick: 2
// maxFox:
// mindistance : 2
  
             Integer minElement = null;
             if (elemtnOne == null || Integer.compare(elementOne, elementTwo) > 0) {
               // elementTwo gets inserted into a hypothetical array
                maxSoFarFromListTwo = elementTwo;
                minDistance = getMinDistance(minDistance, elementTwo, maxSoFarFromListOne);
                listTwo.removeFirst();
             } else if (elementTwo == null || Integer.compare(elementOne, elementTwo) <= 0) {
                maxSoFarFromListOne = elementOne;
                minDistance = getMinDistance(minDistance, elementOne, maxSoFarFromListTwo);
               listOne.removeFirst();
             }

           
        }
      
    }
  
    private Integer getMinDistance(Integer minDistanceSoFar, Integer value1, Integer value2) {
        if (value1 == null || value2 ==null) {
           return minDistanceSoFar;
        }
      
        return Math.min(minDistanceSoFar, Math.abs(value2-value1));
    }
  
  
  // the: 1 4 6 8 10 12
  // quick : 3 5 7 9 11 13
  // fox: 4 6
  
  1 5 6 
   
  3 10
    
  1 3 4 5.....

1,3... 1

 1 3 5 6 10


1  3 5 6 10

    
    
    2
    1
  


1 -> 2
4 -> 1

}

// O(N)
// NLogN








/**
 * This function determines if the braces ('(' and ')') in a string are properly matched.
 * it ignores non-brace characters.
 * Some examples:
 * "()()()()[]"   -> true
 * "((45+)*a3)" -> true
 * "(((({}))())"  -> false
 * "{[}]" -> false
 */

// Time - O(N)...N is the length of string
// Space - O(1) extra space.
 public boolean matched(String s) {
    int countOfOpenBrackets = 0;
    
    if (s == null) {
       throw new IllegalArgumentException("Null input");
    }
   
    for(char ch : s.toCharArray()) {
       if (ch == '(') {
          countOfOpenBrackets++;
       } else if (ch == ')') {
          countOfOpenBrackets--;
       }
      
       if (countOfOpenBrackets < 0) {
          return false;
       }
    }
   
    return countOfOpenBrackets == 0;
 }

// Part-II


// {[}]
 public boolean matched(String s) {
    Map<Character, Integer> bracketTypeToCountMap = new HashMap<>();
    bracketTypeToCountMap.put('(', 0);
    bracketTypeToCountMap.put('{', 0);
    bracketTypeToCountMap.put('[', 0);
   
   
    if (s == null) {
       throw new IllegalArgumentException("Null input");
    }
   
    for(char ch : s.toCharArray()) {
       
       // Else we process the character
       
       char targetType = '(';
       switch (ch) {
          case '('; 
                bracketTypeToCountMap.put('(', bracketTypeToCountMap.get('(') + 1);
                targetType = '(';
                break;
          case ')':
                bracketTypeToCountMap.put('(', bracketTypeToCountMap.get('(') - 1);
                targetType = '(';
                break;
          case '{';
                 targetType = '{';
                bracketTypeToCountMap.put('{', bracketTypeToCountMap.get('{') + 1);
                break;
          case '}':
                targetType = '{';
                bracketTypeToCountMap.put('{', bracketTypeToCountMap.get('{') - 1);
                break;
          case '[';
                targetType = '[';
                bracketTypeToCountMap.put('[', bracketTypeToCountMap.get('[') + 1);
                break;
          case ']':
                targetType = '[';
                bracketTypeToCountMap.put('[', bracketTypeToCountMap.get('[') - 1);
                break;
         default: break;
           
       }
      
       if (bracketTypeToCountMap.get(targetType) < 0) {
          return false;
       }
    }
   
    return bracketTypeToCountMap.get('(') == 0 && bracketTypeToCountMap.get('{') == 0 && bracketTypeToCountMap.get('[') == 0;
 }

private boolean isPositive(char ch, Map<Character, Integer> inputMap) {
     return inputMap.get(ch) >=0 ;
}


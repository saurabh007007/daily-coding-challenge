import java.util.*;

public class MissingNumber {
    public static int missingNumber(int[] numList) {
        // Create a list of positive numbers
        List<Integer> posNumList = new ArrayList<>();
        for (int item : numList) {
            if (item > 0) {
                posNumList.add(item);
            }
        }
        
        // If the list is empty, return 1
        if (posNumList.isEmpty()) {
            return 1;
        }
        
        // Sort the positive number list
        Collections.sort(posNumList);
        
        // Create a list of consecutive positive integers
        List<Integer> positiveList = new ArrayList<>();
        for (int x = 1; x <= posNumList.get(posNumList.size() - 1) + 1; x++) {
            positiveList.add(x);
        }
        
        // Convert lists to sets
        Set<Integer> posNumSet = new HashSet<>(posNumList);
        Set<Integer> positiveSet = new HashSet<>(positiveList);
        
        // Find the symmetric difference
        Set<Integer> symmetricDifference = new HashSet<>(posNumSet);
        symmetricDifference.addAll(positiveSet);
        Set<Integer> tmp = new HashSet<>(posNumSet);
        tmp.retainAll(positiveSet);
        symmetricDifference.removeAll(tmp);
        
        // Return the first (and only) element in the symmetric difference
        return symmetricDifference.iterator().next();
    }
    
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 3, -1, 1}));  // 2
        System.out.println(missingNumber(new int[]{1, 2, 0, -1}));  // 3
    }
}

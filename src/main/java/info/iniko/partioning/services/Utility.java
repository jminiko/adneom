package info.iniko.partioning.services;

import java.util.List;

public class Utility {
    /**
     * utilitiy method to convert a list of list to an array of array
     * @param list
     * @return
     */
    public static Integer[][] convertToArray(List<List<Integer>> list){
        Integer[][] resultArray = new Integer[list.size()][];
        Integer[] blankArray = new Integer[0];
        for(int i=0; i < list.size(); i++) {
            resultArray[i] = list.get(i).toArray(blankArray);
        }
        return resultArray;
    }
}

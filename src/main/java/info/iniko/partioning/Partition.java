package info.iniko.partioning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Partition is a utility class to adhere to the requirements
 * i.e. build a list of sublists (with parameter max size) based on a main list
 */
public class Partition {
    protected static final Logger _logger;

    /**
     * for display and logging to the console
     */
    static {
        _logger = Logger.getLogger(Partition.class.getName());
    }

    /**
     * contains the list of integer elements
     * initialized at instanciation
     */
    private List<Integer> internalList = new ArrayList<Integer>();
    private List<List<Integer>> outputList = new ArrayList<List<Integer>>();
    private int size=0;
    /**
     *
     * @return the sublists
     */
    public List<List<Integer>> getOutputList() {
        return outputList;
    }

    /**
     *
     * @return the parameter size
     */
    public int getSize() {
        return size;
    }

    /**
     * here we don't allow the instanciation with default constructor
     */
    private Partition(){

    }
    /**
     * default constructor
     * @param list, list of string separated by a space
     * @param size, size of the sublists
     */
    public Partition(String list,String size){
        this.size = Integer.valueOf(size);
        String[] splittedList = list.split(" ");
        if(this.size>splittedList.length){
            _logger.log(Level.SEVERE,"size ("+this.size+") inferior to list of elements ("+splittedList.length+")");
            throw new RuntimeException("Size mismatch");
        }
        for(String elem:splittedList){
            internalList.add(Integer.valueOf(elem));
        }
    }

    /**
     * accessor for input list
     * @return List of integers
     */
    public List<Integer> getInternalList() {
        return internalList;
    }

    /**
     *  build the sublists which can be later accessed with
     *   getOutputList()
     */
    public void buildOutpuLists(){
        int i= 0;
        int j= size;
        while (i<j){
            outputList.add(internalList.subList(i,j));
            i=j;
            j=i+size;
            if(j>internalList.size()){
                j=internalList.size();
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("type your list separated by spaces (eg.: 3 5 6 7 1)");
        String list = sc.nextLine();
        System.out.println("type the size of sublists (eg. : 3)");
        String size = sc.nextLine();
        Partition partition = new Partition(list,size);
        partition.buildOutpuLists();
        System.out.println("output list: "+ partition.getOutputList());
    }
}

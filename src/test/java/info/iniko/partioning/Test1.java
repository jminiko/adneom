package info.iniko.partioning;

import info.iniko.partioning.services.Utility;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Test1 {
    Partition ptwo;
    Partition pthree;
    Partition pone;
    @Before
    public void setup(){
        ptwo = new Partition("1 2 3 4 5","2");
        pthree = new Partition("1 2 3 4 5","3");
        pone = new Partition("1 2 3 4 5","1");

    }
    @Test
    public void testSizeOfTwo(){
        int[][] expectedArray={{1,2},{3,4},{5}};
        ptwo.buildOutpuLists();
        Integer[][]targetArray = Utility.convertToArray(ptwo.getOutputList());
        assertArrayEquals(expectedArray,targetArray);
    }
    @Test
    public void testSizeOfThree(){
        int[][] expectedArray={{1,2,3},{4,5}};
        pthree.buildOutpuLists();
        Integer[][]targetArray = Utility.convertToArray(pthree.getOutputList());
        assertArrayEquals(expectedArray,targetArray);
    }
    @Test
    public void testSizeOfOne(){
        int[][] expectedArray={{1},{2},{3},{4},{5}};
        pone.buildOutpuLists();
        Integer[][]targetArray = Utility.convertToArray(pone.getOutputList());
        assertArrayEquals(expectedArray,targetArray);
    }


}

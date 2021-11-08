package test.UsesCasesTest;

import main.UsesCases.*;
import main.Entity.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WorkList_test {
    WorkList WL;

    @Before
    public void Setup(){
        WorkList WL = new WorkList();

    }


    @Test
    public void testAddWork(){
        WL.addWork("Project 1", "1111", "IT", 2);
        for (Work w: WL){
            if (w.getID().equals("1111")){
                assertEquals(w.getName(), "Project 1");
                assertEquals(w.getLevel(), 2);
                assertEquals(w.getDepartment(), "IT");
            }
        }
    }
}
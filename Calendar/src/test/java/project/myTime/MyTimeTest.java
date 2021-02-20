package project.myTime;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alan on 06/12/16.
 */
public class MyTimeTest {
    @Test
    public void isValidTime() throws Exception {
        MyTime myTime = new MyTime(10, 00, 00);

        assertTrue(myTime.isValidTime(10, 00, 00));
        assertFalse(myTime.isValidTime(25, 70, 800));
    }

    @Test
    public void setMyTime() throws Exception {
        MyTime myTime = new MyTime(10, 00, 00);
        String str = myTime.toString();

        myTime.setMyTime(23, 59, 50);
        assertNotEquals(str, myTime.toString());
    }

}
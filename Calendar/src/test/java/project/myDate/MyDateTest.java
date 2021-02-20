package project.myDate;

import org.junit.Test;
import project.Event;

import static org.junit.Assert.*;

/**
 * Created by alan on 06/12/16.
 */
public class MyDateTest {
    @Test
    public void isLeepYear() throws Exception {
        MyDate myDate1 = new MyDate(2016, 12, 06);
        assertTrue(myDate1.isLeepYear(2016));
        assertFalse(myDate1.isLeepYear(2017));
    }

    @Test
    public void getDayOfWeek() throws Exception {
        MyDate myDate1 = new MyDate(2016, 12, 06);
        assertEquals(myDate1.getDayOfWeek(2016, 12, 07), 3);
    }

    @Test
    public void isValidDate() throws Exception {
        MyDate myDate1 = new MyDate(2016, 12, 06);
        assertTrue(myDate1.isValidDate(2016, 12, 07));
        assertFalse(myDate1.isValidDate(2016, 13, 45));
    }

    @Test
    public void setDate() throws Exception {
        MyDate myDate1 = new MyDate(2016, 12, 06);
        String str = myDate1.toString();

        myDate1.setDate(2016, 11, 04);
        assertNotEquals(str, myDate1.toString());
    }
}
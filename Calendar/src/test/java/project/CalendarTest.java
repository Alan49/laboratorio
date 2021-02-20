package project;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by alan on 06/12/16.
 */
public class CalendarTest {
    private Calendar tmp = new Calendar(0);

    @Test
    public void addEvent() throws Exception {
        tmp.addEvent("navidad", "25/12/2016", "25/12/2016", "00:00:00", "23:59:59");
        assertNotNull(tmp.getEvent("navidad"));
    }

    @Test
    public void existEvent() throws Exception {
        addEvent();
        assertTrue(tmp.existEvent("navidad"));
    }

    @Test
    public void removeEvent() throws Exception {
        addEvent();
        assertEquals(1, tmp.getNumberOfEvents());

        tmp.removeEvent("navidad");
        assertEquals(0, tmp.getNumberOfEvents());
    }

    @Test
    public void setEvent() throws Exception {
        addEvent();
        String str = tmp.getEvent("navidad").getName();

        tmp.setEvent("navidad", "25 de mayo", "25/05/2016", "25/05/2016", "23:12:56", "23:59:59");
        assertNotEquals(str, tmp.getEvent("25 de mayo").getName());
    }

    @Test
    public void getEvent() throws Exception {
        addEvent();
        assertNotNull(tmp.getEvent("navidad"));
    }

    @Test
    public void getId() throws Exception {
        assertEquals(0, tmp.getId());
    }

    @Test
    public void getNumberOfEvents() throws Exception {
        assertNotNull(tmp.getNumberOfEvents());
    }

    @Test
    public void getEvents() throws Exception {
        assertNotNull(tmp.getEvents());
    }

}
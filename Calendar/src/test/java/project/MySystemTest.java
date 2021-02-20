package project;

import org.junit.Test;
import project.exceptions.EmailExistException;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by alan on 06/12/16.
 */
public class MySystemTest {
    private MySystem system = new MySystem();

    @Test
    public void searchUser() throws Exception {
        assertNull(system.searchUser("alan@alan"));

        system.addUser("alan", "obregon", "alan@alan");
        assertNotNull(system.searchUser("alan@alan"));
    }

    @Test
    public void emailExist() throws Exception {
        assertFalse(system.emailExist("alan@alan"));

        system.addUser("alan", "obregon", "alan@alan");
        assertTrue(system.emailExist("alan@alan"));
    }

    @Test
    public void addUser() throws Exception {
        system.addUser("alan", "obregon", "alan@alan");
        assertNotNull(system.getUser("alan@alan"));
    }

    @Test
    public void removeUser() throws Exception {
        system.addUser("alan", "obregon", "alan@alan");
        assertTrue(system.emailExist("alan@alan"));

        system.removeUser("alan@alan");
        assertFalse(system.emailExist("alan@alan"));
    }

    @Test
    public void setUser() throws Exception {
        system.addUser("alan", "obregon", "alan@alan");

        String strName = system.getUser("alan@alan").getName();
        String strLastName = system.getUser("alan@alan").getLastName();
        String strEmail = system.getUser("alan@alan").getEmail();

        system.setUser("alan@alan", "pepe", "lopez", "pepe@lopez");

        assertNotEquals(strName, system.getUser("pepe@lopez").getName());
        assertNotEquals(strLastName, system.getUser("pepe@lopez").getLastName());
        assertNotEquals(strEmail, system.getUser("pepe@lopez").getEmail());
    }

    @Test
    public void getUser() throws Exception {
        system.addUser("alan", "obregon", "alan@alan");

        assertNotNull(system.getUser("alan@alan"));
    }

    @Test
    public void getUsers() throws Exception {
        system.addUser("alan", "obregon", "alan@alan");

        assertNotNull(system.getUsers());
    }

    @Test
    public void addCalendar() throws Exception {
        system.addUser("alan", "obregon", "alan@alan");
        system.addCalendar("alan@alan");

        assertNotNull(system.getCalendar("alan@alan", 0));
    }

    @Test
    public void removeCalendar() throws Exception {
        system.addUser("alan", "obregon", "alan@alan");
        system.addCalendar("alan@alan");

        assertEquals(1, system.getUser("alan@alan").getNumberOfCalendar());

        system.removeCalendar("alan@alan", 0);
        assertEquals(0, system.getUser("alan@alan").getNumberOfCalendar());
    }

    @Test
    public void getCalendar() throws Exception {
        system.addUser("alan", "obregon", "alan@alan");
        system.addCalendar("alan@alan");

        assertNotNull(system.getCalendar("alan@alan", 0));
    }

    @Test
    public void getCalendars() throws Exception {
        system.addUser("alan", "obregon", "alan@alan");
        system.addCalendar("alan@alan");

        assertNotNull(system.getCalendars("alan@alan"));
    }

    @Test
    public void addEvent() throws Exception {
        system.addUser("alan", "obregon", "alan@alan");
        system.addCalendar("alan@alan");

        assertEquals(0, system.getUser("alan@alan").getNumberOfEvents());
        system.addEvent("alan@alan", 0, "test", "07/12/2016", "07/12/2016", "00:00:00", "00:00:01");
        assertEquals(1, system.getUser("alan@alan").getNumberOfEvents());
    }

    @Test
    public void removeEvent() throws Exception {
        system.addUser("alan", "obregon", "alan@alan");
        system.addCalendar("alan@alan");
        system.addEvent("alan@alan", 0, "test", "07/12/2016", "07/12/2016", "00:00:00", "00:00:01");
        assertEquals(1, system.getUser("alan@alan").getNumberOfEvents());

        system.removeEvent("alan@alan", 0, "test");
        assertEquals(0, system.getUser("alan@alan").getNumberOfEvents());
    }

    @Test
    public void setEvent() throws Exception {
        system.addUser("alan", "obregon", "alan@alan");
        system.addCalendar("alan@alan");
        system.addEvent("alan@alan", 0, "test", "07/12/2016", "07/12/2016", "00:00:00", "00:00:01");

        String str = system.getEvent("alan@alan", 0, "test").getName();

        system.setEvent("alan@alan", 0, "test", "prueba", "", "", "", "");
        assertNotEquals(str, system.getEvent("alan@alan", 0, "prueba").getName());
    }

    @Test
    public void getEvent() throws Exception {
        system.addUser("alan", "obregon", "alan@alan");
        system.addCalendar("alan@alan");
        system.addEvent("alan@alan", 0, "test", "07/12/2016", "07/12/2016", "00:00:00", "00:00:01");

        assertNotNull(system.getEvent("alan@alan", 0, "test"));
    }

    @Test
    public void getEvents() throws Exception {
        system.addUser("alan", "obregon", "alan@alan");
        system.addCalendar("alan@alan");
        system.addEvent("alan@alan", 0, "test", "07/12/2016", "07/12/2016", "00:00:00", "00:00:01");

        assertNotNull(system.getEvents("alan@alan", 0));
    }

}
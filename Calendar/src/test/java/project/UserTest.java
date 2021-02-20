package project;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alan on 06/12/16.
 */
public class UserTest {
    private User user = new User("Alan", "Obregon", "alan@alan");

    @Test
    public void getName() throws Exception {
        assertNotNull(user.getName());
    }

    @Test
    public void getLastName() throws Exception {
        assertNotNull(user.getLastName());
    }

    @Test
    public void getEmail() throws Exception {
        assertNotNull(user.getEmail());
    }

    @Test
    public void getNumberOfCalendar() throws Exception {
        assertEquals(0, user.getNumberOfCalendar());

        user.addCalendar();
        assertEquals(1, user.getNumberOfCalendar());
    }

    @Test
    public void getNumberOfEvents() throws Exception {
        assertEquals(0, user.getNumberOfEvents());

        user.addCalendar();
        user.addEvent(0, "test", "07/12/2016", "07/12/2016", "0:0:0", "23:59:59");
        assertEquals(1, user.getNumberOfEvents());

        user.removeEvent(0, "test");
        assertEquals(0, user.getNumberOfEvents());
    }

    @Test
    public void setName() throws Exception {
        String tmp = user.getName();

        user.setName("pepe");
        assertNotEquals(tmp, user.getName());
    }

    @Test
    public void setLastName() throws Exception {
        String tmp = user.getLastName();

        user.setLastName("lopez");
        assertNotEquals(tmp, user.getLastName());
    }

    @Test
    public void setEmail() throws Exception {
        String tmp = user.getEmail();

        user.setEmail("pepe@lopez");
        assertNotEquals(tmp, user.getEmail());
    }

    @Test
    public void existCalendar() throws Exception {
        assertFalse(user.existCalendar(4));

        user.addCalendar();
        assertTrue(user.existCalendar(0));
    }

    @Test
    public void addCalendar() throws Exception {
        assertEquals(0, user.getNumberOfCalendar());

        user.addCalendar();
        assertEquals(1, user.getNumberOfCalendar());
    }

    @Test
    public void removeCalendar() throws Exception {
        user.addCalendar();
        assertEquals(1, user.getNumberOfCalendar());

        user.removeCalendar(0);
        assertEquals(0, user.getNumberOfCalendar());
    }

    @Test
    public void getCalendar() throws Exception {
        user.addCalendar();
        assertNotNull(user.getCalendar(0));
    }

    @Test
    public void getCalendars() throws Exception {
        user.addCalendar();
        assertNotNull(user.getCalendars());
    }

    @Test
    public void addEvent() throws Exception {
        assertEquals(0, user.getNumberOfEvents());

        user.addCalendar();
        user.addEvent(0, "test", "07/12/2016", "07/12/2016", "0:0:0", "23:59:59");
        assertEquals(1, user.getNumberOfEvents());
    }

    @Test
    public void removeEvent() throws Exception {
        user.addCalendar();
        user.addEvent(0, "test", "07/12/2016", "07/12/2016", "0:0:0", "23:59:59");
        assertEquals(1, user.getNumberOfEvents());

        user.removeEvent(0, "test");
        assertEquals(0, user.getNumberOfEvents());
    }

    @Test
    public void setEvent() throws Exception {
        user.addCalendar();
        user.addEvent(0, "test", "07/12/2016", "07/12/2016", "0:0:0", "23:59:59");
        assertEquals(1, user.getNumberOfEvents());

        String str = user.getEvent(0, "test").getName();
        user.setEvent(0, "test", "navidad", "", "", "", "");

        assertNotEquals(str, user.getEvent(0, "navidad").getName());
    }

    @Test
    public void getEvent() throws Exception {
        user.addCalendar();
        user.addEvent(0, "test", "07/12/2016", "07/12/2016", "0:0:0", "23:59:59");

        assertNotNull(user.getEvent(0, "test"));
    }

    @Test
    public void getEvents() throws Exception {
        user.addCalendar();
        user.addEvent(0, "test", "07/12/2016", "07/12/2016", "0:0:0", "23:59:59");

        assertNotNull(user.getEvents(0));
    }

}
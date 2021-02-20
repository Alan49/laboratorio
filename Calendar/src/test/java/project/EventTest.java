package project;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alan on 06/12/16.
 */
public class EventTest {
    private Event tmp = new Event("navidad", "25/12/2016", "25/12/2016", "00:00:00", "23:59:59");

    @Test
    public void setName() throws Exception {
        String str = tmp.getName();
        assertEquals(str, tmp.getName());

        tmp.setName("dia de la independencia");
        assertNotEquals(str, tmp.getName());
    }

    @Test
    public void setInicialDate() throws Exception {
        String str = tmp.getInicialDate();
        assertEquals(str, tmp.getInicialDate());

        tmp.setInicialDate("09/07/2016");
        assertNotEquals(str, tmp.getInicialDate());
    }

    @Test
    public void setFinalDate() throws Exception {
        String str = tmp.getFinalDate();
        assertEquals(str, tmp.getFinalDate());

        tmp.setFinalDate("09/07/2016");
        assertNotEquals(str, tmp.getFinalDate());
    }

    @Test
    public void setInicialTime() throws Exception {
        String str = tmp.getInicialTime();
        assertEquals(str, tmp.getInicialTime());

        tmp.setInicialTime("10:00:25");
        assertNotEquals(str, tmp.getInicialTime());
    }

    @Test
    public void setFinalTime() throws Exception {
        String str = tmp.getFinalTime();
        assertEquals(str, tmp.getFinalTime());

        tmp.setFinalTime("21:30:20");
        assertNotEquals(str, tmp.getFinalTime());
    }

    @Test
    public void getName() throws Exception {
        assertNotNull(tmp.getName());
    }

    @Test
    public void getInicialDate() throws Exception {
        assertNotNull(tmp.getInicialDate());
    }

    @Test
    public void getFinalDate() throws Exception {
        assertNotNull(tmp.getFinalDate());
    }

    @Test
    public void getInicialTime() throws Exception {
        assertNotNull(tmp.getInicialTime());
    }

    @Test
    public void getFinalTime() throws Exception {
        assertNotNull(tmp.getFinalTime());
    }

}
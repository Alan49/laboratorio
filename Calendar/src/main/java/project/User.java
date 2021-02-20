package project;

import project.exceptions.CalendarNoExistException;
import project.exceptions.EventNoExistException;

import java.util.ArrayList;

/**
 * Created by alan on 05/12/16.
 */
public class User {

    private String name;
    private String lastName;
    private String email;

    private int numberOfCalendar;
    private int numberOfEvents;

    private ArrayList<Calendar> calendars;

    public User(String name, String lastName, String email){
        this.name = name;
        this.lastName = lastName;
        this.email = email;

        this.numberOfCalendar = 0;
        this.numberOfEvents = 0;

        calendars = new ArrayList<Calendar>();
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getNumberOfCalendar() {
        return numberOfCalendar;
    }

    public int getNumberOfEvents() {
        return numberOfEvents;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean existCalendar(int id) {
        if (id >= 0 && id <= calendars.size()){
            return true;
        } else return false;
    }

    public void addCalendar(){
        calendars.add(new Calendar(numberOfCalendar));
        numberOfCalendar++;
    }

    public void removeCalendar(int id) throws CalendarNoExistException {
        if (existCalendar(id)){
            numberOfEvents -= calendars.get(id).getNumberOfEvents();
            calendars.remove(id);
            numberOfCalendar--;
        } else throw new CalendarNoExistException();
    }

    public Calendar getCalendar(int id) throws CalendarNoExistException {
        Calendar tmp = null;

        if (existCalendar(id)) {
            tmp = calendars.get(id);
        } else throw new CalendarNoExistException();

        return tmp;
    }

    public ArrayList<Calendar> getCalendars(){
        return calendars;
    }

    public void addEvent(int id, String name, String inicialDate, String finalDate, String inicialTime, String finalTime) throws CalendarNoExistException{
        if (existCalendar(id)){
            calendars.get(id).addEvent(name, inicialDate, finalDate, inicialTime, finalTime);
            numberOfEvents++;
        } else throw new CalendarNoExistException();
    }

    public void removeEvent(int id, String name) throws CalendarNoExistException {
        if (existCalendar(id)){
            try {
                calendars.get(id).removeEvent(name);
                numberOfEvents--;
            } catch (EventNoExistException ex){
                ex.getMessage();
            }
        } else throw new CalendarNoExistException();
    }

    public void setEvent(int idCalendar, String nameEvent, String newNameEvent, String newIDate, String newFDate, String newITime, String newFTime) throws CalendarNoExistException {
        if (existCalendar(idCalendar)) {
            try {
                getCalendar(idCalendar).setEvent(nameEvent, newNameEvent, newIDate, newFDate, newITime, newFTime);
            } catch (EventNoExistException ex) {
                ex.getMessage();
            } catch (CalendarNoExistException ex) {
                ex.getMessage();
            }
        } else throw new CalendarNoExistException();
    }

    public Event getEvent(int id, String name) throws CalendarNoExistException {
        Event tmp = null;

        if (existCalendar(id)){
            try {
                tmp = calendars.get(id).getEvent(name);
            } catch (EventNoExistException ex){
                ex.getMessage();
            }
        } else throw new CalendarNoExistException();

        return tmp;
    }

    public ArrayList<Event> getEvents(int id){
        return calendars.get(id).getEvents();
    }
}

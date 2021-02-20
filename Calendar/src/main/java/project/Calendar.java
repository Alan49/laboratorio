package project;

import project.exceptions.EmailNoExistException;
import project.exceptions.EmptyParametersException;
import project.exceptions.EventNoExistException;

import java.util.ArrayList;

/**
 * Created by alan on 05/12/16.
 */
public class Calendar {

    private int id;
    private int numberOfEvents;
    private ArrayList<Event> events;

    public Calendar(int id){
        this.id = id;
        events = new ArrayList<Event>();
    }

    public boolean existEvent(String name) {
        for (Event e: events) {
            if (e.getName().equalsIgnoreCase(name)){
                return true;
            }
        }

        return false;
    }

    public void addEvent(String name, String inicialDate, String finalDate, String inicialTime, String finalTime){
        events.add(new Event(name, inicialDate, finalDate, inicialTime, finalTime));
        numberOfEvents++;
    }

    public void removeEvent(String name) throws EventNoExistException {
        if (existEvent(name)){
            for (int e = 0; e < events.size(); e++) {
                if (events.get(e).getName().equalsIgnoreCase(name)){
                    events.remove(e);
                    numberOfEvents--;
                }
            }
        } else throw new EventNoExistException();
    }

    public void setEvent(String name, String newName, String inicialDate, String finalDate, String inicialTime, String finalTime) throws EventNoExistException {
        int cantMod = 0;

        if (existEvent(name)){
            for (Event e: events) {
                if (e.getName().equalsIgnoreCase(name)){
                    if (!newName.equalsIgnoreCase("")){
                        e.setName(newName);
                        cantMod++;
                    }

                    if (!inicialDate.equalsIgnoreCase("")){
                        e.setInicialDate(inicialDate);
                        cantMod++;
                    }

                    if (!finalDate.equalsIgnoreCase("")){
                        e.setFinalDate(finalDate);
                        cantMod++;
                    }

                    if (!inicialTime.equalsIgnoreCase("")){
                        e.setInicialTime(inicialTime);
                        cantMod++;
                    }

                    if (!finalTime.equalsIgnoreCase("")){
                        e.setFinalTime(finalTime);
                        cantMod++;
                    }
                }
            }

            if (cantMod == 0){
                throw new EmptyParametersException();
            }
        } else throw new EventNoExistException();
    }

    public Event getEvent(String name) throws EventNoExistException {
        Event tmp = null;

        if (existEvent(name)){
            for (Event e: events) {
                if (e.getName().equalsIgnoreCase(name)){
                    tmp = e;
                }
            }
        } else throw new EventNoExistException();

        return tmp;
    }

    public int getId(){
        return id;
    }

    public int getNumberOfEvents(){
        return numberOfEvents;
    }

    public ArrayList<Event> getEvents(){
        return events;
    }
}

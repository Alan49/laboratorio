package project;

import project.exceptions.CalendarNoExistException;
import project.exceptions.EmailExistException;
import project.exceptions.EmailNoExistException;
import project.exceptions.EmptyParametersException;

import java.util.ArrayList;

/**
 * Created by alan on 05/12/16.
 */
public class MySystem {

    private ArrayList<User> users;

    public MySystem(){
        users = new ArrayList<User>();
    }

    /**
     * Metodos para el control de usuarios
     * @param email
     * @return
     */

    public User searchUser(String email){
        User tmp = null;

        if (emailExist(email)){
            for (User u: users) {
                if (u.getEmail().equalsIgnoreCase(email)){
                    tmp = u;
                }
            }
        }

        return tmp;
    }

    public boolean emailExist(String email){
        for (User u: users) {
            if (u.getEmail().equalsIgnoreCase(email)){
                return true;
            }
        }

        return false;
    }

    public User addUser(String name, String lastName, String email) throws EmailExistException {
        if (emailExist(email)){
            throw new EmailExistException();
        }

        users.add(new User(name, lastName, email));
        return new User(name, lastName, email);
    }

    public void removeUser(String email) throws EmailNoExistException {
        if (!emailExist(email)){
            throw new EmailNoExistException();
        }

        users.remove(searchUser(email));
    }

    public void setUser(String email, String newName, String newLastName, String newEmail) {
        int canMod = 0;

        if (emailExist(email)){
            for (User u: users) {
                if (u.getEmail().equalsIgnoreCase(email)){
                    if (!newName.equalsIgnoreCase("")){
                        u.setName(newName);
                        canMod++;
                    }

                    if (!newLastName.equalsIgnoreCase("")){
                        u.setLastName(newLastName);
                        canMod++;
                    }

                    if (!newEmail.equalsIgnoreCase("")){
                        u.setEmail(newEmail);
                        canMod++;
                    }

                    if (canMod == 0){
                        throw new EmptyParametersException();
                    }
                }
            }
        }
    }

    public User getUser(String email){
        User tmp = null;

        if (emailExist(email)){
            tmp = searchUser(email);
        } else throw new EmailNoExistException();

        return tmp;
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    /**
     * Control de calendarios
     * @param email
     */

    public void addCalendar(String email){
        if (emailExist(email)){
            searchUser(email).addCalendar();
        } else throw new EmailNoExistException();
    }

    public void removeCalendar(String email, int id){
        if (emailExist(email)){
            try {
                searchUser(email).removeCalendar(id);
            } catch (CalendarNoExistException ex){
                ex.getMessage();
            }
        }
    }

    public Calendar getCalendar(String email, int id){
        Calendar tmp = null;

        if (emailExist(email)){
            try {
                tmp = searchUser(email).getCalendar(id);
            } catch (CalendarNoExistException ex){
                ex.getMessage();
            }
        } else throw new EmailNoExistException();

        return tmp;
    }

    public ArrayList<Calendar> getCalendars(String email){
        ArrayList<Calendar> tmp = null;

        if (emailExist(email)){
            tmp = searchUser(email).getCalendars();
        } else throw new EmailNoExistException();

        return tmp;
    }

    /**
     * Control de eventos
     * @param email
     * @param idCalendar
     * @param name
     * @param iDate
     * @param fDate
     * @param iTime
     * @param fTime
     */

    public void addEvent(String email, int idCalendar, String name, String iDate, String fDate, String iTime, String fTime){
        if (emailExist(email)){
            if (!name.equalsIgnoreCase("")){
                if (!iDate.equalsIgnoreCase("")){
                    if (!fDate.equalsIgnoreCase("")){
                        if (!iTime.equalsIgnoreCase("")){
                            if (!fTime.equalsIgnoreCase("")){
                                try {
                                    searchUser(email).addEvent(idCalendar ,name, iDate, fDate, iTime, fTime);
                                } catch (CalendarNoExistException ex){
                                    ex.getMessage();
                                }
                            } else throw new EmptyParametersException();
                        } else throw new EmptyParametersException();
                    } else throw new EmptyParametersException();
                } else throw new EmptyParametersException();
            } else throw new EmptyParametersException();
        } else throw new EmailNoExistException();
    }

    public void removeEvent(String email, int idCalendar, String nameEvent){
        if (emailExist(email)){
            try {
                searchUser(email).removeEvent(idCalendar, nameEvent);
            } catch (CalendarNoExistException ex){
                ex.getMessage();
            }
        } else throw new EmailNoExistException();
    }

    public void setEvent(String email, int idCalendar, String nameEvent, String newNameEvent, String newIDate, String newFDate, String newITime, String newFTime){
        if (emailExist(email)){
            try {
                searchUser(email).setEvent(idCalendar, nameEvent, newNameEvent, newIDate, newFDate, newITime, newFTime);
            } catch (CalendarNoExistException ex){
                ex.getMessage();
            }
        } else throw new EmailNoExistException();
    }

    public Event getEvent(String email, int idCalendar, String nameEvent){
        Event tmp = null;

        if (emailExist(email)){
            try {
                tmp = searchUser(email).getEvent(idCalendar, nameEvent);
            } catch (CalendarNoExistException ex){
                ex.getMessage();
            }
        } else throw new EmailNoExistException();

        return tmp;
    }

    public ArrayList<Event> getEvents(String email, int idCalendar){
        ArrayList<Event> tmp = null;

        if (emailExist(email)){
            tmp = searchUser(email).getEvents(idCalendar);
        }

        return tmp;
    }
}

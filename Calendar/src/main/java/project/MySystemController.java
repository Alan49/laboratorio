package project;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.exceptions.EmptyParametersException;

import java.util.ArrayList;

/**
 * Created by alan on 05/12/16.
 */
@RestController
public class MySystemController {

    private final MySystem system = new MySystem();

    @RequestMapping("/crearusuario")
    public User addUser(@RequestParam(value = "name", defaultValue = "") String name,
                        @RequestParam(value = "lastname", defaultValue = "") String lastName,
                        @RequestParam(value = "email", defaultValue = "") String email){
        return system.addUser(name, lastName, email);
    }

    @RequestMapping("/eliminarusuario")
    public String removeUser(@RequestParam(value = "email", defaultValue = "") String email){
        system.removeUser(email);
        return "eliminado";
    }

    @RequestMapping("/modificarusuario")
    public String setUser(@RequestParam(value = "email", defaultValue = "") String email,
                          @RequestParam(value = "newname", defaultValue = "") String newName,
                          @RequestParam(value = "newlastname", defaultValue = "") String newLastName,
                          @RequestParam(value = "newemail", defaultValue = "") String newEmail){
        system.setUser(email, newName, newLastName, newEmail);
        return "modificado";
    }

    @RequestMapping("/verusuario")
    public User getUser(@RequestParam(value = "email", defaultValue = "") String email){
        return system.getUser(email);
    }

    @RequestMapping("/verlistausuarios")
    public ArrayList<User> getUsers(){
        return system.getUsers();
    }

    @RequestMapping("/crearcalendario")
    public String addCalendar(@RequestParam(value = "email", defaultValue = "") String email){
        system.addCalendar(email);
        return "calendario creado";
    }

    @RequestMapping("/borrarcalendario")
    public String removeCalendar(@RequestParam(value = "email", defaultValue = "") String email,
                                 @RequestParam(value = "idcalendar", defaultValue = "") String idCalendar){
        if (idCalendar.equalsIgnoreCase("")){
            throw new EmptyParametersException();
        }

        int id = Integer.parseInt(idCalendar);
        system.removeCalendar(email, id);
        return "calendario eliminado";
    }

    @RequestMapping("/vercalendario")
    public Calendar getCalendar(@RequestParam(value = "email", defaultValue = "") String email,
                                @RequestParam(value = "idcalendar", defaultValue = "") String idCalendar){
        if (idCalendar.equalsIgnoreCase("")){
            throw new EmptyParametersException();
        }

        int id = Integer.parseInt(idCalendar);

        return system.getCalendar(email, id);
    }

    @RequestMapping("/verlistacalendarios")
    public ArrayList<Calendar> getCalendars(@RequestParam(value = "email", defaultValue = "") String email){
        return system.getCalendars(email);
    }

    @RequestMapping("/crearevento")
    public String addEvent(@RequestParam(value = "email", defaultValue = "") String email,
                           @RequestParam(value = "idcalendar", defaultValue = "") String idCalendar,
                           @RequestParam(value = "name", defaultValue = "") String name,
                           @RequestParam(value = "inicialdate", defaultValue = "") String iDate,
                           @RequestParam(value = "finaldate", defaultValue = "") String fDate,
                           @RequestParam(value = "inicialtime", defaultValue = "") String iTime,
                           @RequestParam(value = "finaltime", defaultValue = "") String fTime){

        if (idCalendar.equalsIgnoreCase("")){
            throw new EmptyParametersException();
        }

        int id = Integer.parseInt(idCalendar);
        system.addEvent(email, id, name, iDate, fDate, iTime, fTime);
        return "evento creado";
    }

    @RequestMapping("/eliminarevento")
    public String removeEvent(@RequestParam(value = "email", defaultValue = "") String email,
                           @RequestParam(value = "idcalendar", defaultValue = "") String idCalendar,
                           @RequestParam(value = "name", defaultValue = "") String name){
        if (idCalendar.equalsIgnoreCase("")){
            throw new EmptyParametersException();
        }

        String str = "evento eliminado";

        int id = Integer.parseInt(idCalendar);
        system.removeEvent(email, id, name);
        return str;
    }

    @RequestMapping("/modificarevento")
    public String setEvent(@RequestParam(value = "email", defaultValue = "") String email,
                           @RequestParam(value = "idcalendar", defaultValue = "") String idCalendar,
                           @RequestParam(value = "name", defaultValue = "") String name,
                           @RequestParam(value = "newname", defaultValue = "") String newName,
                           @RequestParam(value = "inicialdate", defaultValue = "") String iDate,
                           @RequestParam(value = "finaldate", defaultValue = "") String fDate,
                           @RequestParam(value = "inicialtime", defaultValue = "") String iTime,
                           @RequestParam(value = "finaltime", defaultValue = "") String fTime){
        if (idCalendar.equalsIgnoreCase("")){
            throw new EmptyParametersException();
        }

        int id = Integer.parseInt(idCalendar);
        system.setEvent(email, id, name, newName, iDate, fDate, iTime, fTime);
        return "evento modificado";
    }

    @RequestMapping("/verevento")
    public Event getEvent(@RequestParam(value = "email", defaultValue = "") String email,
                          @RequestParam(value = "idcalendar", defaultValue = "") String idCalendar,
                          @RequestParam(value = "name", defaultValue = "") String name){
        if (idCalendar.equalsIgnoreCase("")){
            throw new EmptyParametersException();
        }

        int id = Integer.parseInt(idCalendar);
        return system.getEvent(email, id, name);
    }

    @RequestMapping("/verlistaeventos")
    public ArrayList<Event> getEvents(@RequestParam(value = "email", defaultValue = "") String email,
                                      @RequestParam(value = "idcalendar", defaultValue = "") String idCalendar){
        if (idCalendar.equalsIgnoreCase("")){
            throw new EmptyParametersException();
        }

        int id = Integer.parseInt(idCalendar);

        return system.getEvents(email, id);
    }

}

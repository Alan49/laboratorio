package project;

import project.myDate.MyDate;
import project.myTime.MyTime;

/**
 * Created by alan on 05/12/16.
 */
public class Event {

    private String name;

    private MyDate inicialDate;
    private MyDate finalDate;

    private MyTime inicialTime;
    private MyTime finalTime;

    public Event(String name, String inicialDate, String finalDate, String inicialTime, String finalTime){
        this.name = name;

        String[] iDate = inicialDate.split("/");
        String[] fDate = finalDate.split("/");

        this.inicialDate = new MyDate(Integer.parseInt(iDate[2]), Integer.parseInt(iDate[1]), Integer.parseInt(iDate[0]));
        this.finalDate = new MyDate(Integer.parseInt(fDate[2]), Integer.parseInt(fDate[1]), Integer.parseInt(fDate[0]));

        String[] iTime = inicialTime.split(":");
        String[] fTime = finalTime.split(":");

        this.inicialTime = new MyTime(Integer.parseInt(iTime[0]), Integer.parseInt(iTime[1]), Integer.parseInt(iTime[2]));
        this.finalTime = new MyTime(Integer.parseInt(fTime[0]), Integer.parseInt(fTime[1]), Integer.parseInt(fTime[2]));
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInicialDate(String inicialDate) {
        String[] iDate = inicialDate.split("/");
        this.inicialDate = new MyDate(Integer.parseInt(iDate[2]), Integer.parseInt(iDate[1]), Integer.parseInt(iDate[0]));
    }

    public void setFinalDate(String finalDate) {
        String[] fDate = finalDate.split("/");
        this.finalDate = new MyDate(Integer.parseInt(fDate[2]), Integer.parseInt(fDate[1]), Integer.parseInt(fDate[0]));
    }

    public void setInicialTime(String inicialTime) {
        String[] iTime = inicialTime.split(":");
        this.inicialTime = new MyTime(Integer.parseInt(iTime[0]), Integer.parseInt(iTime[1]), Integer.parseInt(iTime[2]));
    }

    public void setFinalTime(String finalTime) {
        String[] fTime = finalTime.split(":");
        this.finalTime = new MyTime(Integer.parseInt(fTime[0]), Integer.parseInt(fTime[1]), Integer.parseInt(fTime[2]));
    }

    public String getName() {
        return name;
    }

    public String getInicialDate() {
        return inicialDate.toString();
    }

    public String getFinalDate() {
        return finalDate.toString();
    }

    public String getInicialTime() {
        return inicialTime.toString();
    }

    public String getFinalTime() {
        return finalTime.toString();
    }
}

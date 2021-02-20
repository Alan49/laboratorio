package project.myDate;

/**
 * Created by alan on 05/12/16.
 */
public class MyDate {

    private int year;
    private int month;
    private int day;
    private String[] strMonths = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private String[] strDay = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public boolean isLeepYear(int year){
        if (year % 4 == 0 && year % 100 != 0){
            daysInMonths[1] = 29;
            return true;
        } else if (year % 100 == 0 && year % 400 == 0){
            daysInMonths[1] = 29;
            return true;
        } else {
            daysInMonths[1] = 28;
            return false;
        }
    }

    public int getDayOfWeek(int year, int month, int day){

        /**
         * 1 - Siglos
         */
        int a = 0;
        if (year >= 1700 && year <= 1799){
            a = 5;
        } else if (year >= 1800 && year <= 1899){
            a = 3;
        } else if (year >= 1900 && year <= 1999){
            a = 1;
        } else if (year >= 2000 && year <= 2099){
            a = 0;
        } else if (year >= 2100 && year <= 2199){
            a = -2;
        } else if (year >= 2200 && year <= 2299){
            a = -4;
        }

        /**
         * 2 - Año
         */
        int temp = year % 10; int temp1 = (year / 10) % 10;
        int temp2 = Integer.parseInt(String.valueOf(temp1) + String.valueOf(temp));

        int b = temp2 + (temp2 / 4);

        /**
         * 3 - Años Bisiestos
         */
        int c;
        if (isLeepYear(year)){
            if (month == 2 || month == 1){
                c = -1;
            } else c = 0;
        } else c = 0;

        /**
         * 4 - Mes
         */
        int d = 0;
        switch (month){
            case 1: d = 6; break;
            case 2: d = 2;break;
            case 3: d = 2;break;
            case 4: d = 5;break;
            case 5: d = 0;break;
            case 6: d = 3;break;
            case 7: d = 5;break;
            case 8: d = 1;break;
            case 9: d = 4;break;
            case 10: d = 6;break;
            case 11: d = 2;break;
            case 12: d = 4;break;
        }

        /**
         * 5 - Dia
         */
        int e = day;

        /**
         * 6 - Algoritmo
         */
        int r = a + b + c + d + e;

        do {
            r = r - 7;
        } while (!(r >= 0 && r <= 6));

        return r;
    }

    public boolean isValidDate(int year, int month, int day){
        if (year >= 1 && year <= 2020){
            if (month >= 1 && month <= 12){
                if (day >= 1 && day <= daysInMonths[month - 1]){
                    return true;
                }
                return false;
            }
            return false;
        }

        return false;
    }

    public MyDate(int year, int month, int day) throws MyDateException {
        if (isValidDate(year, month, day)){
            this.year = year;
            this.month = month;
            this.day = day;
        } else throw new MyDateException();
    }

    public void setDate(int year, int month, int day) throws MyDateException {
        if (isValidDate(year, month, day)){
            this.year = year;
            this.month = month;
            this.day = day;
        } else throw new MyDateException();
    }

    @Override
    public String toString() {
        return strDay[getDayOfWeek(this.year, this.month, this.day)] + " " + this.day + " " + strMonths[this.month - 1] + " " + this.year;
    }
}

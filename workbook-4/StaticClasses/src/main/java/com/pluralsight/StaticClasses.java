package com.pluralsight;

public class StaticClasses {
    public static String format(String firstName, String lastName){
        return lastName + ", " + firstName;
    }
    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix){
        return lastName + ", " + prefix + " " + firstName + " " + middleName + ", " + suffix;
    }
    public static String format(String fullName){
        if(fullName.contains(",")) {
            String[] initial = fullName.split(",");
            String[] temp = initial[0].split(" ");
            switch (temp.length) {
                case 2:
                    return temp[1] + ", " + temp[0] + ", " + initial[1].trim();
                case 3:
                    return temp[2] + ", " + temp[0] + " " + temp[1] + ", " + initial[1].trim();
                case 4:
                    return temp[3] + ", " + temp[0] + " " + temp[1] + " " + temp[2] + ", " + initial[1].trim();
            }
        }
        else{
            String[] temp = fullName.split(" ");
            switch (temp.length) {
                case 2:
                    return temp[1] + ", " + temp[0];
                case 3:
                    return temp[2] + ", " + temp[0] + " " + temp[1];
                case 4:
                    return temp[3] + ", " + temp[0] + " " + temp[1] + " " + temp[2];
            }
        }
        return null;
    }
}

package smiyan.aleksey.util;

public class NameCreator {

    public static String getPrefix(){
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String getName(String entityName){
        return entityName + getPrefix();
    }

    public static String getName(String entityName, int countChar) {
        return getName(entityName).substring(0, countChar);
    }
}

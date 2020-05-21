package org.iisi.easysetting;

import com.google.gson.Gson;

/**
 * easysetting
 */
public class Easysetting<T> {
    /*
    public T getSettings(Class<?> settingClass) {
        Gson gson = new Gson();
        String jsonLocation = "./config/" + this.getClassName(settingClass) + ".json";
        T var = gson.fromJson(jsonLocation, settingClass);
        return var;
    }*/

    public String getClassName(Class<?> runtimeClass) {
        String entireClassName = runtimeClass.getName();
        int lastIndexOfDot = entireClassName.lastIndexOf(".");
        String className = entireClassName.substring(lastIndexOfDot + 1);
        return className;
    }
    

    public static void main(String[] args) {
        Integer i = new Integer(10);
        System.out.println(Integer.class.getName());
    }
}
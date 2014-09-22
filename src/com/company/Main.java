package com.company;

import java.io.File;
import java.lang.reflect.Method;

//http://habrahabr.ru/post/104229/

public class Main {
    public static void main(String[] args) throws ClassNotFoundException{
        String modulePath = args[0];

        //Создаем загрузчик модулей
        ModuleLoader loader = new ModuleLoader("task_4_moduled.jar", ClassLoader.getSystemClassLoader());
        System.out.println(loader.findClass("FirstModule").getName());
        //Получаем список доступных модулей
        File dir = new File(modulePath);
        String[] modules = dir.list();

        //Загружаем и исполняем каждый модуль
        for(String module : modules) {
            try {
                String moduleName = module.split(".class")[0];
                Class clazz = loader.loadClass(moduleName);
                Module execution = (Module) clazz.newInstance();

                execution.load();
                execution.run();
                execution.unload();
            } catch(ClassNotFoundException e) {
                e.printStackTrace();
            } catch(InstantiationException e) {
                e.printStackTrace();
            } catch(IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }
}

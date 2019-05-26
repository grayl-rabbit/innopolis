package main.java.part01.lesson08.task01;/*
 *  26.05.2019
 *  main.java.part01.lesson08.task01
 *  innopolis
 *  @author L
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if ("main.java.part01.lesson08.task01.service.WorkerImpl".equals(name)) {
            return findClass(name);
        }
        return super.loadClass(name); // механизм загрузки
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("findClass starts work: " + name);
        if ("main.java.part01.lesson08.task01.service.WorkerImpl".equals(name)) {
            try {
                byte[] bytes = Files.readAllBytes(Paths.get("WorkerImpl.class"));
                return defineClass(name, bytes, 0, bytes.length); // мапит byte[] в Class
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.findClass(name);
    }
}

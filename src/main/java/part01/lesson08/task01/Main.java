package main.java.part01.lesson08.task01;

import main.java.part01.lesson08.task01.service.Worker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input code: ");
        String code = in.nextLine();
        in.close();
    }


    private static void useCustomClassLoader() throws Exception {
        ClassLoader cl = new MyClassLoader();
        Class<?> worker = cl.loadClass("main.java.part01.lesson08.task01.service.WorkerImpl");
        Worker kindMagic = (Worker) worker.newInstance();
        kindMagic.doWork();
    }
}

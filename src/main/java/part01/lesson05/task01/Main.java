package main.java.part01.lesson05.task01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
////        File file = new File(new File("bel.txt").);
//        File file = new File("src/main/java/part01/lesson05/bel");
//
////        Files.copy(Paths.get("fileToWrite"), Paths.get("newTest"));
//
//        printPaths(file);
//
//        FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath());
//
//        BufferedInputStream reader2 = new BufferedInputStream(fileInputStream, 200);
//        BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()));

//        int i;
//
//        while((i = bufferedInputStream.read())!= -1){
//
//            System.out.print((char)i);
//        }

//        Map<String, String> map=new TreeMap<String, String>();
//        String line="";
//        int i=0;
//        while((line=reader.readLine())!=null){
//            System.out.println(line);
//            map.put(getField(line),line);
//        }
//        reader.close();
//        FileWriter writer = new FileWriter("fileToWrite");
//        for(String val : map.values()){
//            writer.write(val);
//            writer.write('\n');
//        }
//        writer.close();


        List<String> bel = Files.readAllLines(Paths.get("words"));
        List<String> txt = new ArrayList<String>();
        bel.forEach(txt::add);
//        Collections.sort(txt, new SortIgnoreCase());
//        System.out.println(txt);
        Comparator<String> comparator = Comparator.comparing(String::toLowerCase);
        Collections.sort(txt, comparator);
        List<String> collect = txt.stream()
                .map(String::toLowerCase)
                .distinct()
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    private static void printPaths(File file) throws IOException {
        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("Canonical Path: " + file.getCanonicalPath());
        System.out.println("Path: " + file.getPath());
    }

    private static String getField(String line) {
        return line.split(" ")[0];//extract value you want to sort on
    }

    public static class SortIgnoreCase implements Comparator<Object> {
        public int compare(Object o1, Object o2) {
            String s1 = (String) o1;
            String s2 = (String) o2;
            return s1.toLowerCase().compareTo(s2.toLowerCase());
        }
    }
}

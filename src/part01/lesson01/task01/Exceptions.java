package part01.lesson01.task01;/*
 *  21.04.2019
 *  part01.lesson01.task01
 *  innopolis
 *  @author L
 */

public class Exceptions {

    public void hello(){
        System.out.println("Hello World!");
    }

    public void npe(){
        String msg = null;

        try {
            if(msg.equals("some txt")){
                System.out.println("O_o");
            }
        }catch (NullPointerException e){
            System.out.println("NullPointerException Caught - " + e);
        }
    }

    public void indexOutOfBounds(){
        int[] arr = {1,2,3};

        try {
            System.out.println("arr[5]: " + arr[5]);
        }catch (IndexOutOfBoundsException e){
            System.out.println("IndexOutOfBoundsException Caught - " + e);
        }
    }

    public void testError(){
        try {
            throw new StringIndexOutOfBoundsException("test");
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("StringIndexOutOfBoundsException Caught - " + e);
        }
    }

}

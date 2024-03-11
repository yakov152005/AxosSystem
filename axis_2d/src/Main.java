import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     Ex1();
     Ex2();
     Ex3();
     Ex4();
     Ex5();
     Ex6();
     Ex7();
     Ex8();
    }
    public static Random r = new Random();
    public static Scanner s = new Scanner(System.in);
    public static AxisSystem axisSystem1 = new AxisSystem();
    public static void addSinglePoint(AxisSystem axisSystem, int x, int y){
        axisSystem.addSinglePoint(x,y,"BLUE");
    }
    public static void addMultiplePoint(AxisSystem axisSystem, int[] arr,String color){
        axisSystem.addMultiplePoints(arr,color);
    }
    public static void clear(AxisSystem axisSystem){
        axisSystem.clear();
    }
    public static void Ex1(){
        addSinglePoint(axisSystem1,100,150);
    }
    public static void Ex2(){
       addSinglePoint(axisSystem1,-200,200);
    }
    public static void Ex3(){
        int[] arr = {70,70,60,60,50,50};
        String color = "BLUE";
       addMultiplePoint(axisSystem1,arr,color);
    }
    public static void Ex4(){
        System.out.print("Enter X: ");
        int x = s.nextInt();
        System.out.print("Enter Y: ");
        int y = s.nextInt();
        addSinglePoint(axisSystem1,x,y);
    }
    public static void Ex5(){
        System.out.print("How many point you want to draw? ");
        int point = s.nextInt();
        System.out.print("Which color --> ");
        String color = s.next();
        int[] arr = new int[point*2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(30);
        }
        for (int i = 0; i < arr.length; i++) {
            addMultiplePoint(axisSystem1, arr,color);
        }
    }
    public static void Ex6(){
        for (int i = 0; i < 10; i++) {
            int x = r.nextInt(30);
            int y = (2*x) + 100;
            addSinglePoint(axisSystem1,x,y);
        }

    }
    public static void Ex7() {
        System.out.println("|Enter a details for y = mx + n| -->");
        System.out.print("Enter mx --> ");
        int mx = s.nextInt();
        System.out.print("Enter n --> ");
        int n = s.nextInt();
        for (int x = -250; x <= 250; x++) {
            int y =(mx*x) + n;
            if (y >= -250 && y <= 250) {
                addSinglePoint(axisSystem1, x, y);
            }
        }
    }
    public static void Ex8(){
        for (int x = -250; x <= 250; x++) {
            int y = (int) (2 * Math.pow(x, 2) - 3 * x + 50);
            if (y >= -250 && y <= 250) {
                addSinglePoint(axisSystem1, x, y);
                }
            }
        }
    }



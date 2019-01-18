import java.util.HashSet;
import java.util.Vector;
import java.util.Scanner;


class Menu{
    public static void main(String[] args){
        printMenu();
        Scanner stdin = new Scanner(System.in);
        String file;
        while(true){
            switch(stdin.nextInt()){
                case 1:{
                    file = "iris.csv";
                    break;
                }
                case 2:{
                    file = "restaurant.csv";
                    break;
                }
                case 3:{
                    file = "weather.csv";
                    break;
                }
                case 4:{
                    System.out.println("Escreva o nome do ficheiro sem .csv");
                    file = stdin.next() + ".csv";
                    break;
                }
                default: return; //sair
            }

            printMenu();
        }
    }

    private static void printMenu(){
        System.out.println("1 - usar iris.csv");
        System.out.println("2 - usar restaurant.csv");
        System.out.println("3 - usar weather.csv");
        System.out.println("4 - usar outro");
        System.out.println("5 - sair");
    }



}

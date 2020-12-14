package pkg21pickup;

import java.util.Random;
import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int chips = 10;
        boolean finnished=false;
        while(finnished==false){
            System.out.println("How much are you going to bet? you currently have "+chips+"chips.");
            boolean temp1 = false;
            while(temp1==false){
                int temp = input.nextInt();
                if(temp<(chips+1)){
                    int bet = temp;
                    temp1=true;
                }else{
                    System.out.println("Plese enter a number equal to or below your total number of chips");
                }
            }
            int round = round();
            int comround = comround();
            if(round>21){
                System.out.println("You lost, too bad. You lose all your chips.");
                if(chips==0){
                    System.out.println("Oh no, you've bet all your chips!You've lost the game!");
                    finnished=true;
                }
            }else{
                if(comround>round){
                    System.out.println("You lost, too bad. You lose all your chips.");
                    if(chips==0){
                        System.out.println("Oh no, you've bet all your chips!You've lost the game!");
                        finnished=true;
                    }
                }else{
                    if(comround<round){
                        System.out.println("Good job, you won! your bet chips have been doubled!");
                        
                    }  
                }
            }
            System.out.println("Do you want to play again?");
            if((input.next()).equalsIgnoreCase("no")){
                finnished = true;
            }
        }
        System.out.println("You got a total of "+chips+" chips.");
    }
    
    public static int round(){
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        int total = 0;
        boolean finnished = false;
        while(finnished==false){
            int temp = random.nextInt(13)+1;
            System.out.println("The card you got was ");
            check(temp);
            total = total+ temp;
            if(total>21){
                System.out.println("Oh no, your total is "+total+", thats over 21! you lose this round!");
                finnished=true;
                break;
            }
            System.out.println("Do you want to draw another card?");
            if((input.next()).equalsIgnoreCase("no")){
                finnished = true;
                break;
            }
        }
        return total;
    }
    
    public static int comround(){
        Random random = new Random();
        int total = 0;
        boolean finnished = false;
        while(finnished==false){
            int temp = random.nextInt(13)+1;
            System.out.println("The dealer got ");
            check(temp);
            System.out.println("Their total so far is "+total);
            if((total>17)){
                finnished=true;
            }else{
                System.out.println("They are drawing another card");
            }
        }
        return total;
    }
    
    public static void check(int a){
        if((a>1)&&(a<11)){
            System.out.println("a "+a);
        }
        if((a==1)){
            System.out.println("an Ace");
        }
        if((a==11)){
            System.out.println("a Jack");
        }
        if((a==12)){
            System.out.println("a Queen");
        }
        if((a==13)){
            System.out.println("a King");
        }
    }
    
}

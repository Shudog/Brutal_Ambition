import java.lang.Math;

public class highdice {
    public static void main (String args[]){
        double p1r,p2r,d1r,d2r;
        int ptotal,dtotal;
        p1r = Math.random();
        p2r = Math.random()  ;
        d1r = Math.random()   ;
        d2r = Math.random();
        p1r *= 6;
        p2r *= 6 ;
        d1r *= 6   ;
        d2r *= 6  ;
        int p1 = (int) p1r;
        int p2 = (int) p2r;
        int d1 = (int) d1r;
        int d2 = (int) d2r;
        p1++;
        p2++;
        d1++;
        d2++;
        ptotal = p1+p2               ;
        dtotal = d1+d2               ;

        //Print out the scores...
        System.out.print("Player: ");
        System.out.println(p1+" + "+p2+" = "+ptotal);
        System.out.print("Dealer: ");
        System.out.println(d1+" + "+d2+" = "+dtotal);

        //Decide who wins and display it
        if(ptotal > dtotal){
            String result = "win";
            System.out.println("You Win!");
        }
        else if(ptotal == dtotal){
            String result = "tie";
            System.out.println("You tied.");
        }
        else if(ptotal < dtotal){
            String result = "loss";
            System.out.println("You lost.");
        }
        System.out.println("");
        System.out.println("");
        System.out.print("This program was made by Braden Shepherdson on July 10, 2001.");
        System.out.print("Braden is 14 years old and lives in Ontario, Canada.");
        System.out.print("Thanks go to the author of Brewing Java for his tutorial and to");
        System.out.println(" Planet Source Code.com for hosting it.");

    }
}
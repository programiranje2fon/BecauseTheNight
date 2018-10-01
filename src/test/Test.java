/*
 * Created on Oct 1, 2018
 *
 */
package test;

import java.util.Scanner;

import music.Performer;
import music.Song;

public class Test {
    
    public static final Scanner IN = new Scanner(System.in);
    
    public void testPrintln() {
        System.out.println("Hi.");
        System.out.println("" + 1 + '.' + "10." + 2018);
        System.out.println("Hi again :)");
        System.out.println();
        String songRating = "legendary";
        System.out.println("\"Because the Night\" is a " + songRating.toUpperCase() + " song, " + '\n' +
                '\t' + "written by Bruce Springsteen and Patti Smith," + '\n' +
                '\t' + "released on March 02, 1978.");
    }
    
    public void testKeyboardInput() {
        System.out.print("Enter something: ");
        String something = IN.nextLine();
        System.out.println("Here's what you entered: " + something);
    }
    
    public void testSongs() {
        Song becauseTheNight = new Song("Because the Night", 1978);
//        System.out.println(becauseTheNight.title);                  // No way! "title" is private!
        System.out.println("Printing just the title: " + 
                            becauseTheNight.getTitle());
        System.out.println("Printing the song object: " + 
                            becauseTheNight);                         // Ha, what's that?!?!
        System.out.println();
        
        Song dancingInTheDark = new Song();
        Performer bruceSpringsteen = new Performer("Bruce Springsteen", true, 69);
        dancingInTheDark.setTitle("Dancing in the Dark");
        dancingInTheDark.setPerformer(bruceSpringsteen);
        dancingInTheDark.setYear(1984);
        bruceSpringsteen.play(dancingInTheDark);
    }

}

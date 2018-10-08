/*
 * Created on Oct 1, 2018
 *
 */
package test;

import java.util.Scanner;

import music.Album;
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
        dancingInTheDark.setTitle("");
        dancingInTheDark.setTitle("Dancing in the Dark");
        dancingInTheDark.setPerformer(bruceSpringsteen);
        dancingInTheDark.setYear(1984);
        bruceSpringsteen.play(dancingInTheDark);
    }
    
    public void testIntegerAndDouble() {
        int n = 3;
        Integer i = new Integer("5");
        System.out.println("int n: " + n);
        System.out.println("Integer i: " + i);
        System.out.println("i.doubleValue(): " + i.doubleValue());
        System.out.println();
        
        double r = 4.5;
        Double d = new Double(5);
        System.out.println("double r: " + r);
        System.out.println("Double d: " + d);
        System.out.println("d.intValue(): " + d.intValue());
    }
    
    public void testStatic() {
        Song becauseTheNight = new Song("Because the Night", 1978);
        System.out.println("becauseTheNight.getConcept(): " + becauseTheNight.getConcept());
        System.out.println("Song.getConcept(): " + Song.getConcept());
        Song dancingInTheDark = new Song();
        System.out.println("dancingInTheDark.getConcept(): " + dancingInTheDark.getConcept());
        System.out.println();
        
        dancingInTheDark.setConcept("A very nice piece of music");
        System.out.println("becauseTheNight.getConcept(): " + becauseTheNight.getConcept());
        System.out.println("dancingInTheDark.getConcept(): " + dancingInTheDark.getConcept());
        System.out.println("Song.getConcept(): " + Song.getConcept());

        System.out.println();
        System.out.print("Song.defineConcept(): ");
        Song.defineConcept();
    }
    
    public void testLoops() {
        for (int i = 0; i < 5; i++) {       // basic for loop
            System.out.println(i);
        }
        System.out.println();
        
        int i = 0;
        while (i < 5) {                     // basic while loop
            System.out.println(i);
            i++;
        }
        System.out.println();
        
        i = 0;
        do {                                // basic do-while loop
            System.out.println(i);
            i++;
        } while (i < 5);
        System.out.println();
        
        for (int i1 = 0; i1 < 5; i1++) {    // continue and break
            if (i1 == 3) {
//                continue;
                break;
            }
            System.out.println(i1);
        }
        System.out.println();
    }
    
    public void testArrays() {
//        int[] a = new int[5];
//        for (int i = 0; i < 6; i++) {       // exception!!!
//            a[i] = i + 1;
//            System.out.println(a[i]);
//        }
//        System.out.println();
        
//        int[] a = new int[5];
//        for (int i = 0; i < a.length; i++) {
//            a[i] = i + 1;
//            System.out.println(a[i]);
//        }
//        System.out.println();
        
//        int[] a = new int[5];               // foreach loop
        int[] a = {0, 1, 2, 3, 4};
        for (int j : a) {
            a[j] = j + 1;
            System.out.println(a[j]);
        }
        System.out.println();
        
    }
    
    public void testAlbum() {
        Song becauseTheNight = new Song("Because the Night", 1978);
        Song dancingInTheDark = new Song("Dancing in the Dark", 1984);
        Song bornInTheUSA = new Song("Born in the USA", 1984);
        
        Song[] songs = {becauseTheNight, dancingInTheDark, bornInTheUSA};
        Album bornInTheUSAAlbum = new Album("Born in the USA", 1984, songs);
        for (int i = 0; i < songs.length; i++) {
            System.out.println(bornInTheUSAAlbum.getSongs()[i].getTitle());
        }
        System.out.println();
        
//        Album bornInTheUSAAlbumV2 = new Album("Born in the USA", 1984, 3);
//        for (int i = 0; i < songs.length; i++) {
//            System.out.println(bornInTheUSAAlbumV2.getSongs()[i].getTitle());       // No!!! Album.songs[i] is not initialized yet!
//        }
    }

}

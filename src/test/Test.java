/*
 * Created on Oct 1, 2018
 *
 */
package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import music.Album;
import music.Band;
import music.Composer;
import music.GuitarPlayer;
import music.MusicPlayer;
import music.Musician;
import music.Performance;
import music.Performer;
import music.PerformingArtist;
import music.Singer;
import music.Song;
import music.SongNotIncludedException;
import music.enums.Genre;
import music.enums.GuitarRole;
import music.enums.Instrument;
import music.enums.Vocals;
import util.Utility;

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
    
    public void testSwitch() {
        System.out.print("Enter an int between 0 and 2: ");
        int a = IN.nextInt();
        switch (a) {
            case 0: System.out.println(0); break;
            case 1: System.out.println(1); break;
            case 2: System.out.println(2); break;
            default: System.out.println("Value not between 0 and 2: " + a);
        }
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
//            System.out.println(bornInTheUSAAlbum.getSongs()[i].getTitle());
            System.out.println(bornInTheUSAAlbum.getSongs()[i]);
        }
        System.out.println();
        
//        Album bornInTheUSAAlbumV2 = new Album("Born in the USA", 1984, 3);
//        for (int i = 0; i < songs.length; i++) {
//            System.out.println(bornInTheUSAAlbumV2.getSongs()[i].getTitle());       // No!!! Album.songs[i] is not initialized yet!
//        }
        
        System.out.println(bornInTheUSAAlbum);
    }
    
    public void testStrings() {
    	Performer pattiSmith = new Performer("Patti Smith", true, 72);
        Song becauseTheNight = new Song("Because the Night", 1978, pattiSmith);
        
        if (becauseTheNight.getTitle().contains("Because")) {
        	System.out.println("\"Because\" is in \"Because the Night\"");
        }
        System.out.println();
        
        String[] wordsInTitle = becauseTheNight.getTitle().split(" ");
        for (String string : wordsInTitle) {
			System.out.println(string);
		}
        System.out.println();
        
        StringBuffer sb = new StringBuffer();
        sb.append("Because").append(" the ").append("Night !");
        System.out.println(sb);
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb);
    }
    
    public void testArrayList() {
    	Performer pattiSmith = new Performer("Patti Smith");
    	Performer jayDeeDaugherty = new Performer("Jay Dee Daugherty");
    	Performer richardSohl = new Performer("Richard Sohl");
    	Performer ivanKral = new Performer("Ivan Kral");
    	Performer lennyKaye = new Performer("Lenny Kaye");
    	
    	Band pattiSmithGroup = new Band();
    	pattiSmithGroup.setName("Patti Smith Group");
    	pattiSmithGroup.addPerformer(pattiSmith);
    	pattiSmithGroup.addPerformer(lennyKaye);
    	pattiSmithGroup.addPerformer(ivanKral);
    	pattiSmithGroup.addPerformer(richardSohl);
    	pattiSmithGroup.addPerformer(jayDeeDaugherty);
    	System.out.println(pattiSmithGroup);
    }
    
    public void testGregorianCalendar() {
    	GregorianCalendar c = new GregorianCalendar();
    	System.out.println(c);
    	System.out.println(c.getTime());
    	System.out.println();
    	
    	Album easter = new Album("Easter", 1978, null, new GregorianCalendar(1978, 2, 3));
    	easter.printReleaseDate();
    	if (easter.getReleaseDate().before(new GregorianCalendar())) {
    		System.out.println("That was long ago...");
    	}
    }
    
    public void testNumberFormatting() {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        System.out.println((double) 6/7);
        System.out.println("6/7 with NumberFormat and 2 fraction digits: " + nf.format((double) 6/7));
        System.out.println("Math.PI with NumberFormat and 2 fraction digits: " + nf.format(Math.PI));
        nf.setMaximumFractionDigits(3);
        System.out.println("6/7 with NumberFormat and 3 fraction digits: " + nf.format((double) 6/7));
        System.out.println();
        
        System.out.printf("%s%.2f%n", "6/7 with PrintStream.printf() and 2 fraction digits: ", (double) 6/7);
        System.out.printf("%s%.3f%n", "6/7 with PrintStream.format() and 3 fraction digits: ", (double) 6/7);
        System.out.println();
        
        System.out.println(String.format("%s%.2f", "6/7 with String.format() and 2 fraction digits: ", (double) 6/7));
        System.out.println(String.format("%s%.3f", "6/7 with String.format() and 3 fraction digits: ", (double) 6/7));
        System.out.println();
    }
    
    public void testInheritance() {
        MusicPlayer bruceSpringsteen = new MusicPlayer("Bruce Springsteen",true, 69, Instrument.GUITAR);
        System.out.println(bruceSpringsteen);
        System.out.println();
        
        bruceSpringsteen.play();
        System.out.println();
        Song theRising = new Song("The Rising", 2002);
        bruceSpringsteen.play(theRising);
        System.out.println();
        
        GuitarPlayer georgeHarrison = new GuitarPlayer("George Harrison", false, 0, Instrument.GUITAR, GuitarRole.LEAD);
        System.out.println(georgeHarrison);
        System.out.println();
        Song longLongLong = new Song("Long, Long, Long", 1968);
        georgeHarrison.play(longLongLong);
        System.out.println();
        
        Performer pattiSmith = new Performer("Patti Smith", true, 72);
        Song becauseTheNight = new Song("Because the Night", 1978);
        pattiSmith.play(becauseTheNight);
        System.out.println();

//        Polymorphism
        
        Performer[] performers = {pattiSmith, bruceSpringsteen, georgeHarrison};
        for (Performer performer : performers) {
            performer.play(longLongLong);
            System.out.println();
        }
        
    }

    public void testEquals() {
        
//        Album easter = new Album("Easter", 1978, null, new GregorianCalendar(1978, 2, 3));
//        Album e = new Album("Easter", 1978, null, new GregorianCalendar(1978, 2, 3));
//        if (easter == e) {
//            System.out.println(true);
//        } else {
//            System.out.println(false);
//        }
//        if (easter.getTitle() == e.getTitle()) {
//            System.out.println(true);
//        } else {
//            System.out.println(false);
//        }
        
        Singer pattiSmith = new Singer("Patti Smith", true, 72, Vocals.LEAD);
        Singer patti = new Singer("Patti Smith", true, 72, Vocals.BACKGROUND);
        if (pattiSmith.equals(patti)) {
            System.out.println("Yes, that's the same old Patti Smith :)");
        } else {
            System.out.println("No, that's someone else...");
        }
    }
    
    public void testAbstractClasses() {
        
//        Musician m = new Musician(Genre.BLUES);                       // No! Musician is an abstract class!
//        Musician m = new Musician(Genre.BLUES) {
//            
//            @Override
//            public void play() {
//                // TODO Auto-generated method stub
//                
//            }
//        };
//        System.out.println(m.getGenre());
        
        Performer p = new Performer();
        p.play();
        System.out.println(p.getGenre());
        p.setGenre(Genre.BLUES);
        System.out.println(p.getGenre());
        System.out.println();
        
        Composer c = new Composer(Genre.ROCK, "Mike Stoller");          // the composer of Elvis Presley's hit "Jailhouse Rock" :)
        c.play();
    }
    
    public void testInterfaces() {
        Performance p1 = new Performance(new GregorianCalendar(1972, 9, 25), "Point Pleasant, NJ");
        Performance p2 = new Performance(new GregorianCalendar(1971, 1, 10), "New York City, NY");
        
        Band eStreetBand = new Band("E Street Band", new ArrayList<Performer>(), false, p1, 200);
        eStreetBand.addPerformer(new Performer("Bruce Springsteen"));
        Performer patti = new Performer(Genre.ROCK, "Patti Smith", true, 72, p2);
        
        PerformingArtist[] artists = {eStreetBand, patti};
        artists[0].showFirstPerformance();
        artists[1].showFirstPerformance();
        artists[0].showMembers();
        System.out.println();
        
        List<String> titles = new LinkedList<String>();
        titles.add("Because the Night");
        titles.add("Dancing Barefoot");
        for (String title : titles) {
            System.out.println(title);
        }
    }
    
    public void testIterators() {
        Performer pattiSmith = new Performer("Patti Smith");
        Performer jayDeeDaugherty = new Performer("Jay Dee Daugherty");
        Performer richardSohl = new Performer("Richard Sohl");
        Performer ivanKral = new Performer("Ivan Kral");
        Performer lennyKaye = new Performer("Lenny Kaye");
        
        Band pattiSmithGroup = new Band();
        pattiSmithGroup.setName("Patti Smith Group");
        pattiSmithGroup.addPerformer(pattiSmith);
        pattiSmithGroup.addPerformer(lennyKaye);
        pattiSmithGroup.addPerformer(ivanKral);
        pattiSmithGroup.addPerformer(richardSohl);
        pattiSmithGroup.addPerformer(jayDeeDaugherty);
        System.out.println(pattiSmithGroup);

//        while (pattiSmithGroup.hasNext()) {
//            System.out.println(pattiSmithGroup.next());
//        }
//        System.out.println();

//        for (Performer p : pattiSmithGroup.getMembers()) {        // No! Throws ConcurrentModificationException.
//            pattiSmithGroup.remove(p);
//        }
        
//        while (pattiSmithGroup.hasNext()) {
//            pattiSmithGroup.remove(pattiSmithGroup.next());
//        }
//        System.out.println(pattiSmithGroup);
        
//        pattiSmithGroup.removeAllMembers();
        
//        Iterator<Performer> i = pattiSmithGroup.getMembers().iterator();
//        while (i.hasNext()) {
//            i.next();
//            i.remove();
//        }
        
        Iterator<Performer> i = pattiSmithGroup.iterator();
        while (i.hasNext()) {
            i.next();
            i.remove();
        }
        
        System.out.println(pattiSmithGroup);
        
    }
    
    public void testExceptions() {
        
        Performer bruceSpringsteen = new Performer("Bruce Springsteen");
        
        Song gloryDays = new Song("Glory Days", 1984, bruceSpringsteen);
        Song dancingInTheDark = new Song("Dancing in the Dark", 1984, bruceSpringsteen);
        Song bornInTheUSA = new Song("Born in the USA", 1984, bruceSpringsteen);
        
        Song becauseTheNight = new Song("Because the Night", 1978, bruceSpringsteen);
        
        Song[] songs = {gloryDays, dancingInTheDark, bornInTheUSA};
        Album bornInTheUSAAlbum = new Album("Born in the USA", 1984, songs);
        
        try {
//            Album.playSong(gloryDays, bornInTheUSAAlbum);
            Album.playSong(becauseTheNight, bornInTheUSAAlbum);
        } catch (SongNotIncludedException e) {
            e.printStackTrace();
            System.out.println("Handling exception: " + e.getMessage());
        } finally {
            System.out.println("\nFinally, some optional steps...");
        }
    }
    
    public void testTextFiles() {
        
        Song gloryDays = new Song("Glory Days", 1984);
        Song dancingInTheDark = new Song("Dancing in the Dark", 1984);
        Song bornInTheUSA = new Song("Born in the USA", 1984);
        
        File f = new File("songs.txt");
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f)));
            out.println(gloryDays.getTitle());
            out.println(gloryDays.getYear());
            out.println(dancingInTheDark.getTitle());
            out.println(dancingInTheDark.getYear());
            out.println(bornInTheUSA.getTitle());
            out.println(bornInTheUSA.getYear());
            out.flush();
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Songs saved to a text file.");
        System.out.println();
        
        Song[] songs = new Song[3];
        try {
            BufferedReader in = new BufferedReader(new FileReader(f));
            for (int i = 0; i < songs.length; i++) {
                songs[i] = new Song();
                songs[i].setTitle(in.readLine());
                songs[i].setYear(Integer.parseInt(in.readLine()));
            }
            in.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        for (Song song : songs) {
            System.out.println(song);
        }
        System.out.println();
        
        System.out.print("Enter something: ");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(in.readLine());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    public void testSerialization() {
        Song gloryDays = new Song("Glory Days", 1984);
        gloryDays.serialize("Glory Days.serialized");
        System.out.println("Song serialized.");
        System.out.println();
    }
    
    public void testDeserialization() {
        Song gloryDays = Song.deserialize("Glory Days.serialized");
        System.out.println("Song deserialized.");
        System.out.println(gloryDays);
    }
    
    public void testProjectDir() {
        System.out.println(Utility.getProjectDir());
    }
    
    public void testMkProjectSubdir() {
        System.out.println(Utility.mkProjectSubdir("resources"));
    }
    
}

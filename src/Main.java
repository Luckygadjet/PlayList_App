import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Album album1 = new Album("Sarkar","Thaman");
        album1.addSong("Kalaavathi",5.45);
        album1.addSong("Penny",4.30);

        Album album2 = new Album("Pushpa","DSP");
        album2.addSong("Oo Antava",3.29);
        album2.addSong("yee bidda",4.57);


        LinkedList<Song> myplaylist = new LinkedList<>();
        System.out.println(album1.addSongToPlayListfromAlbum("Penny",myplaylist));
        System.out.println(album2.addSongToPlayListfromAlbum(1,myplaylist));
        System.out.println(album1.addSongToPlayListfromAlbum(1,myplaylist));
        System.out.println(album2.addSongToPlayListfromAlbum(2,myplaylist));


        System.out.println(album1.findsong("chumma"));
        System.out.println(album1.addSong("Penny",4.56));


        play(myplaylist);


    }
    public static void play(LinkedList<Song> myplaylist)
    {
        if(myplaylist.size() == 0)
        {
            System.out.println("Sorry Your Plalist is Empty");
            return;
        }

        ListIterator<Song> itr = myplaylist.listIterator();
        System.out.println("Current Playing: ");
        System.out.println(itr.next());
        boolean isNext = true;

        Scanner sc = new Scanner(System.in);
        System.out.println("1.next_Song");
        System.out.println("2.previous-Song");
        System.out.println("3.repeat current song");
        System.out.println("4.Print All Songs in the PlaList");
        System.out.println("5.");
        System.out.println("6.");
        System.out.println("7.Exit");

        while(true)
        {
            System.out.println("Enter the Choice");
            int choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                    if(!isNext)
                    {
                        itr.next();
                        isNext = true;
                    }
                    if(itr.hasNext()) {
                        System.out.println("Current Playing: ");
                        System.out.println(itr.next());
                        isNext = true;
                    }
                    else {
                        System.out.println("Hey you reached end of the song List");
                    }
                    break;
                case 2:
                    if(isNext)
                    {
                        itr.previous();
                        isNext = false;
                    }
                    if(itr.hasPrevious())
                    {
                        System.out.println("Currently Playing");
                        System.out.println(itr.previous());
                        isNext = false;
                    }
                    else {
                        System.out.println("You are at 1st Song ALready");
                    }
                    break;
                case 3:

                    System.out.println("You are Playing the song again"+itr.previous());
                    itr.next();
                    break;
                case 4:
                    printallsongs(myplaylist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    itr.remove();
                    break;
                case 7:
                    return;

            }
        }

    }
    //static void del(LinkedList<Song> myplayList)
    static void printallsongs(LinkedList<Song> myplayList)
    {
        for(Song s : myplayList)
        {
            System.out.println(s);
        }
        return; // good practice
    }
    static void printMenu()
    {
        System.out.println("1.next_Song");
        System.out.println("2.previous-Song");
        System.out.println("3.repeat current song");
        System.out.println("4.Print All Songs in the PlaList");
        System.out.println("5.Print Menu");
        System.out.println("6. Delete the Current Song");
        System.out.println("7.Exit");
    }
}
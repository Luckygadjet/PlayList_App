import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Album {

    private String Title;
    private String Artist;

    private List<Song> songs;

    public Album(String title, String artist) {
        Title = title;
        Artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    boolean findsong(String title)
    {
        for(Song song:songs)
        {
            if(song.getTitle().equals(title))
            {
                return true;
            }

        }
        return false;
    }
    String addSong(String title,double duration)
    {
        Song s = new Song(title,duration); // We are making this bcos our data type is Song so we create it
        if(findsong(title) == false)
        {
            songs.add(s);
            return "Song has been Added to ALbum";
        }

        return "This SOng is ALready Present In it";
    }

    String addSongToPlayListfromAlbum(String title, LinkedList<Song> playList)
    {
        if(findSOngfromplayListfrom(title,playList) == false)
        {
            return "This SOng is ALready added in PlayList";
        }
        if(findsong(title) == true)
        {
            for(Song s : songs)
            {
                if(s.getTitle().equals(title) == true)
                {
                    playList.add(s);
                    return "SOng added to PlalIst and Njoy";
                }
            }
        }

        return "Sorry couldnt FInd";
    }

    String addSongToPlayListfromAlbum(int trackNo,LinkedList<Song> playList)
    {

        if(findSOngfromplayListfrom(trackNo,playList) == false)
        {
            return "This SOng is ALready added in PlayList";
        }
        int index = trackNo -1;
        if(index >= 0 && index < this.songs.size())
        {
            playList.add(this.songs.get(index));
            return "Song Added to PlayList Adn Njoy";
        }

        else {
            return "Track No is wrong";
        }

    }
    boolean findSOngfromplayListfrom(String title,LinkedList<Song> playList)
    {
        ListIterator<Song> itr = playList.listIterator();
        while(itr.hasNext())
        {
            if(itr.next().getTitle().equals(title))
            {
                return false;
            }
        }
        return true;
    }
    boolean findSOngfromplayListfrom(int trackNo,LinkedList<Song> playList)
    {
        int indx = trackNo -1;
        String title="";
        if(indx>=0 && indx < playList.size())
        {
            title = this.songs.get(indx).getTitle();
        }
        ListIterator<Song> itr = playList.listIterator();
        while(itr.hasNext())
        {
            if(itr.next().getTitle().equals(title))
            {
                return false;
            }
        }
        return true;
    }

}

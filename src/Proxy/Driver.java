package Proxy;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        Song song1 = new Song("song1", "artist1", "album1", 1, 100);
        Song song2 = new Song("song2", "artist1", "album1", 2, 100);
        Song song3 = new Song("song3", "artist2", "album1", 3, 100);
        Song song4 = new Song("song4", "artist3", "album1", 4, 100);
        Song song5 = new Song("song5", "artist4", "album1", 5, 100);

        List<Song> song_list_1 = new ArrayList<Song>();
        song_list_1.add(song1);
        song_list_1.add(song2);
        song_list_1.add(song3);
        song_list_1.add(song4);
        song_list_1.add(song5);

        Proxy song6 = new Proxy("song1", "artist6", "album2", 6, 100);
        List<Song> song_list_2 = new ArrayList<Song>();
        song_list_2.add(song6);

        song1.searchByID(song_list_1, song1.getSongID());

        song6.searchByID(song_list_2, song6.getSongID());

    }
}

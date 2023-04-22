package Proxy;

import java.util.ArrayList;
import java.util.List;
public class Proxy extends Song {

    public Proxy(String _title, String _artist, String _album, Integer _songID, Integer _duration) {
        super(_title, _artist, _album, _songID, _duration);
    }

    @Override
    public Song searchByID(List<Song> list, int id){
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getSongID() == id){
                System.out.println("Proxy found SongId: " + list.get(i).getSongID());
                return list.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Song> searchByTitle(List<Song> list, String title) {
        List<Song> songs = new ArrayList<Song>();
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getTitle() == title){
                System.out.println("Proxy found title: " + list.get(i).getTitle());
                songs.add(list.get(i));
            }
        }
        return songs;
    }

    @Override
    public List<Song> searchByAlbum(List<Song> list, String album) {
        List<Song> songs = new ArrayList<Song>();
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getAlbum() == album){
                songs.add(list.get(i));
            }
        }
        System.out.println("Proxy found songs on " + album + ":");
        for(int i=0; i<songs.size(); i++){
            System.out.println(songs.get(i).getTitle());
        }
        return songs;
    }
}

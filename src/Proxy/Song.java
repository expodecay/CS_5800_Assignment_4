package Proxy;

import java.util.ArrayList;
import java.util.List;

public class Song implements SongService{
    private String title;
    private String artist;
    private String album;
    private Integer songID;
    private Integer songDuration;

    public Song(String _title, String _artist, String _album, Integer _songID, Integer _duration){
        title = _title;
        artist = _artist;
        album = _album;
        songID = _songID;
        songDuration = _duration;
    }

    public void setTitle(String new_title){
        title = new_title;
    }

    public String getTitle(){
        return title;
    }

    public void setArtist(String new_artit){
        artist = new_artit;
    }

    public String getArtist(){
        return artist;
    }

    public void setAlbum(String new_album){
        album = new_album;
    }

    public String getAlbum(){
        return album;
    }

    public void setSongID(Integer id){
        songID = id;
    }

    public Integer getSongID(){
        return songID;
    }

    public void setDuration(Integer duration){
        songDuration = duration;
    }

    @Override
    public Song searchByID(Integer songID) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        System.out.println("here");
        return null;
    }

    public Song searchByID(List<Song> list, int id){
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getSongID() == id){
                System.out.println("Server found SongId: " + list.get(i).getSongID());
                return list.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        return null;
    }

    public List<Song> searchByTitle(List<Song> list, String title) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        List<Song> songs = new ArrayList<Song>();
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getTitle() == title){
                System.out.println("Server found title: " + list.get(i).getTitle());
                songs.add(list.get(i));
                return songs;
            }
        }
        return null;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        return null;
    }

    public List<Song> searchByAlbum(List<Song> list, String album) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        List<Song> songs = new ArrayList<Song>();
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getAlbum() == album){
                System.out.println("Server found album: " + list.get(i).getAlbum());
                songs.add(list.get(i));
                return songs;
            }
        }
        return null;
    }
}

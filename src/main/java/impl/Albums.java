package impl;

import pojo.Album;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Albums implements Serializable {
    HashMap<String, Album> albums = new HashMap<>();

    public Albums(){ }

    public void addAlbum(Album album){
        albums.put(album.getISRC(), album);
    }
    public void deleteAlbum(String ISRC){
        albums.remove(ISRC);
    }
    public Album getAlbum(String ISRC){
        return albums.get(ISRC);
    }
    public String toString(){
        String str = null;
        if(albums.size() == 0){
            str = "There are no albums listed.";
        }
        else {
            str = "";
            Iterator it = albums.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                str += "ISRC: " + pair.getKey() + ", Title: " + ((Album) pair.getValue()).getTitle() + "\n";
            }
        }
        return str;
    }
    public boolean albumExists(String ISRC){
        return albums.containsKey(ISRC);
    }
}

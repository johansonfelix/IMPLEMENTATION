package impl;

import pojo.Album;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Albums {
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
        String str = "";
        Iterator it = albums.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            str += "ISRC: " + pair.getKey() + ", Title: " + ((Album)pair.getValue()).getTitle() + " | ";
            it.remove(); // avoids a ConcurrentModificationException
        }
        return str;
    }
    public boolean albumExists(String ISRC){
        return albums.containsKey(ISRC);
    }
}

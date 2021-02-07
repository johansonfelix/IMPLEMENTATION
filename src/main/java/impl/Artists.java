package impl;

import pojo.Artist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Artists {
    HashMap<String, Artist> artists = new HashMap<>();
    public void addArtist(Artist artist){
        artists.put(artist.getNickName(), artist);
    }
    public Artist getArtist(String nickname){
        return artists.get(nickname);
    }
    public void deleteArtist(String nickname){
        artists.remove(nickname);
    }
    public String toString(){
        String str = "";
        Iterator it = artists.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            str += "Nickname: " + pair.getKey() + ", Full name: " + ((Artist)pair.getValue()).getFirstName()+ " " + ((Artist)pair.getValue()).getLastName() + " | ";
            it.remove(); // avoids a ConcurrentModificationException

        }
        return str;
    }
    
    public void tes(){}

}

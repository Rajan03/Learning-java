package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            Song newSong = new Song(title, duration);
            songs.add(newSong);
            return true;
        }
        return false;
    }
    private Song findSong(String title){
        for (Song eachSong : this.songs){
            if(eachSong.getTitle().equals(title))
            return eachSong;
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        trackNumber -= 1;
        ListIterator<Song> playListIterator = playList.listIterator();
        if (playListIterator.hasNext() && playListIterator.next() == this.songs.get(trackNumber)){
            return false;
        }else {
            playList.add(songs.get(trackNumber));
            return true;
        }
    }
    public boolean addToPlayList(String trackName, LinkedList<Song> playList){
        Song favSong = findSong(trackName);
        if (favSong != null){
            playList.add(favSong);
            return true;
        }
        return false;
    }
}

package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class RecentlyPlayedSongsStore {
    private int capacity;
    private Map<String, Queue<String>> songUserMap;

    public RecentlyPlayedSongsStore(int capacity) {
        this.capacity = capacity;
        this.songUserMap = new LinkedHashMap<>();
    }

    public void playSong(String user, String song) {
        try {
            if (!songUserMap.containsKey(user)) {
                songUserMap.put(user, new LinkedList<>());
            }

            Queue<String> playlist = songUserMap.get(user);

            // Check if the song is already in the play_list and remove it to maintain uniqueness
            playlist.remove(song);

            // Add the song to the front of the play_list
            playlist.add(song);

            // If the play_list size exceeds capacity, remove the least recently played song
            if (playlist.size() > capacity) {
                playlist.poll();
            }
        } catch (NullPointerException e) {
            System.out.println("Error: NullPointerException occurred while playing the song.");
        }
    }

    public List<String> getRecentlyPlayedSongs(String user) {
        try {
            if (!songUserMap.containsKey(user)) {
                return Collections.emptyList();
            }

            // Return the play_list for the user
            return new ArrayList<>(songUserMap.get(user));
        } catch (NullPointerException e) {
            System.out.println("Error: NullPointerException occurred while retrieving recently played songs.");
            return Collections.emptyList();
        }
    }
}

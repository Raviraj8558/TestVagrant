package main;



import test.RecentlyPlayedSongsStore;

public class Main_Method {

	public static void main(String[] args) {
	    try {
	        RecentlyPlayedSongsStore store = new RecentlyPlayedSongsStore(3);

	        store.playSong("user1", "S1");
	        store.playSong("user1", "S2");
	        store.playSong("user1", "S3");
	        System.out.println("User1 :" + store.getRecentlyPlayedSongs("user1")); // Output: [S1, S2, S3]

	        store.playSong("user1", "S4");
	        System.out.println("User1 :" + store.getRecentlyPlayedSongs("user1")); // Output: [S2, S3, S4]

	        store.playSong("user1", "S2");
	        System.out.println("User1 :" + store.getRecentlyPlayedSongs("user1")); // Output: [S3, S4, S2]

	        store.playSong("user1", "S1");
	        System.out.println("User1 :" + store.getRecentlyPlayedSongs("user1")); // Output: [S4, S2, S1]
	    } catch (Exception e) {
	        System.out.println("Error: An unexpected exception occurred.");
	        e.printStackTrace();
	    }
	}
}

    















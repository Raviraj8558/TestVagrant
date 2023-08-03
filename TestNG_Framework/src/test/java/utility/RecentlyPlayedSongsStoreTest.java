package utility;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RecentlyPlayedSongsStoreTest {
    private RecentlyPlayedSongsStore store;

    @BeforeMethod
    public void setUp() {
        store = new RecentlyPlayedSongsStore(3);
    }

    @Test
    public void testRecentlyPlayedSongs() {
        try {
            store.playSong("user1", "S1");
            store.playSong("user1", "S2");
            store.playSong("user1", "S3");
            List<String> expectedPlaylist1 = Arrays.asList("S1", "S2", "S3");
            AssertJUnit.assertEquals(store.getRecentlyPlayedSongs("user1"), expectedPlaylist1);

            store.playSong("user1", "S4");
            List<String> expectedPlaylist2 = Arrays.asList("S2", "S3", "S4");
            AssertJUnit.assertEquals(store.getRecentlyPlayedSongs("user1"), expectedPlaylist2);

            store.playSong("user1", "S2");
            List<String> expectedPlaylist3 = Arrays.asList("S3", "S4", "S2");
            AssertJUnit.assertEquals(store.getRecentlyPlayedSongs("user1"), expectedPlaylist3);

            store.playSong("user1", "S1");
            List<String> expectedPlaylist4 = Arrays.asList("S4", "S2", "S1");
            AssertJUnit.assertEquals(store.getRecentlyPlayedSongs("user1"), expectedPlaylist4);

            // User2 hasn't played any songs yet
            List<String> expectedEmptyPlaylist = Arrays.asList();
            AssertJUnit.assertEquals(store.getRecentlyPlayedSongs("user2"), expectedEmptyPlaylist);
        } catch (Exception e) {
            // Handle any exceptions thrown during the test execution
            e.printStackTrace();
        }
    }
    
    @Test
    public void testRecentlyPlayedSongsUser2() {
        try {
            store.playSong("user2", "S5");
            store.playSong("user2", "S6");
            store.playSong("user2", "S7");
            List<String> expectedPlaylist1 = Arrays.asList("S5", "S6", "S7");
            AssertJUnit.assertEquals(store.getRecentlyPlayedSongs("user2"), expectedPlaylist1);

            store.playSong("user2", "S8");
            List<String> expectedPlaylist2 = Arrays.asList("S6", "S7", "S8");
            AssertJUnit.assertEquals(store.getRecentlyPlayedSongs("user2"), expectedPlaylist2);

            store.playSong("user2", "S9");
            List<String> expectedPlaylist3 = Arrays.asList("S7", "S8", "S9");
            AssertJUnit.assertEquals(store.getRecentlyPlayedSongs("user2"), expectedPlaylist3);

            store.playSong("user2", "S10");
            List<String> expectedPlaylist4 = Arrays.asList("S8", "S9", "S10");
            AssertJUnit.assertEquals(store.getRecentlyPlayedSongs("user2"), expectedPlaylist4);

            // User3 hasn't played any songs yet
            List<String> expectedEmptyPlaylist = Arrays.asList();
            
            AssertJUnit.assertEquals(store.getRecentlyPlayedSongs("user3"), expectedEmptyPlaylist);
        } catch (Exception e) {
            // Handle any exceptions thrown during the test execution
            e.printStackTrace();
        }
    }
    
    @AfterMethod
    
	@BeforeSuite
    public void tearDown () {
        // Any teardown logic can be added here if required
    }
}

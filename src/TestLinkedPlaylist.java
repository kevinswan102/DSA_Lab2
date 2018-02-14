/**
 * @author chakkac5
 * test the playlist linked list using the generic linked list 
 */
import java.awt.List;
import java.util.Scanner;

public class TestLinkedPlaylist {

	public static void runTest() {
		Song s1 = new Song("Yellow", "Cold Play", (float) 2.4);
		Song s2 = new Song("Clocks", "Cold Play2", (float) 3.56);

		LinkedPlaylist p = new LinkedPlaylist("ColdPlayHits");
		p.addSong(s1);
		p.addSong(s2);
		int totalSongs = p.totalSongs();

		System.out.println("Total songs in playlist : " + totalSongs);

		p.playlistTime();
		p.removeSong(s2);

		totalSongs = p.totalSongs();
		System.out.println("Total songs in playlist : " + totalSongs);

		p.addSong(s2);
		p.isSongInPlaylist("clocks");
		p.songsByArtist("Cold play");
		p.songsByArtist("Grease Monkey");
		Song s3 = new Song("Around the Sun", "REM", (float) 4.30);
		LinkedPlaylist favorites = new LinkedPlaylist("favorites");
		favorites.addSong(s3);
		favorites.addSong(s1);
		favorites.addSongsFrom(p);

		List tempList = favorites.getList();

		for (int i = 0; i < tempList.getItemCount(); i++) {
			System.out.println(tempList.getItem(i).toString());
		}
	}

	public static void PerformanceTest() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Start Loading songs");
		long startTime = System.currentTimeMillis();

		FileUtility fileUtility = new FileUtility();
		Scanner readFile = fileUtility.RequestForValidFile(scanner);

		if (readFile == null)
			return;

		LinkedPlaylist p = new LinkedPlaylist("Songs");

		while (readFile.hasNextLine()) {
			String line = readFile.nextLine();
			String token[] = StringUtility.GetTokensFromString(line, ",");

			Song s = new Song(token[0].trim(), token[1].trim(), Float.parseFloat(token[2].trim()));
			p.addSong(s);
		}

		long estimatedTime = System.currentTimeMillis() - startTime;

		int totalSongs = p.totalSongs();

		System.out.println("Total songs in playlist : " + totalSongs + " estimated time " + estimatedTime);
		System.out.println("------------------");
		System.out.println("\n");

		System.out.println("Start adding song 1");
		startTime = System.currentTimeMillis();
		Song s1 = new Song("Around the Sun 1", "REM", (float) 4.10);
		p.addSongAt(s1, 500);
		estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("Song 1 estimated time " + estimatedTime);
		totalSongs = p.totalSongs();
		System.out.println("Total songs in playlist : " + totalSongs);
				
		System.out.println("------------------");
		
		System.out.println("\n");
		System.out.println("Start adding song 2");
		startTime = System.currentTimeMillis();
		Song s2 = new Song("Around the Sun 2", "REM", (float) 3.50);
		p.addSongAt(s2, 50000);
		estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("Song 2 estimated time " + estimatedTime);
		totalSongs = p.totalSongs();
		System.out.println("Total songs in playlist : " + totalSongs);
		
		System.out.println("------------------");

		System.out.println("\n");
		System.out.println("Start adding song 3");
		startTime = System.currentTimeMillis();
		Song s3 = new Song("Around the Sun 3", "REM", (float) 3.10);
		p.addSongAt(s3, 500000);
		estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("Song 3 estimated time " + estimatedTime);
		totalSongs = p.totalSongs();
		System.out.println("Total songs in playlist : " + totalSongs);
		
		System.out.println("------------------");
		
		
		System.out.println("\n");
		System.out.println("Start retrieve song 1");
		startTime = System.currentTimeMillis();
		System.out.println(p.getSongAt(10000).toString());
		estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("retrieve Song 1 estimated time " + estimatedTime);
		System.out.println("------------------");
		
		System.out.println("\n");
		System.out.println("Start retrieve song 2");
		startTime = System.currentTimeMillis();
		System.out.println(p.getSongAt(100000).toString());
		estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("retrieve Song 2 estimated time " + estimatedTime);
		System.out.println("------------------");
		
		System.out.println("\n");
		System.out.println("Start retrieve song 3");
		startTime = System.currentTimeMillis();
		System.out.println(p.getSongAt(1000000).toString());
		estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("retrieve Song 3 estimated time " + estimatedTime);
		System.out.println("------------------");
		
		/*
		System.out.println("\n");
		System.out.println("Start swap 1");
		startTime = System.currentTimeMillis();
		p.MoveSong(p.getSongAt(10000), 55000);
		estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("swap 1 estimated time " + estimatedTime);
		System.out.println("------------------");
		
		System.out.println("\n");
		System.out.println("Start swap 2");
		startTime = System.currentTimeMillis();
		p.MoveSong(p.getSongAt(100000),225000);
		estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("swap 2 estimated time " + estimatedTime);
		System.out.println("------------------");
		
		System.out.println("\n");
		System.out.println("Start swap 3");
		startTime = System.currentTimeMillis();
		p.MoveSong(p.getSongAt(1000000), 800000);
		estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("swap 3 estimated time " + estimatedTime);
		System.out.println("------------------");
		
		
		System.out.println("\n");
		System.out.println("Start shift 1");
		startTime = System.currentTimeMillis();
		p.MoveAllSongs(500);
		estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("shift 1 estimated time " + estimatedTime);
		System.out.println("------------------");
		
		System.out.println("\n");
		System.out.println("Start shift 2");
		startTime = System.currentTimeMillis();
		p.MoveAllSongs(500000);
		estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("shift 2 estimated time " + estimatedTime);
		System.out.println("------------------");
		
		System.out.println("\n");
		System.out.println("Start shift 3");
		startTime = System.currentTimeMillis();
		p.MoveAllSongs(-800000);
		estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("shift 3 estimated time " + estimatedTime);
		System.out.println("------------------");
		*/
	}
	
}

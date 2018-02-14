/**
 * @author chakkac5
 * creating the playlist using the generic linked list 
 */
import java.awt.List;

public class LinkedPlaylist {

	private String PlaylistName;

	MyLinkedList<Song> list;

	LinkedPlaylist(String name) {
		list = new MyLinkedList<Song>();
		PlaylistName = name;
	}

	String playlistName() {
		return PlaylistName;
	}

	boolean addSong(Song s) {
		return list.add(s);

	}

	boolean addSongAt(Song s, int index) {
		return list.add(index, s);
	}

	Song getSongAt(int index) {
		return list.get(index);
	}

	List getList() {
		Song[] tempArray = list.toArray(Song.class);
		List tempList = new List();

		for (int i = 0; i < tempArray.length; i++) {
			tempList.add(tempArray[i].toString());
		}

		return tempList;
	}

	boolean removeSong(Song s) {
		return (list.remove(s) != null);
	}

	int totalSongs() {
		return list.size();
	}

	float playlistTime() {
		Song[] tempArray = list.toArray(Song.class);
		float tempTime = 0;

		for (int i = 0; i < tempArray.length; i++) {
			tempTime += tempArray[i].getPlaytime();
		}

		return tempTime;
	}

	boolean isSongInPlaylist(String name) {
		Song[] tempArray = list.toArray(Song.class);

		for (int i = 0; i < tempArray.length; i++) {
			if (tempArray[i].getSongName() == name)
				return true;
		}

		return false;
	}

	void songsByArtist(String name) {
		Song[] tempArray = list.toArray(Song.class);
		Integer count = 0;
		System.out.println("Songs belonging to Artist : " + name);
		System.out.println("-------------------------");
		for (int i = 0; i < tempArray.length; i++) {
			if (tempArray[i].getArtist() == name) {
				System.out.println(tempArray[i].toString());
				count++;
			}

		}

		if (count == 0)
			System.out.println("0 songs found");

		System.out.println("-------------------------");
	}

	boolean addSongsFrom(LinkedPlaylist p) {
		if (p.list.size() > 0) {
			Song[] tempArray = p.list.toArray(Song.class);

			for (int i = 0; i < tempArray.length; i++) {
				if (list.indexOf(tempArray[i]) == -1)
					list.add(tempArray[i]);
			}

			return true;
		} else
			return false;
	}

	void MoveSong(Song s, int position) {
		if (position < 1 || position > list.size())
			throw new ArithmeticException("Position between 1 and size of playlist");

		int curPos = list.indexOf(s);

		if (curPos > -1) {
			list.swap(curPos, position);
		} else {
			throw new IllegalArgumentException("Soung not found");
		}
	}

	void MoveAllSongs(int positions) {
		if (Math.abs(positions) > list.size())
			throw new ArithmeticException("Positions cannot be more than size of playlist");

		list.shift(positions);
	}

}

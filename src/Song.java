/**
 * @author kswann
 * Song class to provide the data to be stored in the classes
 */
public class Song {

	private String Name;

	private String Artist;

	private float Playtime;

	Song(String name, String artist, float playtime) {
		Name = name;
		Artist = artist;
		Playtime = playtime;
	}

	public String toString() {
		return String.format("song: %s, artist: %s, playtime: %f", Name, Artist, Playtime);
	}

	public double getPlaytime() {
		return Double.parseDouble(Float.toString(Playtime));
	}

	public String getArtist() {
		return Artist;
	}

	public String getSongName() {
		return Name;
	}

	public boolean equals(Song compareTo) {
		return this.equals(compareTo);
	}
}

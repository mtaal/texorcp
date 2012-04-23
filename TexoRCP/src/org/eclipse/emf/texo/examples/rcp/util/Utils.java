package org.eclipse.emf.texo.examples.rcp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.texo.examples.rcp.music.Album;
import org.eclipse.emf.texo.examples.rcp.music.Artist;
import org.eclipse.emf.texo.examples.rcp.music.Country;
import org.eclipse.emf.texo.examples.rcp.music.Genre;
import org.eclipse.emf.texo.examples.rcp.music.MusicFactory;
import org.eclipse.emf.texo.examples.rcp.music.Rating;
import org.eclipse.emf.texo.examples.rcp.music.Song;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class Utils {
	private static String[] ccodes = new String[] { "ad", "ae", "af", "ag",
			"ai", "al", "am", "an", "ao", "ar", "as", "at", "au", "aw", "ax",
			"az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bm",
			"bn", "bo", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca",
			"catalonia", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm",
			"cn", "co", "cr", "cs", "cu", "cv", "cx", "cy", "cz", "de", "dj",
			"dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "england", "er",
			"es", "et", "eu", "fam", "fi", "fj", "fk", "fm", "fo", "fr", "ga",
			"gb", "gd", "ge", "gf", "gh", "gi", "gl", "gm", "gn", "gp", "gq",
			"gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht",
			"hu", "id", "ie", "il", "in", "io", "iq", "ir", "is", "it", "jm",
			"jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw",
			"ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu",
			"lv", "ly", "ma", "mc", "md", "me", "mg", "mh", "mk", "ml", "mm",
			"mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx",
			"my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np",
			"nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl",
			"pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs",
			"ru", "rw", "sa", "sb", "sc", "scotland", "sd", "se", "sg", "sh",
			"si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "st", "sv", "sy",
			"sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn",
			"to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "um", "us", "uy",
			"uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wales", "wf",
			"ws", "ye", "yt", "za", "zm", "zw" };

	private static Map<String, Image> imageCache = new HashMap<String, Image>();
	
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

	public static String[] getCountryCodes() {
		return ccodes;
	}

	public static String getCountryCodeFlag(String countryCode) {
		return "icons/flags/" + countryCode + ".png";
	}

	public static String getRating(Rating rating) {
		return "icons/rating/" + rating.name() + ".gif";
	}

	public static Image getImage(String name) {
		Image img = imageCache.get(name);
		if (img == null || img.isDisposed()) {
			img = new Image(Display.getDefault(),
					Utils.class.getResourceAsStream(name));
			imageCache.put(name, img);
		}
		return img;
	}

	public static void disposeImageCache() {
		for (Image img : imageCache.values()) {
			img.dispose();
		}
	}

	public static final Album getSampleAlbum() {
		Album justBeFree = MusicFactory.eINSTANCE.createAlbum();
		justBeFree.setId(1);
		justBeFree.setName("Just Be Free");
		justBeFree.setReleaseDate(getDate("19.6.2001"));
		justBeFree.setVersion((long) 1);
		
		justBeFree.getSongs().add(getSong(1, "Just Be Free", 1));
		justBeFree.getSongs().add(getSong(2, "By Your Side", 2));
		justBeFree.getSongs().add(getSong(3, "Move It (Dance Mix)", 3));
		justBeFree.getSongs().add(getSong(4, "Our Day Will Come", 4));
		justBeFree.getSongs().add(getSong(5, "Believe Me", 5));
		justBeFree.getSongs().add(getSong(6, "Make Me Happy", 6));
		justBeFree.getSongs().add(getSong(7, "Dream A Dream", 7));
		justBeFree.getSongs().add(getSong(8, "Move It", 8));
		justBeFree.getSongs().add(getSong(9, "The Way You Talk To Me", 9));
		justBeFree.getSongs().add(getSong(10, "Running Out Of Time", 10));
		justBeFree.getSongs().add(getSong(11, "Believe Me (Dance Mix)", 11));
		justBeFree.getSongs().add(getSong(12, "Just Be Free (remix) ", 12));
		
		justBeFree.getRatings().add(Rating.HIGH);
		justBeFree.getRatings().add(Rating.LOW);
		justBeFree.getRatings().add(Rating.HIGH);
		justBeFree.getRatings().add(Rating.HIGH);
		justBeFree.getRatings().add(Rating.LOW);
		
		Genre pop = MusicFactory.eINSTANCE.createGenre();
		pop.setId(1);
		pop.setName("Pop");
		pop.setVersion((long) 1);
		justBeFree.getGenres().add(pop);

		Country ny = MusicFactory.eINSTANCE.createCountry();
		ny.setName("New York, United States");
		ny.setCode("us");
		
		Artist artist = MusicFactory.eINSTANCE.createArtist();
		artist.setBirthDate(getDate("19.12.1980"));
		artist.setFirstName("Christina");
		artist.setLastName("Aguilera");
		artist.setVersion((long) 1);
		artist.setGenre(pop);
		artist.setCountry(ny);
		justBeFree.setArtist(artist);

		return justBeFree;
	}
	
	private static Song getSong(long id, String name, int track) {
		Song song = MusicFactory.eINSTANCE.createSong();
		song.setId(id);
		song.setName(name);
		song.setTrack(track);
		song.setVersion((long) 1);
		return song;
	}
	
	private static Date getDate(String dateString) {
		try {
			return formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
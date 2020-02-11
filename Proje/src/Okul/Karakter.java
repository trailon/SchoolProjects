package Okul;

public class Karakter {
	String ad;
	String Tur;
	int[][] lokasyon;
	String kapi;
	int[][] mat = new int[11][14];

	@SuppressWarnings("unused")
	private Karakter(final String ad, final String tur, final int[][] lokasyon, final String kapi) {
		super();
		this.ad = ad;
		Tur = tur;
		this.lokasyon = lokasyon;
		this.kapi = kapi;

	}

	public Karakter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTur() {
		return Tur;
	}

	public void setTur(String tur) {
		Tur = tur;
	}

	public int[][] getLokasyon() {
		return lokasyon;
	}

	public void setLokasyon(int[][] lokasyon) {
		this.lokasyon = lokasyon;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public void EnKýsaYol() {

		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 14; j++) {
				mat[i][j] = Integer.parseInt(Ekran.harita[i][j]);
			}
		}
		// Find shortest path from source (0, 0) to
		// destination (7, 5)

	}
}

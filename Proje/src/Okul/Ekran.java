package Okul;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Ekran extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static String[][] harita = new String[11][14];
	public static File file = new File("Harita.txt");
	public static int a = 0, x = 5, y = 6, b, D, K,can=6;
	public static JLabel[][] ldizi = new JLabel[11][14];
	public static ArrayList<Stormtrooper> Stormtp = new ArrayList<>();
	public static ArrayList<DarthVader> Darth = new ArrayList<>();
	public static ArrayList<KyloRen> Ren = new ArrayList<>();
	public static ArrayList<Integer> locationx = new ArrayList<>();
	public static ArrayList<Integer> locationy = new ArrayList<>();
	public static int[][] mat = new int[11][14];
	public static boolean[][] visited = new boolean[11][14];
	public static int temp, sinyal = 0, f = 0, g = 0, t = 0,s = 9, k = 9;
    public void DownRen() {
		Image Yer = new ImageIcon(this.getClass().getResource("/y.png")).getImage();
		Image Kylo = new ImageIcon(this.getClass().getResource("/KyloRen.png")).getImage();
    	if (Ren.size() > 0) {
			if (t == 0) {
				kontrol(Ren.get(0).lokasyon[0][0], Ren.get(0).lokasyon[1][0], Yer, Kylo, "Kylo", 0);
				t = 1;
			} else {

				for (int l = 0; l < 2; l++) {
					Util.BFS(mat, Ren.get(0).lokasyon[0][0], Ren.get(0).lokasyon[1][0], x, y);
					temp = Util.path_length;
					sinyal = 0;
					do {
						int i = 0;

						if (harita[Ren.get(i).lokasyon[0][0] + 1][Ren.get(i).lokasyon[1][0]].charAt(0) == '1') {
							Util.BFS(mat, Ren.get(i).lokasyon[0][0] + 1, Ren.get(i).lokasyon[1][0], x, y);
							if (Util.path_length < temp) {
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Ren.get(i).lokasyon[0][0]++;
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Kylo));
								sinyal = 1;

							}
						}
						if (sinyal == 1)
							break;
						if (harita[Ren.get(i).lokasyon[0][0] - 1][Ren.get(i).lokasyon[1][0]].charAt(0) == '1') {
							Util.BFS(mat, Ren.get(i).lokasyon[0][0] - 1, Ren.get(i).lokasyon[1][0], x, y);
							if (Util.path_length < temp) {
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Ren.get(i).lokasyon[0][0]--;
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Kylo));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;
						if (harita[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0] + 1].charAt(0) == '1') {
							Util.BFS(mat, Ren.get(i).lokasyon[0][0], Ren.get(i).lokasyon[1][0] + 1, x, y);
							if (Util.path_length < temp) {
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Ren.get(i).lokasyon[1][0]++;
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Kylo));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;
						if (harita[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0] - 1].charAt(0) == '1') {
							Util.BFS(mat, Ren.get(i).lokasyon[0][0], Ren.get(i).lokasyon[1][0] - 1, x, y);
							if (Util.path_length < temp) {
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Ren.get(i).lokasyon[1][0]--;
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Kylo));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;

					} while (sinyal == 0);
				}
			}
		}
    }
	public void DownDarth() {
		Image Vader = new ImageIcon(this.getClass().getResource("/DarthVader.png")).getImage();
		Image Yer = new ImageIcon(this.getClass().getResource("/y.png")).getImage();
		Image Duvar = new ImageIcon(this.getClass().getResource("/z.png")).getImage();
		if (Darth.size() > 0) {
			if (g == 0) {
				kontrol(Darth.get(0).lokasyon[0][0], Darth.get(0).lokasyon[1][0], Yer, Vader, "Darth", 0);
				g = 1;
			} else {
				Util.BFS(mat, Darth.get(0).lokasyon[0][0], Darth.get(0).lokasyon[1][0], x, y);
				temp = Util.path_length;
				sinyal = 0;
				do {
					int i = 0;
					Util.BFS(mat, Darth.get(0).lokasyon[0][0] + 1, Darth.get(0).lokasyon[1][0], x, y);
					if (Util.path_length < temp) {

						if (harita[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]].charAt(0) == '1')
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Yer));
						else
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Duvar));
						Darth.get(i).lokasyon[0][0]++;
						ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
								.setIcon(new ImageIcon(Vader));

						sinyal = 1;

					}

					if (sinyal == 1)
						break;

					Util.BFS(mat, Darth.get(0).lokasyon[0][0] - 1, Darth.get(0).lokasyon[1][0], x, y);
					if (Util.path_length < temp) {
						if (harita[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]].charAt(0) == '1')
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Yer));
						else
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Duvar));
						Darth.get(i).lokasyon[0][0]--;
						ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
								.setIcon(new ImageIcon(Vader));
						sinyal = 1;
					}

					if (sinyal == 1)
						break;

					Util.BFS(mat, Darth.get(0).lokasyon[0][0], Darth.get(0).lokasyon[1][0] + 1, x, y);
					if (Util.path_length < temp) {
						if (harita[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]].charAt(0) == '1')
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Yer));
						else
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Duvar));
						Darth.get(i).lokasyon[1][0]++;
						ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
								.setIcon(new ImageIcon(Vader));
						sinyal = 1;
					}

					if (sinyal == 1)
						break;

					Util.BFS(mat, Darth.get(0).lokasyon[0][0], Darth.get(0).lokasyon[1][0] - 1, x, y);
					if (Util.path_length < temp) {
						if (harita[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]].charAt(0) == '1')
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Yer));
						else
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Duvar));
						Darth.get(i).lokasyon[1][0]--;
						ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
								.setIcon(new ImageIcon(Vader));
						sinyal = 1;
					}

					if (sinyal == 1)
						break;

				} while (sinyal == 0);
			}
		}
	}
    public void DownStorm() {
    	Image Troop = new ImageIcon(this.getClass().getResource("/Stormtrooper.png")).getImage();
		Image Yer = new ImageIcon(this.getClass().getResource("/y.png")).getImage();
    	if (Stormtp.size() > 0) {
			for (int i = 0; i < Stormtp.size(); i++) {
				if (f < Stormtp.size()) {
					kontrol(Stormtp.get(i).lokasyon[0][0], Stormtp.get(i).lokasyon[1][0], Yer, Troop, "Storm", i);
					f++;

				} else {

					Util.BFS(mat, Stormtp.get(i).lokasyon[0][0], Stormtp.get(i).lokasyon[1][0], x, y);
					temp = Util.path_length;
					sinyal = 0;
					do {
						if (harita[Stormtp.get(i).lokasyon[0][0] + 1][Stormtp.get(i).lokasyon[1][0]]
								.charAt(0) == '1') {
							Util.BFS(mat, Stormtp.get(i).lokasyon[0][0] + 1, Stormtp.get(i).lokasyon[1][0], x, y);
							if (Util.path_length < temp) {
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Stormtp.get(i).lokasyon[0][0]++;
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Troop));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;
						if (harita[Stormtp.get(i).lokasyon[0][0] - 1][Stormtp.get(i).lokasyon[1][0]]
								.charAt(0) == '1') {
							Util.BFS(mat, Stormtp.get(i).lokasyon[0][0] - 1, Stormtp.get(i).lokasyon[1][0], x, y);
							if (Util.path_length < temp) {
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Stormtp.get(i).lokasyon[0][0]--;
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Troop));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;
						if (harita[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0] + 1]
								.charAt(0) == '1') {
							Util.BFS(mat, Stormtp.get(i).lokasyon[0][0], Stormtp.get(i).lokasyon[1][0] + 1, x, y);
							if (Util.path_length < temp) {
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Stormtp.get(i).lokasyon[1][0]++;
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Troop));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;
						if (harita[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0] - 1]
								.charAt(0) == '1') {
							Util.BFS(mat, Stormtp.get(i).lokasyon[0][0], Stormtp.get(i).lokasyon[1][0] - 1, x, y);
							if (Util.path_length < temp) {
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Stormtp.get(i).lokasyon[1][0]--;
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Troop));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;

					} while (sinyal == 0);
				}
			}
		}
    }
    public void LeftRen() {
		Image Yer = new ImageIcon(this.getClass().getResource("/y.png")).getImage();
		Image Kylo = new ImageIcon(this.getClass().getResource("/KyloRen.png")).getImage();
    	if (Ren.size() > 0) {
			if (t == 0) {
				kontrol(Ren.get(0).lokasyon[0][0], Ren.get(0).lokasyon[1][0], Yer, Kylo, "Kylo", 0);
				t = 1;
			} else {
				for (int l = 0; l < 2; l++) {
					Util.BFS(mat, Ren.get(0).lokasyon[0][0], Ren.get(0).lokasyon[1][0], x, y);
					temp = Util.path_length;
					sinyal = 0;
					do {
						int i = 0;

						if (harita[Ren.get(i).lokasyon[0][0] + 1][Ren.get(i).lokasyon[1][0]].charAt(0) == '1') {
							Util.BFS(mat, Ren.get(i).lokasyon[0][0] + 1, Ren.get(i).lokasyon[1][0], x, y);
							if (Util.path_length < temp) {
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Ren.get(i).lokasyon[0][0]++;
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Kylo));
								sinyal = 1;

							}
						}
						if (sinyal == 1)
							break;
						if (harita[Ren.get(i).lokasyon[0][0] - 1][Ren.get(i).lokasyon[1][0]].charAt(0) == '1') {
							Util.BFS(mat, Ren.get(i).lokasyon[0][0] - 1, Ren.get(i).lokasyon[1][0], x, y);
							if (Util.path_length < temp) {
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Ren.get(i).lokasyon[0][0]--;
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Kylo));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;
						if (harita[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0] + 1].charAt(0) == '1') {
							Util.BFS(mat, Ren.get(i).lokasyon[0][0], Ren.get(i).lokasyon[1][0] + 1, x, y);
							if (Util.path_length < temp) {
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Ren.get(i).lokasyon[1][0]++;
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Kylo));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;
						if (harita[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0] - 1].charAt(0) == '1') {
							Util.BFS(mat, Ren.get(i).lokasyon[0][0], Ren.get(i).lokasyon[1][0] - 1, x, y);
							if (Util.path_length < temp) {
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Ren.get(i).lokasyon[1][0]--;
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Kylo));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;

					} while (sinyal == 0);
				}
			}
		}
    }
    public void LeftDarth() {
		Image Vader = new ImageIcon(this.getClass().getResource("/DarthVader.png")).getImage();
		Image Yer = new ImageIcon(this.getClass().getResource("/y.png")).getImage();
		Image Duvar = new ImageIcon(this.getClass().getResource("/z.png")).getImage();
    	if (Darth.size() > 0) {
			if (g == 0) {
				kontrol(Darth.get(0).lokasyon[0][0], Darth.get(0).lokasyon[1][0], Yer, Vader, "Darth", 0);
				g = 1;
			} else {
				Util.BFS(mat, Darth.get(0).lokasyon[0][0], Darth.get(0).lokasyon[1][0], x, y);
				temp = Util.path_length;
				sinyal = 0;
				do {
					int i = 0;
					Util.BFS(mat, Darth.get(0).lokasyon[0][0] + 1, Darth.get(0).lokasyon[1][0], x, y);
					if (Util.path_length < temp) {

						if (harita[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]].charAt(0) == '1')
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Yer));
						else
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Duvar));
						Darth.get(i).lokasyon[0][0]++;
						ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
								.setIcon(new ImageIcon(Vader));

						sinyal = 1;

					}

					if (sinyal == 1)
						break;

					Util.BFS(mat, Darth.get(0).lokasyon[0][0] - 1, Darth.get(0).lokasyon[1][0], x, y);
					if (Util.path_length < temp) {
						if (harita[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]].charAt(0) == '1')
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Yer));
						else
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Duvar));
						Darth.get(i).lokasyon[0][0]--;
						ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
								.setIcon(new ImageIcon(Vader));
						sinyal = 1;
					}

					if (sinyal == 1)
						break;

					Util.BFS(mat, Darth.get(0).lokasyon[0][0], Darth.get(0).lokasyon[1][0] + 1, x, y);
					if (Util.path_length < temp) {
						if (harita[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]].charAt(0) == '1')
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Yer));
						else
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Duvar));
						Darth.get(i).lokasyon[1][0]++;
						ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
								.setIcon(new ImageIcon(Vader));
						sinyal = 1;
					}

					if (sinyal == 1)
						break;

					Util.BFS(mat, Darth.get(0).lokasyon[0][0], Darth.get(0).lokasyon[1][0] - 1, x, y);
					if (Util.path_length < temp) {
						if (harita[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]].charAt(0) == '1')
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Yer));
						else
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Duvar));
						Darth.get(i).lokasyon[1][0]--;
						ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
								.setIcon(new ImageIcon(Vader));
						sinyal = 1;
					}

					if (sinyal == 1)
						break;

				} while (sinyal == 0);
			}
		}	
    }
    public void LeftStorm() {
		Image Troop = new ImageIcon(this.getClass().getResource("/Stormtrooper.png")).getImage();
		Image Yer = new ImageIcon(this.getClass().getResource("/y.png")).getImage();
    	if (Stormtp.size() > 0) {
			for (int i = 0; i < Stormtp.size(); i++) {
				if (f < Stormtp.size()) {
					kontrol(Stormtp.get(i).lokasyon[0][0], Stormtp.get(i).lokasyon[1][0], Yer, Troop, "Storm", i);
					f++;

				} else {
					Util.BFS(mat, Stormtp.get(i).lokasyon[0][0], Stormtp.get(i).lokasyon[1][0], x, y);
					temp = Util.path_length;
					sinyal = 0;
					do {
						if (harita[Stormtp.get(i).lokasyon[0][0] + 1][Stormtp.get(i).lokasyon[1][0]]
								.charAt(0) == '1') {
							Util.BFS(mat, Stormtp.get(i).lokasyon[0][0] + 1, Stormtp.get(i).lokasyon[1][0], x, y);
							if (Util.path_length < temp) {
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Stormtp.get(i).lokasyon[0][0]++;
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Troop));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;
						if (harita[Stormtp.get(i).lokasyon[0][0] - 1][Stormtp.get(i).lokasyon[1][0]]
								.charAt(0) == '1') {
							Util.BFS(mat, Stormtp.get(i).lokasyon[0][0] - 1, Stormtp.get(i).lokasyon[1][0], x, y);
							if (Util.path_length < temp) {
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Stormtp.get(i).lokasyon[0][0]--;
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Troop));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;
						if (harita[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0] + 1]
								.charAt(0) == '1') {
							Util.BFS(mat, Stormtp.get(i).lokasyon[0][0], Stormtp.get(i).lokasyon[1][0] + 1, x, y);
							if (Util.path_length < temp) {
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Stormtp.get(i).lokasyon[1][0]++;
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Troop));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;
						if (harita[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0] - 1]
								.charAt(0) == '1') {
							Util.BFS(mat, Stormtp.get(i).lokasyon[0][0], Stormtp.get(i).lokasyon[1][0] - 1, x, y);
							if (Util.path_length < temp) {
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Stormtp.get(i).lokasyon[1][0]--;
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Troop));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;

					} while (sinyal == 0);
				}
			}
		}
}
    public void RightRen() {
		Image Yer = new ImageIcon(this.getClass().getResource("/y.png")).getImage();
		Image Kylo = new ImageIcon(this.getClass().getResource("/KyloRen.png")).getImage();
    	if (Ren.size() > 0) {
			if (t == 0) {
				kontrol(Ren.get(0).lokasyon[0][0], Ren.get(0).lokasyon[1][0], Yer, Kylo, "Kylo", 0);
				t = 1;
			} else {
				for (int l = 0; l < 2; l++) {
					Util.BFS(mat, Ren.get(0).lokasyon[0][0], Ren.get(0).lokasyon[1][0], x, y);
					temp = Util.path_length;
					sinyal = 0;
					do {
						int i = 0;

						if (harita[Ren.get(i).lokasyon[0][0] + 1][Ren.get(i).lokasyon[1][0]].charAt(0) == '1') {
							Util.BFS(mat, Ren.get(i).lokasyon[0][0] + 1, Ren.get(i).lokasyon[1][0], x, y);
							if (Util.path_length < temp) {
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Ren.get(i).lokasyon[0][0]++;
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Kylo));
								sinyal = 1;

							}
						}
						if (sinyal == 1)
							break;
						if (harita[Ren.get(i).lokasyon[0][0] - 1][Ren.get(i).lokasyon[1][0]].charAt(0) == '1') {
							Util.BFS(mat, Ren.get(i).lokasyon[0][0] - 1, Ren.get(i).lokasyon[1][0], x, y);
							if (Util.path_length < temp) {
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Ren.get(i).lokasyon[0][0]--;
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Kylo));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;
						if (harita[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0] + 1].charAt(0) == '1') {
							Util.BFS(mat, Ren.get(i).lokasyon[0][0], Ren.get(i).lokasyon[1][0] + 1, x, y);
							if (Util.path_length < temp) {
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Ren.get(i).lokasyon[1][0]++;
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Kylo));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;
						if (harita[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0] - 1].charAt(0) == '1') {
							Util.BFS(mat, Ren.get(i).lokasyon[0][0], Ren.get(i).lokasyon[1][0] - 1, x, y);
							if (Util.path_length < temp) {
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Ren.get(i).lokasyon[1][0]--;
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Kylo));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;

					} while (sinyal == 0);
				}
			}
		}
    }
    public void RightDarth() {
		Image Vader = new ImageIcon(this.getClass().getResource("/DarthVader.png")).getImage();
		Image Yer = new ImageIcon(this.getClass().getResource("/y.png")).getImage();
		Image Duvar = new ImageIcon(this.getClass().getResource("/z.png")).getImage();
    	if (Darth.size() > 0) {
			if (g == 0) {
				kontrol(Darth.get(0).lokasyon[0][0], Darth.get(0).lokasyon[1][0], Yer, Vader, "Darth", 0);
				g = 1;
			} else {
				Util.BFS(mat, Darth.get(0).lokasyon[0][0], Darth.get(0).lokasyon[1][0], x, y);
				temp = Util.path_length;
				sinyal = 0;
				do {
					int i = 0;
					Util.BFS(mat, Darth.get(0).lokasyon[0][0] + 1, Darth.get(0).lokasyon[1][0], x, y);
					if (Util.path_length < temp) {
						if (harita[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]].charAt(0) == '1')
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Yer));
						else
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Duvar));
						Darth.get(i).lokasyon[0][0]++;
						ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
								.setIcon(new ImageIcon(Vader));
						sinyal = 1;
					}

					if (sinyal == 1)
						break;

					Util.BFS(mat, Darth.get(0).lokasyon[0][0] - 1, Darth.get(0).lokasyon[1][0], x, y);
					if (Util.path_length < temp) {
						if (harita[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]].charAt(0) == '1')
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Yer));
						else
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Duvar));
						Darth.get(i).lokasyon[0][0]--;
						ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
								.setIcon(new ImageIcon(Vader));
						sinyal = 1;
					}

					if (sinyal == 1)
						break;

					Util.BFS(mat, Darth.get(0).lokasyon[0][0], Darth.get(0).lokasyon[1][0] + 1, x, y);
					if (Util.path_length < temp) {
						if (harita[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]].charAt(0) == '1')
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Yer));
						else
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Duvar));
						Darth.get(i).lokasyon[1][0]++;
						ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
								.setIcon(new ImageIcon(Vader));
						sinyal = 1;
					}

					if (sinyal == 1)
						break;

					Util.BFS(mat, Darth.get(0).lokasyon[0][0], Darth.get(0).lokasyon[1][0] - 1, x, y);
					if (Util.path_length < temp) {
						if (harita[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]].charAt(0) == '1')
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Yer));
						else
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Duvar));
						Darth.get(i).lokasyon[1][0]--;
						ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
								.setIcon(new ImageIcon(Vader));
						sinyal = 1;
					}

					if (sinyal == 1)
						break;

				} while (sinyal == 0);
			}
		}
    }
    public void RightStorm() {
		Image Troop = new ImageIcon(this.getClass().getResource("/Stormtrooper.png")).getImage();
		Image Yer = new ImageIcon(this.getClass().getResource("/y.png")).getImage();
    	if (Stormtp.size() > 0) {
			for (int i = 0; i < Stormtp.size(); i++) {
				if (f < Stormtp.size()) {
					kontrol(Stormtp.get(i).lokasyon[0][0], Stormtp.get(i).lokasyon[1][0], Yer, Troop, "Storm", i);
					f++;

				} else {
					Util.BFS(mat, Stormtp.get(i).lokasyon[0][0], Stormtp.get(i).lokasyon[1][0], x, y);
					temp = Util.path_length;
					sinyal = 0;
					do {
						if (harita[Stormtp.get(i).lokasyon[0][0] + 1][Stormtp.get(i).lokasyon[1][0]]
								.charAt(0) == '1') {
							Util.BFS(mat, Stormtp.get(i).lokasyon[0][0] + 1, Stormtp.get(i).lokasyon[1][0], x, y);
							if (Util.path_length < temp) {
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Stormtp.get(i).lokasyon[0][0]++;
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Troop));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;
						if (harita[Stormtp.get(i).lokasyon[0][0] - 1][Stormtp.get(i).lokasyon[1][0]]
								.charAt(0) == '1') {
							Util.BFS(mat, Stormtp.get(i).lokasyon[0][0] - 1, Stormtp.get(i).lokasyon[1][0], x, y);
							if (Util.path_length < temp) {
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Stormtp.get(i).lokasyon[0][0]--;
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Troop));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;
						if (harita[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0] + 1]
								.charAt(0) == '1') {
							Util.BFS(mat, Stormtp.get(i).lokasyon[0][0], Stormtp.get(i).lokasyon[1][0] + 1, x, y);
							if (Util.path_length < temp) {
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Stormtp.get(i).lokasyon[1][0]++;
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Troop));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;
						if (harita[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0] - 1]
								.charAt(0) == '1') {
							Util.BFS(mat, Stormtp.get(i).lokasyon[0][0], Stormtp.get(i).lokasyon[1][0] - 1, x, y);
							if (Util.path_length < temp) {
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Stormtp.get(i).lokasyon[1][0]--;
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Troop));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;

					} while (sinyal == 0);
				}
			}
		}
    }
    public void UpRen() {
		Image Yer = new ImageIcon(this.getClass().getResource("/y.png")).getImage();
		Image Kylo = new ImageIcon(this.getClass().getResource("/KyloRen.png")).getImage();
		if (Ren.size() > 0) {
			if (t == 0) {
				kontrol(Ren.get(0).lokasyon[0][0], Ren.get(0).lokasyon[1][0], Yer, Kylo, "Kylo", 0);
				t = 1;
			} else {
				for (int l = 0; l < 2; l++) {
					Util.BFS(mat, Ren.get(0).lokasyon[0][0], Ren.get(0).lokasyon[1][0], x, y);
					temp = Util.path_length;
					sinyal = 0;
					do {
						int i = 0;

						if (harita[Ren.get(i).lokasyon[0][0] + 1][Ren.get(i).lokasyon[1][0]].charAt(0) == '1') {
							Util.BFS(mat, Ren.get(i).lokasyon[0][0] + 1, Ren.get(i).lokasyon[1][0], x, y);
							if (Util.path_length < temp) {
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Ren.get(i).lokasyon[0][0]++;
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Kylo));
								sinyal = 1;

							}
						}
						if (sinyal == 1)
							break;
						if (harita[Ren.get(i).lokasyon[0][0] - 1][Ren.get(i).lokasyon[1][0]].charAt(0) == '1') {
							Util.BFS(mat, Ren.get(i).lokasyon[0][0] - 1, Ren.get(i).lokasyon[1][0], x, y);
							if (Util.path_length < temp) {
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Ren.get(i).lokasyon[0][0]--;
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Kylo));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;
						if (harita[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0] + 1].charAt(0) == '1') {
							Util.BFS(mat, Ren.get(i).lokasyon[0][0], Ren.get(i).lokasyon[1][0] + 1, x, y);
							if (Util.path_length < temp) {
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Ren.get(i).lokasyon[1][0]++;
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Kylo));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;
						if (harita[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0] - 1].charAt(0) == '1') {
							Util.BFS(mat, Ren.get(i).lokasyon[0][0], Ren.get(i).lokasyon[1][0] - 1, x, y);
							if (Util.path_length < temp) {
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Ren.get(i).lokasyon[1][0]--;
								ldizi[Ren.get(i).lokasyon[0][0]][Ren.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Kylo));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;

					} while (sinyal == 0);
				}
			}
		}
	}
	public void UpDarth() {
		Image Vader = new ImageIcon(this.getClass().getResource("/DarthVader.png")).getImage();
		Image Yer = new ImageIcon(this.getClass().getResource("/y.png")).getImage();
		Image Duvar = new ImageIcon(this.getClass().getResource("/z.png")).getImage();
		if (Darth.size() > 0) {
			if (g == 0) {
				kontrol(Darth.get(0).lokasyon[0][0], Darth.get(0).lokasyon[1][0], Yer, Vader, "Darth", 0);
				g = 1;
			} else {
				Util.BFS(mat, Darth.get(0).lokasyon[0][0], Darth.get(0).lokasyon[1][0], x, y);
				temp = Util.path_length;
				sinyal = 0;
				do {
					int i = 0;
					Util.BFS(mat, Darth.get(0).lokasyon[0][0] + 1, Darth.get(0).lokasyon[1][0], x, y);
					if (Util.path_length < temp) {

						if (harita[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]].charAt(0) == '1')
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Yer));
						else
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Duvar));
						Darth.get(i).lokasyon[0][0]++;
						ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
								.setIcon(new ImageIcon(Vader));

						sinyal = 1;

					}

					if (sinyal == 1)
						break;

					Util.BFS(mat, Darth.get(0).lokasyon[0][0] - 1, Darth.get(0).lokasyon[1][0], x, y);
					if (Util.path_length < temp) {
						if (harita[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]].charAt(0) == '1')
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Yer));
						else
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Duvar));
						Darth.get(i).lokasyon[0][0]--;
						ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
								.setIcon(new ImageIcon(Vader));
						sinyal = 1;
					}

					if (sinyal == 1)
						break;

					Util.BFS(mat, Darth.get(0).lokasyon[0][0], Darth.get(0).lokasyon[1][0] + 1, x, y);
					if (Util.path_length < temp) {
						if (harita[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]].charAt(0) == '1')
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Yer));
						else
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Duvar));
						Darth.get(i).lokasyon[1][0]++;
						ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
								.setIcon(new ImageIcon(Vader));
						sinyal = 1;
					}

					if (sinyal == 1)
						break;

					Util.BFS(mat, Darth.get(0).lokasyon[0][0], Darth.get(0).lokasyon[1][0] - 1, x, y);
					if (Util.path_length < temp) {
						if (harita[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]].charAt(0) == '1')
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Yer));
						else
							ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
									.setIcon(new ImageIcon(Duvar));
						Darth.get(i).lokasyon[1][0]--;
						ldizi[Darth.get(i).lokasyon[0][0]][Darth.get(i).lokasyon[1][0]]
								.setIcon(new ImageIcon(Vader));
						sinyal = 1;
					}

					if (sinyal == 1)
						break;

				} while (sinyal == 0);
			}
		}
	}
	public void UpStorm() {
		Image Troop = new ImageIcon(this.getClass().getResource("/Stormtrooper.png")).getImage();
		Image Yer = new ImageIcon(this.getClass().getResource("/y.png")).getImage();
		if (Stormtp.size() > 0) {
			for (int i = 0; i < Stormtp.size(); i++) {
				if (f < Stormtp.size()) {
					kontrol(Stormtp.get(i).lokasyon[0][0], Stormtp.get(i).lokasyon[1][0], Yer, Troop, "Storm", i);
					f++;

				} else {
					Util.BFS(mat, Stormtp.get(i).lokasyon[0][0], Stormtp.get(i).lokasyon[1][0], x, y);
					temp = Util.path_length;
					sinyal = 0;

					do {

						if (harita[Stormtp.get(i).lokasyon[0][0] + 1][Stormtp.get(i).lokasyon[1][0]]
								.charAt(0) == '1') {
							Util.BFS(mat, Stormtp.get(i).lokasyon[0][0] + 1, Stormtp.get(i).lokasyon[1][0], x, y);
							if (Util.path_length < temp) {
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Stormtp.get(i).lokasyon[0][0]++;
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Troop));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;
						if (harita[Stormtp.get(i).lokasyon[0][0] - 1][Stormtp.get(i).lokasyon[1][0]]
								.charAt(0) == '1') {
							Util.BFS(mat, Stormtp.get(i).lokasyon[0][0] - 1, Stormtp.get(i).lokasyon[1][0], x, y);
							if (Util.path_length < temp) {
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Stormtp.get(i).lokasyon[0][0]--;
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Troop));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;
						if (harita[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0] + 1]
								.charAt(0) == '1') {
							Util.BFS(mat, Stormtp.get(i).lokasyon[0][0], Stormtp.get(i).lokasyon[1][0] + 1, x, y);
							if (Util.path_length < temp) {
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Stormtp.get(i).lokasyon[1][0]++;
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Troop));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;
						if (harita[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0] - 1]
								.charAt(0) == '1') {
							Util.BFS(mat, Stormtp.get(i).lokasyon[0][0], Stormtp.get(i).lokasyon[1][0] - 1, x, y);
							if (Util.path_length < temp) {
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Yer));
								Stormtp.get(i).lokasyon[1][0]--;
								ldizi[Stormtp.get(i).lokasyon[0][0]][Stormtp.get(i).lokasyon[1][0]]
										.setIcon(new ImageIcon(Troop));
								sinyal = 1;
							}
						}
						if (sinyal == 1)
							break;

					} while (sinyal == 0);
				}
			}
		}
	}


	public static void kontrol(int x, int y, Image a, Image b, String c, int z) {
		switch (c) {
		case "Storm":
			switch (y) {
			case 0:
				ldizi[x][y].setIcon(new ImageIcon(a));
				ldizi[x][y + 1].setIcon(new ImageIcon(b));
				Stormtp.get(z).lokasyon[1][0]++;
				break;
			case 13:
				ldizi[x][y].setIcon(new ImageIcon(a));
				ldizi[x][y - 1].setIcon(new ImageIcon(b));
				Stormtp.get(z).lokasyon[1][0]--;
				break;
			}
			switch (x) {
			case 0:
				ldizi[x][y].setIcon(new ImageIcon(a));
				ldizi[x + 1][y].setIcon(new ImageIcon(b));
				Stormtp.get(z).lokasyon[0][0]++;
				break;
			case 10:
				ldizi[x][y].setIcon(new ImageIcon(a));
				ldizi[x - 1][y].setIcon(new ImageIcon(b));
				Stormtp.get(z).lokasyon[0][0]--;
				break;
			}
			break;
		case "Darth":
			switch (y) {
			case 0:
				ldizi[x][y].setIcon(new ImageIcon(a));
				ldizi[x][y + 1].setIcon(new ImageIcon(b));
				Darth.get(0).lokasyon[1][0]++;
				break;
			case 13:
				ldizi[x][y].setIcon(new ImageIcon(a));
				ldizi[x][y - 1].setIcon(new ImageIcon(b));
				Darth.get(0).lokasyon[1][0]--;
				break;
			}
			switch (x) {
			case 0:
				ldizi[x][y].setIcon(new ImageIcon(a));
				ldizi[x + 1][y].setIcon(new ImageIcon(b));
				Darth.get(0).lokasyon[0][0]++;
				break;
			case 10:
				ldizi[x][y].setIcon(new ImageIcon(a));
				ldizi[x - 1][y].setIcon(new ImageIcon(b));
				Darth.get(0).lokasyon[0][0]--;
				break;
			}
			break;
		case "Kylo":
			switch (y) {
			case 0:
				ldizi[x][y].setIcon(new ImageIcon(a));
				ldizi[x][y + 1].setIcon(new ImageIcon(b));
				Ren.get(0).lokasyon[1][0]++;
				break;
			case 13:
				ldizi[x][y].setIcon(new ImageIcon(a));
				ldizi[x][y - 1].setIcon(new ImageIcon(b));
				Ren.get(0).lokasyon[1][0]--;
				break;
			}
			switch (x) {
			case 0:
				ldizi[x][y].setIcon(new ImageIcon(a));
				ldizi[x + 1][y].setIcon(new ImageIcon(b));
				Ren.get(0).lokasyon[0][0]++;
				break;
			case 10:
				ldizi[x][y].setIcon(new ImageIcon(a));
				ldizi[x - 1][y].setIcon(new ImageIcon(b));
				Ren.get(0).lokasyon[0][0]--;
				break;
			}
			break;
		}

	}

	public static void haritaoku() throws FileNotFoundException, IOException {
		FileReader fileReader = new FileReader(file);
		String line;
		try (BufferedReader br = new BufferedReader(fileReader)) {
			while ((line = br.readLine()) != null) {
				if (line.contains("Stormtrooper,Kapi:A")) {
					Stormtrooper gecici = new Stormtrooper();
					gecici.Tur = "Kotu";
					gecici.ad = "Stormtrooper";
					gecici.kapi = "A";
					Stormtp.add(gecici);
				} else if (line.contains("Stormtrooper,Kapi:B")) {
					Stormtrooper gecici = new Stormtrooper();
					gecici.Tur = "Kotu";
					gecici.ad = "Stormtrooper";
					gecici.kapi = "B";
					Stormtp.add(gecici);
				} else if (line.contains("Stormtrooper,Kapi:C")) {
					Stormtrooper gecici = new Stormtrooper();
					gecici.Tur = "Kotu";
					gecici.ad = "Stormtrooper";
					gecici.kapi = "C";
					Stormtp.add(gecici);
				} else if (line.contains("Stormtrooper,Kapi:D")) {
					Stormtrooper gecici = new Stormtrooper();
					gecici.Tur = "Kotu";
					gecici.ad = "Stormtrooper";
					gecici.kapi = "D";
					Stormtp.add(gecici);
				} else if (line.contains("Stormtrooper,Kapi:E")) {
					Stormtrooper gecici = new Stormtrooper();
					gecici.Tur = "Kotu";
					gecici.ad = "Stormtrooper";
					gecici.kapi = "E";
					Stormtp.add(gecici);
				} else if (line.contains("Darth") && line.contains("Kapi:A")) {
					DarthVader Vader = new DarthVader();
					Vader.Tur = "Kotu";
					Vader.ad = "DarthVader";
					Vader.kapi = "A";
					Darth.add(Vader);
					D = 1;
				} else if (line.contains("Darth") && line.contains("Kapi:B")) {
					DarthVader Vader = new DarthVader();
					Vader.Tur = "Kotu";
					Vader.ad = "DarthVader";
					Vader.kapi = "B";
					Darth.add(Vader);
					D = 1;
				} else if (line.contains("Darth") && line.contains("Kapi:C")) {
					DarthVader Vader = new DarthVader();
					Vader.Tur = "Kotu";
					Vader.ad = "DarthVader";
					Vader.kapi = "C";
					Darth.add(Vader);
					D = 1;
				} else if (line.contains("Darth") && line.contains("Kapi:D")) {
					DarthVader Vader = new DarthVader();
					Vader.Tur = "Kotu";
					Vader.ad = "DarthVader";
					Vader.kapi = "D";
					Darth.add(Vader);
					D = 1;
				} else if (line.contains("Darth") && line.contains("Kapi:E")) {
					DarthVader Vader = new DarthVader();
					Vader.Tur = "Kotu";
					Vader.ad = "DarthVader";
					Vader.kapi = "E";
					Darth.add(Vader);
					D = 1;
				} else if (line.contains("Kylo") && line.contains("Kapi:A")) {
					KyloRen Kylo = new KyloRen();
					Kylo.Tur = "Kotu";
					Kylo.ad = "KyloRen";
					Kylo.kapi = "A";
					Ren.add(Kylo);
					K = 1;
				} else if (line.contains("Kylo") && line.contains("Kapi:B")) {
					KyloRen Kylo = new KyloRen();
					Kylo.Tur = "Kotu";
					Kylo.ad = "KyloRen";
					Kylo.kapi = "B";
					Ren.add(Kylo);
					K = 1;
				} else if (line.contains("Kylo") && line.contains("Kapi:C")) {
					KyloRen Kylo = new KyloRen();
					Kylo.Tur = "Kotu";
					Kylo.ad = "KyloRen";
					Kylo.kapi = "C";
					Ren.add(Kylo);
					K = 1;
				} else if (line.contains("Kylo") && line.contains("Kapi:D")) {
					KyloRen Kylo = new KyloRen();
					Kylo.Tur = "Kotu";
					Kylo.ad = "KyloRen";
					Kylo.kapi = "D";
					Ren.add(Kylo);
					K = 1;
				} else if (line.contains("Kylo") && line.contains("Kapi:E")) {
					KyloRen Kylo = new KyloRen();
					Kylo.Tur = "Kotu";
					Kylo.ad = "KyloRen";
					Kylo.kapi = "E";
					Ren.add(Kylo);
					K = 1;
				}

				if (line.charAt(0) == '0' || line.charAt(0) == '1') {
					String cumle = line;
					harita[a] = null;
					harita[a] = cumle.split("	");
					a++;
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {

		haritaoku();
		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					Ekran frame = new Ekran();

					frame.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();
				}
			}

		});
		return;
	}

	public void EkranAction() {
		Image imgo = new ImageIcon(this.getClass().getResource("/y.png")).getImage();
		Image imgx = new ImageIcon(this.getClass().getResource("/z.png")).getImage();
		Image imgA = new ImageIcon(this.getClass().getResource("/kapýA.png")).getImage();
		Image imgB = new ImageIcon(this.getClass().getResource("/kapýB.png")).getImage();
		Image imgC = new ImageIcon(this.getClass().getResource("/kapýC.png")).getImage();
		Image imgD = new ImageIcon(this.getClass().getResource("/kapýD.png")).getImage();
		Image imgE = new ImageIcon(this.getClass().getResource("/kapýE.png")).getImage();
		Image Vader = new ImageIcon(this.getClass().getResource("/DarthVader.png")).getImage();
		Image Kylo = new ImageIcon(this.getClass().getResource("/KyloRen.png")).getImage();
		Image Storm = new ImageIcon(this.getClass().getResource("/Stormtrooper.png")).getImage();
		Image Cup = new ImageIcon(this.getClass().getResource("/Cup.png")).getImage();
		x = 5;
		y = 6;
		Label label = new Label("CANLAR");
		label.setFont(new Font("Dialog", Font.PLAIN, 26));
		label.setBounds(764, 76, 108, 46);
		contentPane.add(label);


		int i, j, a = 0;

		for (i = 0; i < 11; i++) {
			for (j = 0; j < 14; j++) {

				if (harita[i][j].charAt(0) == '0')
					ldizi[i][j].setIcon(new ImageIcon(imgx));
				else if (harita[i][j].charAt(0) == '1')
					ldizi[i][j].setIcon(new ImageIcon(imgo));
				ldizi[i][j].setBounds(j * 50, i * 50, 50, 50);
				contentPane.add(ldizi[i][j]);
				ldizi[i][j].repaint();
			}
		}

		for (i = 0; i < 14; i++) {
			if (harita[0][i].charAt(0) == '1') {
				switch (a) {
				case 0:
					ldizi[0][i].setIcon(new ImageIcon(imgA));
					locationx.add(0);
					locationy.add(i);
					a++;
					break;
				case 1:
					ldizi[0][i].setIcon(new ImageIcon(imgB));
					locationx.add(0);
					locationy.add(i);
					a++;
					break;
				case 2:
					ldizi[0][i].setIcon(new ImageIcon(imgC));
					locationx.add(0);
					locationy.add(i);
					a++;
					break;
				case 3:
					ldizi[0][i].setIcon(new ImageIcon(imgD));
					locationx.add(0);
					locationy.add(i);
					a++;
					break;
				case 4:
					ldizi[0][i].setIcon(new ImageIcon(imgE));
					locationx.add(0);
					locationy.add(i);
					a++;
					break;
				case 5:
					ldizi[0][i].setIcon(new ImageIcon(Cup));
					locationx.add(0);
					locationy.add(i);
					break;
				}

			}
		}
		for (i = 0; i < 11; i++) {
			if (harita[i][13].charAt(0) == '1') {
				switch (a) {
				case 0:
					ldizi[i][13].setIcon(new ImageIcon(imgA));
					locationx.add(i);
					locationy.add(13);
					a++;
					break;
				case 1:
					ldizi[i][13].setIcon(new ImageIcon(imgB));
					locationx.add(i);
					locationy.add(13);
					a++;
					break;
				case 2:
					ldizi[i][13].setIcon(new ImageIcon(imgC));
					locationx.add(i);
					locationy.add(13);
					a++;
					break;
				case 3:
					ldizi[i][13].setIcon(new ImageIcon(imgD));
					locationx.add(i);
					locationy.add(13);
					a++;
					break;
				case 4:
					ldizi[i][13].setIcon(new ImageIcon(imgE));
					locationx.add(i);
					locationy.add(13);
					a++;
					break;
				case 5:
					ldizi[i][13].setIcon(new ImageIcon(Cup));
					locationx.add(i);
					locationy.add(13);
					break;

				}
			}
		}
		for (i = 13; i > -1; i--) {
			if (harita[10][i].charAt(0) == '1') {
				switch (a) {
				case 0:
					ldizi[10][i].setIcon(new ImageIcon(imgA));
					locationx.add(10);
					locationy.add(i);
					a++;
					break;
				case 1:
					ldizi[10][i].setIcon(new ImageIcon(imgB));
					locationx.add(10);
					locationy.add(i);
					a++;
					break;
				case 2:
					ldizi[10][i].setIcon(new ImageIcon(imgC));
					locationx.add(10);
					locationy.add(i);
					a++;
					break;
				case 3:
					ldizi[10][i].setIcon(new ImageIcon(imgD));
					locationx.add(10);
					locationy.add(i);
					a++;
					break;
				case 4:
					ldizi[10][i].setIcon(new ImageIcon(imgE));
					locationx.add(10);
					locationy.add(i);
					a++;
					break;
				case 5:
					ldizi[10][i].setIcon(new ImageIcon(Cup));
					locationx.add(10);
					locationy.add(i);
					break;
					

				}
			}
		}
		for (i = 10; i > -1; i--) {
			if (harita[i][0].charAt(0) == '1') {
				switch (a) {
				case 0:
					ldizi[i][0].setIcon(new ImageIcon(imgA));
					locationx.add(i);
					locationy.add(0);
					a++;
					break;
				case 1:
					ldizi[i][0].setIcon(new ImageIcon(imgB));
					locationx.add(i);
					locationy.add(0);
					a++;
					break;
				case 2:
					ldizi[i][0].setIcon(new ImageIcon(imgC));
					locationx.add(i);
					locationy.add(0);
					a++;
					break;
				case 3:
					ldizi[i][0].setIcon(new ImageIcon(imgD));
					locationx.add(i);
					locationy.add(0);
					a++;
					break;
				case 4:
					ldizi[i][0].setIcon(new ImageIcon(imgE));
					locationx.add(i);
					locationy.add(0);
					a++;
					break;
				case 5:
					ldizi[i][0].setIcon(new ImageIcon(Cup));
					locationx.add(i);
					locationy.add(0);
					break;
				}
			}
		}
		if (Stormtp.size() > 0) {
			for (i = 0; i < Stormtp.size(); i++) {
				switch (Stormtp.get(i).kapi.charAt(0)) {
				case 'A':
					ldizi[locationx.get(0)][locationy.get(0)].setIcon(new ImageIcon(Storm));
					Stormtp.get(i).lokasyon = new int[][] { { locationx.get(0) }, { locationy.get(0) } };
					break;
				case 'B':
					ldizi[locationx.get(1)][locationy.get(1)].setIcon(new ImageIcon(Storm));
					Stormtp.get(i).lokasyon = new int[][] { { locationx.get(1) }, { locationy.get(1) } };
					break;
				case 'C':
					ldizi[locationx.get(2)][locationy.get(2)].setIcon(new ImageIcon(Storm));
					Stormtp.get(i).lokasyon = new int[][] { { locationx.get(2) }, { locationy.get(2) } };
					break;
				case 'D':
					ldizi[locationx.get(3)][locationy.get(3)].setIcon(new ImageIcon(Storm));
					Stormtp.get(i).lokasyon = new int[][] { { locationx.get(3) }, { locationy.get(3) } };
					break;
				case 'E':
					ldizi[locationx.get(4)][locationy.get(4)].setIcon(new ImageIcon(Storm));
					Stormtp.get(i).lokasyon = new int[][] { { locationx.get(4) }, { locationy.get(4) } };
					break;
				}

			}
		}
		if (K == 1) {
			switch (Ren.get(0).kapi.charAt(0)) {
			case 'A':
				ldizi[locationx.get(0)][locationy.get(0)].setIcon(new ImageIcon(Kylo));
				Ren.get(0).lokasyon = new int[][] { { locationx.get(0) }, { locationy.get(0) } };
				break;
			case 'B':
				ldizi[locationx.get(1)][locationy.get(1)].setIcon(new ImageIcon(Kylo));
				Ren.get(0).lokasyon = new int[][] { { locationx.get(1) }, { locationy.get(1) } };
				break;
			case 'C':
				ldizi[locationx.get(2)][locationy.get(2)].setIcon(new ImageIcon(Kylo));
				Ren.get(0).lokasyon = new int[][] { { locationx.get(2) }, { locationy.get(2) } };
				break;
			case 'D':
				ldizi[locationx.get(3)][locationy.get(3)].setIcon(new ImageIcon(Kylo));
				Ren.get(0).lokasyon = new int[][] { { locationx.get(3) }, { locationy.get(3) } };
				break;
			case 'E':
				ldizi[locationx.get(4)][locationy.get(4)].setIcon(new ImageIcon(Kylo));
				Ren.get(0).lokasyon = new int[][] { { locationx.get(4) }, { locationy.get(4) } };
				break;
			}
		}
		if (D == 1) {
			switch (Darth.get(0).kapi.charAt(0)) {
			case 'A':
				ldizi[locationx.get(0)][locationy.get(0)].setIcon(new ImageIcon(Vader));
				Darth.get(0).lokasyon = new int[][] { { locationx.get(0) }, { locationy.get(0) } };
				break;
			case 'B':
				ldizi[locationx.get(1)][locationy.get(1)].setIcon(new ImageIcon(Vader));
				Darth.get(0).lokasyon = new int[][] { { locationx.get(1) }, { locationy.get(1) } };
				break;
			case 'C':
				ldizi[locationx.get(2)][locationy.get(2)].setIcon(new ImageIcon(Vader));
				Darth.get(0).lokasyon = new int[][] { { locationx.get(2) }, { locationy.get(2) } };
				break;
			case 'D':
				ldizi[locationx.get(3)][locationy.get(3)].setIcon(new ImageIcon(Vader));
				Darth.get(0).lokasyon = new int[][] { { locationx.get(3) }, { locationy.get(3) } };
				break;
			case 'E':
				ldizi[locationx.get(4)][locationy.get(4)].setIcon(new ImageIcon(Vader));
				Darth.get(0).lokasyon = new int[][] { { locationx.get(4) }, { locationy.get(4) } };
				break;

			}
		}
	}
	
	public Ekran() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		Image Can = new ImageIcon(this.getClass().getResource("/Can.png")).getImage();
		Image Can5 = new ImageIcon(this.getClass().getResource("/Can5.png")).getImage();
		Image Can4 = new ImageIcon(this.getClass().getResource("/Can4.png")).getImage();
		Image Can3 = new ImageIcon(this.getClass().getResource("/Can3.png")).getImage();
		Image Can2 = new ImageIcon(this.getClass().getResource("/Can2.png")).getImage();
		Image Can1 = new ImageIcon(this.getClass().getResource("/Can1.png")).getImage();

		int i, j;
		for (i = 0; i < 11; i++) {
			for (j = 0; j < 14; j++) {
				ldizi[i][j] = new JLabel("");
				contentPane.remove(ldizi[i][j]);
				contentPane.revalidate();
				contentPane.repaint();
			}
		}

		JLabel lblCanlar = new JLabel("");
		lblCanlar.setBounds(794, 138, 50, 300);
		contentPane.add(lblCanlar);

		JButton btnNewButton = new JButton("BA\u015ELAT");
		btnNewButton.setBounds(785, 13, 85, 46);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EkranAction();
				lblCanlar.setIcon(new ImageIcon(Can));
			}

		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Yoda");
		btnNewButton_1.addKeyListener(new KeyAdapter() {
public void CanKontrol1(Image a) {
	if(k!=0) {
		k--;
	}else {
	if(Util.path_length==0 || Util.path_length==1) {
		ldizi[5][6].setIcon(new ImageIcon(a));
		EkranAction();
		can--;
		switch(can) {
		case 5:
			lblCanlar.setIcon(new ImageIcon(Can5));
			break;
		case 4:
			lblCanlar.setIcon(new ImageIcon(Can4));
			break;
		case 3:
			lblCanlar.setIcon(new ImageIcon(Can3));
			break;
		case 2:
			lblCanlar.setIcon(new ImageIcon(Can2));
			break;
		case 1:
			lblCanlar.setIcon(new ImageIcon(Can1));
			break;
		case 0:
			while(true)System.out.println("Kaybettin");
		}
		
	}} 	
            }
			@Override
			public void keyPressed(KeyEvent e) {
				Image Yoda = new ImageIcon(this.getClass().getResource("/Yoda.png")).getImage();
				Image Yer = new ImageIcon(this.getClass().getResource("/y.png")).getImage();
				int keyCode = e.getKeyCode();

				switch (keyCode) {
				case KeyEvent.VK_UP:
					if (harita[x - 1][y].charAt(0) == '1') {
						ldizi[x][y].setIcon(new ImageIcon(Yer));
						x--;
						ldizi[x][y].setIcon(new ImageIcon(Yoda));
						UpRen();
						CanKontrol1(Yoda);
						UpDarth();
						CanKontrol1(Yoda);
						UpStorm();
						CanKontrol1(Yoda);
						
					}
					if(x==locationx.get(5) && y== locationy.get(5)) {
						while(true) {
							System.out.println("Kazandýn");
						}
					}
					break;
				case KeyEvent.VK_DOWN:
					if (harita[x + 1][y].charAt(0) == '1') {
						ldizi[x][y].setIcon(new ImageIcon(Yer));
						x++;
						ldizi[x][y].setIcon(new ImageIcon(Yoda));
						DownRen();
						CanKontrol1(Yoda);
						DownDarth();
						CanKontrol1(Yoda);
						DownStorm();
						CanKontrol1(Yoda);
						
					}
					if(x==locationx.get(5) && y== locationy.get(5)) {
						while(true) {
							System.out.println("Kazandýn");
						}
					}
					break;
				case KeyEvent.VK_LEFT:
					if (harita[x][y - 1].charAt(0) == '1') {
						ldizi[x][y].setIcon(new ImageIcon(Yer));
						y--;
						ldizi[x][y].setIcon(new ImageIcon(Yoda));
						LeftRen();
						CanKontrol1(Yoda);
						LeftDarth();
						CanKontrol1(Yoda);
						LeftStorm();
						CanKontrol1(Yoda);
						
					}
					if(x==locationx.get(5) && y== locationy.get(5)) {
						while(true) {
							System.out.println("Kazandýn");
						}
					}
					break;
				case KeyEvent.VK_RIGHT:

					if (harita[x][y + 1].charAt(0) == '1') {
						ldizi[x][y].setIcon(new ImageIcon(Yer));
						y++;
						ldizi[x][y].setIcon(new ImageIcon(Yoda));
						RightRen();
						CanKontrol1(Yoda);
						RightDarth();
						CanKontrol1(Yoda);
						RightStorm();
						CanKontrol1(Yoda);
						
						
					}
					if(x==locationx.get(5) && y== locationy.get(5)) {
						while(true) {
							System.out.println("Kazandýn");
						}
					}
					break;
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Image Yoda = new ImageIcon(this.getClass().getResource("/Yoda.png")).getImage();
				ldizi[5][6].setIcon(new ImageIcon(Yoda));

			}
		});
		btnNewButton_1.setBounds(713, 478, 71, 50);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Luke");
		btnNewButton_2.addKeyListener(new KeyAdapter() {
			public void CanKontrol2(Image a) {
				if (s!=0){
					s--;
				}
				else {
				if(Util.path_length==0 || Util.path_length==1) {
					ldizi[5][6].setIcon(new ImageIcon(a));
					EkranAction();
					can=can-2;
					switch(can) {
					case 5:
						lblCanlar.setIcon(new ImageIcon(Can5));
						break;
					case 4:
						lblCanlar.setIcon(new ImageIcon(Can4));
						break;
					case 3:
						lblCanlar.setIcon(new ImageIcon(Can3));
						break;
					case 2:
						lblCanlar.setIcon(new ImageIcon(Can2));
						break;
					case 1:
						lblCanlar.setIcon(new ImageIcon(Can1));
						break;
					case 0:
						while(true)System.out.println("Kaybettin");
					}
					
				} 	}
			            }
			@Override
			public void keyPressed(KeyEvent e) {
				Image Luke = new ImageIcon(this.getClass().getResource("/Luke.png")).getImage();
				Image Yer = new ImageIcon(this.getClass().getResource("/y.png")).getImage();
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_UP:
					if (harita[x - 1][y].charAt(0) == '1') {
						ldizi[x][y].setIcon(new ImageIcon(Yer));
						x--;
						ldizi[x][y].setIcon(new ImageIcon(Luke));
						UpRen();
						CanKontrol2(Luke);
						UpDarth();
						CanKontrol2(Luke);
						UpStorm();
						CanKontrol2(Luke);
						
					}
					if(x==locationx.get(5) && y== locationy.get(5)) {
						while(true) {
							System.out.println("Kazandýn");
						}
					}
					break;
				case KeyEvent.VK_DOWN:
					if (harita[x + 1][y].charAt(0) == '1') {
						ldizi[x][y].setIcon(new ImageIcon(Yer));
						x++;
						ldizi[x][y].setIcon(new ImageIcon(Luke));
						DownRen();
						CanKontrol2(Luke);
						DownDarth();
						CanKontrol2(Luke);
						DownStorm();
						CanKontrol2(Luke);
						
					}
					if(x==locationx.get(5) && y== locationy.get(5)) {
						while(true) {
							System.out.println("Kazandýn");
						}
					}
					break;
				case KeyEvent.VK_LEFT:
					if (harita[x][y - 1].charAt(0) == '1') {
						ldizi[x][y].setIcon(new ImageIcon(Yer));
						y--;
						ldizi[x][y].setIcon(new ImageIcon(Luke));
					DownRen();
					CanKontrol2(Luke);
					DownDarth();
					CanKontrol2(Luke);
					DownStorm();
					CanKontrol2(Luke);}
					if(x==locationx.get(5) && y== locationy.get(5)) {
						while(true) {
							System.out.println("Kazandýn");
						}
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (harita[x][y + 1].charAt(0) == '1') {
						ldizi[x][y].setIcon(new ImageIcon(Yer));
						y++;
						ldizi[x][y].setIcon(new ImageIcon(Luke));
					DownRen();
					CanKontrol2(Luke);
					DownDarth();
					CanKontrol2(Luke);
					DownStorm();
					CanKontrol2(Luke);}
					if(x==locationx.get(5) && y== locationy.get(5)) {
						while(true) {
							System.out.println("Kazandýn");
						}
					}
					break;
				}
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Image Luke = new ImageIcon(this.getClass().getResource("/Luke.png")).getImage();
				ldizi[5][6].setIcon(new ImageIcon(Luke));
			}
		});
		btnNewButton_2.setBounds(794, 478, 76, 50);
		contentPane.add(btnNewButton_2);

	}
}

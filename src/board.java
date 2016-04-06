/* File: board.java */

import java.io.IOException;

public class board {
	
	private int sizex;					// panjang board 
	private int sizey;					// lebar board 

	private Point min_h_vertical;
	private Point min_k_vertical;
	private Point max_h_vertical;
	private Point max_k_vertical;
	private Point min_h_horizontal;
	private Point min_k_horizontal;
	private Point max_h_horizontal;
	private Point max_k_horizontal;
		
	private Point pintu_u;				// lokasi pintu benteng utara 
	private Point pintu_s;				// lokasi pintu benteng selatan
	
	private char[][] isi;				//array 2D dinamis
	private char[][] const_isi;			//array 2D dinamis  
	
	/**
	* konstruktor
	*/
	public board() {
		
		//KAMUS
		String path_file = "C:/Users/AlbertusK95/Documents/Semester04/IF2210_OOP/HasilConvertJava/board.txt";
		int[] arrPosition = new int[2];		//return absis dan ordinat
		
		//ALGORITMA
		
		/** membuat objek pembaca file **/
		ReadFileEksternal RFE = new ReadFileEksternal(path_file);
		
		/** membaca board dari file **/ 
		try {
			RFE.startReadingFile();
		} catch (IOException e) {
			System.err.println("IOException baca file: " + e.getMessage());
		}
		
		/** alokasi matriks board **/
		sizex = RFE.getMatrixCol();
		sizey = RFE.getMatrixRow();
		isi = new char[sizey][sizex];
		const_isi = new char[sizey][sizex];
		
		/** inisiasi matriks board **/
		isi = RFE.getDataMatrix();
		const_isi = RFE.getDataMatrix();
		
		/** inisiasi posisi pintu utara dan selatan **/
		pintu_u = new Point();
		pintu_s = new Point();
		for (int i = 0; i < sizey; i++) {
			for (int j = 0; j < sizex; j++) {
				if (isi[i][j] == 'x') {
					pintu_u.set(j, i);
				} else if (isi[i][j] == 'y') {
					pintu_s.set(j, i);
				}
			}
		}
		
		/** inisiasi nilai min_h dan max_h utk HERBIVORA **/ 
		min_h_vertical = new Point();	
		arrPosition = min_h_ver('h');
		min_h_vertical.set(arrPosition[0], arrPosition[1]);
		
		max_h_vertical = new Point();
		arrPosition = max_h_ver('h');
		max_h_vertical.set(arrPosition[0], arrPosition[1]);
		
		min_h_horizontal = new Point();
		arrPosition = min_h_hor('h');
		min_h_horizontal.set(arrPosition[0], arrPosition[1]);
		
		max_h_horizontal = new Point();
		arrPosition = max_h_hor('h');
		max_h_horizontal.set(arrPosition[0], arrPosition[1]);
		
		/** inisiasi nilai min_h dan max_h utk KARNIVORA **/
		min_k_vertical = new Point();	
		arrPosition = min_h_ver('k');
		min_k_vertical.set(arrPosition[0], arrPosition[1]);
		
		max_k_vertical = new Point();
		arrPosition = max_h_ver('k');
		max_k_vertical.set(arrPosition[0], arrPosition[1]);
		
		min_k_horizontal = new Point();
		arrPosition = min_h_hor('k');
		min_k_horizontal.set(arrPosition[0], arrPosition[1]);
		
		max_k_horizontal = new Point();
		arrPosition = max_h_hor('k');
		max_k_horizontal.set(arrPosition[0], arrPosition[1]);
		
	}
	
	/**
	* methods
	*/
	public int[] min_h_ver(char jns_obj) {
		// batasan nilai random untuk vertikal kiri
		//KAMUS 
		int i=0, j=0, found = 0;
		int[] arrPos = new int[2];
		
		//ALGORITMA 
		for (i = 0; i < sizex; i++) {
			for (j = 0; j < sizey; j++) {
				if (isi[j][i] == jns_obj) {
					found = 1;
					break;
				}
			}
			if (found == 1) {
				break;
			}
		}
		
		arrPos[0] = i;
		arrPos[1] = j;
		
		return arrPos;
	}
	
	public int[] max_h_ver(char jns_obj) {
		// batasan nilai random untuk vertikal kanan 
		//KAMUS 
		int i=0, j=0, found = 0;
		int[] arrPos = new int[2];
		
		//ALGORITMA 
		for (i = sizex-1; i >= 0; i--) {
			for (j = 0; j < sizey; j++) {
				if (isi[j][i] == jns_obj) {
					found = 1;
					break;
				}
			}
			if (found == 1) {
				break;
			}
		}
		
		arrPos[0] = i;
		arrPos[1] = j;
		
		return arrPos;
	}
		
	public int[] min_h_hor(char jns_obj) {
		// batasan nilai random untuk horizontal atas
		//KAMUS 
		int i=0, j=0, found = 0;
		int[] arrPos = new int[2];
		
		//ALGORITMA
		for (i = 0; i < sizey; i++) {
			for (j = 0; j < sizex; j++) {
				if (isi[i][j] == jns_obj) {
					found = 1;
					break;
				}
			}
			if (found == 1) {
				break;
			}
		}
		arrPos[0] = j;
		arrPos[1] = i;
		
		return arrPos;
	}
		
	public int[] max_h_hor(char jns_obj) {
		// batasan nilai random untuk horizontal bawah
		//KAMUS 
		int i=0, j=0, found = 0;
		int[] arrPos = new int[2];
		
		//ALGORITMA
		for (i = sizey-1; i >= 0; i--) {
			for (j = 0; j < sizex; j++) {
				if (isi[i][j] == jns_obj) {
					found = 1;
					break;
				}
			}
			if (found == 1) {
				break;
			}
		}
		arrPos[0] = j;
		arrPos[1] = i;
		
		return arrPos;
	}
		
	public void printboard() {
		//print kondisi dunia saat ini
		System.out.println("[PRINT BOARD]: SABANA");
		System.out.println("---------------------");
		for (int i = 0; i < sizey; i++) {
			for (int j = 0; j < sizex; j++) {
				System.out.print(const_isi[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------");
	}
		
	//public void tambah(makhluk&, char);
		//tambahkan makhluk ke papan
	//public void hapus(makhluk*);
		//hapus makhluk dari papan
	
}
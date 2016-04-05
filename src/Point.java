class Point {
    private int x, y; // abscissa and ordinate

    // Constructor
    // Set titik mula-mula ke (0, 0)
    public Point(){
		x = 0;
		y = 0;
	};

    // Getter
    public int getAbsis(){
		return x;
	};
    public int getOrdinat(){
		return y;
	};
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    // Setter
    public void setAbsis(int x){
		this.x = x;
	};
    public void setOrdinat(int y){
		this.y = y;
	};
    public void set(int x,int y){
        this.x = x;
        this.y = y;
    }

    // Predikat
    // Menghasilkan 1 jika titik (x, y) berada di (0, 0) dan 0 apabila sebaliknya
    public int isOrigin(){
		if ((getAbsis()==0)&&(getOrdinat()==0))
			return 1;
		else
			return 0;
	};

    // Operator Relasional
    // Menghasilkan 1 jika titik pada argumen sama dengan dirinya
    public int isEqual(Point p){
		if ((getAbsis()==p.getAbsis())&&(getOrdinat()==p.getOrdinat()))
			return 1;
		else
			return 0;
	};

    // Operator aritmetika
    // Menghasilkan sebuah Point yang memiliki atribut hasil penjumlahan dari atribut argumen kedua titik
    public Point add(Point p1, Point p2){
		Point P = new Point();
		P.setAbsis(p1.getAbsis()+p2.getAbsis());
		P.setOrdinat(p1.getOrdinat()+p2.getOrdinat());
		return P;
	};

    // Menghasilkan sebuah Point yang mentraslasikan point sekarang sebesar Point argumen
    public Point add(Point o){
		Point P = new Point();
		P.setAbsis(getAbsis()+o.getAbsis());
		P.setOrdinat(getOrdinat()+o.getOrdinat());
		return P;
	}; // menghasilkan current objek+P

    // Menghasilkan sebuah Point dengan translasi (x, y)
    public Point add(int x, int y){
		Point P = new Point();
		P.setAbsis(this.getAbsis() + x);
		P.setOrdinat(this.getOrdinat() + y);
		return P;
	};

    // Mengubah titik dengan penambahan Point argumen
    public void addToMe(Point p){
		setAbsis(getAbsis()+p.getAbsis());
		setOrdinat(getOrdinat()+p.getOrdinat());
	};

    // Mentranslasikan titik sebesar (x, y)
    public void addToMe(int x, int y){
		setAbsis(getAbsis()+x);
		setOrdinat(getOrdinat()+y);
	};

    // Mengubah titik yang merupakan hasil mirror dengan garis y = x
    public void mirror(){
		int temp = getAbsis();
		setAbsis(getOrdinat());
		setOrdinat(temp);
	};

    // Fungsi lain
    // Menghasilkan nomor kuadran dari titik sekarang
    // Sebuah titik yang berada pada sumbu x atau y tidak akan dicoba
    public int kuadran(){
		if (getAbsis()>0){
			if(getOrdinat()>0)
				return 1;
			return 4;
		}
		else{
			if (getOrdinat()>0)
				return 2;
			return 3;
		}
	};

    // Menghasilkan sebuah titik yang merupakan hasil mirror dengan garis y = x
    public Point mirrorOfMe(){
		Point P = new Point();
		P.setAbsis(getOrdinat());
		P.setOrdinat(getAbsis());
		return P;
	};
}
import java.lang.*;

class list{
    //atribut
    class node{
        public char nama_makhluk;		// Z = zebra; S = singa; K = kura2; I = kelinci; U = ular; E = elang  
        public makhluk mptr;
        public int id_unique;
        public node next;
    }
    private node head;
    private node tail;
    class path {
            public Point P;
            public path nextp;
    }
    private path headp;
    private path tailp;
    String nama_list;
    //methods
    list(){
        nama_list = "lop";
        headp = null;
        tailp = null;
    };
    list(String s){
        nama_list = s;
        head = null;
        tail = null;
    };
    boolean isEmpty(){
        if (!nama_list.equals("lom")) {
            if (headp == null && tailp == null) {
                return true; 
            } else {
                return false;
            }
        } else {
            if (head == null && tail == null) {
                return true; 
            } else {
                return false;
            }
        }
    }
    void addNode(makhluk m, char nama_mkhlk, int id_unq) {
	// inisialisasi node baru utk ditambahkan
	node ptr = new node();
	if (ptr == null) { // alokasi gagal
		System.out.println("alokasi node gagal");
	} else { // alokasi berhasil 
		ptr.mptr = m;
		ptr.nama_makhluk = nama_mkhlk;
		ptr.id_unique = id_unq;
	}
	
	// menambahkan ke dalam list sbg elemen terakhir
	if (head == null) { // jika list kosong, firstElmt = addedElmt
		head = ptr;
		tail = ptr;
		tail.next = null;
	} else { // list berisi
		tail.next = ptr;
		ptr.next = null;
		tail = ptr;
	}
    }
    boolean isOneElmt() {
	if (nama_list.equals("lom")) {
		if (head != null && head.next == null) {
			return true;
		} else {
			return false;
		}
	} else {
		if (headp != null && headp.nextp == null) {
			return true;
		} else {
			return false;
		}
	}
    }
    void addPathFirst(Point p) {
	path ptr = new path();
	int px, py;
	if (ptr == null) { // alokasi gagal 
		System.out.println("alokasi path first gagal");
	} else { // alokasi berhasil 
		px = p.getX();
		py = p.getY();
		ptr.P.set(px, py);
	}
	
	// menambahkan ke dalam list sbg elemen terdepan 
	if (headp == null) { // jika list kosong, firstElmt = addedElmt
		headp = ptr;
		tailp = ptr;
		tailp.nextp = null;
	} else { // list berisi
		ptr.nextp = headp;
		headp = ptr;
	}
    }
    void addPath(Point p) {
	// inisialisasi path baru utk ditambahkan
	path ptr = new path();
	int px, py;
	if (ptr == null) { // alokasi gagal
		System.out.println("alokasi path gagal");
	} else { // alokasi berhasil 
		px = p.getX();
		py = p.getY();
		ptr.P.set(px, py);
	}
	
	// menambahkan ke dalam list sbg elemen terakhir
	if (headp == null) { // jika list kosong, firstElmt = addedElmt
		headp = ptr;
		tailp = ptr;
	} else { // list berisi
		tailp.nextp = ptr;
		ptr.nextp = null;
		tailp = ptr;
	}
    }
    void deleteNode(node ptr) {
	node temp = ptr;
	node prev = head;
	if (isEmpty()) {
            System.out.println("list kosong tidak bisa dihapus");
	} else {
            if (temp == prev) {
                head = head.next;
                if (tail == temp) {
                        tail = tail.next;
                }
            } else {
                while (prev.next != ptr) {
                        prev = prev.next;
                }
                prev.next = temp.next;
                if (tail == temp) {
                        tail = prev;
                }
            }
	}
    }
    void deletePath(path ptr) {
	path temp = ptr;
	path prev = headp;
	if (isEmpty()) {
            System.out.println("list kosong tidak bisa dihapus");
	} else {
            if (temp == prev) {
                headp = headp.nextp;
                if (tailp == temp) {
                        tailp = tailp.nextp;
                }
            } else {
                while (prev.nextp != ptr) {
                        prev = prev.nextp;
                }
                prev.nextp = temp.nextp;
                if (tailp == temp) {
                        tailp = prev;
                }
            }
	}
    }
    void deleteAllPath() {
        path current, temp;
        current = headp;
        temp = headp;
        while(current != null) {
                current = current.nextp;
                temp = current;
        }

        headp = null;
        tailp = null;
    }
    void printList(node ptr) {
	System.out.println("[Info] Isi list node");
	System.out.println("--------------------");
	if (isEmpty()) {
            System.out.println("menampilkan list kosong");
	} else {
            while (ptr != null) {
                System.out.println(ptr.mptr.getpower());
                ptr = ptr.next;
            }
	}
    }
    void printListPath(path ptr) {
	System.out.println("[Info] Isi list path");
	System.out.println("--------------------");
	if (isEmpty()) {
            System.out.println("menampilkan list kosong");
	} else {
		while (ptr != null) {
                    print_Point(ptr.P);
                    ptr = ptr.nextp;
		}
	}
    }
}
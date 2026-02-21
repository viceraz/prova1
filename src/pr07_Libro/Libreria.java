package pr07_Libro;

import java.util.Arrays;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Libreria {
//modifiche online
	private String nome;
	//private int maxLibri;
	private Libro[] libri;
	//private Libro libri[]; si puo scrivere anche cosi
	private int numLibri;
	
	public Libreria(String nome, int maxLibri) {
		libri=new Libro[maxLibri];
		numLibri=0;
		this.nome=nome;
	}
	
	public boolean addLibro(Libro lib){
		if(numLibri<libri.length) {
		libri[numLibri]=lib;
	    numLibri++;	
	    return true;
		}
	return false;
	}
	
	/*public boolean addLibro(Libro lib){
		libri[numLibri]=lib;
		numLibri++;
		return false;
	}*/
	
	/*public String toString() {
		return "Libreria [nome="+nome+", libri"+Arrays.toString(libri)+"]";
	}*/
	
	
	//elimina libro per posizione senza controllo
	public void delLibroPos(int pos) {
		libri [pos] = null;
	}
	
	//elimina libro per posizione controllo
	public boolean delLibroCodice(String cod) {
		for(int i = 0; i < libri.length; i++) {
			if(libri[i] != null && libri[i].getCodice().equalsIgnoreCase(cod)) {
				
			
			libri [i] = null;
			numLibri--;
			return true; //se trova
			}
		}
		
		return false;  //se non trova niente
		
		
	}
	//elimina libro per posizione controllo e compattazione
	
	public boolean delLibroCodiceComp(String cod) {
		int j;
		for(int i = 0; i < libri.length; i++) {
			if(libri[i] != null && libri[i].getCodice().equalsIgnoreCase(cod)) {
				
			for( j= i+1; j < libri.length; j++) {
				libri[j-1]=libri[j]; //permette di spostare tutto a sinistra
			}
			numLibri--; //variabile per visualizzare i libri presenti nella biblioteca
				libri[j]=null;
			//libri [i] = null;
			return true; //se trova
			}
		}
		
		return false;  //se non trova niente
		
		
	}
	
	int libriPresenti() {
		return numLibri;
	}
	//libro con piu pagine
	Libro libroPiuPagine(){
		Libro libMax = libri [0];
		
		int pagmax= libri [0].getPagine();
		
		//for
		for(int i=0; i < libri.length; i++) {
			if(libri [i] != null  &&  libri [i].getPagine() > pagmax) {
				pagmax = libri[i].getPagine();
				libMax = libri[i];
			}
		}
		
		return libMax;
	}
	
	// ricerca di tutti i libri scritti da un autore
	
	String libriPerAutore(String autore) {
		String st="";
		for(int i=0;i<libri.length;i++) {
			if (libri[i] != null && libri[i].getAutore().equalsIgnoreCase(autore)) {
				st+=libri[i]+"\n";
			}
		}
		return st;
	}
	
	public String toString() {
		String s="Nome libreria: "+nome+"\n";
		for(int i=0; i < libri.length; i++) {
			if(libri[i] != null) {
				s = s + libri[i] + "\n";
			}
		}
		return s;
	}
	
	
	
	
	public static void main(String[] args) {
		Libreria libCentrale=new Libreria("Libreria viale ferrari", 5);
		Libro lib1=new Libro("Libro 1", "autore 1");
		Libro lib2=new Libro("Libro 2", "autore 2");
		Libro lib3=new Libro("Libro 3", "autore 3");
		Libro lib4=new Libro("Libro 4", "autore 4");
		
		System.out.println(libCentrale.addLibro(lib1));
		System.out.println(libCentrale.addLibro(lib2));
		System.out.println(libCentrale.addLibro(lib3));
		System.out.println(libCentrale.addLibro(lib4));
		
		libCentrale.libri[0].setCodice("Cod 1");
		libCentrale.libri[1].setCodice("Cod 2");
		libCentrale.libri[2].setCodice("Cod 3");
		libCentrale.libri[3].setCodice("Cod 4");
		
		libCentrale.libri[0].setPagine(10);
		libCentrale.libri[1].setPagine(100);
		libCentrale.libri[2].setPagine(200);
		libCentrale.libri[3].setPagine(123);
		
		//(libCentrale.delLibroPos(1);
		System.out.println("--- canc ---");
		System.out.println(libCentrale.delLibroCodice("cod 3"));
		
		System.out.println(libCentrale);
		System.out.println("Libri con più pagine"+ libCentrale.libroPiuPagine());
		System.out.println("Libri presenti "+libCentrale.libriPresenti());
		System.out.println("Questi sono i libri/o per autore: "+libCentrale.libriPerAutore("autore 2"));
		System.out.println("Questi sono i libri/o per autore: "+libCentrale.libriPerAutore("autore 1"));
	}
}


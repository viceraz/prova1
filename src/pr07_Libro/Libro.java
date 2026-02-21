package pr07_Libro;
 //versione 5 online
public class Libro {
	private String titolo;
	private String autore;
	private String codice;
	public String getAutore() {
		return autore;
	}

	public int getPagine() {
		return pagine;
	}

	private int pagine;
	public Libro(String titolo, String autore) {
		this.titolo = titolo;
		this.autore = autore;
	}
	
	public String toString() {
		String s;
		s="titolo=" + titolo + ", autore=" + autore + ", codice=" + codice + ", pagine=" + pagine;
		return s;
	}
	
	
	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}
 
	public void setPagine(int pagine) {
		this.pagine = pagine;
	}
 
	public static void main(String[] args) {
		Libro l1=new Libro("Titolo a caso","Io");
		l1.setCodice("codice555");
		l1.setPagine(125);
		System.out.println(l1);
	}
}
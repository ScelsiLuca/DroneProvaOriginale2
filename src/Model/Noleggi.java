package Model;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Date;



public class Noleggi implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idNoleggio;


	private Date data;


	private Time fineNol;

	private double importo;


	private Time inizioNol;


	private String metodoPag;


	private int idDroni;


	private int idPacchetti;


	private int idUtenti;

	public Noleggi() {
	}

	public Noleggi( int idUtenti, int idDroni, int idPacchetti, Date data, Time inizioNol, Time fineNol, double importo, String metodoPag) {
		super();

		this.data = data;
		this.fineNol = fineNol;
		this.importo = importo;
		this.inizioNol = inizioNol;
		this.metodoPag = metodoPag;
		this.idDroni = idDroni;
		this.idPacchetti = idPacchetti;
		this.idUtenti = idUtenti;
	}

	public int getIdNoleggio() {
		return this.idNoleggio;
	}

	public void setIdNoleggio(int idNoleggio) {
		this.idNoleggio = idNoleggio;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getFineNol() {
		return this.fineNol;
	}

	public void setFineNol(Time fineNol) {
		this.fineNol = fineNol;
	}

	public double getImporto() {
		return this.importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	public Time getInizioNol() {
		return this.inizioNol;
	}

	public void setInizioNol(Time inizioNol) {
		this.inizioNol = inizioNol;
	}

	public String getMetodoPag() {
		return this.metodoPag;
	}

	public void setMetodoPag(String metodoPag) {
		this.metodoPag = metodoPag;
	}

	public int getDroni() {
		return this.idDroni;
	}

	public void setDroni(int droni) {
		this.idDroni = droni;
	}

	public int getPacchetti() {
		return this.idPacchetti;
	}

	public void setPacchetti(int pacchetti) {
		this.idPacchetti = pacchetti;
	}

	public int getUtenti() {
		return this.idUtenti;
	}

	public void setUtenti(int utenti) {
		this.idUtenti = utenti;
	}

}
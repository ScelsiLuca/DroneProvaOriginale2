package Model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;



public class Utenti implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idUtente;

	private String carta;

	private String citta;


	private String codFiscale;

	private String cognome;


	private Date dataNascita;

	private String email;

	private String indirizzo;

	private String nazionalita;

	private String nome;


	private String numTel;

	private String password;

	private String username;


	private List<Noleggi> noleggis;

	public Utenti() {
	}

	public Utenti(String nome, String cognome, Date dataNascita, String indirizzo, String citta, String email, String numTel, String codFiscale, String nazionalita, String username, String password, String carta ) {
		super();
		this.carta = carta;
		this.citta = citta;
		this.codFiscale = codFiscale;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.email = email;
		this.indirizzo = indirizzo;
		this.nazionalita = nazionalita;
		this.nome = nome;
		this.numTel = numTel;
		this.password = password;
		this.username = username;
		this.noleggis = noleggis;
	}

	public int getIdUtente() {
		return this.idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getCarta() {
		return this.carta;
	}

	public void setCarta(String carta) {
		this.carta = carta;
	}

	public String getCitta() {
		return this.citta;
	}

	public void setCitta(String citta) {
		this.citta= citta;
	}

	public String getCodFiscale() {
		return this.codFiscale;
	}

	public void setCodFiscale(String codFiscale) {
		this.codFiscale = codFiscale;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return this.dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNazionalita() {
		return this.nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita= nazionalita;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumTel() {
		return this.numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Noleggi> getNoleggis() {
		return this.noleggis;
	}

	public void setNoleggis(List<Noleggi> noleggis) {
		this.noleggis = noleggis;
	}



}
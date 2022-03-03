package Model;

import java.io.Serializable;



public class Droni implements Serializable {
	private static final long serialVersionUID = 1L;


	private int idDrone;
	private String disponibile;
	private String nome;
	private int idStazione;

	public Droni() {
	}

	public Droni(int idDrone, String nome, int idStazioni, String disponibile) {
		super();
		this.idDrone = idDrone;
		this.disponibile = disponibile;
		this.nome = nome;
		this.idStazione = idStazioni;
	}
	public Droni(String nome, int idStazioni, String disponibile) {
		super();
		this.disponibile = disponibile;
		this.nome = nome;
		this.idStazione = idStazioni;
	}


	public int getIdDrone() {
		return this.idDrone;
	}

	public void setIdDrone(int idDrone) {
		this.idDrone = idDrone;
	}

	public String getDisponibile() {
		return this.disponibile;
	}

	public void setDisponibile(String disponibile) {
		this.disponibile = disponibile;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdStazione() {
		return this.idStazione;
	}

	public void setIdStazione(int stazioni) {
		this.idStazione = stazioni;
	}



}
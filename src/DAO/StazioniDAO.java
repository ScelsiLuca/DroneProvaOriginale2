package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Stazioni;
import Servlet.ConnessioneDb;

public class StazioniDAO {
	
	//Insert di una stazione(abb inutile al momento)
	public void insertStazione(Stazioni s) throws SQLException {
		ConnessioneDb con = new ConnessioneDb();
		try {
			con.connect();
			String query = "INSERT INTO stazioni (nome, posizione) VALUES" + "(?,?);";
			PreparedStatement st = con.getCon().prepareStatement(query);
			st.setString(1, s.getNome());
			st.setString(2, s.getPosizione());
			st.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.close();

	}
	
	//Select di stazione per utente/admin
	public Stazioni selectStazione(int id) {
		Stazioni staz = null;
		ConnessioneDb con = new ConnessioneDb();
		try {
			con.connect();
			String query = "SELECT * from stazioni WHERE id_stazione=?";
			PreparedStatement st = con.getCon().prepareStatement(query);
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String nome = rs.getString("nome");
				String posizione = rs.getString("posizione");
				staz = new Stazioni(nome, posizione);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return staz;
	}
	
	//Select di tutte le stazioni utente (per la tabella della mappa) 
	public List<Stazioni> selectAllStazioni() {
		List<Stazioni> stations = new ArrayList<>();
		Stazioni stat = null;
		ConnessioneDb con = new ConnessioneDb();
		try {
			con.connect();
			String query = "SELECT * from stazioni";
			PreparedStatement st = con.getCon().prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String nome = rs.getString("nome");
				String posizione = rs.getString("posizione");
				stat = new Stazioni(nome, posizione);
				stations.add(stat);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stations;
	}
	
	public int quantityDroni(String nome) {
		
		int quantita = 0 ; 
		ConnessioneDb con = new ConnessioneDb() ; 
		try {
			con.connect();
			String query = "SELECT * FROM droni WHERE disponibile = 'true' AND id_stazione = (SELECT id_stazione FROM stazioni WHERE nome = ?)" ;
			PreparedStatement st = con.getCon().prepareStatement(query);
			st.setString(1, nome);
			ResultSet rs = st.executeQuery() ; 			
			while (rs.next()) {
				quantita += 1 ; 
			}
			
			con.close();
			return quantita ; 

		} catch (Exception e) {
			e.printStackTrace();
		}
		return quantita ; 
	}
}

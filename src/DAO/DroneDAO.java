package DAO;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Droni;
import Servlet.ConnessioneDb;

public class DroneDAO {

	//inserimento drone 
	public void insertDroni(Droni d) throws SQLException {
		ConnessioneDb con = new ConnessioneDb();
		try {
			con.connect();
			String query = "INSERT INTO droni (nome, id_stazione, disponibile) VALUES" + "(?,?,?);";
			PreparedStatement st = con.getCon().prepareStatement(query);
			st.setString(1, d.getNome());
			st.setInt(2, d.getIdStazione());
			st.setString(3, d.getDisponibile());
			st.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.close();

	}
	
	//Select drone per utente
	public Droni selectDroni(int id) {
		Droni drone = null;
		ConnessioneDb con = new ConnessioneDb();
		try {
			con.connect();
			String query = "SELECT nome, id_stazione, disponibile from droni WHERE id_drone=?";
			PreparedStatement st = con.getCon().prepareStatement(query);

			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int idDrone= rs.getInt("id_drone");
				String nome = rs.getString("nome");
				int idStazione = rs.getInt("id_stazione");
				String disponibile = rs.getString("disponibile");
				drone = new Droni(idDrone, nome, idStazione, disponibile);
			}
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return drone;
	}
	
	//Select di tutti i droni admin
	public List<Droni> selectAllDroni() {
		List<Droni> droni = new ArrayList<>();
		ConnessioneDb con = new ConnessioneDb();
		try {
			con.connect();
			String query = "SELECT  nome, id_stazione, disponibile from droni";
			PreparedStatement st = con.getCon().prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String nome = rs.getString("nome");
				int idStazione = rs.getInt("id_stazione");
				String disponibile = rs.getString("disponibile");
				Droni drone = new Droni(nome, idStazione, disponibile);
				droni.add(drone);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return droni;
	}
	
	//Select di tutti i droni di un singolo utente
	public List<Droni> selectAllDroni(int id) {
		List<Droni> droni = new ArrayList<>();
		ConnessioneDb con = new ConnessioneDb();
		try {
			con.connect();
			String query = "SELECT nome, id_stazione, disponibile from droni";
			PreparedStatement st = con.getCon().prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				
				String nome = rs.getString("nome");
				int idStazione = rs.getInt("id_stazione");
				String disponibile = rs.getString("disponibile");
				Droni drone = new Droni(nome, idStazione, disponibile);
				droni.add(drone);
			}
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return droni;
	}
	
	
}


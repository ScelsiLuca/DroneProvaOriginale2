package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Pacchetti;
import Servlet.ConnessioneDb;

public class PacchettiDAO {
	
	//Insert nuovo pacchetto (inutile)
	public void insertPacchetto(Pacchetti p) throws SQLException {
		ConnessioneDb con = new ConnessioneDb();
		try {
			con.connect();
			String query = "INSERT INTO pacchetti (nome, tariffa) VALUES" + "(?,?);";
			PreparedStatement st = con.getCon().prepareStatement(query);
			st.setString(1, p.getNome());
			st.setDouble(2, p.getTariffa());
			st.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.close();

	}
	
	//Select di un singolo pacchetto (utente)
	public Pacchetti selectPacchetti(int id) {
		Pacchetti pack = null;
		ConnessioneDb con = new ConnessioneDb();
		try {
			con.connect();
			String query = "SELECT * from pacchetti WHERE id_pacchetto=?";
			PreparedStatement st = con.getCon().prepareStatement(query);

			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String nome = rs.getString("nome");
				double tariffa = rs.getDouble("tariffa");
				pack= new Pacchetti(nome, tariffa);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pack;
	}
	
	//Select di tutti i pacchetti admin (inutile)
	public List<Pacchetti> selectAllPacchetti() {
		List<Pacchetti> packs = new ArrayList<>();
		Pacchetti pack = null;
		ConnessioneDb con = new ConnessioneDb();
		try {
			con.connect();
			String query = "SELECT * from pacchetti";
			PreparedStatement st = con.getCon().prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String nome = rs.getString("nome");
				double tariffa = rs.getDouble("tariffa");
				pack = new Pacchetti(nome, tariffa);
				packs.add(pack);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return packs;
	}
	
	
}

package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Noleggi;
import Servlet.ConnessioneDb;
import java.sql.*;

public class NoleggiDAO {

	//inserimento noleggio utente
	public void insertNoleggio(Noleggi n) throws SQLException {
		ConnessioneDb con = new ConnessioneDb();
		try {
			con.connect();
			String query = "INSERT INTO noleggi (id_utente, id_drone, id_pacchetto, data, inizio_nol, fine_nol, importo, metodo_pag) VALUES" + "(?,?,?,?,?,?,?,?);";
			PreparedStatement st = con.getCon().prepareStatement(query);
			st.setInt(1, n.getUtenti());
			st.setInt(2, n.getDroni());
			st.setInt(3, n.getPacchetti());
			st.setDate(4,n.getData());
			st.setTime(5, n.getInizioNol());
			st.setTime(6, n.getFineNol());
			st.setDouble(7, n.getImporto());
			st.setString(8, n.getMetodoPag());
			st.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.close();

	}
	
	//Select noleggio singolo
	public Noleggi selectNoleggio(int id) {
		Noleggi nol = null;
		ConnessioneDb con = new ConnessioneDb();
		try {
			con.connect();
			String query = "SELECT * from noleggi WHERE id_noleggio=?";
			PreparedStatement st = con.getCon().prepareStatement(query);

			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int idUtente= rs.getInt("id_utente");
				int idDrone= rs.getInt("id_drone");
				int idPacchetto= rs.getInt("id_pacchetto");
				Date data = rs.getDate("data");
				Time inizioNol = rs.getTime("inizio_nol");
				Time fineNol = rs.getTime("fine_nol");
				double importo = rs.getDouble("importo");
				String metodoPag = rs.getString("metodo_pag");
				nol = new Noleggi(idUtente, idDrone, idPacchetto, data, inizioNol, fineNol, importo, metodoPag);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nol;
	}
	
	//Select tutti noleggi(admin)
	public List<Noleggi> selectAllNoleggiAdmin() {
		List<Noleggi> noleggi = new ArrayList<>();
		Noleggi nol = null;
		ConnessioneDb con = new ConnessioneDb();
		try {
			con.connect();
			String query = "SELECT * from noleggi";
			PreparedStatement st = con.getCon().prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int idUtente= rs.getInt("id_utente");
				int idDrone= rs.getInt("id_drone");
				int idPacchetto= rs.getInt("id_pacchetto");
				Date data = rs.getDate("data");
				Time inizioNol = rs.getTime("inizio_nol");
				Time fineNol = rs.getTime("fine_nol");
				double importo = rs.getDouble("importo");
				String metodoPag = rs.getString("metodo_pag");
				nol = new Noleggi(idUtente, idDrone, idPacchetto, data, inizioNol, fineNol, importo, metodoPag); 
				noleggi.add(nol);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noleggi;
	}
	
	
	
	//Select tutti i noleggi del singolo utente
	public List<Noleggi> selectAllNoleggi(int id_utente) {
		List<Noleggi> noleggi = new ArrayList<>();
		Noleggi nol = null;
		ConnessioneDb con = new ConnessioneDb();
		try {
			con.connect();
			String query = "SELECT * from noleggi where id_utente=?";
			PreparedStatement st = con.getCon().prepareStatement(query);
			ResultSet rs = st.executeQuery();
			st.setInt(1, id_utente);
			while (rs.next()) {
				int idUtente= rs.getInt("id_utente");
				int idDrone= rs.getInt("id_drone");
				int idPacchetto= rs.getInt("id_pacchetto");
				Date data = rs.getDate("data");
				Time inizioNol = rs.getTime("inizio_nol");
				Time fineNol = rs.getTime("fine_nol");
				double importo = rs.getDouble("importo");
				String metodoPag = rs.getString("metodo_pag");
				nol = new Noleggi(idUtente, idDrone, idPacchetto, data, inizioNol, fineNol, importo, metodoPag); 
				noleggi.add(nol);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noleggi;
	}
}

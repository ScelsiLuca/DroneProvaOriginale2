package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Utenti;
import Servlet.ConnessioneDb;

public class UtentiDAO {

	//Insert nuovo utente
	public void insertUtente(Utenti u) throws SQLException {
		ConnessioneDb con = new ConnessioneDb();
		try {
			con.connect();
			String query = "INSERT INTO utenti (nome, cognome, data_nascita, indirizzo, citta, email, num_tel, cod_fiscale, nazionalita, username, password, carta) VALUES" + "(?,?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement st = con.getCon().prepareStatement(query);
			st.setString(1, u.getNome());
			st.setString(2, u.getCognome());
			st.setDate(3, u.getDataNascita());
			st.setString(4, u.getIndirizzo());
			st.setString(5, u.getCitta());
			st.setString(6, u.getEmail());
			st.setString(7, u.getNumTel());
			st.setString(8, u.getCodFiscale());
			st.setString(9, u.getNazionalita());
			st.setString(10, u.getUsername());
			st.setString(11, u.getPassword());
			st.setString(12, u.getCarta());
			st.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.close();

	}
	
	//Select utente per admin
	public Utenti selectUtente(int id) {
		Utenti user = null;
		ConnessioneDb con = new ConnessioneDb();
		try {
			con.connect();
			String query = "SELECT * from utenti WHERE id_utente=?";
			PreparedStatement st = con.getCon().prepareStatement(query);

			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				Date dataNascita = rs.getDate("data_nascita");
				String indirizzo = rs.getString("indirizzo");
				String citta = rs.getString("citta");
				String email = rs.getString("email");
				String numTel = rs.getString("num_tel");
				String codFiscale = rs.getString("cod_fiscale");
				String nazionalita = rs.getString("nazionalita");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String carta = rs.getString("carta");
				user = new Utenti(nome, cognome, dataNascita, indirizzo, citta, email, numTel, codFiscale, nazionalita, username, password, carta);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	//Select di tutti gli utenti per admin
	public List<Utenti> selectAllUtenti() {
		List<Utenti> users = new ArrayList<>();
		Utenti user = null;
		ConnessioneDb con = new ConnessioneDb();
		try {
			con.connect();
			String query = "SELECT * from utenti";
			PreparedStatement st = con.getCon().prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				Date dataNascita = rs.getDate("data_nascita");
				String indirizzo = rs.getString("indirizzo");
				String citta = rs.getString("citta");
				String email = rs.getString("email");
				String numTel = rs.getString("num_tel");
				String codFiscale = rs.getString("cod_fiscale");
				String nazionalita = rs.getString("nazionalita");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String carta = rs.getString("carta");
				user = new Utenti(nome, cognome, dataNascita, indirizzo, citta, email, numTel, codFiscale, nazionalita, username, password, carta);
				users.add(user);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
}

package Servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DroneDAO;
import Model.Droni;

@WebServlet("/inserisciDrone")
public class inserisciDrone extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DroneDAO ddao;

    public inserisciDrone() {
        super();

    }


	public void init(ServletConfig config) throws ServletException {
		ddao = new DroneDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idDrone = Integer.parseInt(request.getParameter("id_drone"));
		String nome = request.getParameter("nome");
		int stazioni = Integer.parseInt(request.getParameter("id_stazione"));
		String disponibile = request.getParameter("disponibile");

		Droni d = new Droni(idDrone, nome, stazioni , disponibile);
		try {
			ddao.insertDroni(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("index.html");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

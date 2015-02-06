package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.L4DFacade;

/**
 * Servlet implementation class L4DStatsServlet
 */
@WebServlet("/Servlet")
public class L4DStatsServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private ArrayList<String> errors;
	private L4DFacade facade = new L4DFacade();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public L4DStatsServlet()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException
	{
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
	{
		errors = new ArrayList<String>();
		String action = request.getParameter("action");
		String destination = "index.html"; // just when something went wrong!

		if (action != null)
		{
			if (action.equals("login"))
			{
				destination = login(request, response);
			}
		}
		request.setAttribute("errors", errors);
		RequestDispatcher view = request.getRequestDispatcher(destination);
		try
		{
			view.forward(request, response);
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	private String login(HttpServletRequest request, HttpServletResponse response)
	{
		String steamID = request.getParameter("steamid");
		String destination = "";
		if (validID(steamID))
		{
			request.setAttribute("profile", facade.getProfile(steamID));
//			request.setAttribute("games", facade.getGames(steamID));
//			request.setAttribute("totalcost", facade.getTotal());
			destination = "overview.jsp";
			request.setAttribute("stats", facade.generatePerspectives(steamID));
		} else
		{
			destination = "steamlogin.jsp";
			errors.add("Invalid steam64 ID");
		}
		return destination;
	}

	private boolean validID(String steamID)
	{

		return steamID.matches("^[0-9]*$") ? true : false;
	}
}

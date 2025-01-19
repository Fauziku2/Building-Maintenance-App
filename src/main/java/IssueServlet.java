
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class IssueServlet
 */
@WebServlet("/IssueServlet")
public class IssueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String jdbcURL = "jdbc:mysql://localhost:3306/IssueDetails";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

	private static final String INSERT_ISSUE_SQL = "INSERT INTO IssueDetails (title, description, location, name, email, phone, priority, assign, status, comment) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String SELECT_ISSUE_BY_ID = "select title,description,location,name,email,phone,priority,assign,status,comment from IssueDetails where title =?";
	private static final String SELECT_ALL_ISSUES = "select * from IssueDetails ";
	private static final String DELETE_ISSUES_SQL = "delete from IssueDetails where title = ?;";
	private static final String UPDATE_ISSUES_SQL = "update IssueDetails set title = ?,description= ?,location =?,name =?,email =?,phone =?, comment =? where title = ?;";
	private static final String ASSIGN_ISSUE_SQL = "update IssueDetails set assign =? where title = ?;";
	private static final String SET_ISSUE_STATUS_SQL = "update IssueDetails set status =? where title = ?;";
	private static final String SET_PRIORITY_SQL = "update IssueDetails set priority =? where title = ?;";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IssueServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/IssueServlet/delete":
				deleteIssue(request, response);
				break;
			case "/IssueServlet/edit":
				showEditForm(request, response);
				break;
			case "/IssueServlet/priority":
				showPriorityForm(request, response);
				break;
			case "/IssueServlet/assign":
				showAssignForm(request, response);
				break;
			case "/IssueServlet/status":
				showStatusForm(request, response);
				break;
			case "/IssueServlet/update":
				updateIssue(request, response);
				break;
			case "/IssueServlet/dashboard":
				listIssues(request, response);
				break;
			case "/IssueServlet/insert":
				addNewIssue(request, response);
				break;
			case "/IssueServlet/setPriority":
				updatePriority(request, response);
				break;
			case "/IssueServlet/setAssign":
				updateAssign(request, response);
				break;
			case "/IssueServlet/setStatus":
				updateStatus(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	private void listIssues(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Issue> issues = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ISSUES);) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String title = rs.getString("title");
				String description = rs.getString("description");
				String location = rs.getString("location");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String priority = rs.getString("priority");
				String assign = rs.getString("assign");
				String status = rs.getString("status");
				String comment = rs.getString("comment");
				issues.add(new Issue(title, description, location, name, email, phone, priority, assign, status, comment));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("listIssues", issues);
		request.getRequestDispatcher("/issueManagement.jsp").forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String title = request.getParameter("title");
		Issue existingIssue= new Issue("", "", "", "", "", "", "", "", "", "");
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ISSUE_BY_ID);) {
			preparedStatement.setString(1, title);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				title = rs.getString("title");
				String description = rs.getString("description");
				String location = rs.getString("location");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String priority = rs.getString("priority");
				String assign = rs.getString("assign");
				String status = rs.getString("status");
				String comment = rs.getString("comment");
				existingIssue = new Issue(title, description, location, name, email, phone, priority, assign, status, comment);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("issue", existingIssue);
		request.getRequestDispatcher("/issueEdit.jsp").forward(request, response);
	}
	
	private void showPriorityForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String title = request.getParameter("title");
		Issue existingIssue= new Issue("", "", "", "", "", "", "", "", "", "");
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ISSUE_BY_ID);) {
			preparedStatement.setString(1, title);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				title = rs.getString("title");
				String priority = rs.getString("priority");
				existingIssue = new Issue(title, "", "", "", "", "", priority, "", "", "");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("issue", existingIssue);
		request.getRequestDispatcher("/priorityEdit.jsp").forward(request, response);
	}
	
	private void showAssignForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String title = request.getParameter("title");
		Issue existingIssue= new Issue("", "", "", "", "", "", "", "", "", "");
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ISSUE_BY_ID);) {
			preparedStatement.setString(1, title);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				title = rs.getString("title");
				String assign = rs.getString("assign");
				existingIssue = new Issue(title, "", "", "", "", "", "", assign, "", "");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("issue", existingIssue);
		request.getRequestDispatcher("/assignEdit.jsp").forward(request, response);
	}
	
	private void showStatusForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String title = request.getParameter("title");
		Issue existingIssue= new Issue("", "", "", "", "", "", "", "", "", "");
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ISSUE_BY_ID);) {
			preparedStatement.setString(1, title);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				title = rs.getString("title");
				String status = rs.getString("status");
				existingIssue = new Issue(title, "", "", "", "", "", "", "", status, "");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("issue", existingIssue);
		request.getRequestDispatcher("/statusEdit.jsp").forward(request, response);
	}
	
	private void updateIssue(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String oriTitle = request.getParameter("oriTitle");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String comment = request.getParameter("comment");
		String location = request.getParameter("location");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_ISSUES_SQL);) {
			statement.setString(1, title);
			statement.setString(2, description);
			statement.setString(3, location);
			statement.setString(4, name);
			statement.setString(5, email);
			statement.setString(6, phone);
			statement.setString(7, comment);
			statement.setString(8, oriTitle);
			int i = statement.executeUpdate();
		}
		response.sendRedirect("http://localhost:8090/BuildingMaintenanceApp/IssueServlet/dashboard");
	}
	
	private void updatePriority(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String title = request.getParameter("title");
		String priority = request.getParameter("priority");
		
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(SET_PRIORITY_SQL);) {
			statement.setString(1, priority);
			statement.setString(2, title);
			int i = statement.executeUpdate();
		}
		response.sendRedirect("http://localhost:8090/BuildingMaintenanceApp/IssueServlet/dashboard");
	}
	
	private void updateAssign(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String title = request.getParameter("title");
		String assign = request.getParameter("assign");
		
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(ASSIGN_ISSUE_SQL);) {
			statement.setString(1, assign);
			statement.setString(2, title);
			int i = statement.executeUpdate();
		}
		response.sendRedirect("http://localhost:8090/BuildingMaintenanceApp/IssueServlet/dashboard");
	}
	
	private void updateStatus(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String title = request.getParameter("title");
		String status = request.getParameter("status");
		
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(SET_ISSUE_STATUS_SQL);) {
			statement.setString(1, status);
			statement.setString(2, title);
			int i = statement.executeUpdate();
		}
		response.sendRedirect("http://localhost:8090/BuildingMaintenanceApp/IssueServlet/dashboard");
	}
	
	private void deleteIssue(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String title = request.getParameter("title");

		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_ISSUES_SQL);) {
			statement.setString(1, title);
			int i = statement.executeUpdate();
		}
		response.sendRedirect("http://localhost:8090/BuildingMaintenanceApp/IssueServlet/dashboard");
	}
	
	private void addNewIssue(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		RequestDispatcher rd = null;
		rd = getServletContext().getRequestDispatcher("/ReportServlet");
		rd.include(request, response);
	}
}

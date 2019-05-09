

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class First
 */
@WebServlet("/First")
public class First extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("vanthutu");
			Connection con=DriverManager.getConnection("jdbc:mysql://172.20.33.65:3306/annamalai", "admin", "root");
			System.out.println("helooo?????");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select* from employee_details;");
			while(rs.next()) {
				System.out.println(rs.getString("emp_id"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s=request .getParameter("uname");
		String s1=request .getParameter("pass");
	response.getWriter().println("hello"+s);
	}

}

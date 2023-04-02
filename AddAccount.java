package bank;


	import java.io.IOException;
	import java.io.PrintWriter;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;


	@WebServlet("/add")
		public class AddAccount extends HttpServlet {
		Connection con;
		long accno1;
		double ini_amt;
		
		@Override
		public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem?user=root&password=sql@123");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//fetch the data from html
		String accno=req.getParameter("accno");
		String name=req.getParameter("name");		
		String amt=req.getParameter("amt");
				
		//parsing
		accno1=Long.parseLong(accno);
		ini_amt=Double.parseDouble(amt);
					
		PreparedStatement pstmt = null;
		
		String query="insert into add_account values(?,?,?)";
		
		try{
			pstmt=con.prepareStatement(query);
			
			pstmt.setLong(1,accno1);
			pstmt.setString(2, name);			
			pstmt.setDouble(3, ini_amt);
	
			
			int count=pstmt.executeUpdate();
			PrintWriter pw=resp.getWriter();
			pw.print("<h1>"+count+"ACCOUNT ADDED SUCCESSFULL</h1>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}

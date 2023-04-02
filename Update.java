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


	@WebServlet("/depositelink")
		public class Update extends HttpServlet {
		Connection con;
		long accno2;
		double amt1;

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

		Deposite o1=new Deposite();
	//fetch the data from html
	String accno=req.getParameter("accno");
	String amt=req.getParameter("amt");

	//parsing
	accno2 = Long.parseLong(accno);
	amt1 = Double.parseDouble(amt);
	double amt3=o1.amt2;
	
		PreparedStatement pstmt = null;
		String query="update add-account set initial_amt=amt3 where accno=?";
		
		try {
			
			pstmt=con.prepareStatement(query);
			pstmt.setLong(1, accno2);
			pstmt.setDouble(2, amt1);
			int count = pstmt.executeUpdate();
					
			W pw=resp.getWriter();
			pw.print("<h1 color='green'>"+count+"AMOUNT DEPOSITED SUCCESSFULLY</h1>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

	}

	


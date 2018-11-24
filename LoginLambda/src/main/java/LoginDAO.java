import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.amazonaws.lambda.demo.LoginRequest;

public class LoginDAO {

	public Boolean validateUser(LoginRequest loginRequest) {
		System.out.println("LoginDAO.validateUser()");
		Connection con = null;
		PreparedStatement ps;
		Boolean result = false;
		ResultSet rs=null;
		String query = "select count(*) from users where user_name=? and password=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://hackriti10c.cmboaqgjozj1.us-east-2.rds.amazonaws.com:3306/test", "digsingh144",
					"pass");

			ps = con.prepareStatement(query);
			ps.setString(1, loginRequest.getUsername());
			ps.setString(2, loginRequest.getPassword());
			// excute the query
			 rs = ps.executeQuery();
			int cnt = 0;
			if (rs.next())
				cnt = rs.getInt(1);
			if (cnt > 0)
				result = true;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}

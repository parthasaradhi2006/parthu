package student;
import java.sql.*;
public class data_base_con {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student",
                "root",
                "Parthasaradhi@415121");
			
		}
		catch(Exception e){
			System.out.println(e);
	
		}
		return con;
		
	}

}

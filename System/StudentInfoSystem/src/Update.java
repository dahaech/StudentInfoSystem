import java.sql.*;

import org.h2.*;

public class Update {
	int id;
	String phone;
	
	public void updateStudent(int id, String phone){
		updateDB(id, phone);
	}
	
	private void updateDB(int id, String phone){
		
		Connection con = null;
		Statement stmt = null;
		
		try{
			Class.forName("org.h2.Driver");

			String url = "jdbc:h2:~/StudentInfo";
			String user = "sa";
			String passwd = "";
			
			con = DriverManager.getConnection(url, user, passwd);
			stmt = con.createStatement();
			
			String sqlCreate = "CREATE TABLE IF NOT EXISTS StudentInfoTable ("
					+"id INT PRIMARY KEY,"
					+"name CHAR(20), "
					+"department CHAR(20),"
					+"phone CHAR(22) "
					+");";
			stmt.execute(sqlCreate);
			String sqlUpdate = "UPDATE StudentInfoTable SET "+"PHONE="+phone+"WHERE ID="+id+";";
			stmt.execute(sqlUpdate);
			
			con.close();
			stmt.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}

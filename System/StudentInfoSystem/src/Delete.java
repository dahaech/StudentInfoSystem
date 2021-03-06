import java.sql.*;

import org.h2.*;

public class Delete {
	int id;
	
	public void deleteStudent(int id){
		deleteFromDB(id);
	}
	
	private void deleteFromDB(int id){
		
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
			String sqlDelete = "DELETE FROM StudentInfoTable WHERE ID="+id+";";
			stmt.execute(sqlDelete);
			
			con.close();
			stmt.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}

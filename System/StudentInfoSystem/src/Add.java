import java.sql.*;

import org.h2.*;

public class Add {

	int id;
	String name, department, phone;
	
	public void addStudent(int id, String name, String department, String phone){
		addToDB(id, name, department, phone);
	}
	
	private void addToDB(int id, String name, String department, String phone){
		
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
			String sqlAdd = "INSERT INTO StudentInfoTable VALUES("+id+", '"+name+"', '"+department+"','"+phone+"');";
			stmt.execute(sqlAdd);
			
			con.close();
			stmt.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}

}




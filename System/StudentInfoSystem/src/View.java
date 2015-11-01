import java.sql.*;
import org.h2.*;

public class View {
	int id;
	String name, department, phone;
	
	public View(int id){
		getStudentInfo(id);
		display();
	}
	
	private void getStudentInfo(int id){
		Connection con = null;
		Statement stmt = null;
		try{
			Class.forName("org.h2.Driver");

			String url = "jdbc:h2:~/test";
			String user = "sa";
			String passwd = "";
			
			con = DriverManager.getConnection(url, user, passwd);
			stmt = con.createStatement();
			
			String sqlCreate = "CREATE TABLE IF NOT EXISTS StudentInfoTable ("
					+"id INT PRIMARY KEY,"
					+"name CHAR(20), "
					+"department CHAR(20),"
					+"phone CHAR(22) "
					//+"PRIMARY KEY(id)"
					+");";
			stmt.execute(sqlCreate);
			String sqlView = "SELECT * FROM StudentInfoTable WHERE id = "+id+";";
			
			ResultSet result = stmt.executeQuery(sqlView);
			boolean isThereAnyData = result.next();
			if(isThereAnyData==false){
				this.id = id;
				name = "no student";
				department = "no department";
				phone = "no phone number";
				
				//System.out.println("no data");
			}
			while(isThereAnyData){
				this.id = result.getInt("ID");
				name = result.getString("NAME");
				department = result.getString("DEPARTMENT");
				phone = result.getString("PHONE");
				//System.out.println("yes data");
				
				isThereAnyData = result.next();
			}
			
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	private void display(){
		System.out.println("id           : " + id);
		System.out.println("name         : " + name);
		System.out.println("department   : " + department);
		System.out.println("phone number : " + phone);
	}
	
}

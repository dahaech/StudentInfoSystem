import java.sql.*;

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
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("driver lodding success");
			
			String url = "jdbc:mysql://localhost/StudentInfoTable";
			String user = "kna4898@gmail.com";
			String passwd = "Oh!941129or";
			
			con = DriverManager.getConnection(url, user, passwd);
			//System.out.println("connection success");
			
			String sqlCreate = "CREATE TABLE IF NOT EXISTS StudentInfoTable ("
					+"id INTEGER NOT NULL,"
					+"name TEXT(20), "
					+"phone TEXT(22), "
					+"PRIMARY KEY(id)"
					+");";
			stmt.executeQuery(sqlCreate);
			String sqlView = "SELECT * FROM table WHERE id = "+ id + ";";
			stmt = con.createStatement();
			
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
				this.id = result.getInt("id");
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

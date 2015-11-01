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
			//Log.i("view", "driver lodding success");
			
			String url = "jdbc:mysql://localhost";
			String root = "root";
			String passwd = "1234";
			
			con = DriverManager.getConnection(url, root, passwd);
			//Log.i("view", "connection success");
			
			String sql = "SELECT * FROM table WHERE id = "+ id + ";";
			stmt = con.createStatement();
			
			ResultSet result = stmt.executeQuery(sql);
			while(result.next()){
				name = result.getString("NAME");
				department = result.getString("DEPARTMENT");
				phone = result.getString("PHONE");
			}
			
			con.close();
		}catch(Exception e){
			
		}
	}
	
	private void display(){
		System.out.println("id           : " + id);
		System.out.println("name         : " + name);
		System.out.println("department   : " + department);
		System.out.println("phone number : " + phone);
	}
	
}

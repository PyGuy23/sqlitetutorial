package sqlitetutorial;
import java.sql.*;
public class Database {
	
	public static void main(String []args){
		
		Connection connection = null;
		Statement stmt = null;
		
		try{
			
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:test.db");
			connection.setAutoCommit(false);
			System.out.println("Successfully opened database");
			
			stmt = connection.createStatement();
			
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY");
			
			while(rs.next()){
				String name = rs.getString("name");
				String address = rs.getString("address");
				float salary = rs.getFloat("salary");
				
				System.out.println("NAME" +name);
				System.out.println("Address" + address);
				System.out.println("Salary" + salary);
			}
			
			
			rs.close();
			stmt.close();
			connection.close();
		/*String sql = "CREATE TABLE COMPANY" +
						 "(PRIMARY_KEY NOT_NULL," +
						 "NAME  TEXT NOT_NULL , " +
						 "ADDRESS CHAR(50)," +
						 "SALARY REAL)";
						 
					 
					
						 
			
			String sql1 = "INSERT INTO COMPANY(NAME,ADDRESS,SALARY)" + 
						"VALUES('Paul','California', 20000.00);";
						
		stmt.executeUpdate(sql);
			stmt.executeUpdate(sql1);
			
			
			
			
			
			sql1 = "INSERT INTO COMPANY(NAME,ADDRESS,SALARY)" +
				  "VALUES('Allen','New Jersey', 30000.00);";
			
			stmt.executeUpdate(sql1);
			
			
			stmt.close();
			connection.commit();
			connection.close();
			
			/*/
			
		}catch(Exception e){
			
			System.err.println(e.getClass().getName() + ":" + e.getMessage());
			System.exit(0);
			
			
		}
		
		System.out.println("opened database successfully");
		
	}

}

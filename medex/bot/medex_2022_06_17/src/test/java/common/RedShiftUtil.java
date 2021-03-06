package common;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

public class RedShiftUtil {
	static String dbURL = "***jdbc cluster connection string ****";
	static String MasterUsername = "***master user name***";
	static String MasterUserPassword = "***master user password***";
	//static List<String[]> list = null;
	private static String path = System.getProperty("user.dir");
	static String query = null;

	public List getData(String queryParam) {
		Connection conn = null;
		Statement stmt = null;
		List resultList=null;
		try {
			query = CommonUtil.GetXMLData(
					Paths.get(path.toString(), "src", "test", "java", "DBSettings.xml").toString(), queryParam);
			dbURL = CommonUtil.GetXMLData(
					Paths.get(path.toString(), "src", "test", "java", "DBSettings.xml").toString(), "RedShift_DbURL");
			MasterUsername = CommonUtil.GetXMLData(
					Paths.get(path.toString(), "src", "test", "java", "DBSettings.xml").toString(), "RedShift_DbUsername");
			MasterUserPassword = CommonUtil.GetXMLData(
					Paths.get(path.toString(), "src", "test", "java", "DBSettings.xml").toString(), "RedShift_DbPassword");
		} catch (Exception ex) {
			throw new CustomException("DBSettings.xml file does not exist");
		}
		try {
			// Dynamically load driver at runtime.
			// Redshift JDBC 4.1 driver: com.amazon.redshift.jdbc41.Driver
			// Redshift JDBC 4 driver: com.amazon.redshift.jdbc4.Driver
			//Class.forName("com.amazon.redshift.jdbc.Driver");
			Class.forName("com.amazon.redshift.jdbc41.Driver");
			// Open a connection and define properties.
			System.out.println("Connecting to database...");
			Properties props = new Properties();

			// Uncomment the following line if using a keystore.
			props.setProperty("sslfactory", "com.amazon.redshift.ssl.NonValidatingFactory");
			props.setProperty("ssl", "true");
			props.setProperty("user", MasterUsername);
			props.setProperty("password", MasterUserPassword);
			conn = DriverManager.getConnection(dbURL, props);

			// Try a simple query.
			System.out.println("Listing system tables...");
			stmt = conn.createStatement();
			String sql;
			// sql = "select * from information_schema.tables;";
			ResultSet rs = stmt.executeQuery(query);
			resultList =CommonUtil.resultSetToArrayList(rs);
			
//			while (rs.next()) {
//				String show = rs.toString();
//				// String season = rs.getString("SEASON");
//				list.add(new String[] { show });
//
//			}

			// Get the data from the result set.
//           while(rs.next()){
//              //Retrieve two columns.
//              String catalog = rs.getString("table_catalog");
//              String name = rs.getString("table_name");
//
//              //Display values.
//              System.out.print("Catalog: " + catalog);
//              System.out.println(", Name: " + name);
//           }
			rs.close();
			stmt.close();
			conn.close();

		} catch (Exception ex) {
			// For convenience, handle all errors here.
			ex.printStackTrace();

		} finally {
			// Finally block to close resources.
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception ex) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		System.out.println("Finished connectivity test.");
		return resultList;
	}
		public List getExcelData(String queryParam) {
		Connection conn = null;
		Statement stmt = null;
		List resultList=null;
		try {
			
			dbURL = CommonUtil.GetXMLData(
					Paths.get(path.toString(), "src", "test", "java", "DBSettings.xml").toString(), "RedShift_DbURL");
			MasterUsername = CommonUtil.GetXMLData(
					Paths.get(path.toString(), "src", "test", "java", "DBSettings.xml").toString(), "RedShift_DbUsername");
			MasterUserPassword = CommonUtil.GetXMLData(
					Paths.get(path.toString(), "src", "test", "java", "DBSettings.xml").toString(), "RedShift_DbPassword");
		} catch (Exception ex) {
			throw new CustomException("DBSettings.xml file does not exist");
		}
		try {
			// Dynamically load driver at runtime.
			// Redshift JDBC 4.1 driver: com.amazon.redshift.jdbc41.Driver
			// Redshift JDBC 4 driver: com.amazon.redshift.jdbc4.Driver
			//Class.forName("com.amazon.redshift.jdbc.Driver");
			Class.forName("com.amazon.redshift.jdbc41.Driver");
			// Open a connection and define properties.
			System.out.println("Connecting to database...");
			Properties props = new Properties();

			// Uncomment the following line if using a keystore.
			props.setProperty("sslfactory", "com.amazon.redshift.ssl.NonValidatingFactory");
			props.setProperty("ssl", "true");
			props.setProperty("user", MasterUsername);
			props.setProperty("password", MasterUserPassword);
			conn = DriverManager.getConnection(dbURL, props);

			// Try a simple query.
			System.out.println("Listing system tables...");
			stmt = conn.createStatement();
			String sql;
			// sql = "select * from information_schema.tables;";
			ResultSet rs = stmt.executeQuery(queryParam);
			resultList =CommonUtil.resultSetToArrayList(rs);
			
//			while (rs.next()) {
//				String show = rs.toString();
//				// String season = rs.getString("SEASON");
//				list.add(new String[] { show });
//
//			}

			// Get the data from the result set.
//           while(rs.next()){
//              //Retrieve two columns.
//              String catalog = rs.getString("table_catalog");
//              String name = rs.getString("table_name");
//
//              //Display values.
//              System.out.print("Catalog: " + catalog);
//              System.out.println(", Name: " + name);
//           }
			rs.close();
			stmt.close();
			conn.close();

		} catch (Exception ex) {
			// For convenience, handle all errors here.
			ex.printStackTrace();

		} finally {
			// Finally block to close resources.
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception ex) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		System.out.println("Finished connectivity test.");
		return resultList;
	}
}

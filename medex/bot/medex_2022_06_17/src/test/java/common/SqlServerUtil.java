package common;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.cucumber.listener.Reporter;

public class SqlServerUtil {

	private Connection conn =null;
	private ResultSet results;
	static String dbURLdb = "***jdbc cluster connection string ****";
	static String dbMasterUsername = "***master user name***";
	static String dbMasterUserPassword = "***master user password***";
	private static String path = System.getProperty("user.dir");
	static String query1 = null;

	public SqlServerUtil() {

	}
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}


	public void createConnection() {


		try {

			System.out.println("Entering getdata method ");

			dbURLdb = CommonUtil.GetXMLData(
					Paths.get(path.toString(), "src", "test", "java", "DBSettings.xml").toString(), "PostgreSql_DbURL");
			dbMasterUsername = CommonUtil.GetXMLData(
					Paths.get(path.toString(), "src", "test", "java", "DBSettings.xml").toString(),
					"PostgreSql_DbUsername");
			dbMasterUserPassword = CommonUtil.GetXMLData(
					Paths.get(path.toString(), "src", "test", "java", "DBSettings.xml").toString(),
					"PostgreSql_DbPassword");
			System.out.println(
					"DB details : " + dbURLdb + " username " + dbMasterUsername + " password " + dbMasterUserPassword);
		} catch (Exception ex) {
			throw new CustomException("DBSettings.xml file does not exist");
		}

		try {
			if(this.conn == null) {
				setConnection();
			}else {
				System.out.println("Already connected to DB");
			}


			//this.results = this.conn.createStatement().executeQuery(query);


		} catch (Exception e1) {
			System.out.println(" ERROR MESSAGE " + e1.getMessage());
			e1.printStackTrace();
			System.err.println(e1.getClass().getName() + ": " + e1.getMessage());
		} 



	}

	public void setConnection() {
		// String format = String.format("jdbc:postgresql://localhost:5433/%s",
		// database);

		String url = CommonUtil.GetXMLData(
				Paths.get(path.toString(), "src", "test", "java", "DBSettings.xml").toString(), "PostgreSql_DbURL");
		String user = CommonUtil.GetXMLData(
				Paths.get(path.toString(), "src", "test", "java", "DBSettings.xml").toString(),
				"PostgreSql_DbUsername");
		String password = CommonUtil.GetXMLData(
				Paths.get(path.toString(), "src", "test", "java", "DBSettings.xml").toString(),
				"PostgreSql_DbPassword");
		System.out.println(
				"DB details : " + url + " username " + user + " password " + password);



		Properties props = new Properties();
		props.setProperty("user", user.trim());
		props.setProperty("password", password.trim());
		props.setProperty("ssl", "true");
		//props.setProperty("trustServerCertificate","false");

		try {

			try {

				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("Before DB is not connected");
			setConn(DriverManager.getConnection(url.trim(),props));
			System.out.println("After DB is connected");

			this.conn.setAutoCommit(true);

			if (conn != null) {
				System.out.println("Connected to the database!");
			} else {
				System.out.println("Failed to make connection!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		} catch (Exception e1) {
			e1.printStackTrace();
			System.err.println(e1.getClass().getName() + ": " + e1.getMessage());
		}
	}

	public Connection getConnection() {
		return this.conn;
	}

	public void closeConnection() {
		try {
			this.conn.close();
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
			e1.printStackTrace();
			System.err.println(e1.getClass().getName() + ": " + e1.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	public SqlServerUtil(Connection conn) {
		this.conn = conn;
	}

	public void update(String query1) {
		int executeUpdteStatus=0;
		boolean connStatus = true;
		try {
			//	query1 = CommonUtil.GetXMLData(
			//	Paths.get(path.toString(), "src", "test", "java", "DBSettings.xml").toString(), queryParam);
			System.out.println("Query value " + query1);
			createConnection();
			try {
				connStatus = this.conn.isClosed();
			}catch(SQLException e) {

			}


			if(!connStatus) {

				//PreparedStatement prepareStatement=this.conn.prepareStatement(query.trim());
				//	executeUpdteStatus = prepareStatement.executeUpdate();
				Statement statement=this.conn.createStatement();
				executeUpdteStatus = statement.executeUpdate(query1.trim());
				System.out.println("Query is Updated in DB " );

			}else {
				query1 = CommonUtil.GetXMLData(
						Paths.get(path.toString(), "src", "test", "java", "DBSettings.xml").toString(), query1);
				System.out.println("Query value " + query1);

				setConnection();
				PreparedStatement prepareStatement=this.conn.prepareStatement(query1.trim());
				executeUpdteStatus = prepareStatement.executeUpdate();
				System.out.println(" DB update row count :"+executeUpdteStatus);
			}
			/* if(executeUpdteStatus>=1) {
				return true;
			}else {
				return false;
			}*/

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new CustomException(e.getMessage(),e);
			//e.printStackTrace();
			//return false;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			throw new CustomException(e.getMessage(),e);
			//e.printStackTrace();
			//return false;
		}finally {
			if (this.conn != null ) {
				closeConnection();
			}

		}

	}

	public void select(String query) {
		try {
			String sqlQuery = CommonUtil.GetXMLData(
					Paths.get(path.toString(), "src", "test", "java", "DBSettings.xml").toString(), query);
			getConnection();
			this.results = this.conn.prepareStatement(sqlQuery).executeQuery();
			List abd = CommonUtil.resultSetToArrayList(results);

			System.out.println(abd.size());
			for (int i = 0; i < abd.size(); i++) {

				HashMap row = (HashMap) abd.get(i);

				for (Object mapVal : row.values())
					System.out.println(mapVal.toString());
			}

		} catch (SQLException e1) {
		}finally {
			if (this.conn != null ) {
				closeConnection();
			}
		}
	}

	public List getData(String query2) {
		List resultList = null;
		try {

			System.out.println("Entering getdata method ");
			//query1 = CommonUtil.GetXMLData(
			//		Paths.get(path.toString(), "src", "test", "java", "DBSettings.xml").toString(), queryParam);
			System.out.println("Query value " + query2);


		} catch (Exception ex) {
			throw new CustomException("DBSettings.xml file does not exist");
		}

		try {
			System.out.println("Before  setConnection ");
			setConnection();
			System.out.println("After  setConnection ");
			this.results = this.conn.createStatement().executeQuery(query2);
			//this.results = this.conn.prepareStatement(query).executeQuery();
			resultList = CommonUtil.resultSetToArrayList(results);

			System.out.println("DB query result size : " + resultList.size());
			//			for (int i = 0; i < abc.size(); i++) {
			//
			//				HashMap row = (HashMap) abc.get(i);
			//
			//				for (Object mapVal : row.values())
			//					System.out.println(mapVal.toString());
			//			}

		} catch (SQLException e) {
			System.out.println(" ERROR MESSAGE " + e.getMessage());
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		} catch (Exception e) {
			System.out.println(" ERROR MESSAGE " + e.getMessage());
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		} finally {
			if (this.conn != null ) {
				closeConnection();
			}

		}

		return resultList;
	}

	public String getSingleData(String query2) {
	//	System.out.println("getSingleData method -------------------------"+query2);
		List resultList = null;
		try {

			System.out.println("Entering getdata method ");
			//query1 = CommonUtil.GetXMLData(
			//		Paths.get(path.toString(), "src", "test", "java", "DBSettings.xml").toString(), queryParam);
			System.out.println("Query value " + query2);


		} catch (Exception ex) {
			throw new CustomException("DBSettings.xml file does not exist");
		}

		try {
			System.out.println("Before  setConnection ");
			setConnection();
			System.out.println("After  setConnection ");
			//this.results = this.conn.createStatement().executeQuery(query2);

			//this.results = this.conn.prepareStatement(query).executeQuery();
			resultList = getData(query2);
			System.out.println("getSingleData output -------------------------"+resultList);
			System.out.println("DB query result size : " + resultList);
			for (int i = 0; i < resultList.size(); i++)
			{
				HashMap row = (HashMap)resultList.get(i);
				System.out.println("row value is :"+row);
				for (Object mapVal : row.values())
				{
					 //System.out.println("mapvalue should be :"+mapVal);
					 Reporter.addStepLog("DB Value copied : "+mapVal);
					return mapVal.toString();


				}
			}
			//			for (int i = 0; i < abc.size(); i++) {
			//
			//				HashMap row = (HashMap) abc.get(i);
			//
			//				for (Object mapVal : row.values())
			//					System.out.println(mapVal.toString());
			//			}

		} catch (Exception e) {
			System.out.println(" ERROR MESSAGE " + e.getMessage());
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		} finally {
			if (this.conn != null ) {
				closeConnection();
			}

		}

		return "";
	}
	public  boolean  verifyDbData(String Paramquery) throws Exception {

		SqlServerUtil sql = new SqlServerUtil();
		//System.out.println("verifyDbdata param query-------------------------"+Paramquery);
		// String commandParam = "select Version from
		// rtlspf_algoshack.dbo.NotificationBatch where Id=2449706--Version--1";
		String query = null;
		//String columnName=null;
		String compareValue=null;
		String[] queryDetails = Paramquery.split("--");
		boolean status=false;

		if (queryDetails.length == 2) {
			query = queryDetails[0];
			compareValue = queryDetails[1];
			compareValue=compareValue.replaceAll("\\[","" ).replaceAll("\\]", "");
		//	System.out.println("after split from -- query-------------------------"+query);
		//	System.out.println("after split from -- compare value-------------------------"+compareValue);
			//columnName = queryDetails[2];

		} else {
			//System.out.println("Invalid param------------------------");
			Reporter.addStepLog("Invalid parameter");
			throw new Exception("Invalid parameter");
		}

		try {

			//sql.createConnection();
			//System.out.println("enter into Get data");

			/* ResultSet rs = sql.getConnection().prepareStatement(query).executeQuery();

System.out.println("Result set size :" + rs.getFetchSize());*/

			//int columnIndex = rs.findColumn(columnName);

			/*while (rs.next()) {

System.out.println("Result should give in resultset" + rs);

status = validateResultSetRecords(rs, compareValue, columnIndex);
                  if(status==true) {
                   break;
                         }
System.out.println("matching value of " + compareValue + " found in DB is " + status);

}*/

			System.out.println("compareValue Should be :"+compareValue    );
			List resultList = getData(query);
			System.out.println("DB output : "+resultList);
			for (int i = 0; i < resultList.size(); i++)
			{
				HashMap row = (HashMap)resultList.get(i);
				System.out.println("row value is :"+row);
				for (Object mapVal : row.values())
				{
					 //System.out.println("mapvalue should be :"+mapVal);
					if(mapVal==null) {
						Reporter.addStepLog("DB Output : Null");
						//System.out.println("Mapvalue is null :");
					}
					else if(mapVal.toString().equals("null")){
						//System.out.println("Mapvalue is String null :");  
						Reporter.addStepLog("DB Output : Null");
					}
					else if(mapVal.toString().contains(compareValue)) {
						Reporter.addStepLog("DB Output : "+resultList+" , Compare Value : "+compareValue);
						//System.out.println("Compare value is :"+mapVal.toString().contains(compareValue));
						status= true;
						return true;
					}


				}
			}
			return status;
		}


		catch (Exception e) {
			//System.out.println(" ERROR : " + e.getMessage());
			Reporter.addStepLog("Error : "+e);
			e.printStackTrace();
			return false;
		}
		finally {

			try {
				getConn().close();
			} catch (SQLException e) {

			}
		}
	}

	public static boolean validateResultSetRecords(ResultSet rs,String compareValue,int columnIndex ) throws SQLException {
		Object columnObject = rs.getObject(columnIndex);
		String columnValue = null;
		if(columnObject instanceof Integer) {
			columnValue = String.valueOf((int) columnObject);

		} else if(columnObject instanceof Boolean) {
			columnValue = String.valueOf((boolean) columnObject);

		} else if(columnObject instanceof Float) {
			columnValue = String.valueOf((Float) columnObject);

		}else if(columnObject instanceof Double) {
			columnValue = String.valueOf((Double) columnObject);

		}else if(columnObject instanceof Character) {
			columnValue = String.valueOf((Character) columnObject);

		}else if(columnObject instanceof String) {
			columnValue = (String) columnObject;				

		}
		System.out.println("result value " + columnValue);


		return compareValue.equalsIgnoreCase(columnValue);
	}
}

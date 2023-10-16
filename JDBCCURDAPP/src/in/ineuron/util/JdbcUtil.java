package in.ineuron.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.*;

public class JdbcUtil {
	private JdbcUtil() {
	}
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
public static Connection getJdbcConnection() throws SQLException, IOException {
	FileInputStream fis = new FileInputStream("src\\in\\ineuron\\properties\\db.properties");
	//"\\src\\in\\ineuron\\properties\\db.properties"
	Properties properties=new Properties();
	properties.load(fis);
	String url=properties.getProperty("url");
	String username=properties.getProperty("user");
	String password=properties.getProperty("password");
	//Connection connection=DriverManager.getConnection(url,username,password);
	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/enterprisejavabatch?user=root&password=Root");
	
	return connection;
}
}

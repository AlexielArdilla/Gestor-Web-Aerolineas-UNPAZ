package alex.databaseConnection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnection {

	private static String DB_DRIVER_CLASS;
	private static String DB_URL;
	private static String DB_USERNAME;
	private static String DB_PASSWORD;

	static {
		Properties props = new Properties();
		InputStream fis = null;
		try {

			fis = MyConnection.class.getClassLoader().getResourceAsStream("db.properties");

			props.load(fis);

			DB_DRIVER_CLASS = props.getProperty("DB_DRIVER_CLASS");
			DB_URL = props.getProperty("DB_URL");
			DB_USERNAME = props.getProperty("DB_USERNAME");
			DB_PASSWORD = props.getProperty("DB_PASSWORD");

			Class.forName(DB_DRIVER_CLASS);

		} catch (IOException error) {
			System.out.println("Error la leer el archivo de configuracion db.properties " + error);

		} catch (ClassNotFoundException error) {
			System.out.println("Error: al cargar el driver de conexi�n a la Base " + error);

		}
	}

	public static Connection getConnection() {

		Connection con = null;
		try {

			con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			return (con);
		}

		catch (SQLException error) {
			// error.printStackTrace();
			System.out.println("Error: en el socket de conexi�n a la base " + error);
			return (null);
		}

	}
	
}
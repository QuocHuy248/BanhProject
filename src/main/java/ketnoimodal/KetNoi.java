package ketnoimodal;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoi {
	public Connection cn;

	public void ketnoi() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://LAPTOP-B1753BFL:1433;databaseName=BanBanh;user=sa;password=123;encrypt=true;trustServerCertificate=true;";
		cn = DriverManager.getConnection(url);

	}
}

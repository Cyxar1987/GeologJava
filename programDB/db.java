package programDB;

import java.sql.SQLException;

public class db {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		
		conndb c = new conndb();
		c.Connect();
		c.CreateDB();
		c.WriteDB();
		c.ReadDB();
		c.CloseDB();
	}
}
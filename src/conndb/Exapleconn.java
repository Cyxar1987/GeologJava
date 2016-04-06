package conndb;

import java.sql.SQLException;

public class Exapleconn {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {


       ConnectDB.Connect();
       // ConnectDB.CreateDB();
       // ConnectDB.WriteDB();
        ConnectDB.ReadDB();
        ConnectDB.CloseDB();
    }
}

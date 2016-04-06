package conndb;

        import java.sql.Connection;
        import java.sql.Driver;
        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;


public class ConnectDB {

    public static  Connection conn = null;
    public static Statement statmt = null;
    public static ResultSet resSet = null;


    public static void Connect() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {


        // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
        Driver driver = (Driver)Class.forName("org.sqlite.JDBC").newInstance();

        String url = "jdbc:sqlite:d:\\sql\\Java\\DataBase\\Testdb";
        //String url = "jdbc:sqlite:Testdb";
        //d:\sql\Java\DataBase\

        conn = DriverManager.getConnection(url);

        System.out.println("База Подключена!");
    }


    // --------Создание таблицы--------
    public static void CreateDB() throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'phone' INT);");

        System.out.println("Таблица создана или уже существует.");
    }
    // --------Заполнение таблицы--------
    public static void WriteDB() throws SQLException
    {
        statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Petya', 125453); ");
        statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Vasya', 321789); ");
        statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Masha', 456123); ");

        System.out.println("Таблица заполнена");

    }

    public static void ReadDB() throws ClassNotFoundException, SQLException
    {
        resSet = statmt.executeQuery("SELECT * FROM users");

        while(resSet.next())
        {
            int id = resSet.getInt("id");
            String  name = resSet.getString("name");
            String  phone = resSet.getString("phone");
            System.out.println( "ID = " + id );
            System.out.println( "name = " + name );
            System.out.println( "phone = " + phone );
            System.out.println();
        }

        System.out.println("Таблица выведена");
    }

    // --------Закрытие--------
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
        conn.close();
        statmt.close();
        resSet.close();

        System.out.println("Соединения закрыты");
    }













	/*

	// --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
	public static void Conn() throws ClassNotFoundException, SQLException
	   {
		   conn = null;
		   Class.forName("org.sqlite.JDBC");
		   conn = DriverManager.getConnection("jdbc:sqlite:SQLite/DSA.s3db");

		   System.out.println("База Подключена!");
	   }

	// --------Создание таблицы--------
	public static void CreateDB() throws ClassNotFoundException, SQLException
	   {
		statmt = conn.createStatement();
		statmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'phone' INT);");

		System.out.println("Таблица создана или уже существует.");
	   }

	// --------Заполнение таблицы--------
	public static void WriteDB() throws SQLException
	{
		   statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Petya', 125453); ");
		   statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Vasya', 321789); ");
		   statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Masha', 456123); ");

		   System.out.println("Таблица заполнена");
	}

	// -------- Вывод таблицы--------
	public static void ReadDB() throws ClassNotFoundException, SQLException
	   {
		resSet = statmt.executeQuery("SELECT * FROM users");

		while(resSet.next())
		{
			int id = resSet.getInt("id");
			String  name = resSet.getString("name");
			String  phone = resSet.getString("phone");
	         System.out.println( "ID = " + id );
	         System.out.println( "name = " + name );
	         System.out.println( "phone = " + phone );
	         System.out.println();
		}

		System.out.println("Таблица выведена");
	    }

		// --------Закрытие--------
		public static void CloseDB() throws ClassNotFoundException, SQLException
		   {
			conn.close();
			statmt.close();
			resSet.close();

			System.out.println("Соединения закрыты");
		   }
*/
}

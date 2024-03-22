package dal;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContext {
    protected Connection connect;
    public DBContext(){
        try {
            String user = "sa";
            String pass = "123456";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Library";
//            String url = "jdbc:sqlserver://localhost:1433;databaseName=MyEmployee";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect = DriverManager.getConnection(url, user, pass);
            if(connect!=null){
                System.out.println("Connected!");
                DatabaseMetaData dm = connect.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        DBContext dbContext = new DBContext();

        // Nếu kết nối thành công, bạn có thể thực hiện các thao tác với database ở đây
        // Ví dụ: In ra tên các bảng trong database
        if (dbContext.connect != null) {
            System.out.println("Connected!");
        }
}
}
    



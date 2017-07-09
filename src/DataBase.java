
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase {

    static final String JDBC_DRIVER = "con.mysql.jdbc.Driver";
    static final String DB_URl = "jdbc:mysql://localhost/accounting";
    static final String USER = "root";
    static final String PASS = "abc";
    static String sql;
    static int total;
    static String from;
    static String jurnalDate;
    static int jurnalId;
//    Statement st;
    static int jurnalShow;
    static String date;

    public static Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection(DB_URl, USER, PASS);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Statement getStatement() {
        Statement st;
        try {
            Connection connection = getConnection();
            st = connection.createStatement();
            return st;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static Statement setExecuteUpdate(String sql) {
        DataBase.sql = sql;
        try {
            Connection connection = getConnection();
            Statement st = getStatement();
            st.executeUpdate(sql);
            System.out.println("Success");
            st.close();
            connection.close();
            return st;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static ResultSet getCount(String from) {
        DataBase.from = from;
        try {
//            sql = "SELECT COUNT(*) AS total FROM " + DataBase.from + ";";
//            Connection connection = getConnection();
            Statement st = getStatement();
            ResultSet rs;
            rs = st.executeQuery("SELECT COUNT(*) AS total FROM " + DataBase.from + ";");
            while (rs.next()) {
                DataBase.total = rs.getInt("total");
            }
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static ResultSet setJurnalId() {
        try {
            Connection connection = getConnection();
            Statement st = getStatement();
            ResultSet rs;
            rs = st.executeQuery("SELECT SYSTEM_NUMBER FROM SYSTEM WHERE SYSTEM_DATE LIKE '" + DataBase.date + "-01';");
            System.out.println("SELECT SYSTEM_NUMBER FROM SYSTEM WHERE SYSTEM_DATE LIKE '" + DataBase.date + "-01';");
            while (rs.next()) {
                DataBase.jurnalId = rs.getInt("SYSTEM_NUMBER");
            }
            System.out.println("jurnalid= "+jurnalId);
            rs.close();
            st.close();
            connection.close();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    

//    public static ResultSet getResultSet(){
//        ResultSet st;
//        try{
//            
//            return st;
//        }catch(Exception e){
//            System.out.println(e);
//            return null;
//        }
//    }
}

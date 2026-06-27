import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseManager.getConnection();
            System.out.println("KONEKSI BERHASIL!");
            conn.close();
        } catch (Exception e) {
            System.out.println("KONEKSI GAGAL: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
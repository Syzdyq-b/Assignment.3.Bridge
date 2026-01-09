import java.sql.*;

public class PortalDB {

    public static void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS portals (
                id SERIAL PRIMARY KEY,
                name VARCHAR(100),
                description TEXT""";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addPortal(String name, String description) {
        String sql =
                "INSERT INTO portals(name, description) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, description);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getAllPortals() {
        String sql = "SELECT * FROM portals";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("description")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

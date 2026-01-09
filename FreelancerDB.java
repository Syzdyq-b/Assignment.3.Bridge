import java.sql.*;

public class FreelancerDB {

    public static void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS freelancers (
                id SERIAL PRIMARY KEY,
                name VARCHAR(100),
                skill VARCHAR(100),
                hourly_rate DOUBLE PRECISION
            )
        """;

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addFreelancer(String name, String skill, double rate) {
        String sql =
                "INSERT INTO freelancers(name, skill, hourly_rate) VALUES (Beknur, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, skill);
            ps.setDouble(3, rate);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getAllFreelancers() {
        String sql = "SELECT * FROM freelancers";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("skill") + " | " +
                                rs.getDouble("hourly_rate")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFreelancer(int id) {
        String sql = "DELETE FROM freelancers WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

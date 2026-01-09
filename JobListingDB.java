import java.sql.*;

public class JobListingDB {

    // 1. TABLE CREATE
    public static void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS job_listings (
                id SERIAL PRIMARY KEY,
                title VARCHAR(100),
                description TEXT,
                budget DOUBLE PRECISION
            )
        """;

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);
            System.out.println("Table job_listings created");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 2. INSERT
    public static void addJob(String title, String description, double budget) {
        String sql =
                "INSERT INTO job_listings(title, description, budget) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, title);
            ps.setString(2, description);
            ps.setDouble(3, budget);
            ps.executeUpdate();

            System.out.println("Job added");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 3. READ
    public static void getAllJobs() {
        String sql = "SELECT * FROM job_listings";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("title") + " | " +
                                rs.getString("description") + " | " +
                                rs.getDouble("budget")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 4. UPDATE
    public static void updateJobBudget(int id, double newBudget) {
        String sql =
                "UPDATE job_listings SET budget = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, newBudget);
            ps.setInt(2, id);
            ps.executeUpdate();

            System.out.println("Job updated");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 5. DELETE
    public static void deleteJob(int id) {
        String sql = "DELETE FROM job_listings WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Job deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package PlayWright_11_09_2025;

import java.sql.*;

public class DBUtils {

    public static String getOTP() {
        String otp = null;
        // DB connection parameters
        String url = "jdbc:sqlserver://10.0.0.250:50155;encrypt=false;databaseName=Remittance_Swift";
        String user = "app_user";
        String password = "qstggn@54321";

        String query = "select OTP,* from OTPRequests order by Date desc";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                otp = rs.getString("OTP"); // column name must match your table
                System.out.println("Latest OTP: " + otp);
            } else {
                System.out.println("No OTP records found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return otp;
    }
}
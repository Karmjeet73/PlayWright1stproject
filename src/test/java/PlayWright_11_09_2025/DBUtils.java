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
    public static void fetchLatestRechargeTxn() {
        String url = "jdbc:sqlserver://10.0.0.250:50155;encrypt=false;databaseName=Remittance_Swift";
        String user = "app_user";
        String password = "qstggn@54321";
        String query = "SELECT TOP 1 TransactionID, RechargeMobileNo, SPKey, RechargeAmount, " +
                "Response, ResponseStatus, Account, Optional7, DepositorName, DepositorMobileNo, TypeOfPayment, * " +
                "FROM RechargeTxnDetails ORDER BY DTCreatedDate DESC";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                System.out.println("---- Latest RechargeTxnDetails ----");
                System.out.println("TransactionID: " + rs.getString("TransactionID"));
                System.out.println("RechargeMobileNo: " + rs.getString("RechargeMobileNo"));
                System.out.println("SPKey: " + rs.getString("SPKey"));
                System.out.println("RechargeAmount: " + rs.getString("RechargeAmount"));
                int response = rs.getInt("Response");
                System.out.println("Response:"+  response);
                String responseStatus = rs.getString("ResponseStatus");
                System.out.println("ResponseStatus: " +responseStatus);
                System.out.println("Account: " + rs.getString("Account"));
                System.out.println("Optional7: " + rs.getString("Optional7"));
                System.out.println("DepositorName: " + rs.getString("DepositorName"));
                System.out.println("DepositorMobileNo: " + rs.getString("DepositorMobileNo"));
                System.out.println("TypeOfPayment: " + rs.getString("TypeOfPayment"));
                System.out.println("CreatedDate: " + rs.getTimestamp("DTCreatedDate"));
            } else {
                System.out.println("No records found in RechargeTxnDetails.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
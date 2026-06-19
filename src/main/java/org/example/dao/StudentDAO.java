package org.example.dao;

import org.example.db.DBConnection;
import org.example.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class StudentDAO {

    public void addStudent(Student student) {

        String sql = "INSERT INTO students(name,age,course,email,branch,mobile,total_fee,paid_fee,due_fee,fee_status) VALUES(?,?,?,?,?,?,?,?,?,?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getCourse());
            ps.setString(4, student.getEmail());
            ps.setString(5, student.getBranch());
            ps.setString(6, student.getMobile());
            ps.setDouble(7, student.getTotalFee());
            ps.setDouble(8, student.getPaidFee());
            ps.setDouble(9, student.getDueFee());
            ps.setString(10, student.getFeeStatus());

            ps.executeUpdate();

            System.out.println("Student Added Successfully!");

        } catch (Exception e) {
            System.out.println("Operation failed!");
            e.printStackTrace();
        }
    }
    public void getAllStudents() {

        String sql = "SELECT * FROM students";

        try {

            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                printStudent(rs);
            }

        } catch (Exception e) {
            System.out.println("Operation failed!");
            e.printStackTrace();
        }
    }
    public void updateStudent(int id, String course) {

        String sql = "UPDATE students SET course = ? WHERE id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, course);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Updated Successfully!");
            } else {
                System.out.println("Student Not Found!");
            }

        } catch (Exception e) {
            System.out.println("Operation failed!");
            e.printStackTrace();
        }
    }
    public void deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Deleted Successfully!");
            } else {
                System.out.println("Student Not Found!");
            }

        } catch (Exception e) {
            System.out.println("Operation failed!");
            e.printStackTrace();
        }
    }
    public void searchStudentById(int id) {

        String sql = "SELECT * FROM students WHERE id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                printStudent(rs);

            } else {
                System.out.println("Student Not Found!");
            }

        } catch (Exception e) {
            System.out.println("Operation failed!");
            e.printStackTrace();
        }
    }
    public void searchStudentByName(String name) {

        String sql = "SELECT * FROM students WHERE name = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                printStudent(rs);

            } else {

                System.out.println("Student Not Found!");

            }

        } catch (Exception e) {
            System.out.println("Operation failed!");
            e.printStackTrace();
        }
    }
    public void sortStudentsByName() {

        String query = "SELECT * FROM students ORDER BY name ASC";

        try(
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery()
        ) {

            while(rs.next()) {

                printStudent(rs);
            }

        } catch (Exception e) {
            System.out.println("Operation failed!");
            e.printStackTrace();
        }
    }
    public void sortStudentsByAge() {

        String query = "SELECT * FROM students ORDER BY age ASC";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                printStudent(rs);
            }

        } catch (Exception e) {
            System.out.println("Operation failed!");
            e.printStackTrace();
        }
    }
    public void getTotalStudents() {

        String query = "SELECT COUNT(*) FROM students";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery()
        ) {

            if(rs.next()) {
                System.out.println("Total Students = " + rs.getInt(1));
            }

        } catch (Exception e) {
            System.out.println("Operation failed!");
            e.printStackTrace();
        }
    }
    public void getAverageAge() {

        String query = "SELECT AVG(age) FROM students";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery()
        ) {

            if(rs.next()) {
                System.out.println("Average Age = " + rs.getDouble(1));
            }

        } catch (Exception e) {
            System.out.println("Operation failed!");
            e.printStackTrace();
        }
    }
    public void courseWiseCount() {

        String query = "SELECT course, COUNT(*) FROM students GROUP BY course";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery()
        ) {

            System.out.println("\n===== COURSE REPORT =====");

            while(rs.next()) {
                System.out.println(
                        rs.getString(1) + " : " +
                                rs.getInt(2)
                );
            }

        } catch (Exception e) {
            System.out.println("Operation failed!");
            e.printStackTrace();
        }
    }
    public void oldestStudent() {

        String query = "SELECT * FROM students ORDER BY age DESC LIMIT 1";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery()
        ) {

            if(rs.next()) {
                System.out.println("\n===== OLDEST STUDENT =====");

                printStudent(rs);
            }

        } catch (Exception e) {
            System.out.println("Operation failed!");
            e.printStackTrace();
        }
    }
    public void youngestStudent() {

        String query = "SELECT * FROM students ORDER BY age ASC LIMIT 1";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery()
        ) {

            if(rs.next()) {

                System.out.println("\n===== YOUNGEST STUDENT =====");

                printStudent(rs);
            }

        } catch (Exception e) {
            System.out.println("Operation failed!");
            e.printStackTrace();
        }
    }
    public void studentsByCourse(String course) {

        String query = "SELECT * FROM students WHERE course = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)
        ) {

            ps.setString(1, course);

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while(rs.next()) {

                found = true;

                printStudent(rs);
            }

            if(!found) {
                System.out.println("No students found in this course.");
            }

        } catch (Exception e) {
            System.out.println("Operation failed!");
            e.printStackTrace();
        }
    }
    public void branchWiseStudentCount() {
        String sql = "SELECT branch, COUNT(*) AS total FROM students GROUP BY branch";

        try (
                Connection con = DBConnection.getConnection();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql)
        ) {
            while(rs.next()) {
                System.out.println(
                        rs.getString("branch") +
                                " : " +
                                rs.getInt("total")
                );
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void searchStudentByMobile(String mobile) {
        String sql = "SELECT * FROM students WHERE mobile = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, mobile);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                printStudent(rs);
            } else {
                System.out.println("Student not found!");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void showPendingFeeStudents() {
        String sql = "SELECT * FROM students WHERE fee_status='PENDING'";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                printStudent(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showFeeDetailsById(int id) {
        String sql = "SELECT * FROM students WHERE id=?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Total Fee: " + rs.getDouble("total_fee"));
                System.out.println("Paid Fee: " + rs.getDouble("paid_fee"));
                System.out.println("Due Fee: " + rs.getDouble("due_fee"));
                System.out.println("Status: " + rs.getString("fee_status"));
            } else {
                System.out.println("Student not found!");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void showPaidFeeStudents() {

        String sql =
                "SELECT * FROM students WHERE fee_status='PAID'";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                printStudent(rs);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void updateFeeDetails(int id, double paidFee) {

        try {

            Connection con = DBConnection.getConnection();

            String selectSql =
                    "SELECT total_fee, paid_fee FROM students WHERE id=?";

            PreparedStatement ps1 =
                    con.prepareStatement(selectSql);

            ps1.setInt(1, id);

            ResultSet rs = ps1.executeQuery();

            if(rs.next()) {

                double totalFee = rs.getDouble("total_fee");
                double currentPaid = rs.getDouble("paid_fee");

                double newPaid = currentPaid + paidFee;

                if(newPaid > totalFee) {
                    System.out.println("Payment exceeds Total Fee!");
                    return;
                }

                double dueFee = totalFee - newPaid;

                String feeStatus =
                        dueFee == 0 ? "PAID" : "PENDING";

                String updateSql =
                        "UPDATE students SET paid_fee=?, due_fee=?, fee_status=? WHERE id=?";

                PreparedStatement ps2 =
                        con.prepareStatement(updateSql);

                ps2.setDouble(1, newPaid);
                ps2.setDouble(2, dueFee);
                ps2.setString(3, feeStatus);
                ps2.setInt(4, id);

                int rows = ps2.executeUpdate();

                if(rows > 0)
                    System.out.println("Fee Updated Successfully!");
                else
                    System.out.println("Student Not Found!");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void feeSummaryReport() {
        try {
            Connection con = DBConnection.getConnection();

            String sql = """
                SELECT
                COUNT(*) AS totalStudents,
                SUM(CASE WHEN fee_status='PAID' THEN 1 ELSE 0 END) AS paidStudents,
                SUM(CASE WHEN fee_status='PENDING' THEN 1 ELSE 0 END) AS pendingStudents,
                SUM(paid_fee) AS totalCollected,
                SUM(due_fee) AS totalDue
                FROM students
                """;

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()) {
                System.out.println("\n===== FEE SUMMARY REPORT =====");
                System.out.println("Total Students : " + rs.getInt("totalStudents"));
                System.out.println("Paid Students : " + rs.getInt("paidStudents"));
                System.out.println("Pending Students : " + rs.getInt("pendingStudents"));
                System.out.println("Total Fees Collected : " + rs.getDouble("totalCollected"));
                System.out.println("Total Fees Due : " + rs.getDouble("totalDue"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void printStudent(ResultSet rs) throws SQLException {
        System.out.println(
                rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getInt("age") + " | " +
                        rs.getString("course") + " | " +
                        rs.getString("email") + " | " +
                         rs.getString("branch")
                        + " | " + rs.getString("mobile")
                        + " | " + rs.getDouble("total_fee")
                        + " | " + rs.getDouble("paid_fee")
                        + " | " + rs.getDouble("due_fee")
                        + " | " + rs.getString("fee_status")
        );
    }

    }

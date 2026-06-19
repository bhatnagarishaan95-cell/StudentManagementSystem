package org.example.service;


import org.example.dao.StudentDAO;
import org.example.model.Student;
public class StudentService {

    private StudentDAO dao = new StudentDAO();
    public void showTotalStudents(){
        dao.getTotalStudents();
    }

    public void showAverageAge() {
        dao.getAverageAge();
    }

    public void showCourseWiseCount() {
        dao.courseWiseCount();
    }

    public void showOldestStudent() {
        dao.oldestStudent();
    }

    public void showYoungestStudent() {
        dao.youngestStudent();
    }

    public void showStudentsByCourse(String course) {
        dao.studentsByCourse(course);
    }
    public void addStudent(Student student) {
        dao.addStudent(student);
    }

    public void viewStudents() {
        dao.getAllStudents();
    }

    public void updateStudent(int id , String course) {
        dao.updateStudent(id, course);
    }

    public void deleteStudent(int id) {
        dao.deleteStudent(id);
    }

    public void searchStudentById(int id) {
        dao.searchStudentById(id);
    }

    public void searchStudentByName(String name) {
        dao.searchStudentByName(name);
    }

    public void sortStudentsByName() {
        dao.sortStudentsByName();
    }

    public void sortStudentsByAge() {
        dao.sortStudentsByAge();
    }
    public void branchWiseStudentCount() {
        dao.branchWiseStudentCount();
    }
    public void searchStudentByMobile(String mobile) {
        dao.searchStudentByMobile(mobile);
    }
    public void showPendingFeeStudents() {
        dao.showPendingFeeStudents();
    }
    public void showFeeDetailsById(int id) {
        dao.showFeeDetailsById(id);
    }
    public void showPaidFeeStudents() {
        dao.showPaidFeeStudents();
    }
    public void updateFeeDetails(int id,

                                 double paidFee) {

        dao.updateFeeDetails(id,paidFee);
    }
    public void feeSummaryReport() {
        dao.feeSummaryReport();
    }
}

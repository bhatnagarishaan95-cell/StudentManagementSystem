package org.example;
import org.example.model.Student;
import java.util.Scanner;
import org.example.service.StudentService;

public class Main{
    private static double getTotalFee(String course, String branch) {

        if(course.equalsIgnoreCase("BTECH")) {

            if(branch.equalsIgnoreCase("CSE")) return 120000;
            if(branch.equalsIgnoreCase("AIML")) return 130000;
            if(branch.equalsIgnoreCase("DS")) return 125000;
            if(branch.equalsIgnoreCase("IT")) return 115000;
        }

        if(course.equalsIgnoreCase("BCA"))
            return 70000;

        if(course.equalsIgnoreCase("MCA"))
            return 90000;

        if(course.equalsIgnoreCase("MBA"))
            return 150000;

        return 50000;
    }
    private static void showMainMenu() {
        System.out.println("===== STUDENT MANAGEMENT SYSTEM =====");
        System.out.println("1. Student Operations");
        System.out.println("2. Search & Filter");
        System.out.println("3. Reports & Analytics");
        System.out.println("4. Fee Management");
        System.out.println("5. Exit");
    }

    private static void showStudentMenu() {
        System.out.println("===== STUDENT OPERATIONS =====");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Back");
    }
    private static void showSearchMenu() {
        System.out.println("===== SEARCH & FILTER =====");
        System.out.println("1. Search By ID");
        System.out.println("2. Search By Name");
        System.out.println("3. Search By Mobile");
        System.out.println("4. Search By Course");
        System.out.println("5. Sort By Name");
        System.out.println("6. Sort By Age");
        System.out.println("7. Back");
    }

    private static void showReportMenu() {

            System.out.println("===== REPORTS & ANALYTICS =====");
            System.out.println("1. Total Students Count");
            System.out.println("2. Average Age");
            System.out.println("3. Course Wise Student Count");
            System.out.println("4. Branch Wise Student Count");
            System.out.println("5. Oldest Student");
            System.out.println("6. Youngest Student");
            System.out.println("7. Back");

    }

    private static void showFeeMenu() {

            System.out.println("===== FEE MANAGEMENT =====");
            System.out.println("1. Show Pending Fee Students");
            System.out.println("2. Show Paid Fee Students");
            System.out.println("3. Show Fee Details By Student ID");
            System.out.println("4. Update Fee Details");
            System.out.println("5. Fee Summary Report");
            System.out.println("6. Back");

    }
    public static void main(String[] args) {


        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);
        while (true) {
            showMainMenu();
            System.out.println("Enter Choice: ");
            int choice = sc.nextInt();

            sc.nextLine();
            if(choice == 1){

                showStudentMenu();

                int studentChoice = sc.nextInt();
                sc.nextLine();

                if(studentChoice == 1){
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    if (name.trim().isEmpty()) {
                        System.out.println("Name cannot be empty!");
                        continue;
                    }
                    if (name.length() < 2) {
                        System.out.println("Name too short!");
                        continue;
                    }
                    if (!name.matches("[a-zA-Z ]+")) {
                        System.out.println("Name should contain only letters!");
                        continue;
                    }

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    if (age < 18 || age > 50) {
                        System.out.println("Age must be between  18 and 50. ");
                        continue;
                    }

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();


                    course = course.replace(".", "");
                    course = course.replace(" ", "");
                    course = course.replace("-", "");
                    if (course.trim().isEmpty()) {
                        System.out.println("Course cannot be empty!");
                        continue;
                    }
                    String[] validCourses = {
                            "BCA", "MCA", "BTech", "MTech",
                            "BSc", "MSc", "BCom", "MCom",
                            "BBA", "MBA", "BA", "MA",
                            "BPharma", "MPharma",
                            "LLB", "LLM",
                            "MBBS", "BDS",
                            "BArch", "MArch",
                            "BEd", "MEd"
                    };

                    boolean valid = false;

                    for (String c : validCourses) {
                        if (c.equalsIgnoreCase(course)) {
                            valid = true;
                            break;
                        }
                    }

                    if (!valid) {
                        System.out.println("Invalid Course!");
                        continue;
                    }

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    if (!email.contains("@") || !email.contains(".")) {
                        System.out.println("Invalid Email!");
                        continue;
                    }
                    if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                        System.out.println("Invalid Email!");
                        continue;
                    }
                    System.out.print("Enter Branch: ");
                    String branch = sc.nextLine();
                    if (branch.trim().isEmpty()) {
                        System.out.println("Branch cannot be empty!");
                        continue;
                    }
                    String[] validBranches = {
                            "CSE", "IT", "ECE", "EEE", "ME", "CE",
                            "AI", "AIML", "DS", "CSBS",
                            "COMPUTER APPLICATIONS",
                            "AGRICULTURE",
                            "FINANCE", "MARKETING", "HR",
                            "COMMERCE"
                    };

                    boolean branchValid = false;

                    for (String b : validBranches) {
                        if (b.equalsIgnoreCase(branch)) {
                            branchValid = true;
                            break;
                        }
                    }

                    if (!branchValid) {
                        System.out.println("Invalid Branch!");
                        continue;
                    }
                    System.out.print("Enter Mobile: ");
                    String mobile = sc.nextLine();
                    if (!mobile.matches("[6-9]\\d{9}")) {
                        System.out.println("Invalid Mobile Number!");
                        continue;
                    }
                    double totalFee = getTotalFee(course, branch);
                    double paidFee = 0;
                    double dueFee  =totalFee - paidFee;
                    String feeStatus = "PENDING";

                    Student student = new Student(0, name, age, course, email, branch, mobile,totalFee, paidFee,dueFee, "PENDING");

                    service.addStudent(student);


                }
                else if(studentChoice == 2){
                    service.viewStudents();
                }
                else if(studentChoice == 3){
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Course: ");
                    String course = sc.nextLine();
                    course = course.replace(".", "");
                    course = course.replace(" ", "");
                    course = course.replace("-", "");
                    if (course.trim().isEmpty()) {
                        System.out.println("Course cannot be empty!");
                        continue;
                    }
                    String[] validCourses = {
                            "BCA", "MCA", "BTech", "MTech",
                            "BSc", "MSc", "BCom", "MCom",
                            "BBA", "MBA", "BA", "MA",
                            "BPharma", "MPharma",
                            "LLB", "LLM",
                            "MBBS", "BDS",
                            "BArch", "MArch",
                            "BEd", "MEd"
                    };

                    boolean valid = false;

                    for (String c : validCourses) {
                        if (c.equalsIgnoreCase(course)) {
                            valid = true;
                            break;
                        }
                    }

                    if (!valid) {
                        System.out.println("Invalid Course!");
                        continue;
                    }
                    service.updateStudent(id, course);
                }
                else if(studentChoice == 4){
                    System.out.println("Enter Student ID: ");
                    int id = sc.nextInt();
                    service.deleteStudent(id);
                }
                else if(studentChoice  == 5){
                    continue;
                }
                else{
                    System.out.println("Invalid Choice!");
                }
            }
            else if(choice == 2){
                showSearchMenu();
                int searchChoice = sc.nextInt();
                sc.nextLine();
                if(searchChoice == 1){
                    System.out.println("Enter Student ID: ");
                    int id = sc.nextInt();
                    if(id <= 0){
                        System.out.println("Invalid ID");
                        continue;
                    }
                    service.searchStudentById(id);
                }
                else if(searchChoice == 2){
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    if(name.trim().isEmpty()){
                        System.out.println("Name cannot be empty!");
                    }
                    else if(!name.matches("[a-zA-Z ]+")){
                        System.out.println("Name should contain only letters!");
                    }
                    else{
                        service.searchStudentByName(name);
                    }
                }
                else if(searchChoice == 3){
                    System.out.print("Enter Mobile: ");
                    String mobile = sc.nextLine();
                    if(!mobile.matches("[6-9]\\d{9}")){
                        System.out.println("Invalid Mobile Number!");
                        continue;
                    }
                    service.searchStudentByMobile(mobile);
                }
                else if(searchChoice == 4){
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    course = course.trim();
                    course = course.replace(".", "");
                    course = course.replace(" ", "");
                    course = course.replace("-", "");
                    if(course.trim().isEmpty()){
                        System.out.println("Course cannot be empty!");
                        continue;
                    }
                    String[] validCourses = {
                            "BCA","MCA","BTECH","MTECH",
                            "BSC","MSC","BCOM","MCOM",
                            "BBA","MBA","BA","MA",
                            "BPHARMA","MPHARMA",
                            "LLB","LLM",
                            "MBBS","BDS",
                            "BARCH","MARCH",
                            "BED","MED"
                    };
                    boolean valid = false;

                    for(String c : validCourses){
                        if(c.equalsIgnoreCase(course)){
                            valid = true;
                            break;
                        }
                    }
                    service.showStudentsByCourse(course);
                }
                else if(searchChoice == 5){
                    service.sortStudentsByName();
                }
                else if(searchChoice == 6){
                    service.sortStudentsByAge();
                }
                else if(searchChoice == 7){
                    continue;
                }
                else{
                    System.out.println("Invalid Choice!");
                }
            }
            else if(choice == 3){
                showReportMenu();
                int reportChoice = sc.nextInt();
                sc.nextLine();

                if(reportChoice == 1){
                    service.showTotalStudents();
                }
                else if(reportChoice == 2){
                    service.showAverageAge();
                }
                else if(reportChoice == 3){
                    service.showCourseWiseCount();
                }
                else if(reportChoice == 4){
                    service.branchWiseStudentCount();
                }
                else if(reportChoice == 5){
                    service.showOldestStudent();
                }
                else if(reportChoice == 6){
                    service.showYoungestStudent();
                }
                else if(reportChoice == 7){
                    continue;
                }
                else{
                    System.out.println("Invalid Choice!");
                }
            }
            else if(choice == 4){

                showFeeMenu();

                int feeChoice = sc.nextInt();
                sc.nextLine();

                if(feeChoice == 1){
                    service.showPendingFeeStudents();
                }
                else if(feeChoice == 2){
                    service.showPaidFeeStudents();
                }
                else if(feeChoice == 3){
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    service.showFeeDetailsById(id);
                }
                else if(feeChoice == 4){
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Paid Amount: ");
                    double amount = sc.nextDouble();
                    if(amount <= 0){
                        System.out.println("Amount must be greater than 0!");
                        continue;
                    }

                    service.updateFeeDetails(id, amount);
                }
                else if(feeChoice == 5){
                    service.feeSummaryReport();
                }
                else if(feeChoice == 6){
                    continue;
                }
                else{
                    System.out.println("Invalid Choice!");
                }
            }
             else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            }
            else{
                System.out.println("Invalid Choice!");
            }
        }
    }
}

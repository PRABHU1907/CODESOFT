package TasksCodeSoft2; //STUDENT COURSE REGISTRATION SYSTEM

import java.util.ArrayList;
import java.util.Scanner;

public class Task3 {

    static class Course {
        String courseCode;
        String title;
        String description;
        int capacity;
        int enrolled;

        public Course(String courseCode, String title, String description, int capacity) {
            this.courseCode = courseCode;
            this.title = title;
            this.description = description;
            this.capacity = capacity;
            this.enrolled = 0;
        }

        public boolean isAvailable() {
            return enrolled < capacity;
        }

        public void enroll() {
            if (isAvailable()) {
                enrolled++;
                System.out.println("Successfully enrolled in " + title);
            } else {
                System.out.println("Sorry, the course is full.");
            }
        }

        public void drop() {
            if (enrolled > 0) {
                enrolled--;
                System.out.println("Successfully dropped from " + title);
            } else {
                System.out.println("You are not enrolled in this course.");
            }
        }

        @Override
        public String toString() {
            return "Course Code: " + courseCode + ", Title: " + title + ", Capacity: " + capacity + ", Enrolled: " + enrolled;
        }
    }

    static class Student {
        String studentId;
        String name;
        ArrayList<Course> registeredCourses;

        public Student(String studentId, String name) {
            this.studentId = studentId;
            this.name = name;
            this.registeredCourses = new ArrayList<>();
        }

        public void registerCourse(Course course) {
            if (course.isAvailable()) {
                course.enroll();
                registeredCourses.add(course);
            } else {
                System.out.println("Course is full, cannot register.");
            }
        }

        public void dropCourse(Course course) {
            if (registeredCourses.contains(course)) {
                course.drop();
                registeredCourses.remove(course);
            } else {
                System.out.println("You are not registered for this course.");
            }
        }

        public void viewRegisteredCourses() {
            System.out.println("Registered Courses for " + name + ":");
            for (Course course : registeredCourses) {
                System.out.println(course);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get student details
        System.out.print("Enter your name: ");
        String studentName = scanner.nextLine();  // Read the student's name
        Student student = new Student("S001", studentName);  // Create a student with the input name

        // Create some courses
        Course course1 = new Course("CS101", "Intro to Computer Science", "Learn the basics of computer science.", 3);
        Course course2 = new Course("MATH101", "Calculus I", "Introduction to Calculus.", 2);
        Course course3 = new Course("PHY101", "Physics I", "Fundamentals of Physics.", 2);

        // Menu
        while (true) {
            System.out.println("\n1. View Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. View Registered Courses");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Display available courses
                System.out.println("\nAvailable Courses:");
                System.out.println(course1);
                System.out.println(course2);
                System.out.println(course3);

            } else if (choice == 2) {
                // Register for a course
                System.out.print("Enter course code to register (e.g., CS101): ");
                String code = scanner.next();
                if (code.equals(course1.courseCode)) {
                    student.registerCourse(course1);
                } else if (code.equals(course2.courseCode)) {
                    student.registerCourse(course2);
                } else if (code.equals(course3.courseCode)) {
                    student.registerCourse(course3);
                } else {
                    System.out.println("Invalid course code.");
                }

            } else if (choice == 3) {
                // Drop a course
                System.out.print("Enter course code to drop (e.g., CS101): ");
                String code = scanner.next();
                if (code.equals(course1.courseCode)) {
                    student.dropCourse(course1);
                } else if (code.equals(course2.courseCode)) {
                    student.dropCourse(course2);
                } else if (code.equals(course3.courseCode)) {
                    student.dropCourse(course3);
                } else {
                    System.out.println("Invalid course code.");
                }

            } else if (choice == 4) {
                // View registered courses
                student.viewRegisteredCourses();

            } else if (choice == 5) {
                // Exit
                System.out.println("Exiting the system.");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}

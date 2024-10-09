import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

class Course {
    private String code;
    private String name;
    private String category;

    public Course(String code, String name, String category) {
        this.code = code;
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
}

class Student {
    private String id;
    private double cgpa;
    private String program;

    public Student(String id, double cgpa, String program) {
        this.id = id;
        this.cgpa = cgpa;
        this.program = program;
    }

    public String getId() {
        return id;
    }

    public double getCgpa() {
        return cgpa;
    }

    public String getProgram() {
        return program;
    }
}

class AdvisingSystem {
    private List<Course> courses;

    public AdvisingSystem(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> recommendCourses(Student student) {

        return new ArrayList<>(courses);
    }
}

class SimpleAdvisingSystem {

    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("CSE101", "Java Programming", "Core"));
        courses.add(new Course("CSE102", "Data Structures", "Core"));
        courses.add(new Course("CSE201", "Algorithms", "Core"));
        courses.add(new Course("CSE301", "AI Basics", "Elective"));

        AdvisingSystem advisingSystem = new AdvisingSystem(courses);

        String program = JOptionPane.showInputDialog(null, "Please enter your academic program (e.g., Software Engineering):", "Academic Program", JOptionPane.QUESTION_MESSAGE);
        if (program == null || program.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Program cannot be empty. Exiting.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String id = JOptionPane.showInputDialog(null, "Please enter your student ID:", "Student ID", JOptionPane.QUESTION_MESSAGE);
        String cgpaString = JOptionPane.showInputDialog(null, "Please enter your CGPA:", "CGPA", JOptionPane.QUESTION_MESSAGE);

        double cgpa;
        try {
            cgpa = Double.parseDouble(cgpaString);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid CGPA format. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Student student = new Student(id, cgpa, program);

        List<Course> recommendedCourses = advisingSystem.recommendCourses(student);

        StringBuilder message = new StringBuilder("Recommended Courses for " + program + ":\n");
        for (Course course : recommendedCourses) {
            message.append(course.getName()).append(" (").append(course.getCategory()).append(")\n");
        }
        JOptionPane.showMessageDialog(null, message.toString(), "Course Recommendations", JOptionPane.INFORMATION_MESSAGE);
    }
}

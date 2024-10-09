public class Program {
    private String name;
    private Course[] courses;

    // Constructor
    public Program(String name, Course[] courses) {
        this.name = name;
        this.courses = courses;
    }

    // Getters
    public String getName() { return name; }
    public Course[] getCourses() { return courses; }
}

public class ProjectTest {
    public static void main(String[] args) {
        Project project1 = new Project();
        Project project2 = new Project("Second Project");
        Project project3 = new Project("Third Project", "This is the third project", 10);
        System.out.println(project1);
        System.out.println(project2);
        System.out.println(project3);
        System.out.println(project3.elevatorPitch());
    }
}

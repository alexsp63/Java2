
import models.*;
import services.*;

public class Main {
    public static void main(String[] args) {
        AnswerService answerService = new AnswerService();
        GroupService groupService = new GroupService();
        QuestionService questionService = new QuestionService();
        RoleService roleService = new RoleService();
        Student_answer studentAnswer = new Student_answer();
        Test_listService testListService = new Test_listService();
        TestService testService = new TestService();
        UserService userService = new UserService();


        /*Role student = new Role("Student");
        User user = new User("Софья", "Попова", "Александровна", "alexsp", "123");
        user.setRole(student);
        userService.saveUser(user);

        Test_list test = new Test_list("IT");
        testListService.saveTest_list(test);

        Group group = new Group("ПИ19-4", 2019, "3");
        groupService.saveGroup(group);

         */

        System.out.println("Преподаватели: " + userService.getTeachers());

        System.out.println("Студенты: " + userService.getStudents());

        System.out.println(testListService.findTest_list(2));

        System.out.println(testService.findAll());

    }
}

package peaksoft;

import peaksoft.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
//        userService.createUsersTable();  //create table
//        userService.dropUsersTable();   // drop table
        userService.saveUser("Aqua","Man",(byte)18);
        userService.saveUser("Super","Man",(byte)19);
        userService.saveUser("Spider","Man",(byte)20);
        userService.saveUser("Hollow","Man",(byte)21);
        System.out.println(userService.getAllUsers());
        userService.removeUserById((long)1);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        System.out.println(userService.getAllUsers());



    }
}

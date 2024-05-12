package org.example.projectjavafx;

import java.util.ArrayList;

public class WholeUsers {
    private static ArrayList<User> users;

    public WholeUsers() {
        users = new ArrayList<User>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}

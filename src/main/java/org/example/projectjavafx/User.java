package org.example.projectjavafx;

import java.util.ArrayList;

public class User {
    private int userId;
    private String userName;
    private ArrayList<Question> userQuestions;
    private ArrayList<Question> savedQuestions;
    private String userPassword;
    private String userProfile;
    private int userCoin;
    private String userEmail;
    private ArrayList<User> friends;
    private int userRank;


    public User(String user_name,int id, String password,String email)
    {
        this.userName= user_name;
        this.userId = id;
        this.userPassword= password;
        this.userEmail=email;
        
    }

    public void changeProfilePicture(String picturePath){


    }

    public void addFriend(User user){

        friends.add(user);
    }

    public void removeFriend(User user){

        friends.remove(user);
    }

    public void saveQuestion(Question question){

        savedQuestions.add(question);
    }

    public ArrayList<User> getFriends() {
    return friends;
    }
}

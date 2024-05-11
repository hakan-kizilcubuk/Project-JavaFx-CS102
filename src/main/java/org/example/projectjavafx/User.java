package org.example.projectjavafx;

import java.util.ArrayList;

public class User {
    private String userId;
    private String userName;
    private ArrayList<Question> userQuestions;
    private ArrayList<Question> savedQuestions;
    private String userPassword;
    private String userProfile;
    private int userCoin;
    private String userEmail;
    private ArrayList<User> friends;
    private int userRank;


    public User(String user_name,String id, String password,String email, int userCoin)
    {
        this.userPassword= password;
        this.userId = id;
        this.userName= user_name;
        this.userEmail=email;
        this.userCoin=userCoin;
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

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setUserPassword(String userPassword){
        this.userPassword = userPassword;
    }

    public void setUserId(String id){
        this.userId = id;
    }

    public void setUserEmail(String email)
    {
        this.userEmail = email;
    }

    public int getUserCoin(){
        return this.userCoin;
    }

    public void setUserCoin(int userCoin){
        this.userCoin = userCoin;
    }
}

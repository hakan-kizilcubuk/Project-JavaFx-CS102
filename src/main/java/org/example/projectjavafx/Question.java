package org.example.projectjavafx;

import java.util.ArrayList;
import java.util.List;

public class Question
{
    protected String questionId;
    protected String content;
    protected User creator;
    protected String mediaUrl;
    protected Branch branch;
    protected int difficultyLevel;
    private List<String> options;
    private String correctAnswer;
    private boolean jokerCallAFriend;
    private boolean jokerFiftyFifty;
    private int time;
    private int ratioOfCorrectAnswer;
    private int answerCount;

    public Question()
    {
        options = new ArrayList<>();
        //correctAnswer = "";
        jokerCallAFriend = true;
        jokerFiftyFifty = true;
        time = 20;
        ratioOfCorrectAnswer = 0;
        answerCount = 0;
    }

    public void updateContent(String content)
    {
        this.content = content;
    }

    public void attachMedia(String mediaLink)
    {
        this.mediaUrl = mediaLink;
    }

    public void difficultyMethod(int ratioOfCorrectAnswer)
    {
        
    }

    public void calculateTimeLimit(int difficultyLevel)
    {
        time = difficultyLevel * time;
    }

    public void answerQuestion(String userAnswer)
    {

    }
    public void isCorrect(String userAnswer)
    {
        if(userAnswer.equals(correctAnswer))
        {
            answerCount++;
        }
    }
    public void useJokerCallAFriend()
    {
        jokerCallAFriend = false;
    }
    public void usejokerFiftyFifty()
    {
        jokerFiftyFifty = false;
    }


}

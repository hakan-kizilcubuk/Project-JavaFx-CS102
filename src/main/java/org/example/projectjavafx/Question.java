package org.example.projectjavafx;

import java.util.ArrayList;
import java.util.List;

public class Question
{
    protected String questionId;
    protected String content;
    protected String creatorOfQuestion;
    protected String mediaUrl;
    protected String branch;
    protected int difficultyLevel;
    private List<String> options;
    private String correctAnswer;
    private boolean jokerCallAFriend;
    private boolean jokerFiftyFifty;
    private int time;
    private int ratioOfCorrectAnswer;
    private int answerCount;
    protected String wrongAnswerNo1;
    protected String wrongAnswerNo2;
    protected String wrongAnswerNo3;
    protected String correctAnswerNo1;

    public Question(String username, String wronganswer1, String wronganswer2, String wronganswer3, String correctAnswer, String branch, String question)
    {
        this.questionId = username;
        this.wrongAnswerNo1 = wronganswer1;
        this.wrongAnswerNo2 = wronganswer2;
        this.wrongAnswerNo3 = wronganswer3;
        this.correctAnswer = correctAnswer;
        this.branch = branch;
        this.content = question;
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

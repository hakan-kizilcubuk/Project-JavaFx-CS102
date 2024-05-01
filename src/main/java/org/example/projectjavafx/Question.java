package org.example.projectjavafx;

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


    public void updateContent(String content)
    {
        this.content = content;
    }
    public void attachMedia(String mediaLink)
    public void difficultyMethod( int ratioOfCorrectAnswer)
    public void calculateTimeLimit(int difficultyLevel)
    public void answerQuestion(String userAnswer)
    public void isCorrect(String userAnswer)
    public void useJokerCallAFriend()
    public void usejokerFiftyFifty()


}

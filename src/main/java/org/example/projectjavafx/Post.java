package org.example.projectjavafx;

public class Post {
    private int answers;
    private String branch;
    private String username;
    private int challenging;
    private String mediaSrc;
    private String profilePicSrc;
    private String question;

    public String getMediaSrc()
    {
        return mediaSrc;
    }

    public void setMediaSrc( String src)
    {
        this.mediaSrc = src;
    }

    public String getProfilePicSrc()
    {
        return profilePicSrc;
    }

    public void setProfilePicSrc( String src)
    {
        this.profilePicSrc = src;
    }

    public int getAnswers()
    {
        return answers;
    }

    public void setAnswers( int answers)
    {
        this.answers = answers;
    }

    public String getBranch()
    {
        return branch;
    }

    public void setBranch( String branch)
    {
        this.branch = branch;
    }

    public int getChallenging()
    {
        return challenging;
    }

    public void setChallenging( int challenging)
    {
        this.challenging = challenging;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername( String username)
    {
        this.username = username;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion( String question)
    {
        this.question = question;
    }
}

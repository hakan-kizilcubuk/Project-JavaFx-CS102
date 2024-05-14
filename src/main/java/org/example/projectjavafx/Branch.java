package org.example.projectjavafx;

import java.util.ArrayList;

public class Branch {
    private int branchId;
    private String branchName;
    private ArrayList<Question> questions;

    public String printBranch() {
        return this.branchName;
    }
}

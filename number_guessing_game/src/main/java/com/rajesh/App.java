package com.rajesh;

import com.rajesh.helpers.GameHelper;
import com.rajesh.helpers.InputHelper;

public class App {
    public static void main(String[] args) {
        InputHelper.initializeUserInputReader();
        GameHelper.startGame();
    }
}

package com.revature.hangman.models;

public class Player {
    private int life;

    public Player() {
    }

    public Player(int life) {
        this.life = life;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public String toString() {
        return "Player [life=" + life + "]";
    }
}

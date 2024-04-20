package Classes;

import java.util.Scanner;

public class Swimming {
    // For Day of the lessons
    String[] lessonDate = { "", "Monday", "Monday", "Monday", "Wednesday", "Wednesday", "Wednesday", "Friday", "Friday",
            "Friday", "Saturday", "Saturday", "Monday", "Monday", "Monday", "Wednesday", "Wednesday", "Wednesday",
            "Friday", "Friday", "Friday", "Saturday", "Saturday", "Monday", "Monday", "Monday", "Wednesday",
            "Wednesday", "Wednesday", "Friday", "Friday", "Friday", "Saturday", "Saturday", "Monday", "Monday",
            "Monday", "Wednesday", "Wednesday", "Wednesday", "Friday", "Friday", "Friday", "Saturday", "Saturday" };

    // For time for the lessons
    String[] lessonTime = { "", "4pm", "5pm", "6pm", "4pm", "5pm", "6pm", "4pm", "5pm", "6pm", "2pm", "3pm", "4pm",
            "5pm", "6pm", "4pm", "5pm", "6pm", "4pm", "5pm", "6pm", "2pm", "3pm", "4pm", "5pm", "6pm", "4pm", "5pm",
            "6pm", "4pm", "5pm", "6pm", "2pm", "3pm", "4pm", "5pm", "6pm", "4pm", "5pm", "6pm", "4pm", "5pm", "6pm",
            "2pm", "3pm" };
    // For storing coach name of the lessons
    String[] lessonCoach = { " ", "Sakib", "Tamim", "Riyad", "Sakib", "Tamim", "Riyad", "Sakib", "Tamim", "Riyad",
            "Sakib", "Tamim", "Sakib", "Tamim", "Riyad", "Sakib", "Tamim", "Riyad", "Sakib", "Tamim", "Riyad", "Sakib",
            "Tamim", "Sakib", "Tamim", "Riyad", "Sakib", "Tamim", "Riyad", "Sakib", "Tamim", "Riyad", "Sakib", "Tamim",
            "Sakib", "Tamim", "Riyad", "Sakib", "Tamim", "Riyad", "Sakib", "Tamim", "Riyad", "Sakib", "Tamim" };
    // For associating coach index with their name
    int[] lessonCoachIndex = { 0, 2, 1, 3, 2, 1, 3, 2, 1, 3, 2, 1, 2, 1, 3, 2, 1, 3, 2, 1, 3, 2, 1, 2, 1, 3, 2, 1, 3, 2,
            1, 3, 2, 1, 2, 1, 3, 2, 1, 3, 2, 1, 3, 2, 1 };
    // This expresses the week no for lessons.
    int[] weekNo = { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 };
    int[] forGrade = { 0, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1,
            1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1,
            1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1,
            1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1 };

    private Learner[] learners;
    private Coach[] coaches;
    private int totalLearner;
    private int totalCoach;
    private int[] learnerTaken;

    // Constructor
    public Swimming() {
        this.learners = new Learner[70];
        this.coaches = new Coach[7];
        this.learnerTaken = new int[50];
        this.totalLearner = 0;
        // 3 coaches are preRegistered.
        this.totalCoach = 3;
        // Pre-register learners and coaches
        // this.init();
    }

    // Get and set functions for accessing private elements
    public Learner[] getLearners() {
        return this.learners;
    }

    public Coach[] getCoaches() {
        return this.coaches;
    }

    public int getTotalLearner() {
        return this.totalLearner;
    }

    public int getTotalCoach() {
        return this.totalCoach;
    }

    public int[] getLearnerTaken() {
        return this.learnerTaken;
    }

    public void setTotalLearner(int totalLearner) {
        this.totalLearner = totalLearner;
    }

    public void setLearnerTaken(int ind, int val) {
        learnerTaken[ind] = val;
    }

    public void setTotalCoach(int totalCoach) {
        this.totalCoach = totalCoach;
    }

    public void setLearners(int ind, Learner l) {
        this.learners[ind] = l;
    }

    public static void main(String args[]) {

    }
}

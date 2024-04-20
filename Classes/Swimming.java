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

    // function for booking lessons
    void bookLesson() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter your name: ");
        String name = input.next();
        System.out.println("Please Enter your phone numbers: ");
        String phone = input.next();
        int ind = -1;
        for (int i = 1; i <= totalLearner; i++) {
            if (learners[i].getName().equals(name) && learners[i].getPhone().equals(phone)) {
                ind = i;
                break;
            }
        }
        if (ind == -1) {
            System.out.println("Invalid learner");
            return;
        }
        int grade = learners[ind].getGrade();
        int[] canTake = new int[50];
        int cnt = 0;
        for (int i = 1; i <= 44; i++) {
            // System.out.println(forgrade[i]+" "+grade);
            if (forGrade[i] != grade && forGrade[i] != grade + 1)
                continue;

            if (forGrade[learners[ind].getLesson1()] == forGrade[i]
                    || forGrade[learners[ind].getLesson2()] == forGrade[i])
                continue;
            if (learnerTaken[i] < 4) {
                cnt++;
                // System.out.println("I: "+i);
                canTake[cnt] = i;
            }
        }
        System.out.println("View the timetable and select a lesson ");
        System.out.println("Press 1 to view by specifying the day ");
        System.out.println("Press 2 to view by specifying the grade level ");
        System.out.println("Press 3 to view by specifying the coach's name ");
        int opt = input.nextInt();
        if (opt == 1) {
            System.out.println("The available day for you: ");
            for (int i = 1; i <= cnt; i++) {
                int x = canTake[i];
                System.out.println("For week " + weekNo[x] + " " + lessonDate[x] + " at " + lessonTime[x]
                        + " for lesson no: " + x);
            }
        } else if (opt == 2) {
            System.out.println("The available grade for you: ");
            for (int i = 1; i <= cnt; i++) {
                int x = canTake[i];
                System.out.println("For grade " + forGrade[x] + " , lesson no: " + x);
            }
        } else if (opt == 3) {
            System.out.println("The available coaches for you: ");
            for (int i = 1; i <= cnt; i++) {
                int x = canTake[i];
                System.out.println("For Coach name : " + lessonCoach[x] + " , lesson no: " + x);
            }
        } else {
            System.out.println("Invalid number pressed!!!");
            return;
        }
        if (cnt < 1) {
            System.out.println("Sorry... no lessons available for booking");
            return;
        }
        System.out.println("Choose an available lesson number that mentioned above..");
        int interestedLesson = input.nextInt();
        Boolean f = false;
        for (int i = 1; i <= cnt; i++)
            if (interestedLesson == canTake[i])
                f = true;
        if (f == false) {
            System.out.println("Invalid option chosen");
            return;
        }

        if (learners[ind].getLesson1() < 1) {
            learners[ind].setLesson1(interestedLesson);
        } else
            learners[ind].setLesson2(interestedLesson);
        learnerTaken[interestedLesson]++;
        System.out.println("Lesson " + interestedLesson + " is successfully booked by " + name);
    }

    // Function for changing booking
    void changeBooking() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter your name: ");
        String name = input.next();
        System.out.println("Please Enter your phone number: ");
        String phone = input.next();
        int ind = -1;
        for (int i = 1; i <= totalLearner; i++) {
            if (learners[i].getName().equals(name) && learners[i].getPhone().equals(phone)) {
                ind = i;
                break;
            }
        }
        if (ind == -1) {
            System.out.println("Invalid learner");
            return;
        }
        System.out.println("What lesson do you want to change or cancel?");
        int opt = input.nextInt();
        if (opt < 1 || opt > 44) {
            System.out.println("Invalid lesson");
            return;
        }
        if (opt == learners[ind].getLesson1() && learners[ind].getAttended1() == false) {
            learnerTaken[learners[ind].getLesson1()]--;
            learners[ind].setCancelCount(learners[ind].getCancelCount() + 1);
            learners[ind].getCancel()[learners[ind].getCancelCount()] = learners[ind].getLesson1();
            learners[ind].setLesson1(0);
        } else if (opt == learners[ind].getLesson2() && learners[ind].getAttended2() == false) {
            learnerTaken[learners[ind].getLesson2()]--;
            learners[ind].setCancelCount(learners[ind].getCancelCount() + 1);
            learners[ind].getCancel()[learners[ind].getCancelCount()] = learners[ind].getLesson2();
            learners[ind].setLesson2(0);
        }

        else {
            System.out.print("Sorry, You can not cancel...");
            return;
        }
        System.out.println("Do you want to cancel only or change the lessons?");
        System.out.println("Press 1 to cancel only");
        System.out.println("Press any other key to change");
        int choice = input.nextInt();
        if (choice == 1) {
            return;
        }
        int grade = learners[ind].getGrade();

        int[] canTake = new int[50];
        int cnt = 0;
        for (int i = 1; i <= 44; i++) {
            if (forGrade[i] != grade && forGrade[i] != grade + 1)
                continue;
            if (forGrade[learners[ind].getLesson1()] == forGrade[i]
                    || forGrade[learners[ind].getLesson2()] == forGrade[i])
                continue;
            if (learnerTaken[i] < 4) {
                cnt++;
                canTake[cnt] = i;
            }
        }

        System.out.println("You can take the following lessons: Enter the lesson number you want to book ");
        for (int i = 1; i <= cnt; i++) {
            int x = canTake[i];
            System.out.println("Lesson no: " + x);
        }

        int interestedLesson = input.nextInt();
        Boolean f = false;
        for (int i = 1; i <= cnt; i++)
            if (interestedLesson == canTake[i])
                f = true;
        if (f == false) {
            System.out.println("Invalid option chosen");
            return;
        }

        if (learners[ind].getLesson1() < 1) {
            learners[ind].setLesson1(interestedLesson);
        } else {
            learners[ind].setLesson2(interestedLesson);
        }

        learnerTaken[interestedLesson]++;

        System.out.println("Booking change is successful!");
    }

    // Function for attending lessons
    void attendLesson() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter your name: ");
        String name = input.next();
        System.out.println("Please Enter your phone number: ");
        String phone = input.next();
        int ind = -1;
        for (int i = 1; i <= totalLearner; i++) {
            if (learners[i].getName().equals(name) && learners[i].getPhone().equals(phone)) {
                ind = i;
                break;
            }
        }
        if (ind == -1) {
            System.out.println("Invalid learner");
            return;
        }
        if (learners[ind].getLesson1() < 1 && learners[ind].getLesson2() < 1) {
            System.out.println("Learner has no lessons booked...");
            return;
        }
        int g1 = -1, g2 = -1;
        if (learners[ind].getLesson1() > 0)
            g1 = learners[ind].getLesson1();
        if (learners[ind].getLesson2() > 0)
            g2 = learners[ind].getLesson2();
        System.out.println("Choose which of the below lessons you want to attend: ");
        if (g1 != -1)
            System.out.println(g1);
        if (g2 != -1)
            System.out.println(g2);
        int opt = input.nextInt();
        if (opt != g1 && opt != g2) {
            System.out.println("Invalid lesson chosen");
            return;
        }
        if (opt == g1) {
            if (learners[ind].getAttended1() == true) {
                System.out.println("Already booked ..");
                return;
            }
            learners[ind].setAttended1(true);
        } else {
            if (learners[ind].getAttended2() == true) {
                System.out.println("Already booked ..");
                return;
            }
            learners[ind].setAttended2(true);
        }
        System.out.println("Successfully attended the lesson " + opt);
        System.out.println("Please provide a review for your coach: ");
        String review = input.next();
        System.out.println("Successfully provided the review");
        if (opt == learners[ind].getGrade() + 1 && learners[ind].getGrade() + 1 <= 5)
            learners[ind].setGrade(learners[ind].getGrade() + 1);
        System.out.println("Please provide a numerical rating of the lesson ranging from 1 to 5");
        System.out.println("1: Very dissatisfied");
        System.out.println("2: Dissatisfied");
        System.out.println("3: OK");
        System.out.println("4: Satisfied");
        System.out.println("5: Very Satisfied");

        int r = input.nextInt();
        while (r < 1 || r > 5) {
            System.out.println("Please provide rating between 1 and 5");
            r = input.nextInt();
        }
        int coachIndex = lessonCoachIndex[opt];
        coaches[coachIndex].setTotalRating(coaches[coachIndex].getTotalRating() + r);
        coaches[coachIndex].setFeedbackCount(coaches[coachIndex].getFeedbackCount() + 1);
        coaches[coachIndex].setReview(coaches[coachIndex].getFeedbackCount(), review);

        System.out.println("Thanks for providing rating ");
    }

    // Function for monthly report of learners
    void learnerReport() {
        for (int i = 1; i <= totalLearner; i++) {
            System.out.println("The learner number: " + i);
            System.out.println("Name: " + learners[i].getName());
            System.out.println("Age: " + learners[i].getAge());
            System.out.println("Phone: " + learners[i].getPhone());
            System.out.println("Booked lessons: ");
            if (learners[i].getLesson1() > 0)
                System.out.println("  " + learners[i].getLesson1());
            if (learners[i].getLesson2() > 0)
                System.out.println("  " + learners[i].getLesson2());
            for (int j = 1; j <= learners[i].getCancelCount(); j++) {
                System.out.println("  " + learners[i].getCancel()[j]);
            }
            System.out.println("Attended lessons: ");
            if (learners[i].getAttended1())
                System.out.println("  " + learners[i].getLesson1());
            if (learners[i].getAttended2())
                System.out.println("  " + learners[i].getLesson2());
            System.out.println("Canceled lessons: ");
            for (int j = 1; j <= learners[i].getCancelCount(); j++) {
                System.out.println("  " + learners[i].getCancel()[j]);
            }
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }

    public static void main(String args[]) {

    }
}

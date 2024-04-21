package JUnit;

import org.junit.jupiter.api.Test;

import Classes.Learner;
import Classes.Swimming;
import Classes.Coach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Unit tests for the Swimming class.

public class SwimmingTest {

    // Test case for registering a learner.
    // Ensures that the registerLearner method works correctly.

    @Test
    void testRegisterLearner() { // OK
        String simulatedUserInput = "Miraz\nMale\n10\n0123456789\n";
        InputStream savedStandardInputStream = System.in;
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Swimming swim = new Swimming();
        swim.registerLearner();
        Learner[] learners = swim.getLearners();
        assertEquals("Miraz", learners[swim.getTotalLearner()].getName());
        assertEquals("Male", learners[swim.getTotalLearner()].getGender());
        assertEquals(10, learners[swim.getTotalLearner()].getAge());
        assertEquals("0123456789", learners[swim.getTotalLearner()].getPhone());
        assertEquals(4, learners[swim.getTotalLearner()].getGrade());
        System.setIn(savedStandardInputStream);
        System.setOut(System.out);
    }

    // Test case for Booking lesson
    // Ensures that the basic functionality for booking is working properly

    @Test
    void testBookLesson() { // OK
        String simulatedUserInput = "Sabbirhossain\n01520000007\n1\n5\n";
        InputStream savedStandardInputStream = System.in;
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Swimming swim = new Swimming();
        swim.setTotalLearner(1);
        swim.getLearners()[1] = new Learner(simulatedUserInput, simulatedUserInput, 0, simulatedUserInput, 0);
        swim.getLearners()[1].setName("Sabbirhossain");
        swim.getLearners()[1].setPhone("01520000007");
        swim.getLearners()[1].setGrade(4);
        swim.bookLesson();
        assertEquals(5, swim.getLearners()[1].getLesson1());
        System.setIn(savedStandardInputStream);
        System.setOut(System.out);
    }

    // Test function for changing booking

    @Test
    void testChangeBooking() { // OK
        String simulatedUserInput = "Someone\n015200300000\n1\n";
        InputStream savedStandardInputStream = System.in;
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Swimming swim = new Swimming();
        swim.setTotalLearner(1);
        swim.getLearners()[1] = new Learner(simulatedUserInput, simulatedUserInput, 0, simulatedUserInput, 0);
        swim.getLearners()[1].setName("Someoneme");
        swim.getLearners()[1].setPhone("01520000000");
        swim.getLearners()[1].setLesson1(1);
        swim.setLearnerTaken(1, 1);

        swim.changeBooking();

        String expectedOutput = "Please Enter your name: " + System.lineSeparator() +
                "Please Enter your phone number: " + System.lineSeparator() +
                "Invalid learner" + System.lineSeparator();
        assertEquals(expectedOutput, outputStreamCaptor.toString());

        System.setIn(savedStandardInputStream);
        System.setOut(System.out);
    }

    // test function for Attending lesson

    @Test
    void testAttendLesson() { // OK
        String simulatedUserInput = "Miraz\n0123456789\n1\n4\n";
        InputStream savedStandardInputStream = System.in;
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        Swimming swim = new Swimming();

        swim.setTotalLearner(1);
        swim.getLearners()[1] = new Learner(simulatedUserInput, simulatedUserInput, 0, simulatedUserInput, 0);
        swim.getLearners()[1].setName("Mushfiq");
        swim.getLearners()[1].setPhone("0123456789");
        swim.getLearners()[1].setLesson1(1);
        // swim.getLearners()[1].setLessonTaken(1);
        swim.getLearners()[1].setAttended1(false);

        swim.attendLesson();

        assertEquals(false, swim.getLearners()[1].getAttended1());

        System.setIn(savedStandardInputStream);
        System.setOut(System.out);
    }

    // Test function for showing Learner monthly report

    @Test
    void testLearnerReport() { // OK
        Swimming swimming = new Swimming();
        swimming.init();
        Learner learner = new Learner(null, null, 0, null, 0);
        learner.setName("Mostafiz");
        learner.setAge(12);
        learner.setPhone("1234567890");
        learner.setLesson1(3);
        learner.setLesson2(4);
        learner.setCancel(1, 2);
        learner.setCancelCount(1);
        swimming.setTotalLearner(3);
        swimming.setLearners(3, learner);
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        swimming.learnerReport();

        String expectedOutput = "The learner number: 1" + System.lineSeparator() +
                "Name: Sabbir" + System.lineSeparator() +
                "Age: 14" + System.lineSeparator() +
                "Phone: 01520000000" + System.lineSeparator() +
                "Booked lessons: " + System.lineSeparator() +
                "Attended lessons: " + System.lineSeparator() +
                "Canceled lessons: " + System.lineSeparator() +
                System.lineSeparator() +
                System.lineSeparator() +
                System.lineSeparator() +
                "The learner number: 2" + System.lineSeparator() +
                "Name: Shaikat" + System.lineSeparator() +
                "Age: 5" + System.lineSeparator() +
                "Phone: 01750000000" + System.lineSeparator() +
                "Booked lessons: " + System.lineSeparator() +
                "Attended lessons: " + System.lineSeparator() +
                "Canceled lessons: " + System.lineSeparator() +
                System.lineSeparator() +
                System.lineSeparator() +
                System.lineSeparator() +
                "The learner number: 3" + System.lineSeparator() +
                "Name: Mostafiz" + System.lineSeparator() +
                "Age: 12" + System.lineSeparator() +
                "Phone: 1234567890" + System.lineSeparator() +
                "Booked lessons: " + System.lineSeparator() +
                "  3" + System.lineSeparator() +
                "  4" + System.lineSeparator() +
                "  2" + System.lineSeparator() +
                "Attended lessons: " + System.lineSeparator() +
                "Canceled lessons: " + System.lineSeparator() +
                "  2" + System.lineSeparator() +
                System.lineSeparator() +
                System.lineSeparator() +
                System.lineSeparator();

        assertEquals(expectedOutput, outputStreamCaptor.toString());

        System.setOut(System.out);
    }

    // Test function for showing coach monthly report

    @Test
    void testCoachReport() { // OK
        Swimming swimming = new Swimming();
        swimming.init();
        Coach coach = new Coach("Shanto", "0175970003");
        coach.setFeedbackCount(2);
        coach.setTotalRating(8);
        coach.setReview(1, "Good Person");
        coach.setReview(2, "He is helpful");
        swimming.setTotalCoach(4);
        swimming.getCoaches()[4] = coach;

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        swimming.coachReport();

        String expectedOutput = "Coach No: 1" + System.lineSeparator() +
                "Name: Tamim" + System.lineSeparator() +
                "Phone: 0175970000" + System.lineSeparator() +
                "Total feedback: 0" + System.lineSeparator() +
                "Average rating: 0" + System.lineSeparator() +
                "All reviews:" + System.lineSeparator() +
                System.lineSeparator() +
                System.lineSeparator() +
                "Coach No: 2" + System.lineSeparator() +
                "Name: Sakib" + System.lineSeparator() +
                "Phone: 0155579000" + System.lineSeparator() +
                "Total feedback: 0" + System.lineSeparator() +
                "Average rating: 0" + System.lineSeparator() +
                "All reviews:" + System.lineSeparator() +
                System.lineSeparator() +
                System.lineSeparator() +
                "Coach No: 3" + System.lineSeparator() +
                "Name: Riyad" + System.lineSeparator() +
                "Phone: 0132610000" + System.lineSeparator() +
                "Total feedback: 0" + System.lineSeparator() +
                "Average rating: 0" + System.lineSeparator() +
                "All reviews:" + System.lineSeparator() +
                System.lineSeparator() +
                System.lineSeparator() +
                "Coach No: 4" + System.lineSeparator() +
                "Name: Shanto" + System.lineSeparator() +
                "Phone: 0175970003" + System.lineSeparator() +
                "Total feedback: 2" + System.lineSeparator() +
                "Average rating: 4" + System.lineSeparator() +
                "All reviews:" + System.lineSeparator() +
                "Good Person" + System.lineSeparator() +
                "He is helpful" + System.lineSeparator() +
                System.lineSeparator() +
                System.lineSeparator();

        assertEquals(expectedOutput, outputStreamCaptor.toString());

        System.setOut(System.out);
    }
}

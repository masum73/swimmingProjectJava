
// Class for Coach information
public class Coach {
    private String name;
    private String phone;
    private String[] review;
    private int feedbackCount;
    private int totalRating;

    // Constructor
    public Coach(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.review = new String[50];
        this.feedbackCount = 0;
        this.totalRating = 0;
    }

    // getter setter
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String[] getReview() {
        return review;
    }

    public int getTotalRating() {
        return totalRating;
    }

    public int getFeedbackCount() {
        return feedbackCount;
    }

    public void setTotalRating(int totalRating) {
        this.totalRating = totalRating;
    }

    public void setFeedbackCount(int feedbackCount) {
        this.feedbackCount = feedbackCount;
    }

    public void setReview(int index, String review) {
        this.review[index] = review;
    }
}

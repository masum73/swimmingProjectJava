package Classes;

// Class for Coach information
class Coach {
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

}

package FlashCardModule;

public class Question {
    public Question(){
        this.questionText = "Who is you?";
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    private String questionText;
}

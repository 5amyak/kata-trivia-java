package trivia;

import java.util.LinkedList;

public class QuestionManager {
    LinkedList<String> popQuestions = new LinkedList<>();
    LinkedList<String> scienceQuestions = new LinkedList<>();
    LinkedList<String> sportsQuestions = new LinkedList<>();
    LinkedList<String> rockQuestions = new LinkedList<>();

    public QuestionManager() {
        for (int i = 0; i < 50; i++) {
            this.popQuestions.addLast("Pop Question " + i);
            this.scienceQuestions.addLast(("Science Question " + i));
            this.sportsQuestions.addLast(("Sports Question " + i));
            this.rockQuestions.addLast("Rock Question " + i);
        }
    }

    void askQuestion(String category) {
        if (category.equals("Pop"))
            System.out.println(popQuestions.removeFirst());
        if (category.equals("Science"))
            System.out.println(scienceQuestions.removeFirst());
        if (category.equals("Sports"))
            System.out.println(sportsQuestions.removeFirst());
        if (category.equals("Rock"))
            System.out.println(rockQuestions.removeFirst());
    }
}
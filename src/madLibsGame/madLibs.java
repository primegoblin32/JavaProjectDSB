package madLibsGame;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;


public class madLibs extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    String[] words = new String[5];
    String[] questions = {"Enter an adjective (description)",
                          "Enter a noun (animal or person)",
                          "Enter an adjective (description)",
                          "Enter a verb and with -ing (action)",
                          "Enter an adjective (description)"};
    int i = 0;

    @Override
    public void start(Stage primaryStage) {

        double windowWidth = 400;
        double windowHeight = 300;
        double textBoxHeight = 50;

        TextField textField = new TextField();
        textField.setPrefSize(windowWidth/2, textBoxHeight);
        textField.setLayoutX(windowWidth/4);
        textField.setLayoutY(windowHeight * 3/4 - textBoxHeight/2);

        Label question = new Label();
        question.setPrefSize(400, 50);
        question.setLayoutX(0);
        question.setLayoutY(windowHeight/2 - 50);
        question.setStyle("-fx-font-size: 24px; -fx-alignment: center;");

        Label story = new Label();
        story.setPrefSize(400, 300);
        story.setLayoutX(0);
        story.setLayoutY(50);
        story.setStyle("-fx-font-size: 20px; -fx-alignment: top-center;");
        story.setVisible(true);

        question.setText(questions[i]);
        textField.setOnAction(actionEvent -> {
            words[i] = textField.getText();
            i++;
            if(i == 5) {
                for(String word : words) {
                    question.setVisible(false);
                    textField.setVisible(false);
                    story.setText("Today I went to a " + words[0] + " zoo.\n" +
                                  "In an exhibit, I saw a " + words[1] + ".\n"
                                  + words[1] + " was " + words[2] + " and " + words[3] + "!\n" +
                                  "I was " + words[4] + "!");
                    story.setVisible(true);
                }
            }
            else {
                question.setText(questions[i]);
                textField.setText("");
            }

        });

        Pane rootLayout = new Pane();
        rootLayout.getChildren().addAll(textField, question, story);

        Scene scene = new Scene(rootLayout, windowWidth, windowHeight);
        primaryStage.setTitle("Mad Libs Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

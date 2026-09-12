package compoundInterestCalculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class compoundInterest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        TextField principalBox = new TextField();
        principalBox.setPrefSize(125, 25);
        principalBox.setLayoutX(165);
        principalBox.setLayoutY(25);

        TextField rateBox = new TextField();
        rateBox.setPrefSize(125, 25);
        rateBox.setLayoutX(165);
        rateBox.setLayoutY(75);

        ComboBox<String> compoundDropdown = new ComboBox<>();
        compoundDropdown.setPrefSize(130, 25);
        compoundDropdown.setLayoutX(165);
        compoundDropdown.setLayoutY(125);
        compoundDropdown.getItems().addAll("Annually (1/Yr)", "Semi-Annually (2/Yr)", "Quarterly (4/Yr)", "Monthly (12/Yr)");
        compoundDropdown.setPromptText("select an option");

        TextField yearsBox = new TextField();
        yearsBox.setPrefSize(125, 25);
        yearsBox.setLayoutX(165);
        yearsBox.setLayoutY(175);

        Label principalLabel = new Label("Principal (P): $");
        principalLabel.setPrefSize(150, 25);
        principalLabel.setLayoutX(55);
        principalLabel.setLayoutY(25);

        Label rateLabel = new Label("Rate (R): %");
        rateLabel.setPrefSize(150, 25);
        rateLabel.setLayoutX(55);
        rateLabel.setLayoutY(75);

        Label compoundLabel = new Label("Compound (n)");
        compoundLabel.setPrefSize(150, 25);
        compoundLabel.setLayoutX(55);
        compoundLabel.setLayoutY(125);

        Label yearsLabel = new Label("Time (t in years)");
        yearsLabel.setPrefSize(150, 25);
        yearsLabel.setLayoutX(55);
        yearsLabel.setLayoutY(175);

        Button calculateBtn = new Button("Calculate");
        calculateBtn.setPrefSize(80, 25);
        calculateBtn.setLayoutX(245);
        calculateBtn.setLayoutY(210);

        TextArea answerBox = new TextArea("Answer:");
        answerBox.setPrefSize(300,50);
        answerBox.setLayoutX(25);
        answerBox.setLayoutY(245);
        answerBox.setStyle("-fx-alignment: top-left;");
        answerBox.setEditable(false);

        calculateBtn.setOnAction(actionEvent -> {

            double principal;
            double rate;
            int timesCompounded;
            int years;
            double amount;

            if(!principalBox.getText().isEmpty() && !rateBox.getText().isEmpty() && !yearsBox.getText().isEmpty()) {

                if(compoundDropdown.getValue() == null) {
                    answerBox.setText("Answer:\n\tPlease enter Compound (n)");
                    return;
                }
                else {
                    timesCompounded = switch(compoundDropdown.getValue()) {
                        case String s when s.contains("12/Yr") -> 12;
                        case String s when s.contains("4/Yr") -> 4;
                        case String s when s.contains("2/Yr") -> 2;
                        case String s when s.contains("1/Yr") -> 1;
                        default -> 0;
                    };
                }

                principal = Double.parseDouble(principalBox.getText());
                rate = Double.parseDouble(rateBox.getText()) / 100;
                years = Integer.parseInt(yearsBox.getText());

                amount = principal * Math.pow(1 + (rate / timesCompounded), timesCompounded * years);
                answerBox.setText(String.format("Answer:\n\t$%.2f", amount));

            }
            else {
                answerBox.setText("Answer:\n\tPlease enter all fields");
            }
        });

        Pane rootLayout = new Pane();
        rootLayout.getChildren().addAll(principalBox, rateBox, compoundDropdown, yearsBox, principalLabel, rateLabel, compoundLabel, yearsLabel, answerBox, calculateBtn);

        Scene scene = new Scene(rootLayout, 350, 320);
        primaryStage.setTitle("Compound Interest Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

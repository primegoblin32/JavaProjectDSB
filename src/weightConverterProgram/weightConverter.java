package weightConverterProgram;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;

public class weightConverter extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        TextField leftField = new TextField();
        leftField.setPrefSize(150,40);
        leftField.setLayoutX(25);
        leftField.setLayoutY(25);

        TextField rightField = new TextField();
        rightField.setPrefSize(150, 40);
        rightField.setLayoutX(225);
        rightField.setLayoutY(25);

        Label equalsLabel = new Label("=");
        equalsLabel.setPrefSize(40, 40);
        equalsLabel.setLayoutX(180);
        equalsLabel.setLayoutY(25);
        equalsLabel.setStyle("-fx-alignment: center; -fx-font-size: 26px;");

        ComboBox<String> leftHandDropdown = new ComboBox<>();
        leftHandDropdown.getItems().addAll("Pound");
        leftHandDropdown.setValue("Pound");
        leftHandDropdown.setPrefSize(150, 30);
        leftHandDropdown.setLayoutX(25);
        leftHandDropdown.setLayoutY(65);

        ComboBox<String> rightHandDropdown = new ComboBox<>();
        rightHandDropdown.getItems().addAll("Kilogram");
        rightHandDropdown.setValue("Kilogram");
        rightHandDropdown.setPrefSize(150, 30);
        rightHandDropdown.setLayoutX(225);
        rightHandDropdown.setLayoutY(65);

        leftField.setOnAction(actionEvent -> {
            double weight;
            double convertedWeight;

            weight = Double.parseDouble(leftField.getText());
            convertedWeight =  weight / 2.205;

            rightField.setText(String.valueOf(convertedWeight));
        });

        rightField.setOnAction(actionEven -> {
            double weight;
            double convertedWeight;

            weight = Double.parseDouble(rightField.getText());
            convertedWeight = weight * 2.205;

            leftField.setText(String.valueOf(convertedWeight));
        });

        Pane rootLayout = new Pane();
        rootLayout.getChildren().addAll(leftField, rightField, equalsLabel, leftHandDropdown, rightHandDropdown);

        Scene scene = new Scene(rootLayout, 400, 150);
        primaryStage.setTitle("Weight Converter");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

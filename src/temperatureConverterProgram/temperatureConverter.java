package temperatureConverterProgram;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;

public class temperatureConverter extends Application {
    public static void main (String[] args) {
        launch(args);
    }

    String unit;

    @Override
    public void start(Stage primaryStage) {

        TextField temperatureBox = new TextField();
        temperatureBox.setPrefSize(150, 40);

        TextArea resultBox = new TextArea();
        resultBox.setPrefSize(150, 40);

        Button celsiusBtn = new Button("To °C");
        celsiusBtn.setPrefSize(100, 40);

        Button fahrenheitBtn = new Button("To °F");
        fahrenheitBtn.setPrefSize(100, 40);

        Button convertBtn = new Button("Convert");
        fahrenheitBtn.setPrefSize(100, 40);

        Label temperatureBoxLabel = new Label("Enter the temperature:");
        Label resultBoxLabel = new Label("Result:");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);

        grid.add(celsiusBtn, 0, 0);
        grid.add(fahrenheitBtn, 1, 0);

        celsiusBtn.setOnAction(actionEvent -> {
            unit = ("C");
        });

        fahrenheitBtn.setOnAction(actionEvent -> {
            unit = ("F");
        });

        convertBtn.setOnAction(actionEvent -> {

            double temp = Double.parseDouble(temperatureBox.getText());
            double convertedTemp;

            convertedTemp = (unit.equals("C")) ? (temp-32) * 5/9 : (temp * 9/5) +32;

            resultBox.setText(String.format("%.2f °%s", convertedTemp, unit));
        });

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 20px; -fx-spacing: 20px;");
        root.getChildren().addAll(temperatureBoxLabel, temperatureBox, resultBoxLabel, resultBox, grid, convertBtn);

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setTitle("Temperature Converter");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

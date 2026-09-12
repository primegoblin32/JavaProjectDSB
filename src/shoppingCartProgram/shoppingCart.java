package shoppingCartProgram;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class shoppingCart extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        double windowWidth = 700;
        double windowHeight = 300;

        TextField itemBox = new TextField();
        itemBox.setPrefSize(200, 50);
        itemBox.setLayoutX(25);
        itemBox.setLayoutY(75);

        TextField priceBox = new TextField();
        priceBox.setPrefSize(200, 50);
        priceBox.setLayoutX(250);
        priceBox.setLayoutY(75);

        TextField quantityBox = new TextField();
        quantityBox.setPrefSize(200, 50);
        quantityBox.setLayoutX(475);
        quantityBox.setLayoutY(75);

        Label itemText = new Label("What item would you like to buy?");
        itemText.setPrefSize(200,50);
        itemText.setLayoutX(25);
        itemText.setLayoutY(0);
        itemText.setStyle("-fx-font-size: 13px; -fx-alignment: bottom-center;");

        Label priceText =new Label("What is the price for each?");
        priceText.setPrefSize(200, 50);
        priceText.setLayoutX(250);
        priceText.setLayoutY(0);
        priceText.setStyle("-fx-font-size: 13px; -fx-alignment: bottom-center;");

        Label quantityText = new Label("How many would you like?");
        quantityText.setPrefSize(200, 50);
        quantityText.setLayoutX(475);
        quantityText.setLayoutY(0);
        quantityText.setStyle("-fx-font-size: 13px; -fx-alignment: bottom-center;");

        Label totalText = new Label();
        totalText.setPrefSize(700,150);
        totalText.setLayoutX(0);
        totalText.setLayoutY(175);
        totalText.setStyle("-fx-font-size: 24px; -fx-alignment: top-center");
        totalText.setVisible(false);

        Runnable itemCart = () -> {
            String item;
            double price;
            int quantity;
            double total;

            if(!itemBox.getText().isEmpty() && !priceBox.getText().isEmpty() && !quantityBox.getText().isEmpty()) {
                item = itemBox.getText();
                price = Double.parseDouble(priceBox.getText());
                quantity = Integer.parseInt(quantityBox.getText());

                total = price * quantity;

                totalText.setText("You have bought " + quantity + " " + item + "/s\nYour total is $" + total);
                totalText.setVisible(true);
            }
        };

        itemBox.setOnAction(_ -> itemCart.run());
        priceBox.setOnAction(_ -> itemCart.run());
        quantityBox.setOnAction(_ -> itemCart.run());

        Pane rootLayout = new Pane();
        rootLayout.getChildren().addAll(itemBox, priceBox, quantityBox, itemText, priceText, quantityText, totalText);

        Scene scene = new Scene(rootLayout, windowWidth, windowHeight);
        primaryStage.setTitle("Shopping Cart");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

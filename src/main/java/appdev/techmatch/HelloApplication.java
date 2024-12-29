package appdev.techmatch;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        // Left Section
        VBox leftSection = new VBox(20); // Add spacing
        leftSection.setPadding(new Insets(40));
        leftSection.setAlignment(Pos.CENTER_LEFT);
        leftSection.setStyle("-fx-background-color: #000000;");

        Text discoverText = new Text("Discover Events That\nMatch Your Passion");
        discoverText.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        discoverText.setFill(Color.web("#FF007F"));

        Label description = new Label(
                "Stay informed and never miss an opportunity to learn, connect, and grow\n"
                        + "with TechMatch, the event recommender system designed for the CCIS community."
        );
        description.setWrapText(true);
        description.setTextFill(Color.LIGHTGRAY);
        description.setFont(Font.font("Arial", 14));
        description.setMaxWidth(400);

        Button loginButton = new Button("Login");
        loginButton.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        loginButton.setStyle("-fx-background-color: #FF9A00; -fx-text-fill: #000000; "
                + "-fx-padding: 10px 30px; -fx-border-radius: 10; -fx-background-radius: 10;");

        Button signUpButton = new Button("Sign Up");
        signUpButton.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        signUpButton.setStyle("-fx-background-color: transparent; -fx-border-color: #FF9A00; -fx-border-width: 2; "
                + "-fx-text-fill: #FF9A00; -fx-padding: 10px 30px; -fx-border-radius: 10; -fx-background-radius: 10;");

        leftSection.getChildren().addAll(discoverText, description, loginButton, signUpButton);

        // Right Section (Login Form)
        VBox rightSection = new VBox(20); // Add spacing
        rightSection.setPadding(new Insets(40));
        rightSection.setAlignment(Pos.CENTER);

        // Loading of BG Image - Gradient
        Image gradientImage = new Image("gradient.png");
        BackgroundImage bgImage = new BackgroundImage(
                gradientImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
        rightSection.setBackground(new Background(bgImage));

        // Add the logo
        Image logoImage = new Image("logo.png");
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setFitWidth(150);
        logoImageView.setPreserveRatio(true);

        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        emailField.setStyle("-fx-prompt-text-fill: #aaaaaa; -fx-background-color: #2c2c2c; "
                + "-fx-text-fill: white; -fx-padding: 10px; -fx-background-radius: 5;");
        emailField.setMaxWidth(Double.MAX_VALUE);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setStyle("-fx-prompt-text-fill: #aaaaaa; -fx-background-color: #2c2c2c; "
                + "-fx-text-fill: white; -fx-padding: 10px; -fx-background-radius: 5;");
        passwordField.setMaxWidth(Double.MAX_VALUE);

        Button logInButton = new Button("Log In");
        logInButton.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        logInButton.setStyle("-fx-background-color: #FF9A00; -fx-text-fill: #000000; "
                + "-fx-padding: 10px 30px; -fx-border-radius: 10; -fx-background-radius: 10;");

        rightSection.getChildren().addAll(logoImageView, emailField, passwordField, logInButton);

        //icon

        primaryStage.getIcons().add(logoImage);

        // Main Layout
        HBox mainLayout = new HBox(10); // Add spacing between sections
        mainLayout.setStyle("-fx-background-color: black;");
        mainLayout.getChildren().addAll(leftSection, rightSection);

        // Enable resizing for sections
        HBox.setHgrow(leftSection, Priority.ALWAYS);
        HBox.setHgrow(rightSection, Priority.ALWAYS);

        // Scene Setup
        Scene scene = new Scene(mainLayout, 900, 600);
        mainLayout.prefWidthProperty().bind(scene.widthProperty());
        mainLayout.prefHeightProperty().bind(scene.heightProperty());

        primaryStage.setTitle("TechMatch Login Page");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true); // Enable resizing
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

package CountDownTimer;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class Main extends Application {
    @FXML
    ChoiceBox cb_TimerSelection;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ui/countdownlayout.fxml"));
        primaryStage.setTitle("The Pomodoro timer");
        primaryStage.setScene(new Scene(root, 280, 190));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

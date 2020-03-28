package CountDownTimer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Duration;
import CountDownTimer.model.Timer;

public class Controller {
    @FXML
    Button btn_Start;
    @FXML
    Label lbl_MinutesDisplay, lbl_SecondsDisplay;

    @FXML
    ChoiceBox cb_TimerSelection;

    private Timeline timeline;
    private Timer timer;
    private Integer timeSeconds, timeMinutes;


    public void initialize() {
        ObservableList<String> items = FXCollections.observableArrayList("1 mins", "2 mins", "15 mins", "25 mins");
        cb_TimerSelection.setItems(items);
        timer = new Timer();
    }


    public void startTimer(ActionEvent actionEvent) {
        //Get Value and Convert To Second
        lbl_MinutesDisplay.setText(timer.getMinutes());

        timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1), e -> CountDown())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.playFromStart();
    }

    private void CountDown() {
        int seconds = Integer.parseInt(timer.getSeconds());
        int minutes = Integer.parseInt(timer.getMinutes());
        if (minutes == 0) {
            timeline.stop();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("You should take a break !!!!");
            Platform.runLater(alert::showAndWait);
        } else {
            if (seconds == 0) {
                minutes--;
                seconds = 60;
            } else {
                seconds--;
            }
            timer.setMinutes(String.valueOf(minutes));
            timer.setSeconds(String.valueOf(seconds));
            if (minutes > 1 ) {
                int temp = minutes - 1;
                lbl_MinutesDisplay.setText(String.valueOf(temp));
            }  else { lbl_MinutesDisplay.setText("00");}
            if (seconds != 60 && seconds > 0) {
                lbl_SecondsDisplay.setText(timer.getSeconds());
            } else {
                lbl_SecondsDisplay.setText("00");
            }
        }
    }

    public void returnTimeValue(ActionEvent actionEvent) {
        String selectionTimer = (cb_TimerSelection.getSelectionModel().getSelectedItem().toString()).split(" ")[0];
        timer.setMinutes(selectionTimer);
        timer.setSeconds("60");
    }
}

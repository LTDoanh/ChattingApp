package com.example.demo;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public class Controller implements Initializable {


  @FXML
  private ImageView profile;

  @FXML
  private ImageView profile_big;

  @FXML
  private ScrollPane scrollPane;

  @FXML
  private VBox chatBox;

  @FXML
  private TextField messageField;

  @FXML

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    Circle clip1 = new Circle(profile.getFitWidth() / 2, profile.getFitHeight() / 2,
        Math.min(profile.getFitWidth(), profile.getFitHeight()) / 2);
    profile.setClip(clip1);
    Circle clip2 = new Circle(profile_big.getFitWidth() / 2, profile_big.getFitHeight() / 2,
        Math.min(profile_big.getFitWidth(), profile_big.getFitHeight()) / 2);
    profile_big.setClip(clip2);
    ImageView hiImage = new ImageView(new Image(getClass().getResource("hi.png").toExternalForm()));
    hiImage.setFitHeight(100);
    hiImage.setFitWidth(100);
    HBox hbox1 = new HBox();
    hbox1.setPrefWidth(chatBox.getPrefWidth());
    hbox1.getStyleClass().add("received");
    hbox1.getChildren().add(hiImage);
    AppLabel label = new AppLabel("Chào bạn", false);
    HBox hbox2 = new HBox();
    hbox2.setPrefWidth(chatBox.getPrefWidth());
    hbox2.getStyleClass().add("received");
    hbox2.getChildren().add(label);
    chatBox.getChildren().addAll(hbox1, hbox2);
    scrollPane.setContent(chatBox);
  }

  @FXML
  private void handleSendButton(ActionEvent event) {
    String message = messageField.getText();
    if (!message.isEmpty()) {
      messageField.clear();
      AppLabel label = new AppLabel(message, true);
      HBox hbox = new HBox();
      hbox.setPrefWidth(chatBox.getPrefWidth());
      hbox.getStyleClass().add("sent");
      hbox.getChildren().add(label);
      chatBox.getChildren().add(hbox);
      scrollPane.setContent(chatBox);
      scrollPane.vvalueProperty().bind(chatBox.heightProperty());
    }
  }
}

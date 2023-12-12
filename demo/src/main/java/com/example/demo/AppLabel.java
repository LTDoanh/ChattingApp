package com.example.demo;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class AppLabel extends Label {
  public AppLabel(String message, boolean isSent) {
    super(message);
    this.setFont(new Font(14));
    this.getStyleClass().add("message");
//    if (isSent) {
//      this.getStyleClass().add("sent");
//    } else {
//      this.getStyleClass().add("received");
//    }
  }
}

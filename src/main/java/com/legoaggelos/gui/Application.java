package com.legoaggelos.gui;

import com.legoaggelos.util.PIUtil;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage primaryStage) {
        VBox components = new VBox();

        Label text = new Label("Enter number of PI digits here(goes up to 60000):");

        TextArea PIdigitInput = new TextArea("");
        PIdigitInput.setPrefSize(13,31);

        TextArea digits = new TextArea("");

        digits.setEditable(false);

        Button showDigits = new Button("Show digits");
        showDigits.setOnAction(event -> {
            try {
                int digitsCounter = Integer.parseInt(PIdigitInput.getText().trim());
                if(digitsCounter<=60000) {
                    digits.setText(getStringWithSpaceEvery47Chars(PIUtil.getPIDigits(digitsCounter)));
                }
            } catch(Exception e){
                digits.setText("That wasnt a number!");
            }
        });

        components.getChildren().addAll(text,PIdigitInput,showDigits,digits);
        Scene scene = new Scene(components,314,314);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static String getStringWithSpaceEvery47Chars(String string){
        int fortySevenIndex = 0;
        for (int i = 0; i < string.length()-47; i++) {
            if(i%47==0){
                System.out.println(i);
                fortySevenIndex++;
                String firstHalf = string.substring(0,fortySevenIndex*47);
                String secondHalf = string.substring(fortySevenIndex*47);
                string=firstHalf+"\n"+secondHalf;
            }
        }
        return string;
    }
}

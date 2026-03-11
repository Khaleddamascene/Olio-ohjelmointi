package View;

import Controller.DictionaryController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class DictionaryView extends Application {
    private TextField searchField;
    private TextArea resultArea;
    private DictionaryController controller;

    @Override
    public void init() {
        controller = new DictionaryController();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Virtual Dictionary");

        // Komponentit
        Label searchLabel = new Label("Enter word:");
        searchField = new TextField();
        searchField.setPromptText("e.g. house, car, java");
        searchField.setPrefWidth(200);

        Button searchButton = new Button("Search");
        resultArea = new TextArea();
        resultArea.setPrefSize(350, 120);
        resultArea.setEditable(false);
        resultArea.setWrapText(true);

        // FlowPane layout
        FlowPane pane = new FlowPane(10, 10);
        Insets insets = new Insets(15);
        pane.setPadding(insets);
        pane.setHgap(10);
        pane.setAlignment(Pos.CENTER_LEFT);

        pane.getChildren().addAll(searchLabel, searchField, searchButton, resultArea);


        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String word = searchField.getText();
                String result = controller.searchWord(word);  // Controller saa String
                resultArea.setText(result);  // näyttää tuloksen
                searchField.clear();  // Tyhjennä kenttä
            }
        });

        Scene scene = new Scene(pane, 450, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


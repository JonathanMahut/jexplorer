package mattw.jexplorer.v2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JExplorerWindow extends Application {

    private Image ICON = new Image("/mattw/jexplorer/v2/img/icon.png");
    private DriveSideMenu sideMenu;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {

        SplitPane split = new SplitPane();
        split.getItems().addAll(new StackPane(sideMenu = new DriveSideMenu()), new StackPane());
        split.setDividerPosition(0, 0.35);

        StackPane main = new StackPane();
        main.getChildren().addAll(split);

        Scene scene = new Scene(main, 800, 500);
        scene.getStylesheets().add("/mattw/jexplorer/v2/styles.css");
        stage.setTitle("JExplorer");
        stage.setScene(scene);
        stage.getIcons().add(ICON);
        stage.setOnCloseRequest(we -> {
            Platform.exit();
            System.exit(0);
        });
        stage.show();
    }

}

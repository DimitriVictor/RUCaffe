package RUCafe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class is the driver for the project that starts and runs it
 * @author Padmank Ambadipudi
 * @author Dimitri Victor
 */
public class Main extends Application {

    /**
     * This function starts the program and creates the window that displays the project
     * @param primaryStage main stage of the project
     * @throws Exception that is thrown if the application cannot successfully start
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        primaryStage.setTitle("RU Cafe Main Menu");
        primaryStage.setScene(new Scene(root, Constants.MAIN_WINDOW_WIDTH, Constants.MAIN_WINDOW_HEIGHT));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * Main function that runs the appllication
     * @param args that are passed when the program starts
     */
    public static void main(String[] args) {
        launch(args);
    }
}

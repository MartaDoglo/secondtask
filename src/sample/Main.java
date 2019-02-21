/**
 * Я приношу глубочайшие извинения за написанный код, мне безумно стыдно показывать вам свои
 * наиглупейшие решения задачи. В данный момент я всеми силами разбираюсь с Retrofit'ом,
 * чтобы в ближайшее время создать что-то достойное.
 * Спасибо
 */

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("SecondTask by Dummy");
        primaryStage.setScene(new Scene(root, 400, 450));
        primaryStage.setResizable(false);
        primaryStage.show();
        System.out.println();
    }
}

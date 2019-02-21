package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button previous;
    @FXML
    private Button next;
    @FXML
    private Text status;
    @FXML
    private Label list;

    private int page = 1;
    private int pages;

    @FXML
    void initialize() throws Exception {

        previous.setDisable(true);
        next.setDisable(true);

        if (DB.getPages()!=null) {
            pages = Integer.parseInt(DB.getPages());
            if (page>1)
                previous.setDisable(false);
            next.setDisable(false);
        }
        else
            status.setText("Server error");

        if (!DB.getData(page).equals("")){
            list.setText(DB.getData(page));
            status.setText("Done!");
        }
        else {
            status.setText("List doesn't exist");
        }

        next.setOnAction(event -> {
out("1");
            if (page<pages) {
                page++;
                previous.setDisable(false);

                try {
                    if (!DB.getData(page).equals("")){
                        list.setText(DB.getData(page));
                        status.setText("Done!");
                    }
                    else {
                        status.setText("List doesn't exist");
                    }
                } catch (Exception e) {
                }
                if (page==pages){
                    next.setDisable(true);
                }
            }
        });

        previous.setOnAction(event -> {
out("2");
            if (page>1) {
                page--;
                next.setDisable(false);
                try {
                    if (!DB.getData(page).equals("")){
                        list.setText(DB.getData(page));
                        status.setText("Done!");
                    }
                    else {
                        status.setText("List doesn't exist");
                    }
                } catch (Exception e) {
                }
                if (page==1){
                    previous.setDisable(true);
                }
            }
        });
    }

    private void out (String s) {
        System.out.println(s+"\nCurrent page: "+page+"\nTotal pages: "+pages);
    }


}



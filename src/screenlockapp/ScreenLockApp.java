/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package screenlockapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Screen;
import javafx.stage.StageStyle;
import javafx.stage.Stage;

/**
 *
 * @author oscar
 */
public class ScreenLockApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = (Parent)loader.load();
        
        FXMLDocumentController controller = (FXMLDocumentController)loader.getController();
        controller.setStageAndSetupListeners(stage);
        
        Rectangle2D r = Screen.getPrimary().getBounds();
        Scene scene = new Scene(root, r.getWidth(), r.getHeight());
        
        stage.requestFocus();
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.initStyle(StageStyle.TRANSPARENT);
        
        stage.setAlwaysOnTop(true);

        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
        new Thread(new AlwaysTop(stage)).start();

    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public class AlwaysTop implements Runnable{

        private Stage s;
        public AlwaysTop(Stage s) {
            this.s=s;
        }

        
        @Override
        public void run() {
            while(s.isShowing()){
                if(s.isAlwaysOnTop()==false){
                    s.setAlwaysOnTop(true);
                    
                }
                if(!s.fullScreenProperty().getValue()){
                    s.setFullScreen(true);
                }
                
            }
        }
        
    }
}  

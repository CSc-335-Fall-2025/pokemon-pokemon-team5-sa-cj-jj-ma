import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

@SuppressWarnings("deprecation")
public class GameView extends Application implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(Stage stage) throws Exception {
		initializeGame();
		BorderPane MainMenu = new BorderPane();
		HBox buttonBox = new HBox(20);
		Button progressionMode = new Button("Single Player");
		Button multiPlayerVersus = new Button("Multiplayer Versus");
		Button multiPlayerTogether = new Button("Play Together Versus CPU");
		buttonBox.getChildren().add(progressionMode);
		buttonBox.getChildren().add(multiPlayerVersus);
		buttonBox.getChildren().add(multiPlayerTogether);
		buttonBox.setAlignment(Pos.CENTER);
		
		MainMenu.setTop(buttonBox);
		
		
		
		
		

		Scene scene = new Scene(MainMenu, 1280,720);
		stage.setScene(scene);
		stage.setTitle("Pokemen");
		stage.show();
	}
	
	public void initializeGame(){
		
	}
	
	public void initializeBattle() {
		
	}
	
	public void initializeProgression() {
		
	}

}

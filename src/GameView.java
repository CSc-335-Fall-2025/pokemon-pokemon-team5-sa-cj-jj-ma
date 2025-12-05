import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;

import controller.PokemonController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.CreaturePool;
//import model.CreaturePool;
import model.PokemonModel;

@SuppressWarnings("deprecation")
public class GameView extends Application implements Observer {
	
	private PokemonModel model;
	private PokemonController controller;
	

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(Stage stage) throws Exception {
		model = new PokemonModel();
		controller = new PokemonController(model);
		
		BorderPane MainMenu = new BorderPane();
		HBox buttonBox = new HBox(20);
		Button singlePlayer = new Button("Single Player");
		Button multiPlayerVersus = new Button("Multiplayer Versus");
		Button multiPlayerTogether = new Button("Play Together Versus CPU");
		buttonBox.getChildren().add(singlePlayer);
		buttonBox.getChildren().add(multiPlayerVersus);
		buttonBox.getChildren().add(multiPlayerTogether);
		buttonBox.setAlignment(Pos.CENTER);
		
		MainMenu.setTop(buttonBox);
		
		List<String> selectedTeam = new ArrayList<>();
	
		HBox pokemonPool = new HBox(15);
		
		List<String> pokemonStrs = new ArrayList<>(Arrays.asList("pikachu", "charmander", "squirtle", "bulbasaur", "jigglypuff", "yoshi", "poliwhirl", "gloom", "psyduck", "goldeen", "dratini", "meowth"));
		for (String poke : pokemonStrs) {
			Button button = new Button();
			Image image = new Image(getClass().getResourceAsStream("/sprites/pokemon/" + poke + ".png"));
			ImageView imageView = new ImageView(image);
			imageView.setFitHeight(70);
			imageView.setFitWidth(70);
		
//			imageView.setPreserveRatio(true);
			button.setGraphic(imageView);
			button.setStyle("-fx-background-color: transparent;");
			
			button.setOnAction(e -> {
				if (selectedTeam.contains(poke)) {
					selectedTeam.remove(poke);
					imageView.setFitHeight(70);
					imageView.setFitWidth(70);
				} else {
					if (selectedTeam.size() < 3) {
						selectedTeam.add(poke);
						imageView.setFitHeight(80);
						imageView.setFitWidth(80);
					} else {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Too many Pokemon!");
						alert.setHeaderText("Too many Pokemon");
						alert.setContentText("Deselect a Pokemon before adding a new one");
						alert.show();
					}
					
				}
			});
			
			pokemonPool.getChildren().add(button);
		}
		
		pokemonPool.setAlignment(Pos.CENTER);
		MainMenu.setCenter(pokemonPool);

		VBox acceptBox = new VBox(10);
		Label acceptLabel = new Label("Select this team?");
		Button acceptBtn = new Button("Accept");
		acceptBox.getChildren().add(acceptLabel);
		acceptBox.getChildren().add(acceptBtn);
		acceptBox.setAlignment(Pos.CENTER);
		MainMenu.setBottom(acceptBox);
		
		String imgPath = "";
		
		BorderPane BattleViewSinglePlayer = new BorderPane();
		HBox player1 = new HBox(200);
		
		VBox team = new VBox(40);
		Image trainerImage = new Image("/sprites/trainers/lance.png");
		ImageView trainerView = new ImageView(trainerImage);
		trainerView.setFitWidth(200);
		trainerView.setPreserveRatio(true);
		HBox activeTeam = new HBox(20);
		Button firstSwapBtn = new Button("Swap");
		firstSwapBtn.setOnAction(e ->{
			
		});
		Button secondSwapBtn = new Button("Swap");
		secondSwapBtn.setOnAction(e ->{
			
		});
		Button thirdSwapBtn = new Button("Swap");
		thirdSwapBtn.setOnAction(e -> {
			
		});
		activeTeam.getChildren().addAll(firstSwapBtn,secondSwapBtn,thirdSwapBtn);
		team.getChildren().addAll(trainerView,activeTeam);
		
		Image activeCreatureImage = new Image("/sprites/pokemon/pikachu.png");
		ImageView activeCreatureView = new ImageView(activeCreatureImage);
		
		VBox clickableMoves = new VBox(20);
		HBox topRowMoves = new HBox(20);
		HBox botRowMoves = new HBox(20);
		Button move1 = new Button("Move1");
		Button move2 = new Button("Move2");
		Button move3 = new Button("Move3");
		Button move4 = new Button("Move4");
		topRowMoves.getChildren().addAll(move1, move2);
		botRowMoves.getChildren().addAll(move3,move4);
		clickableMoves.getChildren().addAll(topRowMoves,botRowMoves);
		
		player1.getChildren().addAll(team,activeCreatureView,clickableMoves);
		BattleViewSinglePlayer.setBottom(player1);
		
		
		
		BorderPane progressionMenu = new BorderPane();
		HBox levelsBox = new HBox(120);
		Button easyBtn = new Button("Easy");
		easyBtn.setOnAction(e -> {
			Scene battleScene = new Scene(BattleViewSinglePlayer, 1280,720);
			stage.setScene(battleScene);
			stage.setTitle("pokimon");
			stage.show();
		});
		
		Button mediumBtn = new Button("Medium");
		mediumBtn.setOnAction(e ->{
		
		});
		
		Button hardBtn = new Button("Hard");
		hardBtn.setOnAction(e ->{
			
		});
		levelsBox.getChildren().addAll(easyBtn, mediumBtn, hardBtn);
		levelsBox.setAlignment(Pos.CENTER);
		progressionMenu.setCenter(levelsBox);
		
		
		singlePlayer.setOnAction(e -> {
			if (selectedTeam.size() == 3)  {
				TextInputDialog namePrompt = new TextInputDialog("Name");
				
				namePrompt.setTitle("Name prompt");
				namePrompt.setHeaderText("Enter your name");
				namePrompt.setContentText("Enter your name");
				
				Optional<String> input = namePrompt.showAndWait();
				if (input.isPresent()) {
					String inputStr = input.get();
					initializeGame(inputStr, selectedTeam);

				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Error");
					alert.setHeaderText("Enter your name");
					alert.setContentText("Please enter your name");
					alert.show();
				}
				
				Scene progressionScene = new Scene(progressionMenu, 1280, 720);
				stage.setScene(progressionScene);
				stage.setTitle("Progression");
				stage.show();
			}
			else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Member");
				alert.setHeaderText("Too little pokemone");
				alert.setContentText("Please select 3 pokemone");
				alert.show();
			}
			
		});
		
		Scene scene = new Scene(MainMenu, 1280,720);
		stage.setScene(scene);
		stage.setTitle("Pokemen");
		stage.show();
	}
	
	public void initializeGame(String name, List<String> pokemonStrs) {
		System.out.println("initializing game\n");
		controller.createSelfTeam(name, pokemonStrs);
		controller.createComputerTeam();
		
		
	}
	
	public void initializeBattle() {
		
	}
	
	public void initializeProgression() {
		
	}

}

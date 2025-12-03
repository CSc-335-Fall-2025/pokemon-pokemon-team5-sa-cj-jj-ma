import java.util.ArrayList;
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
		Button pikachuBtn = new Button();
		Image pikachuImage = new Image(getClass().getResourceAsStream("/sprites/pokemon/pikachu.png"));
		ImageView pikachuImageView = new ImageView(pikachuImage);
		pikachuImageView.setFitHeight(70);
		pikachuImageView.setFitWidth(70);
	
		
		pikachuBtn.setGraphic(pikachuImageView);
		pikachuBtn.setStyle("-fx-background-color: transparent;");
		
		pikachuBtn.setOnAction(e -> {
			if (selectedTeam.contains("pikachu")) {
				selectedTeam.remove("pikachu");
				pikachuImageView.setFitHeight(70);
				pikachuImageView.setFitWidth(70);
			} else {
				if (selectedTeam.size() < 3) {
					selectedTeam.add("pikachu");
					pikachuImageView.setFitHeight(80);
					pikachuImageView.setFitWidth(80);
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Too many Pokemon!");
					alert.setHeaderText("Too many Pokemon");
					alert.setContentText("Deselect a Pokemon before adding a new one");
					alert.show();
				}
				
			}
		});
		
		Button charmanderBtn = new Button();
		Image charmanderImage = new Image(getClass().getResourceAsStream("/sprites/pokemon/charmander.png"));
		ImageView charmanderImageView = new ImageView(charmanderImage);
		charmanderImageView.setFitHeight(70);
		charmanderImageView.setFitWidth(70);
	
		
		charmanderBtn.setGraphic(charmanderImageView);
		charmanderBtn.setStyle("-fx-background-color: transparent;");
		
		charmanderBtn.setOnAction(e -> {
			if (selectedTeam.contains("charmander")) {
				selectedTeam.remove("charmander");
				charmanderImageView.setFitHeight(70);
				charmanderImageView.setFitWidth(70);
			} else {
				if (selectedTeam.size() < 3) {
					selectedTeam.add("charmander");
					charmanderImageView.setFitHeight(80);
					charmanderImageView.setFitWidth(80);
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Too many Pokemon!");
					alert.setHeaderText("Too many Pokemon");
					alert.setContentText("Deselect a Pokemon before adding a new one");
					alert.show();
				}
				
			}
		});
		Button dratiniBtn = new Button();
		Image dratiniImage = new Image(getClass().getResourceAsStream("/sprites/pokemon/dratini.png"));
		ImageView dratiniImageView = new ImageView(dratiniImage);
		dratiniImageView.setFitHeight(70);
		dratiniImageView.setFitWidth(70);
	
		
		dratiniBtn.setGraphic(dratiniImageView);
		dratiniBtn.setStyle("-fx-background-color: transparent;");
		
		dratiniBtn.setOnAction(e -> {
			if (selectedTeam.contains("dratini")) {
				selectedTeam.remove("dratini");
				dratiniImageView.setFitHeight(70);
				dratiniImageView.setFitWidth(70);
			} else {
				if (selectedTeam.size() < 3) {
					selectedTeam.add("dratini");
					dratiniImageView.setFitHeight(80);
					dratiniImageView.setFitWidth(80);
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Too many Pokemon!");
					alert.setHeaderText("Too many Pokemon");
					alert.setContentText("Deselect a Pokemon before adding a new one");
					alert.show();
				}
				
			}
		});
		Button gloomBtn = new Button();
		Image gloomImage = new Image(getClass().getResourceAsStream("/sprites/pokemon/gloom.png"));
		ImageView gloomImageView = new ImageView(gloomImage);
		gloomImageView.setFitHeight(70);
		gloomImageView.setFitWidth(70);
	
		
		gloomBtn.setGraphic(gloomImageView);
		gloomBtn.setStyle("-fx-background-color: transparent;");
		
		gloomBtn.setOnAction(e -> {
			if (selectedTeam.contains("gloom")) {
				selectedTeam.remove("gloom");
				gloomImageView.setFitHeight(70);
				gloomImageView.setFitWidth(70);
			} else {
				if (selectedTeam.size() < 3) {
					selectedTeam.add("gloom");
					gloomImageView.setFitHeight(80);
					gloomImageView.setFitWidth(80);
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Too many Pokemon!");
					alert.setHeaderText("Too many Pokemon");
					alert.setContentText("Deselect a Pokemon before adding a new one");
					alert.show();
				}
				
			}
		});
		Button goldeenBtn = new Button();
		Image goldeenImage = new Image(getClass().getResourceAsStream("/sprites/pokemon/goldeen.png"));
		ImageView goldeenImageView = new ImageView(goldeenImage);
		goldeenImageView.setFitHeight(70);
		goldeenImageView.setFitWidth(70);
	
		
		goldeenBtn.setGraphic(goldeenImageView);
		goldeenBtn.setStyle("-fx-background-color: transparent;");
		
		goldeenBtn.setOnAction(e -> {
			if (selectedTeam.contains("goldeen")) {
				selectedTeam.remove("goldeen");
				goldeenImageView.setFitHeight(70);
				goldeenImageView.setFitWidth(70);
			} else {
				if (selectedTeam.size() < 3) {
					selectedTeam.add("goldeen");
					goldeenImageView.setFitHeight(80);
					goldeenImageView.setFitWidth(80);
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Too many Pokemon!");
					alert.setHeaderText("Too many Pokemon");
					alert.setContentText("Deselect a Pokemon before adding a new one");
					alert.show();
				}
				
			}
		});
		Button jigglypuffBtn = new Button();
		Image jigglypuffImage = new Image(getClass().getResourceAsStream("/sprites/pokemon/jigglypuff.png"));
		ImageView jigglypuffImageView = new ImageView(jigglypuffImage);
		jigglypuffImageView.setFitHeight(70);
		jigglypuffImageView.setFitWidth(70);
	
		
		jigglypuffBtn.setGraphic(jigglypuffImageView);
		jigglypuffBtn.setStyle("-fx-background-color: transparent;");
		
		jigglypuffBtn.setOnAction(e -> {
			if (selectedTeam.contains("jigglypuff")) {
				selectedTeam.remove("jigglypuff");
				jigglypuffImageView.setFitHeight(70);
				jigglypuffImageView.setFitWidth(70);
			} else {
				if (selectedTeam.size() < 3) {
					selectedTeam.add("jigglypuff");
					jigglypuffImageView.setFitHeight(80);
					jigglypuffImageView.setFitWidth(80);
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Too many Pokemon!");
					alert.setHeaderText("Too many Pokemon");
					alert.setContentText("Deselect a Pokemon before adding a new one");
					alert.show();
				}
				
			}
		});
		Button meowthBtn = new Button();
		Image meowthImage = new Image(getClass().getResourceAsStream("/sprites/pokemon/meowth.png"));
		ImageView meowthImageView = new ImageView(meowthImage);
		meowthImageView.setFitHeight(70);
		meowthImageView.setFitWidth(70);
	
		
		meowthBtn.setGraphic(meowthImageView);
		meowthBtn.setStyle("-fx-background-color: transparent;");
		
		meowthBtn.setOnAction(e -> {
			if (selectedTeam.contains("meowth")) {
				selectedTeam.remove("meowth");
				meowthImageView.setFitHeight(70);
				meowthImageView.setFitWidth(70);
			} else {
				if (selectedTeam.size() < 3) {
					selectedTeam.add("meowth");
					meowthImageView.setFitHeight(80);
					meowthImageView.setFitWidth(80);
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Too many Pokemon!");
					alert.setHeaderText("Too many Pokemon");
					alert.setContentText("Deselect a Pokemon before adding a new one");
					alert.show();
				}
				
			}
		});
		Button poliwhirlBtn = new Button();
		Image poliwhirlImage = new Image(getClass().getResourceAsStream("/sprites/pokemon/poliwhirl.png"));
		ImageView poliwhirlImageView = new ImageView(poliwhirlImage);
		poliwhirlImageView.setFitHeight(70);
		poliwhirlImageView.setFitWidth(70);
	
		
		poliwhirlBtn.setGraphic(poliwhirlImageView);
		poliwhirlBtn.setStyle("-fx-background-color: transparent;");
		
		poliwhirlBtn.setOnAction(e -> {
			if (selectedTeam.contains("poliwhirl")) {
				selectedTeam.remove("poliwhirl");
				poliwhirlImageView.setFitHeight(70);
				poliwhirlImageView.setFitWidth(70);
			} else {
				if (selectedTeam.size() < 3) {
					selectedTeam.add("poliwhirl");
					poliwhirlImageView.setFitHeight(80);
					poliwhirlImageView.setFitWidth(80);
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Too many Pokemon!");
					alert.setHeaderText("Too many Pokemon");
					alert.setContentText("Deselect a Pokemon before adding a new one");
					alert.show();
				}
				
			}
		});
		Button psyduckBtn = new Button();
		Image psyduckImage = new Image(getClass().getResourceAsStream("/sprites/pokemon/psyduck.png"));
		ImageView psyduckImageView = new ImageView(psyduckImage);
		psyduckImageView.setFitHeight(70);
		psyduckImageView.setFitWidth(70);
	
		
		psyduckBtn.setGraphic(psyduckImageView);
		psyduckBtn.setStyle("-fx-background-color: transparent;");
		
		psyduckBtn.setOnAction(e -> {
			if (selectedTeam.contains("psyduck")) {
				selectedTeam.remove("psyduck");
				psyduckImageView.setFitHeight(70);
				psyduckImageView.setFitWidth(70);
			} else {
				if (selectedTeam.size() < 3) {
					selectedTeam.add("psyduck");
					psyduckImageView.setFitHeight(80);
					psyduckImageView.setFitWidth(80);
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Too many Pokemon!");
					alert.setHeaderText("Too many Pokemon");
					alert.setContentText("Deselect a Pokemon before adding a new one");
					alert.show();
				}
				
			}
		});
		Button squirtleBtn = new Button();
		Image squirtleImage = new Image(getClass().getResourceAsStream("/sprites/pokemon/squirtle.png"));
		ImageView squirtleImageView = new ImageView(squirtleImage);
		squirtleImageView.setFitHeight(70);
		squirtleImageView.setFitWidth(70);
	
		
		squirtleBtn.setGraphic(squirtleImageView);
		squirtleBtn.setStyle("-fx-background-color: transparent;");
		
		squirtleBtn.setOnAction(e -> {
			if (selectedTeam.contains("squirtle")) {
				selectedTeam.remove("squirtle");
				squirtleImageView.setFitHeight(70);
				squirtleImageView.setFitWidth(70);
			} else {
				if (selectedTeam.size() < 3) {
					selectedTeam.add("squirtle");
					squirtleImageView.setFitHeight(80);
					squirtleImageView.setFitWidth(80);
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Too many Pokemon!");
					alert.setHeaderText("Too many Pokemon");
					alert.setContentText("Deselect a Pokemon before adding a new one");
					alert.show();
				}
				
			}
		});
		Button yoshiBtn = new Button();
		Image yoshiImage = new Image(getClass().getResourceAsStream("/sprites/pokemon/yoshi.png"));
		ImageView yoshiImageView = new ImageView(yoshiImage);
		yoshiImageView.setFitHeight(50);
		yoshiImageView.setFitWidth(60);
	
		
		yoshiBtn.setGraphic(yoshiImageView);
		yoshiBtn.setStyle("-fx-background-color: transparent;");
		
		yoshiBtn.setOnAction(e -> {
			if (selectedTeam.contains("yoshi")) {
				selectedTeam.remove("yoshi");
				yoshiImageView.setFitHeight(50);
				yoshiImageView.setFitWidth(60);
			} else {
				if (selectedTeam.size() < 3) {
					selectedTeam.add("yoshi");
					yoshiImageView.setFitHeight(60);
					yoshiImageView.setFitWidth(70);
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Too many Pokemon!");
					alert.setHeaderText("Too many Pokemon");
					alert.setContentText("Deselect a Pokemon before adding a new one");
					alert.show();
				}
				
			}
		});
		Button bulbasaurBtn = new Button();
		Image bulbasaurImage = new Image(getClass().getResourceAsStream("/sprites/pokemon/bulbasaur.png"));
		ImageView bulbasaurImageView = new ImageView(bulbasaurImage);
		bulbasaurImageView.setFitHeight(70);
		bulbasaurImageView.setFitWidth(70);
	
		
		bulbasaurBtn.setGraphic(bulbasaurImageView);
		bulbasaurBtn.setStyle("-fx-background-color: transparent;");
		
		bulbasaurBtn.setOnAction(e -> {
			if (selectedTeam.contains("bulbasaur")) {
				selectedTeam.remove("bulbasaur");
				bulbasaurImageView.setFitHeight(70);
				bulbasaurImageView.setFitWidth(70);
			} else {
				if (selectedTeam.size() < 3) {
					selectedTeam.add("bulbasaur");
					bulbasaurImageView.setFitHeight(80);
					bulbasaurImageView.setFitWidth(80);
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Too many Pokemon!");
					alert.setHeaderText("Too many Pokemon");
					alert.setContentText("Deselect a Pokemon before adding a new one");
					alert.show();
				}
				
			}
		});
		
		pokemonPool.getChildren().add(pikachuBtn);
		pokemonPool.getChildren().add(charmanderBtn);
		pokemonPool.getChildren().add(dratiniBtn);
		pokemonPool.getChildren().add(gloomBtn);
		pokemonPool.getChildren().add(goldeenBtn);
		pokemonPool.getChildren().add(jigglypuffBtn);
		pokemonPool.getChildren().add(meowthBtn);
		pokemonPool.getChildren().add(poliwhirlBtn);
		pokemonPool.getChildren().add(psyduckBtn);
		pokemonPool.getChildren().add(squirtleBtn);
		pokemonPool.getChildren().add(yoshiBtn);
		pokemonPool.getChildren().add(bulbasaurBtn);

		pokemonPool.setAlignment(Pos.CENTER);
		MainMenu.setCenter(pokemonPool);

		VBox acceptBox = new VBox(10);
		Label acceptLabel = new Label("Select this team?");
		Button acceptBtn = new Button("Accept");
		acceptBox.getChildren().add(acceptLabel);
		acceptBox.getChildren().add(acceptBtn);
		acceptBox.setAlignment(Pos.CENTER);
		MainMenu.setBottom(acceptBox);
		
		
		
		BorderPane progressionMenu = new BorderPane();
		HBox levelsBox = new HBox(120);
		Button easyBtn = new Button("Easy");
		Button mediumBtn = new Button("Medium");
		Button hardBtn = new Button("Hard");
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
				initializeGame(selectedTeam, input);
				
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
	
	public void initializeGame(List<String> pokemonStrs, Optional<String> name) {
//		this.controller = new PokemonController(userInput, "Computer", pokemonStrs, 
		CreaturePool pool = new CreaturePool();
		List<String> randStrs = new ArrayList<>(pool.generateRandom());
		String nameStr = name.orElse("");
		controller = new PokemonController(nameStr, "computer", pokemonStrs, randStrs);
	}
	
	public void initializeBattle() {
		
	}
	
	public void initializeProgression() {
		
	}

}

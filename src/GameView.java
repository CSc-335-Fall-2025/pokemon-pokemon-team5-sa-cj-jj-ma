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
import model.Creature;
import model.CreaturePool;
//import model.CreaturePool;
import model.PokemonModel;

@SuppressWarnings("deprecation")
public class GameView extends Application implements Observer {
	
	private PokemonModel model;
	private PokemonController controller;
	
	private Scene scene;
	private BorderPane MainMenu;
	private Stage stage;
	
	private Scene progressionScene;
	private BorderPane progressionMenu;
	
	private Scene battleScene;
	private BorderPane BattleViewSinglePlayer;
	
	private Image activeCreatureImage1;
	private ImageView activeCreatureView1;
	private VBox nameAndHealth1;
	private Label pokeName1;
	private HBox healthAndLabel1;
	private Label healthLabel1;
	private Label health1;
	
	private VBox clickableMoves;
	private HBox topRowMoves;
	private HBox botRowMoves;
	private Button move1;
	private Button move2;
	private Button move3;
	private Button move4;
	
	private VBox team2;
	private Image trainerImage2;
	private ImageView trainerView2;
	private HBox activeTeam2;
	private Image activePokemon4;
	private ImageView ap4;
	private Image activePokemon5;
	private ImageView ap5;
	private Image activePokemon6;
	private ImageView ap6;
	
	private Image activeCreatureImage2;
	private ImageView activeCreatureView2;
	private VBox nameAndHealth2;
	private Label pokeName2;
	private HBox healthAndLabel2;
	private Label healthLabel2;
	private Label health2;
	
	private Image swapBut1;
	private ImageView swapButView1;
	private Image swapBut2; 
	private ImageView swapButView2;
	private Image swapBut3;
	private ImageView swapButView3;

	private boolean playedOnce;
	@Override
	public void start(Stage stage) throws Exception {
		model = new PokemonModel();
		controller = new PokemonController(model);
		model.addObserver(this);
		playedOnce = false;
//		controller.createComputerTeam();
//		List<String> initialList = new ArrayList<>();
//		initialList.add("pikachu");
//		initialList.add("pikachu");
//		initialList.add("pikachu");
//		controller.createSelfTeam("Ashe", initialList);
		
		MainMenu = new BorderPane();
		this.stage = stage;
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
				Image image = new Image("/sprites/pokemon/" + poke + ".png");
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
		
		BattleViewSinglePlayer = new BorderPane();
		HBox player1 = new HBox(200);
		
		VBox team = new VBox(40);
		Image trainerImage = new Image("/sprites/trainers/lance.png");
		ImageView trainerView = new ImageView(trainerImage);
		trainerView.setFitWidth(200);
		trainerView.setPreserveRatio(true);
		HBox activeTeam = new HBox(20);
		
		
		Button firstSwapBtn = new Button();
		swapBut1 = new Image("/sprites/trainers/lance.png");
		swapButView1 = new ImageView(swapBut1);
		firstSwapBtn.setGraphic(swapButView1);
		firstSwapBtn.setStyle("-fx-background-color: transparent;");
		firstSwapBtn.setOnAction(e ->{
			controller.getTrainer1().manualSwap(controller.getTrainer1().getCreature1());
			update(model, null);

		});
		
		Button secondSwapBtn = new Button();
		swapBut2 = new Image("/sprites/trainers/lance.png");
		swapButView2 = new ImageView(swapBut2);
		secondSwapBtn.setGraphic(swapButView2);
		secondSwapBtn.setStyle("-fx-background-color: transparent;");
		secondSwapBtn.setOnAction(e ->{
			controller.getTrainer1().manualSwap(controller.getTrainer1().getCreature2());
			update(model, null);

		});
		
		swapBut3 = new Image("/sprites/trainers/lance.png");
		swapButView3 = new ImageView(swapBut3);
		Button thirdSwapBtn = new Button();
		thirdSwapBtn.setGraphic(swapButView3);
		thirdSwapBtn.setStyle("-fx-background-color: transparent;");
		thirdSwapBtn.setOnAction(e -> {
			controller.getTrainer1().manualSwap(controller.getTrainer1().getCreature3());
			update(model, null);
		});
		
		activeTeam.getChildren().addAll(firstSwapBtn,secondSwapBtn,thirdSwapBtn);
		team.getChildren().addAll(trainerView,activeTeam);
		
		activeCreatureImage1 = new Image("/sprites/pokemon/bulbasaur.png");
		activeCreatureView1 = new ImageView(activeCreatureImage1);
		
		nameAndHealth1 = new VBox(20);
		pokeName1 = new Label("Default name");
		healthAndLabel1 = new HBox(20);
		healthLabel1 = new Label("Health: ");
		health1 = new Label("Default health");
		healthAndLabel1.getChildren().addAll(healthLabel1, health1);
		nameAndHealth1.getChildren().addAll(pokeName1, healthAndLabel1);
		
		clickableMoves = new VBox(20);
		topRowMoves = new HBox(20);
		botRowMoves = new HBox(20);
		move1 = new Button("Move1");
		move1.setOnAction(e -> {
			controller.playerTurn(controller.getTrainer1().getActiveCreature().getMoves().get(0).getName());
			controller.computerTurn();
			update(model, null);
		});
		move2 = new Button("Move2");
		move2.setOnAction(e -> {
			controller.playerTurn(controller.getTrainer1().getActiveCreature().getMoves().get(1).getName());
			controller.computerTurn();
			update(model, null);
		});
		move3 = new Button("Move3");
		move3.setOnAction(e -> {
			controller.playerTurn(controller.getTrainer1().getActiveCreature().getMoves().get(2).getName());
			controller.computerTurn();
			update(model, null);
		});
		move4 = new Button("Move4");
		move4.setOnAction(e -> {
			controller.playerTurn(controller.getTrainer1().getActiveCreature().getMoves().get(3).getName());
			controller.computerTurn();
			update(model, null);
		});
		topRowMoves.getChildren().addAll(move1, move2);
		botRowMoves.getChildren().addAll(move3,move4);
		clickableMoves.getChildren().addAll(topRowMoves,botRowMoves);
		
		player1.getChildren().addAll(team,activeCreatureView1, nameAndHealth1, clickableMoves);
		
		HBox player2 = new HBox(200);
		
		nameAndHealth2 = new VBox(20);
		pokeName2 = new Label("Default name");
		healthAndLabel2 = new HBox(20);
		healthLabel2 = new Label("Health: ");
		health2 = new Label("Default health");
		healthAndLabel2.getChildren().addAll(healthLabel2, health2);
		nameAndHealth2.getChildren().addAll(pokeName2, healthAndLabel2);
		
		activeCreatureImage2 = new Image("/sprites/pokemon/pikachu.png");
		activeCreatureView2 = new ImageView(activeCreatureImage2);
		
		team2 = new VBox(20);
		trainerImage2 = new Image("/sprites/trainers/soa.png");
		trainerView2 = new ImageView(trainerImage2);
		activeTeam2 = new HBox(20);
		activePokemon4 = new Image("/sprites/trainers/soa.png");
		ap4 = new ImageView(trainerImage2);
		activePokemon5 = new Image("/sprites/trainers/soa.png");
		ap5 = new ImageView(trainerImage2);
		activePokemon6 = new Image("/sprites/trainers/soa.png");
		ap6 = new ImageView(trainerImage2);
		activeTeam2.getChildren().addAll(ap4,ap5,ap6);
		team2.getChildren().addAll(trainerView2,activeTeam2);
		player2.getChildren().addAll(nameAndHealth2,activeCreatureView2,team2);
		
		BattleViewSinglePlayer.setBottom(player1);
		BattleViewSinglePlayer.setTop(player2);
		
		progressionMenu = new BorderPane();
		HBox levelsBox = new HBox(120);
		Button easyBtn = new Button("Easy");
		easyBtn.setOnAction(e -> {
			trainerImage2 = new Image("/sprites/trainers/soa.png");
			trainerView2.setImage(trainerImage2);
			if (!playedOnce) {
				battleScene = new Scene(BattleViewSinglePlayer, 1280,720);
			}
			controller.setDifficulty(0);
			stage.setScene(battleScene);
			stage.setTitle("pokimon");
			stage.show();
			
		});
		
		Button mediumBtn = new Button("Medium");
		mediumBtn.setOnAction(e ->{
			trainerImage2 = new Image("/sprites/trainers/lunick.png");
			trainerView2.setImage(trainerImage2);
			if (!playedOnce) {
				battleScene = new Scene(BattleViewSinglePlayer, 1280,720);
			}
			stage.setScene(battleScene);
			stage.setTitle("pokimon");
			stage.show();
		});
		
		Button hardBtn = new Button("Hard");
		hardBtn.setOnAction(e ->{
			trainerImage2 = new Image("/sprites/trainers/solana.png");
			trainerView2.setImage(trainerImage2);
			if (!playedOnce) {
				battleScene = new Scene(BattleViewSinglePlayer, 1280,720);
			}
			controller.setDifficulty(2);
			stage.setScene(battleScene);
			stage.setTitle("pokimon");
			stage.show();
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
				
				if (!playedOnce) {
					progressionScene = new Scene(progressionMenu, 1280, 720);
				}
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
		
		scene = new Scene(MainMenu, 1280,720);
		stage.setScene(scene);
		stage.setTitle("Pokemen");
		stage.show();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println(controller.getTrainer1().getActiveCreature().getPath());
		System.out.println(controller.getTrainer3().getActiveCreature().getPath());
		
		activeCreatureImage1 = new Image(controller.getTrainer1().getActiveCreature().getPath());
		activeCreatureView1.setImage(activeCreatureImage1);
		
		pokeName1.setText(controller.getTrainer1().getActiveCreature().getName());
		health1.setText(Integer.toString(controller.getTrainer1().getActiveCreature().getHealth()));
		
		for (Creature c : controller.getTrainer3().getTeam()) {
			System.out.println(c);

		}

		activePokemon4 = new Image(controller.getTrainer3().getCreature1().getPath());
		ap4.setImage(activePokemon4);
		activePokemon5 = new Image(controller.getTrainer3().getCreature2().getPath());
		ap5.setImage(activePokemon5);
		activePokemon6 = new Image(controller.getTrainer3().getCreature3().getPath());
		ap6.setImage(activePokemon6);
		
		activeCreatureImage2 = new Image(controller.getTrainer3().getActiveCreature().getPath());
		activeCreatureView2.setImage(activeCreatureImage2);
		
		pokeName2.setText(controller.getTrainer3().getActiveCreature().getName());
		health2.setText(Integer.toString(controller.getTrainer3().getActiveCreature().getHealth()));
		
		swapBut1 = new Image(controller.getTrainer1().getCreature1().getPath());
		swapButView1.setImage(swapBut1);
		
		swapBut2 = new Image(controller.getTrainer1().getCreature2().getPath());
		swapButView2.setImage(swapBut2);
		
		swapBut3 = new Image(controller.getTrainer1().getCreature3().getPath());
		swapButView3.setImage(swapBut3);
		
		System.out.println(controller.getTrainer1().getActiveCreature().getMoves().get(0));
		move1.setText(controller.getTrainer1().getActiveCreature().getMoves().get(0).getName());
		move2.setText(controller.getTrainer1().getActiveCreature().getMoves().get(1).getName());
		move3.setText(controller.getTrainer1().getActiveCreature().getMoves().get(2).getName());
		move4.setText(controller.getTrainer1().getActiveCreature().getMoves().get(3).getName());
		
		if (controller.isBattleOver()) {
			System.out.println("Game over");
			playedOnce = true;
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Someone Won!");
			alert.setHeaderText(null);
			alert.setContentText(controller.getWinner());
			alert.showAndWait();
			stage.close();
		}
	}
	
	public void initializeGame(String name, List<String> pokemonStrs) {
		System.out.println("initializing game\n");
		controller.createSelfTeam(name, pokemonStrs);
		controller.createComputerTeam();
		System.out.println("Path HELPPPPP: " + controller.getTrainer1().getName());

		
		update(model, null);
		
	}

}

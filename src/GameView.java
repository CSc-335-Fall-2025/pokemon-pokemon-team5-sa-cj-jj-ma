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
import model.Move;
//import model.CreaturePool;
import model.PokemonModel;
import model.Trainer;

@SuppressWarnings("deprecation")
public class GameView extends Application implements Observer {
	
	private PokemonModel model;
	private PokemonController controller;
	
	private Scene scene;
	private BorderPane MainMenu;
	private Stage stage;
	private Stage originalStage;
	private Scene multiplayerPick;
	private Scene progressionScene;
	private BorderPane progressionMenu;
	private Scene localMultiplayerView;
	
	private Scene battleScene;
	
	private Image activeCreatureImage1;
	private ImageView activeCreatureView1;
	private VBox nameAndHealth1;
	private Label pokeName1;
	private HBox healthAndLabel1;
	private Label healthLabel1;
	private Label health1;
	private List<String> pokemonStrs;
	private List<String> secondSelected = new ArrayList<>();
	private List<String> selectedTeam = new ArrayList<>();
	
	private VBox clickableMoves;
	private HBox topRowMoves;
	private HBox botRowMoves;
	private TextInputDialog namePrompt;
	private TextInputDialog namePrompt2;
	
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

	private String input1;

	private VBox clickableMoves2;
	private HBox topRowMoves2;
	private HBox botRowMoves2;
	
	private int battleMode = 0;
	
	private HBox activeTeam;
	private List<Button> player1SwapBtns = new ArrayList<>();
	private List<Button> player1MoveBtns = new ArrayList<>();
	private List<Button> player2SwapBtns = new ArrayList<>();
	private List<Button> player2MoveBtns = new ArrayList<>();
	private HBox player1;
	private HBox player2;
	private VBox team;
	private Image trainerImage;
	private ImageView trainerView;
	private BorderPane battleView;
	private HBox inactiveTeam2;
	
	@Override
	public void start(Stage stage) throws Exception {
		this.originalStage = stage;
		initializeProgram();
	}
	
	public void refresh() {
		selectedTeam.clear();
		secondSelected.clear();
		model = null;
		model = new PokemonModel();
		controller = null;
		controller = new PokemonController(model);
		model.addObserver(this);
	}
	public void initializeProgram() {
		System.out.println("initializing program...");
		// initializeProgram
//		playedOnce = false;
		refresh();
		// CreateMainMenu
		MainMenu = new BorderPane();
		this.stage = originalStage;
		HBox buttonBox = new HBox(20);
		Button singlePlayer = new Button("Single Player");
		Button localMultiplayer = new Button("Local Multiplayer");
		Button multiplayerOnline = new Button("Multiplayer Online");
		buttonBox.getChildren().add(singlePlayer);
		buttonBox.getChildren().add(localMultiplayer);
		buttonBox.getChildren().add(multiplayerOnline);
		buttonBox.setAlignment(Pos.CENTER);
		
		MainMenu.setTop(buttonBox);
		
		selectedTeam = new ArrayList<>();
	
		HBox pokemonPool = new HBox(15);
		
		pokemonStrs = new ArrayList<>(Arrays.asList("pikachu", "charmander", "squirtle", "bulbasaur", "jigglypuff", "yoshi", "poliwhirl", "gloom", "psyduck", "goldeen", "dratini", "meowth"));
			
		// Create initial pool of Pokemon for selecting
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
		
		
		// Create progression menu with three different difficulties
		progressionMenu = new BorderPane();
		HBox levelsBox = new HBox(120);
		
		String[] diffLabels = {"Easy", "Medium", "Hard"};
		String[] diffSprites = {"/sprites/trainers/soa.png", "/sprites/trainers/lunick.png", "/sprites/trainers/solana.png"};
		for (int i = 0; i < 3; i++) {
			final int difficulty = i;
			
			Button difficultyBtn = new Button(diffLabels[difficulty]);
			difficultyBtn.setOnAction(e -> {
				
//				if (!playedOnce) {
				battleScene = new Scene(getBattleView(false), 1280,720);
				
				initializeSinglePlayer(input1, selectedTeam);
				controller.setDifficulty(difficulty);
				
				trainerImage2 = new Image(diffSprites[difficulty]);
				trainerView2.setImage(trainerImage2);
				update(model, null);
				stage.setScene(battleScene);
				stage.setTitle("pokimon");
				stage.show();
				
			});
			
			levelsBox.getChildren().add(difficultyBtn);

		}
		
		levelsBox.setAlignment(Pos.CENTER);
		progressionMenu.setCenter(levelsBox);
		
		singlePlayer.setOnAction(e -> {
			if (selectedTeam.size() == 3)  {
				namePrompt = new TextInputDialog("Name");
				
				namePrompt.setTitle("Name prompt");
				namePrompt.setHeaderText("Enter your name");
				namePrompt.setContentText("Enter your name");
				
				Optional<String> input = namePrompt.showAndWait();
				if (input.isPresent()) {
					String inputStr = input.get();
					input1 = inputStr;
					battleMode = 1;
					progressionScene = new Scene(progressionMenu, 1280, 720);
					stage.setScene(progressionScene);
					stage.setTitle("Progression");
					stage.show();

				} else {
					
				}
			
			}
			else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Member");
				alert.setHeaderText("Too little pokemone");
				alert.setContentText("Please select 3 pokemone");
				alert.show();
			}
			
		});
		
		localMultiplayer.setOnAction(e->{
			if (selectedTeam.size() == 3)  {
				namePrompt = new TextInputDialog("Name");
				
				namePrompt.setTitle("Name prompt");
				namePrompt.setHeaderText("Enter your name");
				namePrompt.setContentText("Enter your name");
				
				Optional<String> input = namePrompt.showAndWait();
				if (input.isPresent()) {
					String inputStr = input.get();
					input1 = inputStr;
//					initializeSinglePlayer(inputStr, selectedTeam);
					multiplayerPick = new Scene(secondPlayerPicking(), 1280, 720);
					stage.setScene(multiplayerPick);
					stage.setTitle("Second Player Picks");
					stage.show();

				} else {
					
				}
			
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
		System.out.println(controller.getTrainer2().getActiveCreature().getPath());
		
		activeCreatureImage1 = new Image(controller.getTrainer1().getActiveCreature().getPath());
		activeCreatureView1.setImage(activeCreatureImage1);
		
		pokeName1.setText(controller.getTrainer1().getActiveCreature().getName());
		health1.setText(Integer.toString(controller.getTrainer1().getActiveCreature().getHealth()));
		
		for (Creature c : controller.getTrainer2().getTeam()) {
			System.out.println(c);

		}
		
		debug();

		if (battleMode == 1) {
			activePokemon4 = new Image(controller.getTrainer2().getCreature1().getPath());
			ap4.setImage(activePokemon4);
			activePokemon5 = new Image(controller.getTrainer2().getCreature2().getPath());
			ap5.setImage(activePokemon5);
			activePokemon6 = new Image(controller.getTrainer2().getCreature3().getPath());
			ap6.setImage(activePokemon6);
		}
		
		
		activeCreatureImage2 = new Image(controller.getTrainer2().getActiveCreature().getPath());
		activeCreatureView2.setImage(activeCreatureImage2);
		
		pokeName2.setText(controller.getTrainer2().getActiveCreature().getName());
		System.out.println("NEW PRINT" + controller.getTrainer2().getActiveCreature().getHealth());
		health2.setText(Integer.toString(controller.getTrainer2().getActiveCreature().getHealth()));
		
		for (int i = 0; i < player1SwapBtns.size(); i++) {
			Image swapImg = new Image(controller.getTrainer1().getTeam().get(i).getPath());
			ImageView swapImgView = (ImageView) player1SwapBtns.get(i).getGraphic();
			swapImgView.setImage(swapImg);
		}
		
		if (battleMode == 2) {
			for (int i = 0; i < player2SwapBtns.size(); i++) {
				Image swapImg = new Image(controller.getTrainer2().getTeam().get(i).getPath());
				ImageView swapImgView = (ImageView) player2SwapBtns.get(i).getGraphic();
				swapImgView.setImage(swapImg);
			}		
			
		}
		
		for (int i = 0; i < player1MoveBtns.size(); i++) {
			player1MoveBtns.get(i).setText(controller.getTrainer1().getActiveCreature().getMoves().get(i).getName());
		}
		
		if (battleMode == 2) {
			for (int i = 0; i < player2MoveBtns.size(); i++) {
				player2MoveBtns.get(i).setText(controller.getTrainer2().getActiveCreature().getMoves().get(i).getName());
			}
		}
		
		if (controller.getCurrTurn() == 1) {
			for (Button b : player1MoveBtns) {
				b.setDisable(false);
			}
			
			for (Button b : player2MoveBtns) {
				b.setDisable(true);
			}
			
			for (Button b : player1SwapBtns) {
				b.setDisable(false);
			}
			
			for (Button b : player2SwapBtns) {
				b.setDisable(true);
			}
		} else if (controller.getCurrTurn() == 2) {
			for (Button b : player1MoveBtns) {
				b.setDisable(true);
			}
			
			for (Button b : player2MoveBtns) {
				b.setDisable(false);
			}
			
			for (Button b : player1SwapBtns) {
				b.setDisable(true);
			}
			
			for (Button b : player2SwapBtns) {
				b.setDisable(false);
			}
		}
		

		if (controller.isBattleOver()) {
			debug();
			System.out.println("Game over");
//			playedOnce = true;
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Someone Won!");
			alert.setHeaderText(null);
			alert.setContentText(controller.getWinner());
			alert.showAndWait();
			controller.resetAllHealth();

			initializeProgram();
			
		}
		
	}
	
	public void debug() {
		System.out.println("team1:");
		System.out.println(controller.getTrainer1().getCreature1().getName() + " : " + controller.getTrainer1().getCreature1().getHealth());
		System.out.println(controller.getTrainer1().getCreature2().getName() + " : " + controller.getTrainer1().getCreature2().getHealth());
		System.out.println(controller.getTrainer1().getCreature3().getName() + " : " + controller.getTrainer1().getCreature3().getHealth());
		
		System.out.println("team2:");
		System.out.println(controller.getTrainer2().getCreature1().getName() + " : " + controller.getTrainer2().getCreature1().getHealth());
		System.out.println(controller.getTrainer2().getCreature2().getName() + " : " + controller.getTrainer2().getCreature2().getHealth());
		System.out.println(controller.getTrainer2().getCreature3().getName() + " : " + controller.getTrainer2().getCreature3().getHealth());
	}
	
	public void initializeSinglePlayer(String name, List<String> pokemonStrs) {
		System.out.println("initializing game\n");
		controller.createTeam(name, pokemonStrs, 1);
		controller.createComputerTeam(pokemonStrs);

		initializeSwapBtns(controller.getTrainer1(), activeTeam, player1SwapBtns);
		team.getChildren().addAll(trainerView,activeTeam);
		
		team2.getChildren().addAll(trainerView2, inactiveTeam2);
		initializeMoveBtns(controller.getTrainer1(), player1MoveBtns, battleMode);
		topRowMoves.getChildren().addAll(player1MoveBtns.get(0), player1MoveBtns.get(1));
		botRowMoves.getChildren().addAll(player1MoveBtns.get(2), player1MoveBtns.get(3));
		clickableMoves.getChildren().addAll(topRowMoves,botRowMoves);
		
		player1.getChildren().addAll(team,activeCreatureView1, nameAndHealth1, clickableMoves);
		player2.getChildren().addAll(nameAndHealth2, activeCreatureView2, team2);
		update(model, null);
		
	}
	
	
	
	public BorderPane secondPlayerPicking() {
		BorderPane rtrn = new BorderPane();
		HBox pokemonPool = new HBox(15);
		String secondInput = "Player 2";
					
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
					if (secondSelected.contains(poke)) {
						secondSelected.remove(poke);
						imageView.setFitHeight(70);
						imageView.setFitWidth(70);
					} else {
						if (secondSelected.size() < 3) {
							if(selectedTeam.contains(poke)) {
								Alert alertt = new Alert(AlertType.INFORMATION);
								alertt.setTitle("Same pokemon as player 1");
								alertt.setHeaderText("Same Pokemon as player 1");
								alertt.setContentText("Please choose a different pokemon");
								alertt.showAndWait();
							} else {
								secondSelected.add(poke);
								imageView.setFitHeight(80);
								imageView.setFitWidth(80);
							}
						} else {
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Too many Pokemon!");
							alert.setHeaderText("Too many Pokemon!");
							alert.setContentText("Deselect a Pokemon before adding a new one");
							alert.show();
						}
						
					}
				});
			
			pokemonPool.getChildren().add(button);
		}
		pokemonPool.setAlignment(Pos.CENTER);
		rtrn.setCenter(pokemonPool);
		
		Label label = new Label("Second player: Select your team.");
		label.setAlignment(Pos.CENTER);
		rtrn.setTop(label);
		
		Button acceptButton = new Button("Accept");
		acceptButton.setOnAction(e->{
			if (secondSelected.size() <3) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Too little Pokemon");
				alert.setHeaderText("To little pokemon");
				alert.setContentText("Please select more pokemon before accepting");
				alert.showAndWait();
			} else {
				namePrompt2 = new TextInputDialog("Name");
				
				namePrompt2.setTitle("Name prompt");
				namePrompt2.setHeaderText("Enter your name");
				namePrompt2.setContentText("Enter your name");
				
				Optional<String> input = namePrompt2.showAndWait();
				if (input.isPresent()) {
					battleMode = 2;
					localMultiplayerView = new Scene(getBattleView(true),1280,720);
					stage.setScene(localMultiplayerView);
					stage.setTitle("Battle!");
					stage.show();
					
					initializeLocalMultiplayer(input1,selectedTeam,input.get(), secondSelected);

				}
			}
		});
		
		rtrn.setBottom(acceptButton);
		rtrn.setAlignment(acceptButton, Pos.CENTER);
		rtrn.setAlignment(label, Pos.CENTER);
		return rtrn;
	}
	
	public void initializeLocalMultiplayer(String name, List<String> pokemonStrs, String name2, List<String> pokemonStrs2) {
		System.out.println("initializing multiplayer game\n");
		controller.createTeam(name, pokemonStrs, 1);
		controller.createTeam(name2, pokemonStrs2, 2);

		initializeSwapBtns(controller.getTrainer1(), activeTeam, player1SwapBtns);
		team.getChildren().addAll(trainerView,activeTeam);
		
		initializeSwapBtns(controller.getTrainer2(), activeTeam2, player2SwapBtns);
		team2.getChildren().addAll(trainerView2,activeTeam2);
		
		initializeMoveBtns(controller.getTrainer1(), player1MoveBtns, battleMode);
		topRowMoves.getChildren().addAll(player1MoveBtns.get(0), player1MoveBtns.get(1));
		botRowMoves.getChildren().addAll(player1MoveBtns.get(2), player1MoveBtns.get(3));
		clickableMoves.getChildren().addAll(topRowMoves,botRowMoves);
		
		player1.getChildren().addAll(team,activeCreatureView1, nameAndHealth1, clickableMoves);
		
		initializeMoveBtns(controller.getTrainer2(), player2MoveBtns, battleMode);
		topRowMoves2.getChildren().addAll(player2MoveBtns.get(0), player2MoveBtns.get(1));
		botRowMoves2.getChildren().addAll(player2MoveBtns.get(2), player2MoveBtns.get(3));
		clickableMoves2.getChildren().addAll(topRowMoves2,botRowMoves2);
		
		player2.getChildren().addAll(clickableMoves2, nameAndHealth2, activeCreatureView2, team2);

		update(model, null);
	}
	
	private void initializeSwapBtns(Trainer trainer, HBox activeTeam, List<Button> swapBtns) {
		activeTeam.getChildren().clear();
		swapBtns.clear();
		
		for (Creature c : trainer.getTeam()) {
			Button swapBtn = new Button();
			Image swapBtnImg = new Image(c.getPath());
			ImageView swapBtnView = new ImageView(swapBtnImg);
			swapBtn.setGraphic(swapBtnView);
			swapBtn.setStyle("-fx-background-color: transparent;");
			swapBtn.setOnAction(e ->{
				trainer.manualSwap(c);
				update(model, null);
	
			});
			
			activeTeam.getChildren().add(swapBtn);
			swapBtns.add(swapBtn);
		}


	}
	
	private void initializeMoveBtns(Trainer trainer, List<Button> moveBtns, int mode) {
		moveBtns.clear();
		
		System.out.println("Active creature moves: " + trainer.getActiveCreature().getMoves().size());
		List<Move> activeMoves = trainer.getActiveCreature().getMoves();
		for (int i = 0; i < 4; i++) {
			final int currMoveIndex = i;
			Button currMove = new Button(activeMoves.get(currMoveIndex).getName());
			currMove.setOnAction(e -> {
				controller.playerTurn(trainer, trainer.getActiveCreature().getMoves().get(currMoveIndex).getName());
				if (mode == 1) {
					controller.computerTurn();
				}
				update(model, null);
			});		
			moveBtns.add(currMove);
		}
	}
	
	public BorderPane getBattleView(boolean interactive) {
		battleView = new BorderPane();
		player1 = new HBox(200);
		
		team = new VBox(40);
		trainerImage = new Image("/sprites/trainers/lance.png");
		trainerView = new ImageView(trainerImage);
		trainerView.setFitWidth(200);
		trainerView.setPreserveRatio(true);
		activeTeam = new HBox(20);
		
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
		
		player2 = new HBox(200);
		
		nameAndHealth2 = new VBox(20);
		pokeName2 = new Label("Default name");
		healthAndLabel2 = new HBox(20);
		healthLabel2 = new Label("Health: ");
		health2 = new Label("Default health");
		healthAndLabel2.getChildren().addAll(healthLabel2, health2);
		nameAndHealth2.getChildren().addAll(pokeName2, healthAndLabel2);
		
		activeCreatureImage2 = new Image("/sprites/pokemon/pikachu.png");
		activeCreatureView2 = new ImageView(activeCreatureImage2);
		
		if (interactive) {
			clickableMoves2 = new VBox(20);
			topRowMoves2 = new HBox(20);
			botRowMoves2 = new HBox(20);
			
			activeCreatureImage2 = new Image("/sprites/pokemon/pikachu.png");
			activeCreatureView2 = new ImageView(activeCreatureImage2);	
			
			team2 = new VBox(40);
			trainerImage2 = new Image("/sprites/trainers/dawnfront.png");
			trainerView2 = new ImageView(trainerImage2);
			trainerView2.setFitWidth(100);
			trainerView2.setPreserveRatio(true);
			activeTeam2 = new HBox(20);
		} else {
			team2 = new VBox(20);
			trainerImage2 = new Image("/sprites/trainers/soa.png");
			trainerView2 = new ImageView(trainerImage2);
			inactiveTeam2 = new HBox(20);
			activePokemon4 = new Image("/sprites/trainers/soa.png");
			ap4 = new ImageView(trainerImage2);
			activePokemon5 = new Image("/sprites/trainers/soa.png");
			ap5 = new ImageView(trainerImage2);
			activePokemon6 = new Image("/sprites/trainers/soa.png");
			ap6 = new ImageView(trainerImage2);
			inactiveTeam2.getChildren().addAll(ap4,ap5,ap6);
			
		}
		

		battleView.setBottom(player1);
		battleView.setTop(player2);
		
		return battleView;
	}
	
//	public BorderPane getLocalMultiplayerBattleView() {
//		
//	}
}

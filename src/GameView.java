import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;

import controller.PokemonController;
import javafx.application.Application;
import javafx.geometry.Insets;
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
import model.PokemonModel;
/**
 * @author conorjanesky, mohammed, jett, safwan
 * file: GameView.java
 * Class: CSC 335 Fall 2025
 * Purpose: This is the GUI class
 * This launches a single window where all of the battles take place,
 * the players are able to pick their pokemon, and the
 * user (in single player) can progress up the difficulties
 */
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
	private BorderPane BattleViewMultiPlayerLocal;
	private Scene battleScene;
	private BorderPane BattleViewSinglePlayer;
	private Image activeCreatureImage1;
	private ImageView activeCreatureView1;
	private VBox nameAndHealth1;
	private Label pokeName1;
	private HBox healthAndLabel1;
	private Label healthLabel1;
	private Label health1;
	private List<String> pokemonStrs;
	private List<String> secondSelected = new ArrayList<>();
	private List<String> selectedTeam = new ArrayList();
	private VBox clickableMoves;
	private HBox topRowMoves;
	private HBox botRowMoves;
	private Button move1;
	private Button move2;
	private Button move3;
	private Button move4;
	private TextInputDialog namePrompt;
	private TextInputDialog namePrompt2;
	private int gamemode = 0;
	private int beaten = 1;
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
	private String input1;
	private ImageView swapButView3;
	private VBox clickableMoves2;
	private HBox topRowMoves2;
	private HBox botRowMoves2;
	private Button move5;
	private Button move6;
	private Button move7;
	private Button move8;
	private Image swapBut4;
	private ImageView swapButView4;
	private Image swapBut5;
	private Image swapBut6;
	private ImageView swapButView6;
	private ImageView swapButView5;
	private Button firstSwapBtn;
	private Button secondSwapBtn;
	private Button thirdSwapBtn;
	private Button firstSwapBtn2;
	private Button secondSwapBtn2;
	private Button thirdSwapBtn2;
	@Override
	/**
	 * @param stage - this is the stage that will come up 
	 * This preveres the inital stage so we can alwyas go back to it, and then initliaizes
	 * our program
	 * 
	 */
	public void start(Stage stage) throws Exception {
		this.originalStage = stage;
		initializeProgram();
	}
	
	/**
	 * This refreshes the game so it sets all of the 
	 * trainers back to emtpy, its creates a new model and controller
	 * so a new battle can take place.
	 */
	public void refresh() {
		model = null;
		model = new PokemonModel();
		controller = null;
		controller = new PokemonController(model);
		model.addObserver(this);
	}
	/**
	 * this initializes our program. 
	 * it builds the mainmenu GUI and the progression gui 
	 * and the singleplayer battle gui
	 * It also shows the stage for the first time to the
	 * user at the main menn gui.
	 */
	public void initializeProgram() {
		System.out.println("initializing program...");
		refresh();
		
		// Creates the main menu that the user sees first
		MainMenu = new BorderPane();
		this.stage = originalStage;
		HBox buttonBox = new HBox(20);
		Button singlePlayer = new Button("Single Player");
		Button localMultiplayer = new Button("Local Multiplayer");
		Button multiplayerOnline = new Button("Multiplayer Online");
		multiplayerOnline.setDisable(true);
		buttonBox.getChildren().add(singlePlayer);
		buttonBox.getChildren().add(localMultiplayer);
		buttonBox.getChildren().add(multiplayerOnline);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setPadding(new Insets(70,0,0,0));
		
		MainMenu.setTop(buttonBox);
		
		selectedTeam = new ArrayList<>();
	
		HBox pokemonPool = new HBox(15);
		
		pokemonStrs = new ArrayList<>(Arrays.asList("pikachu", "charmander", "squirtle", "bulbasaur", "jigglypuff", "yoshi", "poliwhirl", "gloom", "psyduck", "goldeen", "dratini", "meowth"));
			
		// This builds the buttons that user can click to add pokemon to their team
		for (String poke : pokemonStrs) {
				Button button = new Button();
				Image image = new Image("/sprites/pokemon/" + poke + ".png");
				ImageView imageView = new ImageView(image);
				imageView.setFitHeight(70);
				imageView.setFitWidth(70);
			
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
		
		// this adds the buttons to the mainmenu gui
		pokemonPool.setAlignment(Pos.CENTER);
		MainMenu.setCenter(pokemonPool);
		
		// this is where we start making singleplayer
		BattleViewSinglePlayer = new BorderPane();
		HBox player1 = new HBox(150);
		
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
		firstSwapBtn.setOnAction(e ->{
			controller.getTrainer1().manualSwap(controller.getTrainer1().getCreature1());
			update(model, null);

		});
		
		Button secondSwapBtn = new Button();
		swapBut2 = new Image("/sprites/trainers/lance.png");
		swapButView2 = new ImageView(swapBut2);
		secondSwapBtn.setGraphic(swapButView2);
		secondSwapBtn.setOnAction(e ->{
			controller.getTrainer1().manualSwap(controller.getTrainer1().getCreature2());
			update(model, null);

		});
		
		swapBut3 = new Image("/sprites/trainers/lance.png");
		swapButView3 = new ImageView(swapBut3);
		Button thirdSwapBtn = new Button();
		thirdSwapBtn.setGraphic(swapButView3);
		thirdSwapBtn.setOnAction(e -> {
			controller.getTrainer1().manualSwap(controller.getTrainer1().getCreature3());
			update(model, null);
		});
		
		activeTeam.getChildren().addAll(firstSwapBtn,secondSwapBtn,thirdSwapBtn);
		team.getChildren().addAll(trainerView,activeTeam);
		team.setAlignment(Pos.CENTER);
		team.setPadding((new Insets(0,0,20,0)));
		
		activeCreatureImage1 = new Image("/sprites/pokemon/bulbasaur.png");
		activeCreatureView1 = new ImageView(activeCreatureImage1);
		activeCreatureView1.setFitWidth(200);
		activeCreatureView1.setPreserveRatio(true);
		
		nameAndHealth1 = new VBox(20);
		pokeName1 = new Label("Default name");
		healthAndLabel1 = new HBox(20);
		healthLabel1 = new Label("Health: ");
		health1 = new Label("Default health");
		healthAndLabel1.getChildren().addAll(healthLabel1, health1);
		healthAndLabel1.setAlignment(Pos.CENTER);
		nameAndHealth1.getChildren().addAll(pokeName1, healthAndLabel1);
		nameAndHealth1.setAlignment(Pos.CENTER);
		
		clickableMoves = new VBox(20);
		topRowMoves = new HBox(20);
		botRowMoves = new HBox(20);
		move1 = new Button("Move1");
		move1.setOnAction(e -> {
			controller.playerTurn(controller.getTrainer1(), controller.getTrainer1().getActiveCreature().getMoves().get(0).getName());
			controller.computerTurn();
			update(model, null);
		});
		move2 = new Button("Move2");
		move2.setOnAction(e -> {
			controller.playerTurn(controller.getTrainer1(), controller.getTrainer1().getActiveCreature().getMoves().get(1).getName());
			controller.computerTurn();
			update(model, null);
		});
		move3 = new Button("Move3");
		move3.setOnAction(e -> {
			controller.playerTurn(controller.getTrainer1(), controller.getTrainer1().getActiveCreature().getMoves().get(2).getName());
			controller.computerTurn();
			update(model, null);
		});
		move4 = new Button("Move4");
		move4.setOnAction(e -> {
			controller.playerTurn(controller.getTrainer1(), controller.getTrainer1().getActiveCreature().getMoves().get(3).getName());
			controller.computerTurn();
			update(model, null);
		});
		topRowMoves.getChildren().addAll(move1, move2);
		topRowMoves.setAlignment(Pos.CENTER);
		botRowMoves.getChildren().addAll(move3,move4);
		botRowMoves.setAlignment(Pos.CENTER);
		clickableMoves.getChildren().addAll(topRowMoves,botRowMoves);
		clickableMoves.setAlignment(Pos.CENTER);
		
		player1.getChildren().addAll(team,activeCreatureView1, nameAndHealth1, clickableMoves);
		player1.setAlignment(Pos.CENTER);
		
		// this is where we start making player 2 for the battle
		HBox player2 = new HBox(300);
		
		nameAndHealth2 = new VBox(20);
		pokeName2 = new Label("Default name");
		healthAndLabel2 = new HBox(20);
		healthLabel2 = new Label("Health: ");
		health2 = new Label("Default health");
		healthAndLabel2.getChildren().addAll(healthLabel2, health2);
		healthAndLabel2.setAlignment(Pos.CENTER);
		nameAndHealth2.getChildren().addAll(pokeName2, healthAndLabel2);
		nameAndHealth2.setAlignment(Pos.CENTER);
		nameAndHealth2.setPadding(new Insets(0,0,0,50));
		
		activeCreatureImage2 = new Image("/sprites/pokemon/pikachu.png");
		activeCreatureView2 = new ImageView(activeCreatureImage2);
		activeCreatureView2.setFitWidth(200);
		activeCreatureView2.setPreserveRatio(true);
		
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
		team2.setAlignment(Pos.CENTER);
		player2.getChildren().addAll(nameAndHealth2,activeCreatureView2,team2);
		player2.setAlignment(Pos.CENTER);
		
		BattleViewSinglePlayer.setBottom(player1);
		BattleViewSinglePlayer.setTop(player2);
		
		// here is where we start making the progression menu
		progressionMenu = new BorderPane();
		HBox levelsBox = new HBox(120);
		Button easyBtn = new Button("Easy");
		easyBtn.setOnAction(e -> {
			trainerImage2 = new Image("/sprites/trainers/soa.png");
			trainerView2.setImage(trainerImage2);
			
			battleScene = new Scene(BattleViewSinglePlayer, 1280,720);
			controller.setDifficulty(0);
			update(model, null);
			stage.setScene(battleScene);
			stage.setTitle("pokimon");
			stage.show();
			
		});
		
		Button mediumBtn = new Button("Medium");
		mediumBtn.setOnAction(e ->{
			trainerImage2 = new Image("/sprites/trainers/lunick.png");
			trainerView2.setImage(trainerImage2);

			battleScene = new Scene(BattleViewSinglePlayer, 1280,720);
			stage.setScene(battleScene);
			stage.setTitle("pokimon");
			stage.show();
		});
		mediumBtn.setDisable(true);
		if(beaten >=2) {
			mediumBtn.setDisable(false);
		}
		
		Button hardBtn = new Button("Hard");
		hardBtn.setOnAction(e ->{
			trainerImage2 = new Image("/sprites/trainers/solana.png");
			trainerView2.setImage(trainerImage2);

			battleScene = new Scene(BattleViewSinglePlayer, 1280,720);
			controller.setDifficulty(2);
			update(model,null);
			stage.setScene(battleScene);
			stage.setTitle("pokimon");
			stage.show();
		});
		hardBtn.setDisable(true);
		if(beaten >=3) {
			hardBtn.setDisable(false);
		}
		
		levelsBox.getChildren().addAll(easyBtn, mediumBtn, hardBtn);
		levelsBox.setAlignment(Pos.CENTER);
		progressionMenu.setCenter(levelsBox);
		
		// if single player, is clicked it will progress to the progression menu and set the gamemode
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
					gamemode = 1;
					initializeGame(inputStr, selectedTeam);
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
		
		// if local multiplayer is clicked it will prgoress to the gui where the second player picks their team
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
					gamemode =2;
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
		
		// this initially shows the main menu GUI which can then access all the other GUIs
		scene = new Scene(MainMenu, 1280,720);
		stage.setScene(scene);
		stage.setTitle("Pokemen");
		stage.show();
	}
	
	@Override
	/**
	 * This is the update function so any time the 
	 * GUI changes the model, the model changes, and the 
	 * gui can track what is happening in the model.
	 * @param o -this is the observable changed model
	 * @param arg these are the things that changed in observable
	 */
	public void update(Observable o, Object arg) {
		// These update the ctive creautre images everytime that they are changed by the user
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
		// if the game mode is single player, then it will update the trainer sprites and the creature sprites (not buttons)
		if (gamemode ==1) {
		activePokemon4 = new Image(controller.getTrainer2().getCreature1().getPath());
		ap4.setImage(activePokemon4);
		activePokemon5 = new Image(controller.getTrainer2().getCreature2().getPath());
		ap5.setImage(activePokemon5);
		activePokemon6 = new Image(controller.getTrainer2().getCreature3().getPath());
		ap6.setImage(activePokemon6);
		}
		
		if (gamemode == 2) {
			if (controller.getCurrTurn() == 1) {
				move1.setDisable(false);
				move2.setDisable(false);
				move3.setDisable(false);
				move4.setDisable(false);
				
				move5.setDisable(true);
				move6.setDisable(true);
				move7.setDisable(true);
				move8.setDisable(true);
				
				firstSwapBtn.setDisable(false);
				secondSwapBtn.setDisable(false);
				thirdSwapBtn.setDisable(false);
				
				firstSwapBtn2.setDisable(true);
				secondSwapBtn2.setDisable(true);
				thirdSwapBtn2.setDisable(true);
				
			} else if (controller.getCurrTurn() == 2) {
				move1.setDisable(true);
				move2.setDisable(true);
				move3.setDisable(true);
				move4.setDisable(true);
				
				move5.setDisable(false);
				move6.setDisable(false);
				move7.setDisable(false);
				move8.setDisable(false);
				
				firstSwapBtn.setDisable(true);
				secondSwapBtn.setDisable(true);
				thirdSwapBtn.setDisable(true);
				
				firstSwapBtn2.setDisable(false);
				secondSwapBtn2.setDisable(false);
				thirdSwapBtn2.setDisable(false);
			}
		}
		
		activeCreatureImage2 = new Image(controller.getTrainer2().getActiveCreature().getPath());
		activeCreatureView2.setImage(activeCreatureImage2);
		
		// these update the GUI element that displays which pokemon is active and its current health
		pokeName2.setText(controller.getTrainer2().getActiveCreature().getName());
		System.out.println("NEW PRINT" + controller.getTrainer2().getActiveCreature().getHealth());
		health2.setText(Integer.toString(controller.getTrainer2().getActiveCreature().getHealth()));
		
		// these update the swapbuttons so they are the alwys player 1s creatures
		swapBut1 = new Image(controller.getTrainer1().getCreature1().getPath());
		swapButView1.setImage(swapBut1);
		
		swapBut2 = new Image(controller.getTrainer1().getCreature2().getPath());
		swapButView2.setImage(swapBut2);
		
		swapBut3 = new Image(controller.getTrainer1().getCreature3().getPath());
		swapButView3.setImage(swapBut3);
		move1.setText(controller.getTrainer1().getActiveCreature().getMoves().get(0).getName());
		move2.setText(controller.getTrainer1().getActiveCreature().getMoves().get(1).getName());
		move3.setText(controller.getTrainer1().getActiveCreature().getMoves().get(2).getName());
		move4.setText(controller.getTrainer1().getActiveCreature().getMoves().get(3).getName());
		
		// if the gamemode is multiplayer the we also want toupdate the plyer 2 eleemnts
		if (gamemode!=1) {
			swapBut4 = new Image(controller.getTrainer2().getCreature1().getPath());
			swapButView4.setImage(swapBut4);
			
			swapBut5 = new Image(controller.getTrainer2().getCreature2().getPath());
			swapButView5.setImage(swapBut5);
		
			swapBut6 = new Image(controller.getTrainer2().getCreature3().getPath());
			swapButView6.setImage(swapBut6);
			
			move5.setText(controller.getTrainer2().getActiveCreature().getMoves().get(0).getName());
			move6.setText(controller.getTrainer2().getActiveCreature().getMoves().get(1).getName());
			move7.setText(controller.getTrainer2().getActiveCreature().getMoves().get(2).getName());
			move8.setText(controller.getTrainer2().getActiveCreature().getMoves().get(3).getName());
		}
		
		// this checks if the battle is over, if it is display the winner and perform a reset
		if (controller.isBattleOver()) {
			debug();
			System.out.println("Game over");
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Someone Won!");
			alert.setHeaderText(null);
			alert.setContentText(controller.getWinner());
			alert.showAndWait();
			if (gamemode== 1 && controller.getWinner().contains("!!!")) {
				beaten++;
			}
			gamemode = 0;
			controller.resetAllHealth();
			secondSelected.clear();
			initializeProgram();
		}
	}
	
	/**
	 * this is a debugging class that prints the information necessary used for debugging purposes
	 */
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
	
	/**
	 * this initializtes  the single player model and sets the 
	 * teamsto contain the approriate creatures ect...
	 * @param name
	 * @param pokemonStrs
	 */
	public void initializeGame(String name, List<String> pokemonStrs) {
		System.out.println("initializing game\n");
		// creates player1 
		controller.createTeam(name, pokemonStrs, 1);
		// creaes player 2 (cimputer)
		controller.createComputerTeam(pokemonStrs);
//		System.out.println("Path HELPPPPP: " + controller.getTrainer1().getName());
		update(model, null);	
	}
	
	/**
	 * This creates a border pane that contains the menu
	 * for the second player to pick their pokemon
	 * @return rtrtn, border pane that has the second player menu
	 */
	public BorderPane secondPlayerPicking() {
		// this follows the same structure as the first player
		BorderPane rtrn = new BorderPane();
		HBox pokemonPool = new HBox(15);
		String secondInput = "Player 2";
		
		// creates 12 buttons with the creatures and adds them to an hbox
		for (String poke : pokemonStrs) {
				Button button = new Button();
				Image image = new Image("/sprites/pokemon/" + poke + ".png");
				ImageView imageView = new ImageView(image);
				imageView.setFitHeight(70);
				imageView.setFitWidth(70);
			
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
		// we also create a label to instruct the second user and accept the team
		pokemonPool.setAlignment(Pos.CENTER);
		rtrn.setCenter(pokemonPool);
		
		Label label = new Label("Second player please select your team");
		label.setAlignment(Pos.CENTER);
		label.setPadding(new Insets(70,0,0,0));
		rtrn.setTop(label);
		
		// here we also do logic to check if they have the right amount of pokemon
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
					localMultiplayerView = new Scene(getLocalMultiplayerBattleView(),1280,720);
					initializeLocalMultiplayer(input1,selectedTeam,input.get(), secondSelected);
					stage.setScene(localMultiplayerView);
					stage.setTitle("Battle!");
					stage.show();
				}
			}
		});
		
		// return the borderpane
		rtrn.setBottom(acceptButton);
		rtrn.setPadding(new Insets(0,0,70,0));
		rtrn.setAlignment(acceptButton, Pos.CENTER);
		rtrn.setAlignment(label, Pos.CENTER);
		return rtrn;
	}
	
	/**
	 * This initializes the game for local multiplayer
	 * @param name - name of the first player
	 * @param pokemonStrs - the team of the first player
	 * @param name2 - name of the second player
	 * @param pokemonStrs2 - the team of the second player
	 */
	public void initializeLocalMultiplayer(String name, List<String> pokemonStrs, String name2, List<String> pokemonStrs2) {
		System.out.println("initializing multiplayer game\n");
		// creates both teams 
		controller.createTeam(name, pokemonStrs, 1);
		controller.createTeam(name2, pokemonStrs2, 2);
//		System.out.println("Path HELPPPPP: " + controller.getTrainer1().getName());

		
		update(model, null);
	}
	/**
	 * this creates the border pane that where both teams
	 * will fight
	 * @return BattleViewMultiplayerLocal - the borderpane that they will fight in
	 */
	public BorderPane getLocalMultiplayerBattleView() {
		// the construction of the battleview follows the same elements and pattern from singleplayer
		BattleViewMultiPlayerLocal = new BorderPane();
		// this creates player 1 with the different GUI elements
		HBox player1 = new HBox(150);

		VBox team = new VBox(40);
		Image trainerImage = new Image("/sprites/trainers/lance.png");
		ImageView trainerView = new ImageView(trainerImage);
		trainerView.setFitWidth(200);
		trainerView.setPreserveRatio(true);
		HBox activeTeam = new HBox(20);
		
		firstSwapBtn = new Button();
		swapBut1 = new Image("/sprites/trainers/lance.png");
		swapButView1 = new ImageView(swapBut1);
		firstSwapBtn.setGraphic(swapButView1);
		firstSwapBtn.setOnAction(e ->{
			controller.getTrainer1().manualSwap(controller.getTrainer1().getCreature1());
			update(model, null);

		});
		
		secondSwapBtn = new Button();
		swapBut2 = new Image("/sprites/trainers/lance.png");
		swapButView2 = new ImageView(swapBut2);
		secondSwapBtn.setGraphic(swapButView2);
		secondSwapBtn.setOnAction(e ->{
			controller.getTrainer1().manualSwap(controller.getTrainer1().getCreature2());
			update(model, null);

		});
		
		swapBut3 = new Image("/sprites/trainers/lance.png");
		swapButView3 = new ImageView(swapBut3);
		thirdSwapBtn = new Button();
		thirdSwapBtn.setGraphic(swapButView3);
		thirdSwapBtn.setOnAction(e -> {
			controller.getTrainer1().manualSwap(controller.getTrainer1().getCreature3());
			update(model, null);
		});
		
		activeTeam.getChildren().addAll(firstSwapBtn,secondSwapBtn,thirdSwapBtn);
		team.getChildren().addAll(trainerView,activeTeam);
		team.setAlignment(Pos.CENTER);
		team.setPadding((new Insets(0,0,20,0)));
		
		activeCreatureImage1 = new Image("/sprites/pokemon/bulbasaur.png");
		activeCreatureView1 = new ImageView(activeCreatureImage1);
		activeCreatureView1.setFitWidth(200);
		activeCreatureView1.setPreserveRatio(true);
		
		nameAndHealth1 = new VBox(20);
		pokeName1 = new Label("Default name");
		healthAndLabel1 = new HBox(20);
		healthLabel1 = new Label("Health: ");
		health1 = new Label("Default health");
		healthAndLabel1.getChildren().addAll(healthLabel1, health1);
		healthAndLabel1.setAlignment(Pos.CENTER);
		nameAndHealth1.getChildren().addAll(pokeName1, healthAndLabel1);
		nameAndHealth1.setAlignment(Pos.CENTER);
		
		clickableMoves = new VBox(20);
		topRowMoves = new HBox(20);
		botRowMoves = new HBox(20);
		move1 = new Button("Move1");
		move1.setOnAction(e -> {
			controller.playerTurn(controller.getTrainer1(), controller.getTrainer1().getActiveCreature().getMoves().get(0).getName());
			update(model, null);
		});
		move2 = new Button("Move2");
		move2.setOnAction(e -> {
			controller.playerTurn(controller.getTrainer1(), controller.getTrainer1().getActiveCreature().getMoves().get(1).getName());
			update(model, null);
		});
		move3 = new Button("Move3");
		move3.setOnAction(e -> {
			controller.playerTurn(controller.getTrainer1(), controller.getTrainer1().getActiveCreature().getMoves().get(2).getName());
			update(model, null);
		});
		move4 = new Button("Move4");
		move4.setOnAction(e -> {
			controller.playerTurn(controller.getTrainer1(), controller.getTrainer1().getActiveCreature().getMoves().get(3).getName());
			update(model, null);
		});
		topRowMoves.getChildren().addAll(move1, move2);
		topRowMoves.setAlignment(Pos.CENTER);
		botRowMoves.getChildren().addAll(move3,move4);
		botRowMoves.setAlignment(Pos.CENTER);
		clickableMoves.getChildren().addAll(topRowMoves,botRowMoves);
		clickableMoves.setAlignment(Pos.CENTER);
		
		player1.getChildren().addAll(team,activeCreatureView1, nameAndHealth1, clickableMoves);
		
		// now we create player two with the same GUI elements
		HBox player2 = new HBox(150);
		
		nameAndHealth2 = new VBox(20);
		pokeName2 = new Label("Default name");
		healthAndLabel2 = new HBox(20);
		healthLabel2 = new Label("Health: ");
		health2 = new Label("Default health");
		healthAndLabel2.getChildren().addAll(healthLabel2, health2);
		healthAndLabel2.setAlignment(Pos.CENTER);
		nameAndHealth2.getChildren().addAll(pokeName2, healthAndLabel2);
		nameAndHealth2.setAlignment(Pos.CENTER);
		
		clickableMoves2 = new VBox(20);
		topRowMoves2 = new HBox(20);
		botRowMoves2 = new HBox(20);
		move5 = new Button("Move1");
		move5.setOnAction(e -> {
			controller.playerTurn(controller.getTrainer2(), controller.getTrainer2().getActiveCreature().getMoves().get(0).getName());
			update(model, null);
		});
		move6 = new Button("Move2");
		move6.setOnAction(e -> {
			controller.playerTurn(controller.getTrainer2(), controller.getTrainer2().getActiveCreature().getMoves().get(1).getName());
			update(model, null);
		});
		move7 = new Button("Move3");
		move7.setOnAction(e -> {
			controller.playerTurn(controller.getTrainer2(), controller.getTrainer2().getActiveCreature().getMoves().get(2).getName());
			update(model, null);
		});
		move8 = new Button("Move4");
		move8.setOnAction(e -> {
			controller.playerTurn(controller.getTrainer2(), controller.getTrainer2().getActiveCreature().getMoves().get(3).getName());
			update(model, null);
		});
		topRowMoves2.getChildren().addAll(move5, move6);
		topRowMoves2.setAlignment(Pos.CENTER);
		botRowMoves2.getChildren().addAll(move7,move8);
		botRowMoves2.setAlignment(Pos.CENTER);
		clickableMoves2.getChildren().addAll(topRowMoves2,botRowMoves2);
		clickableMoves2.setAlignment(Pos.CENTER);
		clickableMoves2.setPadding(new Insets(0,0,0,20));
		
		activeCreatureImage2 = new Image("/sprites/pokemon/pikachu.png");
		activeCreatureView2 = new ImageView(activeCreatureImage2);
		activeCreatureView2.setFitWidth(200);
		activeCreatureView2.setPreserveRatio(true);
		
		VBox team2 = new VBox(40);
		Image trainerImage2 = new Image("/sprites/trainers/dawnfront.png");
		ImageView trainerView2 = new ImageView(trainerImage2);
		trainerView2.setFitWidth(100);
		trainerView2.setPreserveRatio(true);
		HBox activeTeam2 = new HBox(20);
		
		
		firstSwapBtn2 = new Button();
		swapBut4 = new Image("/sprites/trainers/lance.png");
		swapButView4 = new ImageView(swapBut4);
		firstSwapBtn2.setGraphic(swapButView4);
		firstSwapBtn2.setOnAction(e ->{
			controller.getTrainer2().manualSwap(controller.getTrainer2().getCreature1());
			update(model, null);

		});
		
		secondSwapBtn2 = new Button();
		swapBut5 = new Image("/sprites/trainers/lance.png");
		swapButView5 = new ImageView(swapBut5);
		secondSwapBtn2.setGraphic(swapButView5);
		secondSwapBtn2.setOnAction(e ->{
			controller.getTrainer2().manualSwap(controller.getTrainer2().getCreature2());
			update(model, null);

		});
		
		thirdSwapBtn2 = new Button();
		swapBut6 = new Image("/sprites/trainers/lance.png");
		swapButView6 = new ImageView(swapBut6);
		thirdSwapBtn2.setGraphic(swapButView6);
		thirdSwapBtn2.setOnAction(e -> {
			controller.getTrainer2().manualSwap(controller.getTrainer2().getCreature3());
			update(model, null);
		});
		
		activeTeam2.getChildren().addAll(firstSwapBtn2,secondSwapBtn2,thirdSwapBtn2);
		team2.getChildren().addAll(trainerView2,activeTeam2);
		team2.setAlignment(Pos.CENTER);
		player2.getChildren().addAll(clickableMoves2, nameAndHealth2, activeCreatureView2, team2);
		player2.setAlignment(Pos.CENTER);
		player1.setAlignment(Pos.CENTER);

		BattleViewMultiPlayerLocal.setBottom(player1);
		BattleViewMultiPlayerLocal.setTop(player2);
		
		// after adding all the elements for both players to the borderpane, we return it
		return BattleViewMultiPlayerLocal;
	}
}

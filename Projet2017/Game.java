package simpleUIApp;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Game implements java.io.Serializable {
	private static final long serialVersionUID = -2325653399861863486L;
	private int nbPlayers;
	private int nbPlanets;
	private int nbPPlanets;
	private ArrayList<Player> players;
	private static ArrayList<Planet> planets;
	private ArrayList<Planet> serialPlanets;
	private ArrayList<Planet> Nplanets;
	private ArrayList<Planet> playerPlanets;
	private static CopyOnWriteArrayList<Item> ItemList;
	private CopyOnWriteArrayList<Item> serialItemList;
	private Random random = new Random();
	private ArrayList<Color> colors;
	private int width = 1024;
	private int height = 768;
	private int planet_width = 100;
	private int spaceship_width = 10;
	private int distMin = 80;
	
	
	public Game(int nbPlayers, int nbPlanets, int nbPPlanets) {
		this.nbPlayers = nbPlayers;
		this.nbPlanets = nbPlanets;
		this.nbPPlanets = nbPPlanets;
	}
	

	public Game() {
		super();
	}


	public ArrayList<Player> getPlayers() {
		return players;
	}

	public static ArrayList<Planet> getPlanets() {
		return planets;
	}

	public ArrayList<Planet> getNplanets() {
		return Nplanets;
	}
	
	public static CopyOnWriteArrayList<Item> getItemList() {
		return ItemList;
	}

	public void init(){
		ItemList = new CopyOnWriteArrayList<Item>();
		players = new ArrayList<Player>();
		planets = new ArrayList<Planet>();
		playerPlanets = new ArrayList<Planet>();
		Nplanets = new ArrayList<Planet>();
		colors = new ArrayList<Color>();
		colors.add(Color.red);
		colors.add(Color.black);
		Manager manager = new Manager();
		for(int i=0; i<nbPlayers; i++){
			Player myPlayer = new Player(i, colors.get(i));
			for(int j=0; j<nbPPlanets; j++){
				int x = random.nextInt(width);
				int y = random.nextInt(height);
				if(x < planet_width || y < planet_width || x > width-planet_width || y > height-(2*planet_width)){
					j--;
				}
				else{
					Planet myPlanet = new Planet(x, y, planet_width, colors.get(i), i);
					boolean nointersect = true;
					for(Planet existingPlanet : planets){
						Shape rect = new Rectangle(((int) existingPlanet.getLocation().getX() - planet_width - distMin),
								((int) existingPlanet.getLocation().getY() - planet_width - distMin), planet_width + 2 * distMin, planet_width + 2 * distMin);
						if(manager.isContained(rect, myPlanet)){
							j--;
							nointersect = false;
							break;
						}
					}
					if(nointersect){
						myPlanet.init();
						planets.add(myPlanet);
						ItemList.add(myPlanet);
					}
					
				}
			}
			for(int j=i*nbPPlanets; j<(i+1)*nbPPlanets; j++){
				playerPlanets.add(planets.get(j));
			}
			myPlayer.init(playerPlanets);
			playerPlanets.clear();
			players.add(myPlayer);
		}
		for(int i=0; i<nbPlanets - (nbPlayers * nbPPlanets); i++){
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			if(x < planet_width || y < planet_width || x > width-planet_width || y > height-(2*planet_width)){
				i--;
			}
			else{
				Planet myPlanet = new Planet(x, y, planet_width, Color.green, -1);
				boolean nointersect = true;
				for(Planet existingPlanet : planets){
					Shape rect = new Rectangle(((int) existingPlanet.getLocation().getX() - planet_width - distMin),
							((int) existingPlanet.getLocation().getY() - planet_width - distMin), planet_width + 2 * distMin, planet_width + 2 * distMin);
					if(manager.isContained(rect, myPlanet)){
						i--;
						nointersect = false;
						break;
					}
				}
				if(nointersect){
					myPlanet.init();
					planets.add(myPlanet);
					Nplanets.add(myPlanet);
					ItemList.add(myPlanet);
				}
			}
		}
	}
	
	public static void startGameAI(int id){
		for(Planet enemyPlanet : planets){
			if(enemyPlanet.getOwnerId() != id){
				for(Planet myPlanet : planets){
					if(myPlanet.getOwnerId() == id){
						for(SpaceShip mySpaceShip : myPlanet.getSpaceShips()){
							mySpaceShip.setObjective(enemyPlanet);
						}
					}
				}
			}
		}
	}
	
	public void saveGame(){
		try {
	         FileOutputStream fileOut = new FileOutputStream("/tmp/save.game");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         serialPlanets = Game.getPlanets();
	         serialItemList = Game.getItemList();
	         out.writeObject(this);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in /tmp/save.game");
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	   }
	
	public void setSerialPlanets(ArrayList<Planet> serialPlanets) {
		this.serialPlanets = serialPlanets;
	}


	public void setSerialItemList(CopyOnWriteArrayList<Item> serialItemList) {
		this.serialItemList = serialItemList;
	}


	public Game loadGame(){
		Game game = null;
	      try {
	         FileInputStream fileIn = new FileInputStream("/tmp/save.game");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         game = (Game) in.readObject();
	         game.setPlanets(game.getSerialPlanets());
	         game.setItemList(game.getSerialItemList());
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         return null;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Game class not found");
	         c.printStackTrace();
	         return null;
	      }
	      return game;
	}
		
		public ArrayList<Planet> getSerialPlanets() {
		return serialPlanets;
	}


	public CopyOnWriteArrayList<Item> getSerialItemList() {
		return serialItemList;
	}


		public int getNbPlayers() {
		return nbPlayers;
	}


	public void setNbPlayers(int nbPlayers) {
		this.nbPlayers = nbPlayers;
	}


	public int getNbPlanets() {
		return nbPlanets;
	}


	public void setNbPlanets(int nbPlanets) {
		this.nbPlanets = nbPlanets;
	}


	public int getNbPPlanets() {
		return nbPPlanets;
	}


	public void setNbPPlanets(int nbPPlanets) {
		this.nbPPlanets = nbPPlanets;
	}


	public ArrayList<Planet> getPlayerPlanets() {
		return playerPlanets;
	}


	public void setPlayerPlanets(ArrayList<Planet> playerPlanets) {
		this.playerPlanets = playerPlanets;
	}


	public Random getRandom() {
		return random;
	}


	public void setRandom(Random random) {
		this.random = random;
	}


	public ArrayList<Color> getColors() {
		return colors;
	}


	public void setColors(ArrayList<Color> colors) {
		this.colors = colors;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getPlanet_width() {
		return planet_width;
	}


	public void setPlanet_width(int planet_width) {
		this.planet_width = planet_width;
	}


	public int getSpaceship_width() {
		return spaceship_width;
	}


	public void setSpaceship_width(int spaceship_width) {
		this.spaceship_width = spaceship_width;
	}


	public int getDistMin() {
		return distMin;
	}


	public void setDistMin(int distMin) {
		this.distMin = distMin;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}


	public static void setPlanets(ArrayList<Planet> planets) {
		Game.planets = planets;
	}


	public void setNplanets(ArrayList<Planet> nplanets) {
		Nplanets = nplanets;
	}


	public static void setItemList(CopyOnWriteArrayList<Item> itemList) {
		ItemList = itemList;
	}


		public void playerLost(int id){
		System.out.println("Player " + id + " lost.");
	}
	
	public int winner(){
		return 0;
	}
}

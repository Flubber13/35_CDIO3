package game;


public class Text {
	/* This class contains all the text output for the game. Putting all text in one class, 
	   will make is easier to change the language later, if desired */
	
	// The String in each of the following variables are pulled when referred to in the controller
	
	static String[] enterName = {"Spiller 1 indtast dit navn", "Spiller 2 indtast dit navn",
								"Spiller 3 indtast dit navn", "Spiller 4 indtast dit navn",
								"Spiller 5 indtast dit navn", "Spiller 6 indtast dit navn"};
	static String nameTaken = "Navnet er taget. Prøv igen";
	static String nameInvalid = "Navnet er ugyldigt. Prøv igen";
	
	static String roll = " Tryk OK for at kaste med terningerne";	

	static String landedOn = " landede på: ";

	static String winner = " vinder spillet. Du har nu monopol på hele pladen tilykke med det!";
	
	static String tie = "Spillet endte uafgjort";
	
	static String howManyPlayers = "Hvor mange spillere er I? (2-6 spillere)";
	
	public static String rentRoll = " kast terningerne for at bestemme lejen";
	
	static String bankrupt = " du er gået bankerot! Du mister nu alle dine grunde, og de vil blive sat til salg på ny";
	
	public static String laborRent = "Lejen du skal betale er: 100 x ";
	
	public static String buyQuestion = "Vil du købe denne grund? Pris: ";
	public static String yes = "Ja";
	public static String no = "Nej";
	public static String taxChoice = "Hvor meget vil du betale i skat?";
	
	public static String[] fieldName = {null,"Start","Tribe Encampment","Goldmine","Crater","Second Sail","Mountain","Monastery",
								"Cold Dessert","Sea Grover","Black Cave","Huts int the Mountian","The Warewall","Caravan",
								"Mountain Village","The Buccaneers","South Citdal","Walled City","Palace Gates","The Pit",
								"Tower","Privateer Armade","Castle"};

	public static String owned = "Denne grund er allerede ejet af ";

	public static String mustPay = " skal derfor betale ";

	public static String to = " til ";
	public static String payTax = "Betal skat";
	public static String price = "Pris";
	public static String rent = "Leje";
	public static String recieve = "Modtag";
	public static String numEyes = "antal øjne";
	public static String startField = " landede på Start";
	
}

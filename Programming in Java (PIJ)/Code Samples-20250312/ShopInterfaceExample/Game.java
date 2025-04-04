import java.util.GregorianCalendar;
class Game extends EntertainmentSrc implements ShopInterface {
	public String gameType; //Real time, turn based
	public String genre ; //Action, adventure, exercise
	public GregorianCalendar lastUpdated;
	public String medium; //Physical or Digital
	private int noOfRuns;
	
	public Game()
	{
		this.gameType = "Real time";
		this.genre = "Adventure";
		this.lastUpdated = new GregorianCalendar(2001, 1, 1);
		this.medium = "digital";
		this.noOfRuns = 0;
	}
	public Game(String gameType, String genre, GregorianCalendar lastUpdated, String medium, int noOfRuns)
	{
		this.gameType = gameType;
		this.genre = genre;
		this.lastUpdated = lastUpdated;
		this.medium = medium;
		this.noOfRuns = noOfRuns;
		
	}
	public int getNoOfRuns()
	{
		return noOfRuns;
	}
	//public void setNoOfRuns()
	public void update(double ver)
	{
		System.out.println("This game is upgraded to : " + ver);
	}
	public void updateRunCount()
	{
		noOfRuns++;
	}
	public void play(int noOfP)
	{
		System.out.println("Let's play. We are " + noOfP + " people.");
	}
	
	public void sell(int items, double d)
	{
		if (items > 10)
			System.out.println("Your special discount is: " + (d+0.1*d));
		else
			System.out.println("You're getting " + d + " % discount today!");
	}
	
	public double rent(int items, String gType, int days)
	{
		double amount = 0;
		if (days > ShopInterface.duration)
		{
			System.out.println("You will have to pay fine.");
			amount = 50;
		}
		if (gType.equals("AR/VR"))
		{
			System.out.println("You need to pay deposit for the equipment.");
			return (items*500 + amount);
		}
		else
		{
			return (items*300 + amount);
		}
		
	}

}

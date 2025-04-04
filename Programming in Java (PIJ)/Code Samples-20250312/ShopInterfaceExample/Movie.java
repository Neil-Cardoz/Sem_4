
class Movie extends EntertainmentSrc {
	public String title;
	public String genre;
	public int duration;
	public boolean hasSubtitles;
	public String industryName; //Hollywood, Bollywood etc.
	public String language;
	public static String[] languages = new String[5]; // Need to initialize the array in constructor.
	public int noOfAwards;
	
	private double productionBudget;
	private String encoding; //NTSC, PAL, HGVC
	
	public String ageRating; //U, A, U/A, PG13
	
	public Movie()
	{
		//languages = new String[5];
		languages[0] = "Hindi";
		languages[1] = "English";
		
	}
	
	public double getBudget()
	{
		return productionBudget;
	}
	public void setBudget(double b)
	{
		productionBudget = b;
	}
	public String getEncoding()
	{
		return encoding;
	}
	public void setEncoding(String e)
	{
		encoding = e;
	}
	public void addLanguage(String l)
	{
		//languages = new String[10];
		//Add a new language to the languages array.
		//languages.
		//int len = languages.length;
		
		
	}
	public void play(int noOfP)
	{
		System.out.println("The movie is playing for " + noOfP + " watchers.");
	}

}

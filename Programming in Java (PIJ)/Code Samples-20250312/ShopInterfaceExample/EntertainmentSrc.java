
abstract class EntertainmentSrc {
	public int srcId;
	public int noOfParticipants;
	public int rating;
	public int streamCount;
	
	protected String[] upcomingTitles;
	protected static String srcType;
	protected String franchiseName;
	
	public EntertainmentSrc()
	{
		srcId = 1001;
		noOfParticipants = 1;
		rating = 0;
		streamCount = 0;
		upcomingTitles = new String[5];
		upcomingTitles[0] = "The marvelous Mrs. Maizel";
		upcomingTitles[1] = "Comicstan Season 5";
		srcType = "Audiovisual";
		franchiseName = "";
	}
	
	public double calcClickThroughRate(int participants, int sCount)
	{
		return (sCount/participants);
	}
	abstract public void play(int noOfParticipants);
}

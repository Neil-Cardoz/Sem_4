//import java.util.GregorianCalendar;
public class MainForEntSource {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Movie m1 = new Movie();
		displayMovieAttribs(m1);
		
		/*m1.srcId = 1001;
		m1.noOfParticipants = 1;
		//m1.srcType = "Video";
		m1.title = "Pushpa";
		m1.ageRating = "PG13";
		m1.duration = 149;
		m1.genre = "Family drama";
		m1.hasSubtitles = true;
		m1.setBudget(20000000);	
		displayMovieAttribs(m1);
		m1.play(1);*/
		
		/*Game g1 = new Game();
		EntertainmentSrc.srcType = "Physical";
		//displayGameAttribs(g1);
		g1.sell(10, 20);
		//g1.play(5);
		
		Toy t1 = new Toy();
		//Toy t3 = t1;
		Game g4 = t1;
		//displayGameAttribs(g4);
		g4.sell(15, 10);*/
		
		//t1.play(5);
		
		//t1.play();
		
		/*Game g2 = new Toy();
		g2.play(1);*/
		//g2.play();
		
		/*Toy t2= new Toy();
		t2.franchiseName = "Game of Thrones";
		t2.genre = "Real time";
		t2.sell(5, 5.5);
		double res = t2.rent(2, "AR/VR", 50);
		System.out.println("Rent amount:" + res);*/
		
		/*Game g3 = new Game("Turn based", "Adventure", new GregorianCalendar(2020, 10, 10), "Physical", 10000 );
		displayGameAttribs(g3);
		g3.update(8);
		g3.play(10);*/
	}
	
	public static void displayMovieAttribs(Movie m)
	{
		System.out.println("=========Movie attributes===========");
		System.out.println("Source id: " + m.srcId);
		System.out.println("No. of participants :" + m.noOfParticipants);
		System.out.println("Rating :" + m.rating);
		System.out.println("Stream count: " + m.streamCount);
		for(String t : m.upcomingTitles)
		{
			System.out.println("Upcoming title: " + t);
		}
		System.out.println("Source type: " + m.srcType);
		System.out.println("Franchise :" + m.franchiseName);
		System.out.println("Title :" + m.title);
		System.out.println("Genre :" + m.genre);
		System.out.println("Duration :" + m.duration);
		System.out.println("Sub titles?" + m.hasSubtitles);
		System.out.println("Industry :" + m.industryName);
		System.out.println("Language: " + m.language);
		for(String l : Movie.languages)
		{
			System.out.println("Languages: " + l);
		}
		System.out.println("# of awards :" + m.noOfAwards);
		System.out.println("Budget: " + m.getBudget());
		System.out.println("Encoding: " + m.getEncoding());
		System.out.println("Age rating: " + m.ageRating);
		
		System.out.println("=========End Movie attributes===========");
		
	}
	public static void displayGameAttribs(Game g)
	{
		System.out.println("=========Game attributes===========");
		System.out.println("Source id: " + g.srcId);
		System.out.println("No. of participants :" + g.noOfParticipants);
		System.out.println("Rating :" + g.rating);
		System.out.println("Stream count: " + g.streamCount);
		for(String t : g.upcomingTitles)
		{
			System.out.println("Upcoming title: " + t);
		}
		System.out.println("Source type: " + EntertainmentSrc.srcType);
		System.out.println("Franchise :" + g.franchiseName);
		System.out.println("Type: " + g.gameType);
		System.out.println("Genre: " + g.genre);
		System.out.println("Last updated: " + g.lastUpdated);
		System.out.println("Medium: " + g.medium);
		System.out.println("# of runs: " + g.getNoOfRuns());
		
		System.out.println("=========End Game attributes===========");
	}

}


class Toy extends Game {
	public double length;
	public double height;
	public double width;
	public String color;
	public int noOfPieces;
	public String material;
	
	public void assemble(int noOfPieces)
	{
		System.out.println("Your toy has " + noOfPieces + " pieces.");
		System.out.println("1. Count the no. of pieces. 2. Arrange them in order. 3. Use a #2 spanner.");
		System.out.println("Connect pieces # 2, 4, 6 as shown in the picture.");
		System.out.println("Voila! Your toy is assembled!");
	}
	public void customize(double length, double width, double height)
	{
		if (length < 20 || width < 15 || height < 30)
		{
			System.out.println("Parameters are less than prescribed for the disabled player.");
			System.out.println("Needs customization!");
		}
		else
			System.out.println("No need to customize.");
		
	}
	public void play(int n)
	{
		super.play(n);
		if (n > 1)
			System.out.println("I don't want to share!");
		else
			System.out.println("I'm enjoying this!");
	}
	public void play()
	{
		System.out.println("I don't need any players.");
	}

}

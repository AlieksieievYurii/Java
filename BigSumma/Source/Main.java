public class Main
{
	public static void main(String[] args) 
	{
		WriteArrayFromFile readFile = new WriteArrayFromFile("Array.txt");
		int[][] Numbers = new int[readFile.sizeY][readFile.sizeX];
		Numbers = readFile.FillNumbers();

		System.out.println(readFile.sizeX+" "+readFile.sizeY);

		//printArray(Numbers);

	}

	private static void printArray(int[][] Array)
	{
		for(int i = 0; i < Array.length; i++)
		{
			for(int g = 0; g < Array[i].length; g++)
				System.out.print(Array[i][g]+" ");
		}
		System.out.println();
	}
}
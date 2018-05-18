import java.io.*;

public class WriteArrayFromFile
{

	private File file;
	private FileInputStream fil;

	public int sizeX = 0;
	public int sizeY = 0;

	public WriteArrayFromFile(String nameFile)
	{
		file = new File(nameFile);
		if(!file.exists())
		{
			System.out.println("Error, not found the file!");
			System.exit(1);
		}

		try
		{
			fil = new FileInputStream(file);
			int sym;
			while((sym = fil.read()) != -1)
			{
				char symbol = (char)sym;
			}
			fil.close();
		}catch(IOException e){System.out.println("Error of opening file " + nameFile);}

		SizeX();
		SizeY();
	}

	private void SizeX()
	{
		try
		{
			fil = new FileInputStream(file);
			int sym;
			while((sym = fil.read()) != 10 && sym != 13)sizeX++;
			fil.close();
		}catch(IOException e){System.out.println("Error of sizeX!");}
	}

	private void SizeY()
	{
		try
		{
			fil = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(fil));

			while(reader.readLine() != null) sizeY++;

			reader.close();
			fil.close();
		}catch(IOException e){System.out.println("Error of sizeY!");}

	}

	public int[][] FillNumbers()
	{
		int[][] array = new int[sizeY][sizeX];
		int sym,x = 0,y = 0;
		try
		{
			
			fil = new FileInputStream(file);

			while((sym = fil.read()) != -1)
			{
				System.out.println(sym);
			}
			
		}catch(IOException e)
		{
			System.out.println("Error of filling array!");
			System.exit(2);
		}
		return array;
	}
}
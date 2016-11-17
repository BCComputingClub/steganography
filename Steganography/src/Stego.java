import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;

// havent gotten writing to picture yet
// all files are hardcoded for my (Austin) machine
public class Stego 
{
	static BufferedImage image = null;
	
	public static void main (String[] args) throws IOException
	{
		String fileName;	// need to get from GUI
		PrintWriter text;	// debug logging
		BufferedImage test;	// color change test
		
		int height;
		int width;
		int rbg;
		
		fileName = "C:/Users/Austin/Desktop/bricks.bmp";	// temporaraly hardcoded, need to be changed later
		try
		{
			image = ImageIO.read(new File(fileName));
		} catch (IOException e) {
			System.out.println("Image not found.");
		}
		text = new PrintWriter(new File("C:/Users/Austin/Desktop/stego.txt"));
		test = ImageIO.read(new File("C:/Users/Austin/Desktop/bricks_alt.bmp"));
		
		height = image.getHeight();
		width = image.getWidth();
		
		// prints pizel values to file
		System.out.println((height * width) + " pixels");
		System.out.println(image.getRGB(0, 0));
		System.out.println(Integer.toBinaryString(image.getRGB(0, 0)) + "  " + Integer.numberOfLeadingZeros(image.getRGB(0, 0)));
		for (int h = 0; h < height; h++)
		{
			for (int w = 0; w < width; w++)
			{
				text.print(image.getRGB(h, w) + "  ");
			}
			text.println("x");
		}
		
		// just some tests
		test.setRGB(0, 0, 0);
		test.setRGB(0, 1, -2222222);
		test.setRGB(0, 2, -3333333);
		test.setRGB(1, 0, -1198364);
		test.setRGB(1, 1, -1263224);
		test.setRGB(1, 2, -2473595);
		text.close();
	}
}

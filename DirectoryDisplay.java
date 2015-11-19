/* Benjamin Wu
 * CISC 3150 HW7
 * Display Directory Tree
 *
 * Comments: Got help from websites to begin working on how to display the directories in the computer. Combined code from both websites.
 * editted it somewhat to try to display directories only, but not working...
 * http://www.java-examples.com/list-contents-directory
 * http://www.avajava.com/tutorials/lessons/how-do-i-recursively-display-all-files-and-directories-in-a-directory.html
 *
 */

import java.io.*;

public class DirectoryDisplay 
{

	public static void main(String[] args)
	{							
		int counter = 0;				//counter for putting spaces for ez reading directory in directory
								//Testing using "../" for simplicity single directory.
		File BeginFile = new File("../");		//goes thru previous directories, will try to make a recursive? check for parent directory, up to root?
		showDirectories(BeginFile, counter);			//but spamming ../../../ doesnt make an error of out of bounds, it ends up at BOOT *world languages* (Windows OS) 
	}
	public static void showDirectories(File secondFile, int counter) {
		File[] fileArray = secondFile.listFiles(); 	//to create array for all the files
		for (File checkMoreFiles: fileArray) 		//they used enhanced for loop for each file, check if a file exists, do this.
		{
		if (checkMoreFiles.isDirectory())
			{

		/*						// Using .list() prints out all files. but..dont want that. made a string array, used getName() and isDirectory()
			String[] stringArray = new String[1]; 	//creates a string array since I cannot use string[] = .getName
			for (int i = 0; i < stringArray.length; i++)
				{
				stringArray[i] = checkMoreFiles.getName(); 
				}
			for (String directoryName : stringArray)
				{
				System.out.println(directoryName);
				}
		System.out.println(checkMoreFiles.getPath()); //This prints out the directories only, but it doesn't create spaces or tabs to become 'tree' like
		*/
			if (counter == 0) 
				{
				System.out.println(checkMoreFiles.getName());	//FML. instead of using this complicated stuff, can just use .getName() prints it out.
				//System.out.println(counter);
				}
			else if (counter > 0)
				{
				System.out.println("\t" + checkMoreFiles.getName());
				//System.out.println(counter);
				}
			showDirectories(checkMoreFiles, counter); 	//recursive call.
			}
		}
	}
}

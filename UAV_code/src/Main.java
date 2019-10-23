import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public final static int k = 50; 
	public final static String path_coords = "/Users/spencerseliga/Documents/coords.csv";
	
	public static void main(String[] args){
		
		// ----- Init String Arrays being used ----- 
		String current[]; //Image currently processing
		String ideal[] = "1,1,1,1,1,1,1,1,1,1".split(",");//The perfect image capturing every element. 		
		String content[] = readFile("/Users/spencerseliga/Documents/images.csv").split("\n");
		
		
		// ----- Init necessary int variables (Counters + Hamming Dist) --------- 
		int currentDist;// currentDist is used to store Hamming Dist from perfect image
		int i,j; // Just counters 
		
		// Init all Array lists to store the necessary info to access position in original file, hamming distance from perfect image, 
		//and the list of your best "k" images. 
		
		ArrayList<String[]> best = new ArrayList<>();//store the first "k" images with smallest Hamming Distance
		ArrayList<Integer> hammingList = new ArrayList<>();// store the Hamming Distance of image from perfect image
		ArrayList<Integer> position = new ArrayList<>();//store the position of each image
		// add the first image into the list 
		current = content[0].split(",");
		best.add(current);
		hammingList.add(get_hamming(ideal,current));
		position.add(1);
		//from here we will add the rest of the images. 
			
		for (i = 1; i < k; i++) {
			current = content[i].split(",");
			currentDist = get_hamming(ideal,current);
			if (!check_existance(best,current)) {
				for (j = 0; j < best.size(); j++) {
					if (currentDist < hammingList.get(j)) {
						best.add(j,current);
						hammingList.add(j,currentDist);
						position.add(j,i+1);
						break;
					}
					else if (j == (best.size()-1)) {
						best.add(j,current);
						hammingList.add(j,currentDist);
						position.add(j,i+1);
						break;
					}
				}
			}
		}
		
		
		while (i < content.length) {
			current = content[i].split(",");
			currentDist = get_hamming(ideal,current);
			for (j = 0; j < k; j++) {
				if (currentDist < hammingList.get(j)) {
					best.add(j,current);
					hammingList.add(j,currentDist);
					position.add(j,i+1);
					best.remove(k);
					hammingList.remove(k);
					position.remove(k);
					break;
				}
			}
			i++;
		}
		System.out.print("The following images are the images we want to keep." + "\n" + "Here are their positions." + "\n");
		for (j = 0; j < k; j++)
			System.out.print(position.get(j) + ", ");
		System.out.print("\n" + "They are sorted smallest to largest based off their hamming distance");
		
		
		
		//output the corresponding coordinate
		ArrayList<String> coords = new ArrayList<>();

		content = readFile(path_coords).split("\n");
		for (i = 0; i < k; i++) {
			String coord = content[position.get(i)] + "\n";
			coords.add(coord);
			System.out.println(coord);
		}
		

		

	}
		
		
		
		

	
	
	
	public static int get_hamming(String[] A, String[] B) {
		int i,count = 0;
		int size = A.length;
		for (i = 0; i < size; i++) {
			if (!A[i].equals(B[i]))
				count++;
		}
		return count;
	}

	private static String readFile(String strings) {
		File file = new File(strings);
		String content = "Could not input data";
		try {
			FileInputStream fis = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fis.read(data);
			fis.close();
			content = new String(data, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}
	
	private static boolean check_existance(ArrayList<String[]> list, String[] str) {
		int i,j;
		int length = str.length;
		for (i = 0; i < list.size(); i++) {
			for (j = 0; j < length; j++) {
				//see if the image is the same 
				if (list.get(i)[j] != str[j]) //check if bits do not match
					break;//still  not found
				else if (j == (length - 1))//this is if the last bit in the string matches. 
					return true;
			}
		}
		return false;//if the string is all zeros. 
	}
	
	
	
	
}

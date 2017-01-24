package nl.bos.hackerearth.input_output;

/**
 * https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/roy-and-profile-picture/
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * No package structure! Main throws an Exception
 */
public class RoyAndProfilePicture {

	private static final String STR_TOKEN_DELIM_SPACE = " ";
	private static final String STR_MSG_UPLOAD_ANOTHER = "UPLOAD ANOTHER";
	private static final String STR_MSG_ACCEPTED = "ACCEPTED";
	private static final String STR_MSG_CROP_IT = "CROP IT";

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int lenght = s.nextInt();
		s.nextLine(); // = Carriage return <Enter>
		int nrPhotos = s.nextInt();
		s.nextLine(); // = Carriage return <Enter>

		String[] widthHeightPhotos = new String[nrPhotos];
		for (int i = 0; i < nrPhotos; i++) {
			widthHeightPhotos[i] = s.nextLine();
		}
		System.out.println(renderOutput(widthHeightPhotos, lenght).trim());
		s.close();
	}

	private static String renderOutput(String[] widthHeightPhotos, int lenght) {
		List<String> results = new ArrayList<String>();
		for (int i = 0; i < widthHeightPhotos.length; i++) {
			StringTokenizer tokenizer = new StringTokenizer(
					widthHeightPhotos[i], STR_TOKEN_DELIM_SPACE);
			int width = Integer.parseInt(tokenizer.nextToken());
			int height = Integer.parseInt(tokenizer.nextToken());

			if ((width < lenght) || (height < lenght))
				results.add(STR_MSG_UPLOAD_ANOTHER);
			else if ((width >= lenght) && (height >= lenght)) {
				if (width == height)
					results.add(STR_MSG_ACCEPTED);
				else
					results.add(STR_MSG_CROP_IT);
			}

		}
		return results.stream().collect(Collectors.joining("\n"));
	}
}

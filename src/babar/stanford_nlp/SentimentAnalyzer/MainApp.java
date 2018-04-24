package babar.stanford_nlp.SentimentAnalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import babar.stanford_nlp.model.SentimentResult;
/***********************************
 * Created by Babar on 4/22/2018.  *
 ***********************************/
public class MainApp {

	public static void main(String[] args) throws IOException {


		String text;
		List<String> listOfReviews = null;
		double overAllFileResult = 0.0;
		SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();
		sentimentAnalyzer.initialize();
		if(args!=null && args.length>0 && args[0].equals("-f")) {
			if(args!= null && args.length>0 && args[1]!=null) {
				text = args[1];
				if(text.endsWith("txt")) {
					listOfReviews = readFile(args[1]);
				}


				if(listOfReviews!=null && listOfReviews.size()>0) {
					for(int i=0;i<listOfReviews.size();i++) {
						SentimentResult sentimentResult = sentimentAnalyzer.getSentimentResult(listOfReviews.get(i));

						System.out.println("Sentiment Score: " + sentimentResult.getSentimentScore());
						System.out.println("Sentiment Type: " + sentimentResult.getSentimentType());
						System.out.println("Very positive: " + sentimentResult.getSentimentClass().getVeryPositive()+"%");
						System.out.println("Positive: " + sentimentResult.getSentimentClass().getPositive()+"%");
						System.out.println("Neutral: " + sentimentResult.getSentimentClass().getNeutral()+"%");
						System.out.println("Negative: " + sentimentResult.getSentimentClass().getNegative()+"%");
						System.out.println("Very negative: " + sentimentResult.getSentimentClass().getVeryNegative()+"%");
						overAllFileResult+=sentimentResult.getSentimentScore();
					}
					overAllFileResult /=listOfReviews.size();
					System.out.println("**************");
					System.out.println("Overall review result  is : "+OverAllResultStr(overAllFileResult));


				}
			}}else if(args!=null && args.length>0 && args[0].equals("-s")) {
				SentimentResult sentimentResult = sentimentAnalyzer.getSentimentResult(args[1]);

				System.out.println("Sentiment Score: " + sentimentResult.getSentimentScore());
				System.out.println("Sentiment Type: " + sentimentResult.getSentimentType());
				System.out.println("Very positive: " + sentimentResult.getSentimentClass().getVeryPositive()+"%");
				System.out.println("Positive: " + sentimentResult.getSentimentClass().getPositive()+"%");
				System.out.println("Neutral: " + sentimentResult.getSentimentClass().getNeutral()+"%");
				System.out.println("Negative: " + sentimentResult.getSentimentClass().getNegative()+"%");
				System.out.println("Very negative: " + sentimentResult.getSentimentClass().getVeryNegative()+"%");
			}else {
				text = "S8 is a good mobile";
				SentimentResult sentimentResult = sentimentAnalyzer.getSentimentResult(text);

				System.out.println("Sentiment Score: " + sentimentResult.getSentimentScore());
				System.out.println("Sentiment Type: " + sentimentResult.getSentimentType());
				System.out.println("Very positive: " + sentimentResult.getSentimentClass().getVeryPositive()+"%");
				System.out.println("Positive: " + sentimentResult.getSentimentClass().getPositive()+"%");
				System.out.println("Neutral: " + sentimentResult.getSentimentClass().getNeutral()+"%");
				System.out.println("Negative: " + sentimentResult.getSentimentClass().getNegative()+"%");
				System.out.println("Very negative: " + sentimentResult.getSentimentClass().getVeryNegative()+"%");
			}
	}

	public static List<String> readFile(String fileName){
		BufferedReader br = null;
		List<String> sb = null;;
		try {
			br = new BufferedReader(new FileReader(fileName));
			sb = new ArrayList<>();
			String line = br.readLine();

			while (line != null) {
				sb.add(line);
				line = br.readLine();
			}
			br.close();
		}catch(Exception e) {

		} finally {

		}
		return sb;
	}

	public static String OverAllResultStr(double value) {
		switch ((int)Math.ceil(value)) {
		case 0:
			return "Very Negative";
		case 1:
			return "Negative";
		case 2:
			return "Neutral";
		case 3:
			return "Positive";
		case 4:
			return "Very Positive";
		default:
			return "Un-defined";
		}
	}


}

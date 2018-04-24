package babar.stanford_nlp.model;

/***********************************
 * Created by Babar on 4/22/2018.  *
 ***********************************/

public class SentimentResult {

	double sentimentScore;
	String sentimentType;
	SentimentClassification sentimentClass;

	public double getSentiment() {
		return sentimentScore;
	}

	public double getSentimentScore() {
		return sentimentScore;
	}

	public void setSentimentScore(double sentimentScore) {
		this.sentimentScore = sentimentScore;
	}

	public String getSentimentType() {
		return sentimentType;
	}

	public void setSentimentType(String sentimentType) {
		this.sentimentType = sentimentType;
	}

	public SentimentClassification getSentimentClass() {
		return sentimentClass;
	}

	public void setSentimentClass(SentimentClassification sentimentClass) {
		this.sentimentClass = sentimentClass;
	}

	

}

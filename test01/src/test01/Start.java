package test01;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import opennlp.tools.sentdetect.*;

public class Start {

	public static void main(String[] args) {
		
		InputStream in = null;
		try {
			in = new FileInputStream("en-sent.bin");
			SentenceModel model = new SentenceModel(in);
			SentenceDetectorME detector = new SentenceDetectorME(model);
			String sentences[] = detector.sentDetect("Hello! I am Eric.");
			
			for (int i=0; i<sentences.length; i++) {
				System.out.println(sentences[i]);
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			
			if (in != null) {
				try {
					in.close();
				} catch (IOException ioe) {
					
				}
			}
		}
	}

}

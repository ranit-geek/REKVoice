package COM.SCISS.REK;

import java.io.IOException;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class SphinxConfig extends Base {
	public static void getSphinxConfig() throws IOException
	{
		configuration = new Configuration();
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("/Users/ranit/git/repository/Rek/REK/0305.dic");
        configuration.setLanguageModelPath("/Users/ranit/git/repository/Rek/REK/0305.lm");
        recognize = new LiveSpeechRecognizer(configuration);
        recognize.startRecognition(true);  
	}

}

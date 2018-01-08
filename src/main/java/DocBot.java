import edu.cmu.sphinx.api.*;

public class DocBot {
	private static final String ACOUSTIC_MODEL = "resource:/edu/cmu/sphinx/models/en-us/en-us";
	private static final String DICTIONARY_PATH = "resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict";
	private static final String GRAMMAR_PATH = "resource:/edu/cmu/sphinx/demo/dialog/";
	private static final String LANGUAGE_MODEL = "resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin";
	
	public static void main(String args[]) throws Exception {
		Configuration configuration = new Configuration();
		//Set path to acoustic model.
		configuration.setAcousticModelPath(ACOUSTIC_MODEL);
		//Set path to dictionary.
        configuration.setDictionaryPath(DICTIONARY_PATH);
        //Set path to language model.
        configuration.setLanguageModelPath(LANGUAGE_MODEL);
        //Set path to grammar rules.
        configuration.setGrammarPath(GRAMMAR_PATH);
        configuration.setUseGrammar(true);
        
        LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
	    // Start recognition process pruning previously cached data.
	    recognizer.startRecognition(true);
	    SpeechResult result = recognizer.getResult();
	    // Pause recognition process. It can be resumed then with startRecognition(false).
	    recognizer.stopRecognition();
	    
	    System.out.println(result.getHypothesis());
	}
}

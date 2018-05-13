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
        
        configuration.setGrammarName("dialog");
        LiveSpeechRecognizer jsgfRecognizer =
            new LiveSpeechRecognizer(configuration);

        configuration.setUseGrammar(false);
        configuration.setLanguageModelPath(LANGUAGE_MODEL);
        LiveSpeechRecognizer lmRecognizer =
            new LiveSpeechRecognizer(configuration);

        jsgfRecognizer.startRecognition(true);
        while (true) {
            System.out.println("Choose menu item:");
            System.out.println("Example: go to the bank account");
            System.out.println("Example: exit the program");
            System.out.println("Example: weather forecast");
            System.out.println("Example: digits\n");

            String utterance = jsgfRecognizer.getResult().getHypothesis();

            if (utterance.startsWith("exit"))
                break;
        }
        
        jsgfRecognizer.stopRecognition();
	}
}

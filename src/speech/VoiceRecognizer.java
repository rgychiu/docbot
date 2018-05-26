package speech;

import java.io.IOException;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;

/**
 * Class that handles voice recognition/input.
 * Code adapted from https://cmusphinx.github.io/wiki/tutorialsphinx4/.
 */
public class VoiceRecognizer {
    // Necessary file paths
    private static final String LANGUAGE_MODEL = "resource:/edu/cmu/sphinx/models/en-us/en-us";
    private static final String DICTIONARY = "resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict";
    private static final String ACOUSTIC_MODEL = "resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin";

    // Setup requirements
    private static Configuration configuration;
    private static LiveSpeechRecognizer recognizer;

    // Recognizer results
    private String result;

    /**
     * Constructor that intializes and sets up necessary file connections.
     */
    public VoiceRecognizer() throws IOException {
        // Set up configuration and dependencies
        configuration = new Configuration();
        configuration.setLanguageModelPath(LANGUAGE_MODEL);
        configuration.setDictionaryPath(DICTIONARY);
        configuration.setAcousticModelPath(ACOUSTIC_MODEL);

        // TODO: Fix unknown format exception
        recognizer = new LiveSpeechRecognizer(configuration);
    }

    /**
     * Wrapper start recognition method.
     */
    public void startCleanRecognition() {
        recognizer.startRecognition(true);
    }

    /**
     * Wrapper start recognition method, except without clearing cached data.
     */
    public void resumeRecognition() {
        recognizer.startRecognition(false);
    }

    /**
     * Wrapper stop recognition method, except store result.
     */
    public void pauseRecognition() {
        result = recognizer.getResult().getHypothesis();
        recognizer.stopRecognition();
    }

    /**
     * Wrapper stop recognition method.
     */
    public void stopRecognition() {
        recognizer.stopRecognition();
    }

    public String getResult() {
        return result;
    }
}

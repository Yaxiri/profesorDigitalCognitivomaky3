package logicaIntegracion;

import java.util.List;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechAlternative;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Transcript;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.BaseRecognizeCallback;

public class ServicioVosATexto {
	static String Resultado;
	
public static void SpeechToText() throws InterruptedException, LineUnavailableException {
		
/*		SpeechToText service = new SpeechToText();
		service.setUsernameAndPassword("d6484b2a-587c-4819-ba78-2988c14b6f36", "uV7ngppwWo37");

		// Signed PCM AudioFormat with 16kHz, 16 bit sample size, mono
		int sampleRate = 16000;
		AudioFormat format = new AudioFormat(sampleRate, 16, 1, true, false);
		DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

		if (!AudioSystem.isLineSupported(info)) {
			System.out.println("Line not supported");
			System.exit(0);
		}

		TargetDataLine line = (TargetDataLine) AudioSystem.getLine(info);
		line.open(format);
		line.start();

		AudioInputStream audio = new AudioInputStream(line);

		RecognizeOptions options = new RecognizeOptions.Builder().continuous(true).interimResults(true).model("es-ES_BroadbandModel")
				// .inactivityTimeout(5) // use this to stop listening when the
				// speaker pauses, i.e. for 5s
				.contentType(HttpMediaType.AUDIO_RAW + "; rate=" + sampleRate).build();

		service.recognizeUsingWebSocket(audio, options, new BaseRecognizeCallback() {
			public void onTranscription(SpeechResults speechResults) {
				List<Transcript> V1 = speechResults.getResults();
				Transcript V2 = V1.get(0);
				if (V2.isFinal() != false) {
					List<  > V3 = V2.getAlternatives();
					SpeechAlternative V4 = V3.get(0);
					System.out.println(V4.getTranscript() + " ");
					Resultado += V4.getTranscript() + " ";
				}
			}
		});

		System.out.println("Listening to your voice for the next 30s...");
		Thread.sleep(30 * 1000);

		// closing the WebSockets underlying InputStream will close the
		// WebSocket itself.
		line.stop();
		line.close();
		System.out.println("Fin.");*/
	}
}

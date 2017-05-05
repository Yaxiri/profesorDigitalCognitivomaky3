package logicaIntegracion;

import com.ibm.watson.developer_cloud.language_translator.v2.LanguageTranslator;
import com.ibm.watson.developer_cloud.language_translator.v2.model.Language;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslationResult;

public class ServicioTraducto {

	public static String Traductor(String scrollBar) {
		LanguageTranslator service = new LanguageTranslator();
		TranslationResult translationResult = null;
		service.setUsernameAndPassword("64af68c0-118b-42bf-b711-a51a4b885775", "EIAXzfLfYNg5");
		translationResult = service.translate(scrollBar, Language.SPANISH, Language.ENGLISH).execute();
		
		String traductor = (String) translationResult.getTranslations().get(0).getTranslation();
		
		return traductor;
	}
}

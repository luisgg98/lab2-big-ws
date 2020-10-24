package translator.infrastructure;

import org.springframework.stereotype.Component;

@Component
public class DummyTranslator extends TranslatorImpl {

  @Override
  protected String translateInternal(String from, String to, String text, String encodedText) {
    /*Se fuerza a que lance una excepcion por defecto*/
    throw new RuntimeException( "I don't know how to translate from "+from+" to "+ to + " the text '"+text+"'");
  }
}

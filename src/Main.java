import com.gustavosiqueira.camelcase.CamelCase;
import com.gustavosiqueira.camelcase.CamelCaseException;

import java.util.List;

public class Main {

    public static void main(String[] args) throws CamelCaseException {

        List<String> values = CamelCase.convertCamelCase("recupera10Primeiros");
        String list = values.toString();

        System.out.println(list);

    }

    public static void displayMessage(String message) {
        System.out.println(message);
    }
}

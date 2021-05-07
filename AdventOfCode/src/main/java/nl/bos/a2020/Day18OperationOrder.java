package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Day18OperationOrder {

    public Day18OperationOrder() throws ScriptException {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day18OperationOrder");
        List<String> expressions = AdventReadInput.readData(is);

        List<Long> resultValues = new ArrayList<>();
        for (String expression : expressions) {
            long resultValue = calc(expression);
            System.out.printf("resultValue = %d%n", resultValue);
            resultValues.add(resultValue);
        }

        System.out.printf("The sum of the resulting values = %d%n", resultValues.stream().mapToLong(Long::longValue).sum());
    }

    public static void main(String[] args) throws ScriptException {
        new Day18OperationOrder();
    }

    private long calc(String expression) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        return Long.parseLong(engine.eval(expression).toString());
    }
}


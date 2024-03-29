package Backend;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Helper class to process math requests
 *
 * Authors: Gehrig Wilcox
 * */
public class MathHelper {

    static ScriptEngineManager mgr = new ScriptEngineManager();
    static ScriptEngine engine = mgr.getEngineByName("Nashorn");

    public static String eval(String eq){
        try{
            return "" + engine.eval(eq);
        }catch(ScriptException e){
            e.printStackTrace();

            return "";
        }
    }
}

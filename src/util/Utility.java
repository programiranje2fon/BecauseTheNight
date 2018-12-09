/*
 * Created on Dec 9, 2018
 *
 */
package util;

import java.io.File;

public class Utility {
    
    public static String getProjectDir() {
        StringBuffer sb = new StringBuffer((new File(".")).getAbsolutePath());
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    public static String mkProjectSubdir(String subdir) {
        File sd = new File(getProjectDir(), subdir);
        sd.mkdirs();
        return sd.getAbsolutePath();
    }

}

package MicroSpaceEmpire.iu.GUI;

import java.net.URL;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 * @param args
 */
public class Resources {

    public static final URL getResourceFile(String name) {
        // opens a file with path relative to location of the Resources class
        URL url = Resources.class.getResource(name);
        return url;
    }

}

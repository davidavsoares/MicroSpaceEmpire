package MicroSpaceEmpire.modelo.dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class EmptyException extends Exception {

    String location;

    public EmptyException(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Empty exception (no balls available in " + location + ")";
    }
}

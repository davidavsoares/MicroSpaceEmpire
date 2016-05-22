/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicroSpaceEmpire.modelo;

/**
 *
 * @author David
 */
public class StringException extends Exception {

    String situation;

    public StringException(String situation) {
        this.situation = situation;
    }

    @Override
    public String toString() {
        return "Empty exception (No more objects at" + situation + ")";
    }
}

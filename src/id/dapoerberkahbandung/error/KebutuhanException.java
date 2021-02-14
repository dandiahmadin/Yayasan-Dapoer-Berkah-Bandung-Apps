/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.error;

/**
 *
 * @author Alfi Nurizkya
 */
public class KebutuhanException extends Exception {

    /**
     * Creates a new instance of <code>DonaturException</code> without detail
     * message.
     */
    public KebutuhanException() {
    }

    /**
     * Constructs an instance of <code>DonaturException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public KebutuhanException(String msg) {
        super(msg);
    }
}

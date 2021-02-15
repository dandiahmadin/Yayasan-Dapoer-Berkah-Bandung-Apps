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
public class PengeluaranException extends Exception {

    /**
     * Creates a new instance of <code>PengeluaranException</code> without
     * detail message.
     */
    public PengeluaranException() {
    }

    /**
     * Constructs an instance of <code>PengeluaranException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PengeluaranException(String msg) {
        super(msg);
    }
}

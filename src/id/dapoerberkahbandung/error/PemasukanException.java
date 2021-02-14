/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.error;

/**
 *
 * @author Dandi Ahmadin
 */
public class PemasukanException extends Exception {

    /**
     * Creates a new instance of <code>PemasukanException</code> without detail
     * message.
     */
    public PemasukanException() {
    }

    /**
     * Constructs an instance of <code>PemasukanException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PemasukanException(String msg) {
        super(msg);
    }
}

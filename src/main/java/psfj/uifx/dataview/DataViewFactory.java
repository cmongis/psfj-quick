/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.dataview;

/**
 *
 * @author cyril
 */
@FunctionalInterface
public interface DataViewFactory<T> {
    DataView<T> create() throws Exception;
}

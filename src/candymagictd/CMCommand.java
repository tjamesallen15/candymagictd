/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package candymagictd;

import java.io.Serializable;

/**
 *
 * @author JamesAllen
 */
public class CMCommand implements Serializable {
    String cmCValue1;
    String cmCValue2;
    String cmCValue3;
    String cmCValue4;
    String cmCValue5;
    String cmCValue6;
    String cmCValue7;
    String cmCValue8;
    String cmCValue9;
    String cmCValue10;
    String[] cmArray1;
   
    public CMCommand(String cmv1, String cmv2, String cmv3, String cmv4, String cmv5, String cmv6, String cmv7, String cmv8, String cmv9, String cmv10, String[] cma1) {
        cmCValue1 = cmv1;
        cmCValue2 = cmv2;
        cmCValue3 = cmv3;
        cmCValue4 = cmv4;
        cmCValue5 = cmv5;
        cmCValue6 = cmv6;
        cmCValue7 = cmv7;
        cmCValue8 = cmv8;
        cmCValue9 = cmv9;
        cmCValue10 = cmv10;
        cmArray1 = cma1;
    }
    
    public synchronized String getCMValue1() {
        return cmCValue1;
    }
    
    public synchronized String getCMValue2() {
        return cmCValue2;
    }
    
    public synchronized String getCMValue3() {
        return cmCValue3;
    }
   
    public synchronized String getCMValue4() {
        return cmCValue4;
    }
    
    public synchronized String getCMValue5() {
        return cmCValue5;
    }
    
    public synchronized String getCMValue6() {
        return cmCValue6;
    }
    
    public synchronized String getCMValue7() {
        return cmCValue7;
    }
    
    public synchronized String getCMValue8() {
        return cmCValue8;
    }
    
    public synchronized String getCMValue9() {
        return cmCValue9;
    }
    
    public synchronized String getCMValue10() {
        return cmCValue10;
    }
    
    public synchronized String[] getCMArray1() {
        return cmArray1;
    }
}

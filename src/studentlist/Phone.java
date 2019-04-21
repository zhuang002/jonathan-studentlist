/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentlist;

/**
 *
 * @author zhuan
 */
class Phone {
    String countryCode="001";
    String areaCode="647";
    String code1="000";
    String code2="0000";
    
    @Override
    public String toString() {
        return countryCode+"-"+areaCode+"("+code1+")"+code2; 
    }

    void deserialize(String s) {
        this.countryCode=s.substring(0,3);
        this.areaCode=s.substring(4,7);
        this.code1=s.substring(8,11);
        this.code2=s.substring(12);
        
    }
}

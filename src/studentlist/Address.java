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
class Address {
    String room;
    String streetNumber;
    String street;
    String city;
    String province;
    String postCode;
    
   @Override
   public String toString() {
       return room+","+streetNumber+" "+street+","+city+","+province +" "+postCode;
   }

    void deserialize(String s) {
        String[] fields=s.split(",");
        this.room=fields[0];
        String[] subFields=fields[1].split(" ");
        this.streetNumber=subFields[0];
        this.street=fields[1].substring(this.streetNumber.length()+1);
        this.city=fields[2];
        subFields=fields[3].split(" ");
        this.province=subFields[0];
        this.postCode=fields[3].substring(this.province.length()+1);
        
        
    }
}

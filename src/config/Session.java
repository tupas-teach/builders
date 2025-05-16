/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author Dell
 */
public class Session {
    
     private static Session instance;
    private int id;
    private String fn;
    private String middle;
    private String ln;
    private String username;
    private String type;
      private String gender;
    private String email;
    private String status;
    private Session(){
    
}


    public static synchronized Session getInstance(){
       if(instance == null){
           instance = new Session();
       }
       return instance;
    }
    public static boolean isInstanceEmpty(){
        return instance ==null;
    }

    public int getId(){
        return id ;
    }

    public void setId(int id) {
         this.id = id;
   
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }
 public String getMiddle() {
        return middle;
    }
  public void setMiddle(String middle) {
        this.middle = middle;
    }
    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public String getUsername() {
        return username;
    }

    public void setUn(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getGender() {
      return gender;
    }
      public void setGender(String gender) {
        this.gender = gender;
      }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}

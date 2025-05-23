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
      private int c_id;
    private int p_id;
    private String p_date;
    private String p_updatedate;
    private String p_ontact;
    private String p_location;

    public String getP_location() {
        return p_location;
    }

    public void setP_location(String p_location) {
        this.p_location = p_location;
    }

    public String getP_ontact() {
        return p_ontact;
    }

    public void setP_ontact(String p_ontact) {
        this.p_ontact = p_ontact;
    }
    private String fn;
    private String middle;
    private String ln;
    private String username;
    private String contact;
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
   public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }
     
     public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
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
    public String getContact() {
        return contact;
    }
    public void setcontactN(String contact){
        this.contact = contact;
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
    
     public String getP_date() {
        return p_date;
    }

    public void setP_date(String p_date) {
        this.p_date = p_date;
    }
    
     public String getP_updatedate() {
        return p_updatedate;
    }

    public void setP_updatedate(String p_updatedate) {
        this.p_updatedate = p_updatedate;
    }

    
}

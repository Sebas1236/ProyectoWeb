//Javabean son clases que encapsulan muchos objetos en uno solo, lo que facilita el acceso a todos lo smiembros
//de la clase bean
package login.bean;

public class LoginBean {

 private String userName;
 private String password;
 private String correoUsu;
 public String getUserName() {
    return userName;
 }
 public void setUserName(String userName) {
    this.userName = userName;
 }
 public String getPassword() {
    return password;
 }
 public void setPassword(String password) {
    this.password = password;
 }

 public String getCorreoUsu() {
    return correoUsu;
 }

 public void setCorreoUsu(String correoUsu) {
    this.correoUsu = correoUsu;
 }
 
}

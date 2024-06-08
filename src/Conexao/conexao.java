/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ALFREDO CACONDA
 */
public class conexao {
    
    private Connection c;
    private String caminho="jdbc:mysql://localhost/carta_de_conducao";
    private String usuario="root";
    private String senha="";
  public Connection Conectar(){
      try {
          c=(Connection) DriverManager.getConnection(caminho, usuario, senha);
      } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
      catch(ClassCastException ex){
          JOptionPane.showMessageDialog(null, ex.getMessage());
      }
      return c;
  }
  public void mensagem(String sms){
      JOptionPane.showMessageDialog(null, sms);
  }    
}

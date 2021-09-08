package app;
import java.util.*;
import javax.swing.*;
public class DataAdmin extends EventObject{
	private String username;
	private String password;
	private JTextField user;
	private JPasswordField pass;
	public DataAdmin(Object a) {
		super(a);
	}
	public DataAdmin(Object source, String username, String password, JTextField user, JPasswordField pass) {
		super(source);
		this.user = user;
		this.pass = pass;
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setName(String name) {
		this.username = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public JTextField getUser() {
		return user;
	}
	public JPasswordField getPass() {
		return pass;
	}	
}

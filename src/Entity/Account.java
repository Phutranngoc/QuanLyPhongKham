/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author ADMIN
 */
public class Account {

    /**
     * @return the UserName
     */
    public String getUserName() {
        return UserName;
    }

    /**
     * @param UserName the UserName to set
     */
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the VaiTro
     */
    public Boolean getVaiTro() {
        return VaiTro;
    }

    /**
     * @param VaiTro the VaiTro to set
     */
    public void setVaiTro(Boolean VaiTro) {
        this.VaiTro = VaiTro;
    }
    private String UserName;
    private String Password;
    private Boolean VaiTro;
}

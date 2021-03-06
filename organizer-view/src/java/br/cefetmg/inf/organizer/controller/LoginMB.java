package br.cefetmg.inf.organizer.controller;

import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.service.IKeepUser;
import br.cefetmg.inf.organizer.proxy.KeepUserProxy;
import br.cefetmg.inf.util.PasswordCriptography;
import br.cefetmg.inf.util.exception.BusinessException;
import br.cefetmg.inf.util.exception.PersistenceException;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;


@Named(value = "loginMB")
@SessionScoped
public class LoginMB implements Serializable {
    
    private User currentUser;
    
    private final IKeepUser keepUser;
    
    public LoginMB() throws SocketException, UnknownHostException {
        this.keepUser = new KeepUserProxy();
        currentUser = new User();
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

   
    public String getUserLogin() throws PersistenceException, BusinessException{
        currentUser = keepUser.getUserLogin(currentUser.getCodEmail(), 
        PasswordCriptography.generateMd5(currentUser.getUserPassword()));
        
        if(currentUser == null){
            currentUser = new User();
            FacesContext.getCurrentInstance().addMessage("errorForm:errorCodeInput", new FacesMessage("Error 406!"));
            FacesContext.getCurrentInstance().addMessage("errorForm:errorTextInput", new FacesMessage("O login falhou!"));
            FacesContext.getCurrentInstance().addMessage("errorForm:errorSubTextInput", new FacesMessage("Verifique seu login e/ou senha ou cadastre-se."));
            PrimeFaces current = PrimeFaces.current();
            current.executeScript("PF('errorDialog').show();");
            return "false";
        }else{
            return "true";
        }
    }
    
    public void userLogout() throws IOException{
        currentUser = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("login.jsf");
    }
    
    
}
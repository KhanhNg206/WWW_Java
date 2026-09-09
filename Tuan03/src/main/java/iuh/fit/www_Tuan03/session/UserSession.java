package iuh.fit.www_Tuan03.session;

import iuh.fit.tranngocoanh_tuan02.service.ShoppingCart;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jdk.jfr.Name;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Named("userSession")
@SessionScoped
public class UserSession implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String instanceId = UUID.randomUUID().toString();
    private final ShoppingCart shoppingCart = new ShoppingCart();
    private String username;

    public void login (String username){
        this.username = username;
    }

    public boolean isLogged (){
        return username !=null;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public String getUsername() {
        return username;
    }
}

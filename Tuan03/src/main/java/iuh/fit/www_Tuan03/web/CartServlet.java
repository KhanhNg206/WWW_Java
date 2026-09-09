package iuh.fit.www_Tuan03.web;

import iuh.fit.tranngocoanh_tuan02.model.Product;
import iuh.fit.tranngocoanh_tuan02.service.ProductCatalog;
import iuh.fit.tranngocoanh_tuan02.service.ShoppingCart;
import iuh.fit.tranngocoanh_tuan02.session.UserSession;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/cart/add")
public class CartServlet extends HttpServlet {
    @Inject
    private ProductCatalog productCatalog;
    @Inject
    private UserSession userSession;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!userSession.isLogged()) {
            resp.sendRedirect(req.getContextPath() +"/login");
            return;
        }
        try {
            long productId = Long.parseLong(req.getParameter("productId"));
            Optional<Product> optionalProduct = productCatalog.findById(productId);
            if(optionalProduct.isPresent()){
                Product product = optionalProduct.get();

                ShoppingCart shoppingCart = userSession.getShoppingCart();
                shoppingCart.add(product);
            }
        }catch (NumberFormatException ignored){
        }

        resp.sendRedirect(req.getContextPath() + "/products");

    }
}

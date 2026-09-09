package iuh.fit.www_Tuan03.web;

import iuh.fit.tranngocoanh_tuan02.service.ProductCatalog;
import iuh.fit.tranngocoanh_tuan02.session.UserSession;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {

    @Inject
    private ProductCatalog productCatalog;
    @Inject
    private UserSession userSession;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!userSession.isLogged()) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        req.setAttribute("products", productCatalog.findAll());
        req.setAttribute("userSession", userSession);
        req.getRequestDispatcher("/WEB-INF/views/products.jsp").forward(req, resp);
    }
}

package org.example.www_tuan06_bai04.dao;

import org.example.www_tuan06_bai04.model.Book;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private DataSource dataSource;

    public BookDAO() {
        try {
            InitialContext context = new InitialContext();

            dataSource = (DataSource) context.lookup(
                    "java:comp/env/jdbc/shopdb"
            );

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {

        List<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM books";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Book book = new Book();

                book.setId(rs.getInt("id"));
                book.setTittle(rs.getString("tittle"));
                book.setAuthor(rs.getString("author"));
                book.setImgbook(rs.getString("imgbook"));
                book.setPrice(rs.getDouble("price"));

                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public Book getBookById(int id) {

        String sql = "SELECT * FROM books WHERE id = ?";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return new Book(
                            rs.getInt("id"),
                            rs.getString("tittle"),
                            rs.getString("author"),
                            rs.getString("imgbook"),
                            rs.getDouble("price")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Book> searchBooks(String keyword) {

        List<Book> books = new ArrayList<>();

        String sql = """
                SELECT * FROM books
                WHERE tittle LIKE ?
                   OR author LIKE ?
                """;

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            String search = "%" + keyword + "%";

            ps.setString(1, search);
            ps.setString(2, search);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    books.add(
                            new Book(
                                    rs.getInt("id"),
                                    rs.getString("tittle"),
                                    rs.getString("author"),
                                    rs.getString("imgbook"),
                                    rs.getDouble("price")
                            )
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }
}

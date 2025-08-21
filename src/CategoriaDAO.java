import java.sql.*;
import java.util.*;

public class CategoriaDAO {

    @SuppressWarnings("CallToPrintStackTrace")
    public void inserir(Categoria c) {
        String sql = "INSERT INTO Categorias (nome, ativo) VALUES (?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getNome());
            stmt.setBoolean(2, c.isAtivo());
            stmt.executeUpdate();
            System.out.println("Categoria inserida com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public List<Categoria> listar() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM Categorias";
        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Categoria c = new Categoria(rs.getString("nome"), rs.getBoolean("ativo"));
                c.setId(rs.getInt("id"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void atualizar(Categoria c) {
        String sql = "UPDATE Categorias SET nome = ?, ativo = ? WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getNome());
            stmt.setBoolean(2, c.isAtivo());
            stmt.setInt(3, c.getId());
            stmt.executeUpdate();
            System.out.println("Categoria atualizada!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void deletar(int id) {
        String sql = "DELETE FROM Categorias WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Categoria deletada!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

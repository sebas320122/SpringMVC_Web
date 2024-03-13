
package Repositories;

import Models.Usuario;
import java.sql.SQLSyntaxErrorException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository{
    //Importar mysql
     @Autowired
    private JdbcTemplate jdbcTemplate;

     //Metodo para registrar usuario
    @Override
    public void save(Usuario usuario) {
    String sql = "INSERT INTO usuarios (username, nombre, edad, sexo, password) VALUES (?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql,  usuario.getUsername(), usuario.getNombre(), 
                    usuario.getEdad(), usuario.getSexo(), usuario.getPassword());
        } catch (Exception e) {
            if (e.getCause() instanceof SQLSyntaxErrorException && e.getCause().getMessage().contains("Unknown database 'caj_ev3'")) {
                // Si no hay BD 
                System.out.println("No hay BD, favor de crear db caj_ev3 con tabla usuarios");
            } else {
               
                throw e;
            }
            }
        
    }

    @Override
    public List<Usuario> findAllDb() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int findByUP(String username, String password) {
        String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
    List<Usuario> usuarios = jdbcTemplate.query(sql, new Object[]{username, password}, new BeanPropertyRowMapper<>(Usuario.class));
    return usuarios.size();
    }

    @Override
    public boolean usernameExists(String username) {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE username = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, username);
        return count > 0;
    }
}

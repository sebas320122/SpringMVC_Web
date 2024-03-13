
package Repositories;

import Models.Registro;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RegistroRepositoryImpl implements RegistroRepository{
    //Importar mysql
     @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public void save(Registro registro) {
     String sql = "INSERT INTO registros (username, peso, estatura, imc, fecha) VALUES (?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql,  registro.getUsername(), registro.getPeso(), 
                    registro.getEstatura(), registro.getImc(), registro.getFecha());
        } catch (Exception e) {
            if (e.getCause() instanceof SQLSyntaxErrorException && e.getCause().getMessage().contains("Unknown database 'caj_ev3'")) {
                // Si no hay BD 
                System.out.println("No hay BD, favor de crear db caj_ev3 con tabla registros");
            } else {
               
                throw e;
            }
            }
        }

    //Conseguir todos los registros
    @Override
    public List<Registro> findAllDb() {
    String sql = "SELECT * FROM registros";
        List<Registro> registros = new ArrayList<>();
    try {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : rows) {
            Registro registrodb = new Registro((String) row.get("username"),
            (float) row.get("peso"),(float) row.get("estatura"),(float) row.get("imc"),
            (String) row.get("fecha"));
            registros.add(registrodb);
        }
    } catch (Exception e) {
        throw e;
    }
    return registros; 
    }

    
    
    
    //Despelgar registros de un Usuario
    @Override
    public List<Registro> findByUsername(String username) {
        String sql="SELECT * FROM registros";
        sql = "SELECT * FROM registros WHERE  username = ?";
        
        List<Registro> registros = new ArrayList<>();
    try {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, username);
        for (Map<String, Object> row : rows) {
            Registro registro = new Registro((String) row.get("username"),
            (float) row.get("peso"),(float) row.get("estatura"),(float) row.get("imc"),
            (String) row.get("fecha")      
            );            
            registros.add(registro);
        }
    } catch (Exception e) {
        throw e;
    }
    return registros;
        
    }
    
}

package com.agenda.repository;

import com.agenda.model.Contacto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactoRepository  {
    //TODO: creamos una instancia de la clase JdbcTemplate
    private final JdbcTemplate jdbc;


    public ContactoRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final RowMapper<Contacto> rowMapper =(rs, rowNum)->{
        Contacto contacto = new Contacto();

        contacto.setId(rs.getInt("id"));
        contacto.setNombre(rs.getString("nombre"));
        contacto.setTelefono(rs.getString("telefono"));
        contacto.setEmail(rs.getString("email"));

        return contacto;
    };

    //TODO: listar los contactos
    public List<Contacto> listarContacto(){
        return jdbc.query("SELECT * FROM contactos", rowMapper);
    }

    //TODO: guardar un nuevo contacto
    public void guardarContacto(Contacto contacto){
        jdbc.update("INSERT INTO contactos(nombre, telefono, email) VALUES(?,?,?)", contacto.getNombre(),contacto.getTelefono(), contacto.getEmail());
    }

    //TODO: buscar un contacto enviando como parametro un id
    public Contacto buscarPorId(int id){
        return jdbc.queryForObject("SELECT * FROM contactos where id=?",rowMapper, id);
    }

    //TODO: actualiar un contacto
    public void actualizarContacto(Contacto contacto){
        jdbc.update("UPDATE contactos SET nombre=?, telefono=?, email=? WHERE id=?", contacto.getNombre(), contacto.getTelefono(), contacto.getEmail(), contacto.getId());
    }

    //TODO: eliminar contacto por medio de su id
    public void eliminarContacto(int id){
        jdbc.update("DELETE FROM contactos WHERE id=?", id);
    }
}

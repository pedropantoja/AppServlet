package com.aula114;
import java.util.ArrayList;
import java.util.List;
import redis.clients.jedis.Jedis;
import com.aula114.Persona;
import com.aula114.DAOPers;

public class DAOPersImplRedis implements DAOPers {
  public List<Persona> findAllPersonas() {
    /*Jedis conn = new Jedis("localhost");
    conn.select(5);
    List<Persona> result = new ArrayList<Persona>();
    for (String member : conn.lrange("listaPersona",0,-1)){
      String[] campos = member.split(":");
      result.add(new Persona(campos[0], campos[1], campos[2]));
    }
    return result;
    */
    Jedis conn = new Jedis("localhost");
    conn.select(2);
    List<Persona> result = new ArrayList<>();
    for (String member : conn.lrange("listaPersona",0,-1)){
      result.add(new Persona(member));
    }
    return result;
  }

  public void insert(Persona p) {
    Jedis conn = new Jedis("localhost");
    conn.select(2);
    String registro = p.getNombre() + ":" + p.getApellido() + ":" +
                      p.getEmail();
    conn.rpush("listaPersona",registro);
  }
}

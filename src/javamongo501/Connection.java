/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javamongo501;

import com.mongodb.DBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mongodb.BasicDBObject;
/**
 *
 * @author yazmi
 */
public class Connection {
    DB BaseDatos;
    DBCollection coleccion;
    BasicDBObject document= new BasicDBObject();
    
    public Connection(){
        Mongo mongo = new Mongo("localhost",27017);
        BaseDatos= mongo.getDB("Actividades501");
        coleccion= BaseDatos.getCollection("Actividades501");
        System.out.println("conexion exitosa");
    }
    public boolean insertar(String accion){
        document.put("accion", accion);
        coleccion.insert(document);
        return true;
    }
    public void Mostrar(){
         DBCursor cursor= coleccion.find();
         while(cursor.hasNext()){
             System.out.println(cursor.next());
         } 
    }
    
    public boolean Actualizar(String accionVieja,String accionNueva){
        document.put("accion", accionVieja);
        BasicDBObject documentoNuevo= new BasicDBObject();
        documentoNuevo.put("accion", accionNueva);
        coleccion.findAndModify(document, documentoNuevo);
        
            return true;
        }
    public boolean eliminar(String accion){
     document.put("accion", accion);
     coleccion.remove(document);
     return true;
    }
    
}

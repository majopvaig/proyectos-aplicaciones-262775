package com.example.NebulaMusic.service;

import com.example.NebulaMusic.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UsuarioService {
    private final Map<String, Usuario> usuarios = new ConcurrentHashMap<>();

    public UsuarioService(){}

    public void registrar(Usuario u){
        usuarios.put(u.getCorreo(), u);
    }

    public boolean existeCorreo(String correo){
        return usuarios.containsKey(correo);
    }

    public boolean autenticar(String correo, String contrasenia){
        Usuario u = usuarios.get(correo);
        return u != null && u.getContrasenia().equals(contrasenia);
    }
}

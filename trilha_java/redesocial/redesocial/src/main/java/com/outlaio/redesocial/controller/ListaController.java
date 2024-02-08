package com.outlaio.redesocial.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.outlaio.redesocial.controller.DTO.UserDTO;
import com.outlaio.redesocial.model.Usuario;

@RestController
public class ListaController {
	@RequestMapping("/listausuarios")
	@ResponseBody
	public ArrayList<UserDTO> listaUsuarios() {
        ArrayList<UserDTO> listaUsuarios = new ArrayList<UserDTO>();
        listaUsuarios.add(new UserDTO(new Usuario((long) 1, "Zangado", "zangado@anao", "zangado")));
        listaUsuarios.add(new UserDTO(new Usuario((long) 1, "Soneca", "soneca@anao", "soneca")));
        listaUsuarios.add(new UserDTO(new Usuario((long) 1, "Dunga", "dunga@anao", "dunga")));
        
        return listaUsuarios;
    }
}

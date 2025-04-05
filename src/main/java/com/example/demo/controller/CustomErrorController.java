package com.example.demo.controller;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        // Obtener el código de error
        Object status = request.getAttribute("javax.servlet.error.status_code");
        String errorMessage = "Ha ocurrido un error inesperado.";

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            model.addAttribute("statusCode", statusCode);

            // Personalizar el mensaje según el código de error
            switch (statusCode) {
                case 404:
                    errorMessage = "Página no encontrada.";
                    break;
                case 500:
                    errorMessage = "Error interno del servidor.";
                    break;
                case 403:
                    errorMessage = "Acceso denegado.";
                    break;
                default:
                    errorMessage = "Ha ocurrido un error inesperado.";
            }
        }

        model.addAttribute("errorMessage", errorMessage);
        return "error"; // Nombre de la vista HTML
    }
}